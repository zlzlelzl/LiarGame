package com.sixsense.liargame.security.oauth2;

import com.sixsense.liargame.db.entity.User;
import com.sixsense.liargame.db.repository.UserRepository;
import com.sixsense.liargame.security.auth.UserDetailsCustom;
import com.sixsense.liargame.security.oauth2.provider.GoogleUserInfo;
import com.sixsense.liargame.security.oauth2.provider.KaKaoUserInfo;
import com.sixsense.liargame.security.oauth2.provider.OAuth2UserInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomOAuth2UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수
    //함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    //OAuthAttributes: OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스
    //User: 엔티티 클래스
    //UserRepository: 엔티티 클래스를 DB에 접근하게 해주는 인터페이스
    //SessionUser: 세션에 사용자 정보를 저장하기 위한 Dto 클래스
    //CustomOAuth2UserService: 구글 로그인 이후 가져온 사용자의 정보(email, name, picture 등)들을 기반으로 가입 및 정보수정, 세션 저장 등의 기능 지원
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        return processOAuth2User(userRequest, oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = null;
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            //구글 로그인 요청
            System.out.println("구글 로그인 요청~~");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
            //카카오 로그인 요청
            System.out.println("카카오 로그인 요청~~");
            oAuth2UserInfo = new KaKaoUserInfo((Map) oAuth2User.getAttributes());
            System.out.println(oAuth2UserInfo.toString());
        } else {
            //다른 소셜 로그인 요청
            System.out.println("우리는 구글과 카카오만 지원해요 ㅎㅎ");
        }
        //ex)kakao_1238471249@liargame.com
        String email = oAuth2UserInfo.getProvider() + '_' + oAuth2UserInfo.getProviderId() + "@liargame.com";
        //이미 가입되어있는지 찾아봄
        Optional<User> userOptional =
                userRepository.findByEmail(email);

        User user;
        if (userOptional.isPresent()) {
            // DB에 해당 유저가 있으면 유저를 바로 반환
            user = userOptional.get();
        } else {
            // DB에 해당 유저가 없으면 새로 만들어줌.
            // 닉네임은 해당 유저의 이메일으로, 패스워드는 정해진 패스워드를 암호화해서 넣어줌
            // user의 패스워드를 임의로 정해줬기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음.
            user = User.builder()
                    .email(email)
                    .password(bCryptPasswordEncoder.encode("식스센스"))
                    .role("USER")
                    .name(email)
                    .build();
            user = userRepository.save(user);
        }
        System.out.println(user.toString());
        return new UserDetailsCustom(user, oAuth2User.getAttributes());
    }
}
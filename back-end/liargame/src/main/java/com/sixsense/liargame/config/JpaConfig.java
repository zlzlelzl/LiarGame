package com.sixsense.liargame.config;

import com.sixsense.liargame.api.service.HistoryService;
import com.sixsense.liargame.api.service.impl.HistoryServiceImpl;
import com.sixsense.liargame.db.repository.NormalGameRepository;
import com.sixsense.liargame.db.repository.SpyGameRepository;
import com.sixsense.liargame.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JpaConfig {
    private final NormalGameRepository normalGameRepository;
    private final SpyGameRepository spyGameRepository;
    private final UserRepository userRepository;

    @Bean
    public HistoryService historyService() {
        return new HistoryServiceImpl(normalGameRepository, spyGameRepository, userRepository);
    }
}

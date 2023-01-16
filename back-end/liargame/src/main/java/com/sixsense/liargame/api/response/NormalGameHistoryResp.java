package com.sixsense.liargame.api.response;

import com.sixsense.liargame.db.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalGameHistoryResp {
    private String result;
    private String role;
    private Date playedTime;
    private List<User> users;
}

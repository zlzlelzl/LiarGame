package com.sixsense.liargame.db.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Id;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
public class PlayuserPK implements Serializable {
    @Id
    private Long userId;
    @Id
    private Long historyId;

}

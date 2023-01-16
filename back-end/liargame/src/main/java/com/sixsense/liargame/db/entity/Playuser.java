package com.sixsense.liargame.db.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@EqualsAndHashCode
@IdClass(PlayuserPK.class)
public class Playuser implements Serializable {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Id
    @Column(name = "history_id")
    private Long historyId;
    @ManyToOne
    @JoinColumn(name = "history_id", insertable = false, updatable = false)
    private
    private String role;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

}

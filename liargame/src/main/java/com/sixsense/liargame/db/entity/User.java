package com.sixsense.liargame.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;


/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
public class User extends BaseEntity{
    private String position;
    private String department;
    private String name;
    private String userId;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}

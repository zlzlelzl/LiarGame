package com.sixsense.liargame.db.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Time {
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

//    @CreationTimestamp
//    @Column(name = "createdAt", updatable = false)
//    private LocalDateTime createdTimestamp;
//
//    @UpdateTimestamp
//    @Column(name = "updatedAt", insertable = false)
//    private LocalDateTime updatedTimestamp;
}


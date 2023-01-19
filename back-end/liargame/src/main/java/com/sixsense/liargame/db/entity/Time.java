package com.sixsense.liargame.db.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Time {
    @CreationTimestamp
    @Column(name = "creattedAt", updatable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(name = "updatedAt", insertable = false)
    private LocalDateTime updatedTime;
}

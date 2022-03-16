package com.garpix.springapp.entity.base

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseAuditEntity<T> : BaseEntity<T>() {

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    lateinit var created: LocalDateTime

    @UpdateTimestamp
    @Column(nullable = false)
    lateinit var modified: LocalDateTime
}
package com.serov.library.entity

import com.garpix.springapp.entity.base.BaseEntity
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "authors")
class Author(
    @Column(name = "full_name")
    var fullName: String? = null,
) : BaseEntity<UUID>(), Serializable
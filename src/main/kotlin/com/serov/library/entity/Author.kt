package com.serov.library.entity

import com.serov.library.entity.base.BaseEntityUUID
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "authors")
class Author(
    @Column(name = "full_name")
    var fullName: String? = null,
) : BaseEntityUUID(), Serializable
package com.serov.library.entity

import com.garpix.springapp.entity.base.BaseEntity
import org.hibernate.annotations.NaturalId
import java.io.Serializable
import javax.persistence.Entity

@Entity
class Category(
    @NaturalId
    var name: String? = null
) : BaseEntity<Long>(), Serializable
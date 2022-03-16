package com.serov.library.entity.base

import com.garpix.springapp.entity.base.BaseEntity
import com.serov.library.entity.Author
import com.serov.library.entity.Category
import org.hibernate.annotations.NaturalId
import java.io.Serializable
import java.time.LocalDate
import java.util.*
import javax.persistence.MappedSuperclass


@MappedSuperclass
abstract class BaseBook : BaseEntity<UUID>(), Serializable {
    @NaturalId
    private val isbn: String? = null
    private val title: String? = null
    private val publicationDate: LocalDate? = null
    abstract var authors: List<Author?>?
    abstract var categories: Set<Category?>?
}
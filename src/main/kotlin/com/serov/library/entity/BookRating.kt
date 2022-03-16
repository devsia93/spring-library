package com.serov.library.entity

import com.garpix.springapp.entity.base.BaseEntity
import java.math.BigDecimal
import javax.persistence.*

@Entity
class BookRating(
    @Version
    val version: Int = 0,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    val book: Book? = null,

    val rating: BigDecimal? = null,
    val numberOfRatings: Int = 0
) : BaseEntity<Long>()
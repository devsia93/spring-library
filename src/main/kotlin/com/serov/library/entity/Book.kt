package com.serov.library.entity

import com.serov.library.entity.base.BaseBook
import javax.persistence.*


@NamedEntityGraphs(
    *[
        NamedEntityGraph(
            name = "books.authors",
            attributeNodes = [NamedAttributeNode("authors")]
        ),
        NamedEntityGraph(
            name = "books.authors_categories",
            attributeNodes = [NamedAttributeNode("authors"), NamedAttributeNode("categories")]
        )
    ]
)
@Entity
@Table(name = "books")
class Book(
    @Column(name = "user_id")
    var userId: String? = null, //owner

    @ManyToMany(fetch = FetchType.EAGER)
    override var authors: List<Author?>? = ArrayList(),

    @ManyToMany
    override var categories: Set<Category?>? = LinkedHashSet()
) : BaseBook()
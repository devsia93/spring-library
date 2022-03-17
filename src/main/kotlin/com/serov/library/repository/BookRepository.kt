package com.serov.library.repository

import com.serov.library.entity.Book
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate
import java.util.*

interface BookRepository<T : Book?> : JpaRepository<T, UUID?> {
    fun findByTitleContains(title: String?, pageable: Pageable?): List<T>?

    fun findByAuthorNameAndTitle(
        fetchAuthor: Boolean, distinct: Boolean, authorName: String?, title: String?
    ): List<Book?>?

    @EntityGraph("book.authors")
    fun findByPublicationDateAfter(date: LocalDate?, sort: Sort?): List<Book?>?

    @EntityGraph("book.authors")
    fun findByPublicationDateAfter(date: LocalDate?, pageable: Pageable?): List<Book?>?

    @EntityGraph("book.authors_categories")
    fun findByPublicationDateBetween(startDate: LocalDate?, endDate: LocalDate?, sort: Sort?): List<Book?>?

    @Query(
        "select b from Book b join fetch b.authors"
                + " where b.publicationDate > :date"
                + " order by b.publicationDate asc"
    )
    fun findByPublicationDateAfterJoinFetch(date: LocalDate?): List<Book?>?

    @Query(
        ("select distinct b from Book b join fetch b.authors"
                + " where b.publicationDate > :date"
                + " order by b.publicationDate asc")
    )

    fun findByPublicationDateAfterJoinFetchDistinct(date: LocalDate?): List<Book?>?
}
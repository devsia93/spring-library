package com.serov.library.repository

import com.serov.library.entity.BookRating
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import javax.persistence.LockModeType


interface BookRatingRepository : JpaRepository<BookRating, Long> {
    fun findByBookIsbn(isbn: String?): BookRating?

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select br from BookRating br where br.book.isbn = :isbn")
    fun findByBookIsbnPessimisticReadLock(isbn: String?): BookRating?

    @Lock(LockModeType.OPTIMISTIC)
    @Query("select br from BookRating br where br.book.isbn = :isbn")
    fun findByBookIsbnOptimisticLock(isbn: String?): BookRating?

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("select br from BookRating br where br.book.isbn = :isbn")
    fun findByBookIsbnOptimisticForceIncrementLock(isbn: String?): BookRating?

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select br from BookRating br where br.book.isbn = :isbn")
    fun findByBookIsbnPessimisticWriteLock(isbn: String?): BookRating?
}
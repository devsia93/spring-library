package com.serov.library.dto

import com.serov.library.dto.author.AuthorDto
import java.time.LocalDate


data class BookDto(
    private val isbn: String? = null,
    private val userId: String? = null,
    private val title: String? = null,
    private val publicationDate: LocalDate? = null,
    private val authors: List<AuthorDto>? = ArrayList(),
    private val categories: List<CategoryDto>? = ArrayList()
)
package com.serov.library.mapper

import com.serov.library.dto.author.AuthorDto
import com.serov.library.dto.BookDto
import com.serov.library.dto.CategoryDto
import com.serov.library.entity.Author
import com.serov.library.entity.Book
import com.serov.library.entity.Category
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface BookMapper {
    fun toBookDto(book: Book?): BookDto?

    @Mapping(source = "fullName", target = "name")
    fun toAuthorDto(author: Author?): AuthorDto?

    @Mapping(source = "name", target = "label")
    fun toCategoryDto(category: Category?): CategoryDto?
}
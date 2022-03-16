package com.serov.library.controller

import com.serov.library.dto.author.AuthorResponse
import com.serov.library.dto.base.PaginationRequest
import com.serov.library.entity.Author
import com.serov.library.repository.AuthorRepository
import com.serov.library.util.PaginationFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors/")
class AuthorWebController
@Autowired
constructor(val repository: AuthorRepository) {
    @PostMapping("read")
    fun findAll(@RequestBody(required = false) paginationRequest: PaginationRequest): ResponseEntity<AuthorResponse> {
        val pagingSort = PaginationFactory.getPagingSort(paginationRequest)
        val pageTuts: Page<Author> = repository.findAll(pagingSort)
        val result = pageTuts.content

        val response = AuthorResponse(result = result)
        response.currentPage = pageTuts.number
        response.totalItems = pageTuts.totalElements
        response.totalPages = pageTuts.totalPages

        return ResponseEntity(response, HttpStatus.OK)
    }
}
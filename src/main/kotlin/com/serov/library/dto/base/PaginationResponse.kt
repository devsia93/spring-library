package com.serov.library.dto.base

open class PaginationResponse(
    var totalItems: Long = 0,
    var totalPages: Int = 0,
    var currentPage: Int = 0
)
package com.serov.library.dto.base

open class PaginationRequest(
    val sort: List<String> = listOf("id,desc"),
    val pageNumber: Int = 0,
    val size: Int = 10
)

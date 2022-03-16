package com.serov.library.dto.author

import com.serov.library.dto.base.PaginationResponse
import com.serov.library.entity.Author

data class AuthorResponse(val result: List<Author>): PaginationResponse()
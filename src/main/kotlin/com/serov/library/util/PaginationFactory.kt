package com.serov.library.util

import com.serov.library.dto.base.PaginationRequest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

class PaginationFactory {
    companion object Factory {
        fun getPagingSort(paginationRequest: PaginationRequest): Pageable {
            val size: Int = paginationRequest.size
            val pageNumber: Int = paginationRequest.pageNumber
            val sort: List<String> = paginationRequest.sort
            val orders: MutableList<Sort.Order> = getOrders(sort)

            return PageRequest.of(pageNumber, size, Sort.by(orders))
        }

        private fun getSortDirection(direction: String): Sort.Direction {
            if (direction == "asc") {
                return Sort.Direction.ASC
            } else if (direction == "desc") {
                return Sort.Direction.DESC
            }
            return Sort.Direction.ASC
        }

        private fun getOrders(sort: List<String>): MutableList<Sort.Order>{
            val orders: MutableList<Sort.Order> = mutableListOf()
            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                for (sortOrder in sort) {
                    val _sort = sortOrder.split(",").toTypedArray()
                    orders.add(Sort.Order(getSortDirection(_sort[1]), _sort[0]))
                }
            } else {
                orders.add(Sort.Order(getSortDirection(sort[1]), sort[0]))
            }
            return orders
        }
    }
}
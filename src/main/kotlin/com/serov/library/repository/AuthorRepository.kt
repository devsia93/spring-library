package com.serov.library.repository

import com.serov.library.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AuthorRepository : JpaRepository<Author, UUID>
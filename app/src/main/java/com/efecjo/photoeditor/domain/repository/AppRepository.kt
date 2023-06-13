package com.efecjo.photoeditor.domain.repository

import com.efecjo.photoeditor.util.Resource

interface AppRepository {

        suspend fun initialOperations() : Resource<Boolean>
}
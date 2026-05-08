/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.database.domain.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference

interface DatabaseRepository {
    fun reference(path: String? = null): DatabaseReference
    suspend fun get(path: String): DataSnapshot
    suspend fun set(path: String, value: Any?)
    suspend fun update(path: String, values: Map<String, Any?>)
    suspend fun remove(path: String)
}

/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.database.data.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.template.firebase.database.domain.repository.DatabaseRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.tasks.await

@Singleton
class FirebaseDatabaseRepository @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
) : DatabaseRepository {

    override fun reference(path: String?): DatabaseReference =
        path?.let(firebaseDatabase::getReference) ?: firebaseDatabase.reference

    override suspend fun get(path: String): DataSnapshot = reference(path).get().await()

    override suspend fun set(path: String, value: Any?) {
        reference(path).setValue(value).await()
    }

    override suspend fun update(path: String, values: Map<String, Any?>) {
        reference(path).updateChildren(values).await()
    }

    override suspend fun remove(path: String) {
        reference(path).removeValue().await()
    }
}

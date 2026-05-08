/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.firestore.domain.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

interface FirestoreRepository {
    fun collection(path: String): CollectionReference
    fun document(path: String): DocumentReference
    suspend fun getDocument(path: String): DocumentSnapshot
    suspend fun getCollection(path: String): QuerySnapshot
    suspend fun setDocument(path: String, data: Any)
    suspend fun updateDocument(path: String, data: Map<String, Any?>)
    suspend fun deleteDocument(path: String)
}

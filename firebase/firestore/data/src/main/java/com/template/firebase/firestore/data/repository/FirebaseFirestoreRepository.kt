package com.template.firebase.firestore.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.template.firebase.firestore.domain.repository.FirestoreRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.tasks.await

@Singleton
class FirebaseFirestoreRepository @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore,
) : FirestoreRepository {

    override fun collection(path: String): CollectionReference =
        firebaseFirestore.collection(path)

    override fun document(path: String): DocumentReference =
        firebaseFirestore.document(path)

    override suspend fun getDocument(path: String): DocumentSnapshot =
        document(path).get().await()

    override suspend fun getCollection(path: String): QuerySnapshot =
        collection(path).get().await()

    override suspend fun setDocument(path: String, data: Any) {
        document(path).set(data).await()
    }

    override suspend fun updateDocument(path: String, data: Map<String, Any?>) {
        document(path).update(data).await()
    }

    override suspend fun deleteDocument(path: String) {
        document(path).delete().await()
    }
}

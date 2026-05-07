package com.template.firebase.storage.data.repository

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.template.firebase.storage.domain.repository.StorageRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.tasks.await

@Singleton
class FirebaseStorageRepository @Inject constructor(
    private val firebaseStorage: FirebaseStorage,
) : StorageRepository {

    override fun reference(path: String?): StorageReference =
        path?.let(firebaseStorage::getReference) ?: firebaseStorage.reference

    override suspend fun getDownloadUrl(path: String): Uri =
        reference(path).downloadUrl.await()

    override suspend fun putBytes(path: String, bytes: ByteArray): Uri {
        val result = reference(path).putBytes(bytes).await()
        return result.storage.downloadUrl.await()
    }

    override suspend fun delete(path: String) {
        reference(path).delete().await()
    }
}

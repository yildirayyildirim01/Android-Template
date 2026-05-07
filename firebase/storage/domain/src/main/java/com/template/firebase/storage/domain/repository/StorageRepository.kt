package com.template.firebase.storage.domain.repository

import android.net.Uri
import com.google.firebase.storage.StorageReference

interface StorageRepository {
    fun reference(path: String? = null): StorageReference
    suspend fun getDownloadUrl(path: String): Uri
    suspend fun putBytes(path: String, bytes: ByteArray): Uri
    suspend fun delete(path: String)
}

/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.auth.data.mapper

import com.google.firebase.auth.FirebaseUser
import com.template.firebase.auth.domain.model.AuthUser

internal fun FirebaseUser.toAuthUser() = AuthUser(
    id = uid,
    email = email,
    displayName = displayName,
    photoUrl = photoUrl?.toString(),
    isEmailVerified = isEmailVerified
)

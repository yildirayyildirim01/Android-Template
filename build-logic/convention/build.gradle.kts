/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
plugins {
    `kotlin-dsl`
}

group = "com.android.template"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.google.services.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.android.template.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.android.template.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidTest") {
            id = "com.android.template.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("androidHilt") {
            id = "com.android.template.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("spotless") {
            id = "com.android.template.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
        register("publish") {
            id = "com.android.template.publish"
            implementationClass = "PublishConventionPlugin"
        }
        register("firebaseBase") {
            id = "com.android.template.firebase.base"
            implementationClass = "FirebaseBaseConventionPlugin"
        }
        register("firebaseGoogleServices") {
            id = "com.android.template.firebase.google-services"
            implementationClass = "FirebaseGoogleServicesConventionPlugin"
        }
        register("firebaseAnalytics") {
            id = "com.android.template.firebase.analytics"
            implementationClass = "FirebaseAnalyticsConventionPlugin"
        }
        register("firebaseAuth") {
            id = "com.android.template.firebase.auth"
            implementationClass = "FirebaseAuthConventionPlugin"
        }
        register("firebaseRemoteConfig") {
            id = "com.android.template.firebase.remote-config"
            implementationClass = "FirebaseRemoteConfigConventionPlugin"
        }
        register("firebaseCrashlytics") {
            id = "com.android.template.firebase.crashlytics"
            implementationClass = "FirebaseCrashlyticsConventionPlugin"
        }
        register("firebaseDatabase") {
            id = "com.android.template.firebase.database"
            implementationClass = "FirebaseDatabaseConventionPlugin"
        }
        register("firebaseFirestore") {
            id = "com.android.template.firebase.firestore"
            implementationClass = "FirebaseFirestoreConventionPlugin"
        }
        register("firebaseMessaging") {
            id = "com.android.template.firebase.messaging"
            implementationClass = "FirebaseMessagingConventionPlugin"
        }
        register("firebaseStorage") {
            id = "com.android.template.firebase.storage"
            implementationClass = "FirebaseStorageConventionPlugin"
        }
    }
}

/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
plugins {
    alias(libs.plugins.template.android.application)
    alias(libs.plugins.template.android.test)
    alias(libs.plugins.template.android.hilt)
}

android {
    namespace = "com.android.template"

    defaultConfig {
        applicationId = "com.android.template"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":core:common"))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}

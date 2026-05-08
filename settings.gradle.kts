/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android-Template"
include(":app")
include(":core:mvi")
include(":core:common")
include(":firebase:auth:domain")
include(":firebase:auth:data")
include(":firebase:analytics:domain")
include(":firebase:analytics:data")
include(":firebase:remote-config:domain")
include(":firebase:remote-config:data")
include(":firebase:crashlytics:domain")
include(":firebase:crashlytics:data")
include(":firebase:database:domain")
include(":firebase:database:data")
include(":firebase:firestore:domain")
include(":firebase:firestore:data")
include(":firebase:messaging:domain")
include(":firebase:messaging:data")
include(":firebase:storage:domain")
include(":firebase:storage:data")
include(":google:identity:domain")
include(":google:identity:data")

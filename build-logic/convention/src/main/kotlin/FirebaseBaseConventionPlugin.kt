/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
import extension.addCatalogPlatformDependencyIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project

class FirebaseBaseConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            addCatalogPlatformDependencyIfAbsent("implementation", "firebase.bom")
        }
    }
}

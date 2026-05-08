/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
import extension.addCatalogDependencyIfAbsent
import extension.applyPluginIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidHiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPluginIfAbsent("com.google.dagger.hilt.android")
            applyPluginIfAbsent("com.google.devtools.ksp")

            addCatalogDependencyIfAbsent("implementation", "hilt.android")
            addCatalogDependencyIfAbsent("ksp", "hilt.compiler")
        }
    }
}

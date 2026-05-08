/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
import extension.addCatalogDependencyIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidTestConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.withPlugin("com.android.application") {
                configureTestDependencies()
            }
            pluginManager.withPlugin("com.android.library") {
                configureTestDependencies()
            }
        }
    }

    private fun Project.configureTestDependencies() {
        addCatalogDependencyIfAbsent("testImplementation", "junit")
        addCatalogDependencyIfAbsent("androidTestImplementation", "androidx.junit")
        addCatalogDependencyIfAbsent("androidTestImplementation", "androidx.espresso.core")
    }
}

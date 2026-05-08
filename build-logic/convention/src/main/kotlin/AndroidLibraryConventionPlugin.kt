/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
import com.android.build.api.dsl.LibraryExtension
import extension.applyPluginIfAbsent
import extension.configureJavaCompatibility
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPluginIfAbsent("com.android.library")
            applyPluginIfAbsent("com.android.template.publish")

            val javaVersion = JavaVersion.VERSION_11

            extensions.configure<LibraryExtension> {
                compileSdk {
                    version = release(36) {
                        minorApiLevel = 1
                    }
                }

                defaultConfig {
                    minSdk = 24
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                configureJavaCompatibility(javaVersion)
            }
        }
    }
}

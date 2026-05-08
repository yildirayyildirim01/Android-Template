/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
import com.android.build.api.dsl.ApplicationExtension
import extension.applyPluginIfAbsent
import extension.configureJavaCompatibility
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPluginIfAbsent("com.android.application")

            val javaVersion = JavaVersion.VERSION_11

            extensions.configure<ApplicationExtension> {
                compileSdk {
                    version = release(36) {
                        minorApiLevel = 1
                    }
                }

                defaultConfig {
                    minSdk = 24
                    targetSdk = 36
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }

                configureJavaCompatibility(javaVersion)
            }
        }
    }
}

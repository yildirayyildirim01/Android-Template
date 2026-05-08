/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
import com.diffplug.gradle.spotless.SpotlessExtension
import extension.applyPluginIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SpotlessConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPluginIfAbsent("com.diffplug.spotless")

            extensions.configure<SpotlessExtension> {
                kotlin {
                    target("**/*.kt")
                    targetExclude("**/build/**", "config/spotless/**")
                    licenseHeaderFile(rootProject.file(COPYRIGHT_FILE), KOTLIN_HEADER_DELIMITER)
                    ktlint(KTLINT_VERSION)
                }

                kotlinGradle {
                    target("**/*.gradle.kts")
                    targetExclude("**/build/**", "config/spotless/**")
                    licenseHeaderFile(rootProject.file(COPYRIGHT_FILE), KOTLIN_HEADER_DELIMITER)
                    ktlint(KTLINT_VERSION)
                }

                format("xml") {
                    target("**/*.xml")
                    targetExclude("**/build/**")
                    trimTrailingWhitespace()
                    endWithNewline()
                }
            }

            subprojects {
                tasks.matching { it.name == "lint" || it.name.startsWith("lint") }.configureEach {
                    dependsOn(rootProject.tasks.named("spotlessCheck"))
                }
            }
        }
    }

    private companion object {
        const val KTLINT_VERSION = "1.8.0"
        const val COPYRIGHT_FILE = "config/spotless/copyright.txt"
        const val KOTLIN_HEADER_DELIMITER =
            "(package|import|plugins|pluginManagement|dependencyResolutionManagement|rootProject|include)"
    }
}

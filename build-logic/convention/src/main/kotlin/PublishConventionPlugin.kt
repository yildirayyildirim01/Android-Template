/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
import com.android.build.api.dsl.LibraryExtension
import extension.applyPluginIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

class PublishConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPluginIfAbsent("maven-publish")

            pluginManager.withPlugin("com.android.library") {
                extensions.configure<LibraryExtension> {
                    publishing {
                        singleVariant(RELEASE_VARIANT) {
                            withSourcesJar()
                        }
                    }
                }

                afterEvaluate {
                    extensions.configure<PublishingExtension> {
                        publications {
                            register<MavenPublication>(RELEASE_VARIANT) {
                                from(components[RELEASE_VARIANT])

                                groupId = publishGroup()
                                artifactId = publishArtifactId()
                                version = publishVersion()

                                pom {
                                    name.set(publishArtifactId())
                                    description.set("Android Template ${project.path} module")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun Project.publishGroup(): String {
        val configuredGroup = providers.gradleProperty(PUBLISH_GROUP_PROPERTY).orNull
        if (!configuredGroup.isNullOrBlank()) return configuredGroup

        val jitpackGroup = providers.environmentVariable(JITPACK_GROUP_ENV).orNull
        val jitpackArtifact = providers.environmentVariable(JITPACK_ARTIFACT_ENV).orNull
        if (!jitpackGroup.isNullOrBlank() && !jitpackArtifact.isNullOrBlank()) {
            return "$jitpackGroup.$jitpackArtifact"
        }

        return DEFAULT_GROUP
    }

    private fun Project.publishVersion(): String =
        providers.gradleProperty(PUBLISH_VERSION_PROPERTY)
            .orElse(providers.environmentVariable(JITPACK_VERSION_ENV))
            .orElse(DEFAULT_VERSION)
            .get()

    private fun Project.publishArtifactId(): String =
        providers.gradleProperty(PUBLISH_ARTIFACT_ID_PROPERTY)
            .orElse(path.removePrefix(":").replace(":", "-"))
            .get()

    private companion object {
        const val RELEASE_VARIANT = "release"
        const val PUBLISH_GROUP_PROPERTY = "PUBLISH_GROUP"
        const val PUBLISH_VERSION_PROPERTY = "PUBLISH_VERSION"
        const val PUBLISH_ARTIFACT_ID_PROPERTY = "PUBLISH_ARTIFACT_ID"
        const val JITPACK_GROUP_ENV = "GROUP"
        const val JITPACK_ARTIFACT_ENV = "ARTIFACT"
        const val JITPACK_VERSION_ENV = "VERSION"
        const val DEFAULT_GROUP = "com.github.android-template"
        const val DEFAULT_VERSION = "0.1.0-SNAPSHOT"
    }
}

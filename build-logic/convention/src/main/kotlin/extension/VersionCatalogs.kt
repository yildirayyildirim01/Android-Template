/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package extension

import com.android.build.api.dsl.LibraryProductFlavor
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.libsCatalog(): VersionCatalog =
    extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.applyPluginIfAbsent(pluginId: String) {
    if (!pluginManager.hasPlugin(pluginId)) {
        pluginManager.apply(pluginId)
    }
}

fun Project.addCatalogDependencyIfAbsent(configurationName: String, alias: String) {
    val dependency = libsCatalog().findLibrary(alias).get().get()
    addDependencyIfAbsent(configurationName, dependency)
}

fun Project.addCatalogPlatformDependencyIfAbsent(configurationName: String, alias: String) {
    val dependency = dependencies.platform(libsCatalog().findLibrary(alias).get().get())
    addDependencyIfAbsent(configurationName, dependency)
}

fun Project.addDependencyIfAbsent(configurationName: String, dependency: Dependency) {
    val hasDependency = configurations.getByName(configurationName).dependencies.any {
        it.group == dependency.group && it.name == dependency.name
    }

    if (!hasDependency) {
        dependencies.add(configurationName, dependency)
    }
}

fun LibraryProductFlavor.buildConfigString(key: String, value: String) {
    buildConfigField("String", key, "\"$value\"")
}

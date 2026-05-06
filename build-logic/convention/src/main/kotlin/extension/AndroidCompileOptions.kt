package extension

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal fun ApplicationExtension.configureJavaCompatibility(javaVersion: JavaVersion) {
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}

internal fun LibraryExtension.configureJavaCompatibility(javaVersion: JavaVersion) {
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}

internal fun Project.configureKotlinJvmTarget(
    javaVersion: JavaVersion,
) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(javaVersion.toString()))
        }
    }
}

plugins {
    `kotlin-dsl`
}

group = "com.android.template"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.android.template.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.android.template.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidKotlin") {
            id = "com.android.template.android.kotlin"
            implementationClass = "AndroidKotlinConventionPlugin"
        }
        register("androidTest") {
            id = "com.android.template.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
    }
}

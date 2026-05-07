plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.test)
    alias(libs.plugins.template.android.hilt)
    alias(libs.plugins.template.firebase.crashlytics)
}

android {
    namespace = "com.template.firebase.crashlytics.data"
}

dependencies {
    implementation(project(":firebase:crashlytics:domain"))
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.kotlinx.coroutines.test)
}

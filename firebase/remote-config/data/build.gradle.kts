plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.test)
    alias(libs.plugins.template.android.hilt)
    alias(libs.plugins.template.firebase.remote.config)
}

android {
    namespace = "com.template.firebase.remoteconfig.data"
}

dependencies {
    implementation(project(":firebase:remote-config:domain"))
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.kotlinx.coroutines.test)
}

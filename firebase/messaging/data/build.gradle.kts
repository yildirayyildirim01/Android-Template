plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.test)
    alias(libs.plugins.template.android.hilt)
    alias(libs.plugins.template.firebase.messaging)
}

android {
    namespace = "com.template.firebase.messaging.data"
}

dependencies {
    implementation(project(":firebase:messaging:domain"))
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.play.services)

    testImplementation(libs.kotlinx.coroutines.test)
}

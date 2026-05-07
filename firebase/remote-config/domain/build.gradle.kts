plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.test)
}

android {
    namespace = "com.template.firebase.remoteconfig.domain"
}

dependencies {
    implementation(libs.javax.inject)

    api(libs.kotlinx.coroutines.core)

    testImplementation(libs.kotlinx.coroutines.test)
}

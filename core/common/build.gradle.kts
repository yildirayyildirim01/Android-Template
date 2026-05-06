plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.test)
    alias(libs.plugins.template.android.hilt)
}

android {
    namespace = "com.template.common"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)

    api(libs.kotlinx.coroutines.core)
}

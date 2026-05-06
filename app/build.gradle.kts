plugins {
    alias(libs.plugins.template.android.application)
    alias(libs.plugins.template.android.kotlin)
    alias(libs.plugins.template.android.test)
}

android {
    namespace = "com.android.template"

    defaultConfig {
        applicationId = "com.android.template"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}

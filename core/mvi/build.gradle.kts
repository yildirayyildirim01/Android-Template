plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.test)
}

android {
    namespace = "com.template.mvi"
}

dependencies {
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.kotlinx.coroutines.core)

    testImplementation(libs.kotlinx.coroutines.test)
}

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.test)
}

android {
    namespace = "com.template.google.identity.domain"
}

dependencies {
    implementation(libs.javax.inject)

    testImplementation(libs.kotlinx.coroutines.test)
}

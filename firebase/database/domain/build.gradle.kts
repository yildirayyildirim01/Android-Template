plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.test)
    alias(libs.plugins.template.firebase.database)
}

android {
    namespace = "com.template.firebase.database.domain"
}

dependencies {
    implementation(libs.javax.inject)

    api(libs.kotlinx.coroutines.core)

    testImplementation(libs.kotlinx.coroutines.test)
}

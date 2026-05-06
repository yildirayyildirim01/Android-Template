import extension.configureKotlinJvmTarget
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidKotlinConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            configureKotlinJvmTarget(JavaVersion.VERSION_11)
        }
    }
}

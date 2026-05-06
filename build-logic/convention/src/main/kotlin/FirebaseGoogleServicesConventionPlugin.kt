import extension.applyPluginIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project

class FirebaseGoogleServicesConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.withPlugin("com.android.application") {
                applyPluginIfAbsent("com.google.gms.google-services")
            }
        }
    }
}

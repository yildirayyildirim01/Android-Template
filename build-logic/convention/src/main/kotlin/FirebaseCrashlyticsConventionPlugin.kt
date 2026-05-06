import extension.addCatalogDependencyIfAbsent
import extension.applyPluginIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project

class FirebaseCrashlyticsConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPluginIfAbsent("com.android.template.firebase.base")
            addCatalogDependencyIfAbsent("implementation", "firebase.crashlytics")

            pluginManager.withPlugin("com.android.application") {
                applyPluginIfAbsent("com.google.gms.google-services")
                applyPluginIfAbsent("com.google.firebase.crashlytics")
            }
        }
    }
}

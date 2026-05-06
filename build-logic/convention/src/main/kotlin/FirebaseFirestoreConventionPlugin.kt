import extension.addCatalogDependencyIfAbsent
import extension.applyPluginIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project

class FirebaseFirestoreConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPluginIfAbsent("com.android.template.firebase.base")
            addCatalogDependencyIfAbsent("implementation", "firebase.firestore")
        }
    }
}

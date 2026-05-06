import extension.addCatalogPlatformDependencyIfAbsent
import org.gradle.api.Plugin
import org.gradle.api.Project

class FirebaseBaseConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            addCatalogPlatformDependencyIfAbsent("implementation", "firebase.bom")
        }
    }
}

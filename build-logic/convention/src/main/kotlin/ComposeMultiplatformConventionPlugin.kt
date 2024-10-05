import com.android.build.api.dsl.LibraryExtension
import labs.yprsty.mobile.convention.configureKotlinAndroid
import labs.yprsty.mobile.convention.configureKotlinMultiplatform
import labs.yprsty.mobile.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("jetbrainsCompose").get().get().pluginId)
            apply(libs.findPlugin("androidLibrary").get().get().pluginId)
            apply(libs.findPlugin("compose.compiler").get().get().pluginId)
            apply(libs.findPlugin("kotlinx.serialization").get().get().pluginId)
        }

        val compose = extensions.getByType<ComposeExtension>().dependencies
        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatform)
        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(this)
            buildFeatures.compose = true
            dependencies {
                add("debugImplementation", compose.uiTooling)
            }
        }
    }
}
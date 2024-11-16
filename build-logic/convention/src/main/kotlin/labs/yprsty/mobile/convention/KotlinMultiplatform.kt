package labs.yprsty.mobile.convention

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension,
) = extension.apply {
    jvmToolchain(17)

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    val moduleName = path.getModuleName(separator = "-")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = moduleName
            isStatic = true
        }
    }

    sourceSets.apply {
        commonMain.dependencies {
            implementation(libs.findLibrary("logger.napier").get())
            implementation(libs.findLibrary("kotlinx.coroutines.core").get())
            api(libs.findLibrary("di.koin.core").get())
        }
    }
}
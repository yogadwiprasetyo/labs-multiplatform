plugins {
    `kotlin-dsl`
}

group = "labs.yprsty.mobile.buildlogic"

dependencies {
    compileOnly(libs.plugins.android.application.toDep())
    compileOnly(libs.plugins.androidLibrary.toDep())
    compileOnly(libs.plugins.kotlinMultiplatform.toDep())
    compileOnly(libs.plugins.jetbrainsCompose.toDep())
    compileOnly(libs.plugins.compose.compiler.toDep())
    compileOnly(libs.plugins.kotlinx.serialization.toDep())
}

fun Provider<PluginDependency>.toDep() = map {
    "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}"
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform") {
            id = "labs.yprsty.mobile.convention.kotlinMultiplatform"
            implementationClass = "KotlinMultiplatformConventionPlugin"
            version = "1.0"
        }
        register("composeMultiplatform") {
            id = "labs.yprsty.mobile.convention.composeMultiplatform"
            implementationClass = "ComposeMultiplatformConventionPlugin"
            version = "1.0"
        }
    }
}
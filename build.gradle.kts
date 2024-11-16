plugins {
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.jetbrainsCompose).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.ksp).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
    alias(libs.plugins.storage.sqlDelight).apply(false)
    alias(libs.plugins.buildConfig).apply(false)
    alias(libs.plugins.dokka).apply(false)
    alias(libs.plugins.network.ktorfit).apply(false)
    alias(libs.plugins.test.mokkery).apply(false)
}

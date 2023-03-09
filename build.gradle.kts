import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.kotlinSerialization)
        classpath(Navigation.navigationSafeArgsGradle)
    }
}

allprojects {
    // Opt in for experimental APIs
    tasks.withType<KotlinCompile>().all {
        kotlinOptions {
            freeCompilerArgs += "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
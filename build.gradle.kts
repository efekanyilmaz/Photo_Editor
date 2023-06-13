// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.kotlinGradlePlugin)
        classpath(Google.googleServices)
    }
}

plugins {
    id(Plugins.androidLibrary) version Plugins.androidLibraryVersion apply false
    id(Plugins.kotlinAndroid) version Plugins.kotlinAndroidVersion apply false
    id(Plugins.jvm) version Plugins.jvmVersion apply false}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
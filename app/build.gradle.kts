plugins {
    id (Plugins.androidApplication)
    id (Plugins.kotlinAndroid)
    id (Plugins.kapt)
    id (Plugins.hiltAndroid)
}

android {
    namespace = "com.efecjo.photoeditor"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.efecjo.photoeditor"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
    hilt {
        enableExperimentalClasspathAggregation = true
    }
}

dependencies {
    /** Kotlin **/
    implementation (Kotlin.coreKtx)
    /** Androidx **/
    implementation (AndroidX.appCompat)
    /** Google **/
    implementation (Google.material)
    implementation (Google.accompanistSystemUiController)
    implementation (Google.accompanistPermission)

    /** Compose **/
    implementation(Compose.viewModelCompose)
    implementation(Compose.activityCompose)
    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.uiTooling)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.hiltNavigationCompose)
    implementation(Compose.material)
    implementation(Compose.runtime)
    implementation(Compose.navigation)
    /** Dagger Hilt **/
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
    /** Test **/
    testImplementation (AndroidX.jUnit2)
    androidTestImplementation (AndroidX.jUnit)
    androidTestImplementation (AndroidX.espressoCore)
    /** Timber **/
    implementation(Timber.timber)
    /** Room **/
    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)
    testImplementation(Room.roomTesting)
    /** Coil **/
    implementation(Coil.coilCompose)
    implementation(Coil.coilGif)




}
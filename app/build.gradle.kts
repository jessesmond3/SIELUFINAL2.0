plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

android {
    namespace = "com.example.login"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.login"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        kotlinOptions {
            jvmTarget = "1.8"
        }
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
        jvmTarget = "11" // Ensure this matches or is higher than the jvmTarget in defaultConfig
    }
    // CORRECT LOCATION: This is the primary and only place for buildFeatures { compose = true }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    // Using activity-compose below, so libs.androidx.activity might be redundant if it's not needed for other things.
    // implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout) // Assuming this points to 'androidx.constraintlayout:constraintlayout-compose'

    // Use the Compose BOM to manage Compose library versions
    // This ensures all Compose libraries use compatible versions.
    implementation(platform("androidx.compose:compose-bom:2024.04.00")) // Always check for the LATEST stable version!

    // Specific Compose UI and Foundation dependencies (versions are managed by the BOM)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose") // Version comes from the BOM

    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")


    // Choose ONE navigation-compose dependency and ensure it's the version you intend to use.
    // I've kept the newer beta version. If you prefer stable, use "2.7.7" and remove the beta one.
    implementation("androidx.navigation:navigation-compose:2.9.0-beta01")
    // REMOVED: Duplicate and older navigation dependency
    // implementation("androidx.navigation:navigation-compose:2.7.7")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // AndroidX Compose Test dependencies (versions managed by the BOM)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Debug implementations for tooling
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Para AppCompatActivity
    implementation ("androidx.appcompat:appcompat:1.6.1") // O una versión más reciente si ya usas una más nueva

// Si estás usando Compose en una Activity basada en AppCompat (como MainActivity o pantallaPrincipal)
    implementation ("androidx.activity:activity-compose:1.8.2") // O la versión que se alinee con tu Compose BOM
}
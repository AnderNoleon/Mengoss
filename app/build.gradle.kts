plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.wavesoffood"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.wavesoffood"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
buildFeatures{
    viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)


    val nav_version = "2.8.0"

    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // Feature module support for Fragments
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    implementation("com.github.denzcoskun:ImageSlideshow:0.1.2")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")




    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)



}
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
}
android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "com.example.case1"
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
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
    androidExtensions {
        isExperimental = true
    }
    buildFeatures{
        viewBinding=true
    }
}
dependencies {
    //Kotlin
    implementation(Dependence.kotlin)

    //Android
    implementation(Dependence.androidCompat)
    implementation(Dependence.androidCore)
    implementation(Dependence.androidMeterial)
    implementation(Dependence.androidConstraintLayout)

    //Lifecycle
    implementation(Dependence.lifecycle)

    //Retrofit
    implementation(Dependence.retrofit)
    implementation(Dependence.gsonConverter)

    //Glide
    implementation(Dependence.glide)
    implementation(Dependence.glideCompiler)

    //Coroutines
    implementation(Dependence.coroutinesCore)
    implementation(Dependence.coroutinesAndroid)

    //ViewModel
    implementation(Dependence.viewModel)

    //LiveData
    implementation(Dependence.liveData)

    //TruthTest
    testImplementation(Dependence.truth)
    androidTestImplementation(Dependence.truthAndroid)

    //NavigationComponent
    implementation(Dependence.navigationFragment)
    implementation(Dependence.navigationUi)

    //NavigationTest
    androidTestImplementation(Dependence.navigationTest)

    // androidxFragment
    implementation(Dependence.androidxFragment)

    //Room
    implementation(Dependence.roomRuntime)
    kapt(Dependence.roomCompiler)
    implementation(Dependence.roomAndroid)

    // Test
    testImplementation(Dependence.junit)
    androidTestImplementation(Dependence.junitx)
    androidTestImplementation(Dependence.espresso)
}





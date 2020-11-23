plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
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
        isExperimental=true
    }
    dataBinding {
        isEnabled = true
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

    testImplementation(Dependence.junit)
    androidTestImplementation(Dependence.junitx)
    androidTestImplementation(Dependence.espresso)
}




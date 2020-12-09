object Versions {
    const val kotlin_version = "1.3.72"
    const val androidCore = "1.2.0"
    const val androidCompat = "1.1.0"
    const val androidMeterial = "1.1.0"
    const val androidConstraintLayout = "1.1.3"
    const val retrofit = "2.9.0"
    const val glide = "4.11.0"
    const val coroutinesCore = "1.3.7"
    const val coroutinesAndroid = "1.3.5"
    const val viewModel = "2.2.0"
    const val liveData = "2.2.0"
    const val junit = "4.+"
    const val junitx = "1.1.1"
    const val espresso = "3.2.0"
    const val truth = "1.1"
    const val navigation = "2.3.2"
    const val fragment = "1.2.5"
}

object Dependence {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"

    const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
    const val androidCompat = "androidx.appcompat:appcompat:${Versions.androidCompat}"
    const val androidMeterial = "com.google.android.material:material:${Versions.androidMeterial}"
    const val androidConstraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidConstraintLayout}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"

    const val liveData = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.liveData}"

    const val junit = "junit:junit:${Versions.junit}"
    const val junitx = "androidx.test.ext:junit:${Versions.junitx}"

    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val truthAndroid = "com.google.truth:truth:${Versions.truth}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationTest = "androidx.navigation:navigation-testing:${Versions.navigation}"

    const val androidxFragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
}
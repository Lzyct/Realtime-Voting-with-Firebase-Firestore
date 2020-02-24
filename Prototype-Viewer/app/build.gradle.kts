plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.github.ben-manes.versions")
    id("com.google.gms.google-services")
//    id("io.fabric") TODO add after register on firebase
}

android {
    dataBinding {
        isEnabled = true
    }
    compileSdkVersion(Android.compileSdk)
    defaultConfig {
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)

        applicationId = Android.applicationId
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", "\"https://apipt.pallakagroup.com\"")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

//TODO disable for unused library
dependencies {
    //    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Androidx.appcompat)
    implementation(Androidx.material)
    implementation(Androidx.recyclerview)
    implementation(Androidx.lifecycle)

    implementation(Kotlin.stdlib)
    implementation(Kotlin.koin)

    implementation(Firebase.core)
    implementation(Firebase.analytics)
    implementation(Firebase.fireStore)
    implementation(Firebase.messaging)

//    implementation(PlayService.map)
//    implementation(PlayService.location)
//    implementation(PlayService.place)

    implementation(Rx.kotlin)
    implementation(Rx.android)
    implementation(Rx.permission)

//    implementation(Retrofit.core)
//    implementation(Retrofit.adapter)
//    implementation(Retrofit.converter)

//    implementation(Room.rx)
//    kapt(Room.compiler)


//    implementation(Androidx.multidex)

//    implementation(Log.okhttp)
//    implementation(Log.logger)

//    implementation(Extra.shimmer)
//    implementation(Extra.coil)
}

//override limit error log to 1000
gradle.projectsEvaluated {
    tasks.withType(JavaCompile::class) {
        options.compilerArgs.addAll(arrayOf("-Xmaxerrs", "1000"))
    }
}
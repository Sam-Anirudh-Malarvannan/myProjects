plugins {
    id("com.android.application")
    id("kotlin-android")

    // ✅ Flutter Gradle plugin (should come last among Android/Kotlin)
    id("dev.flutter.flutter-gradle-plugin")

    // ✅ Google Services plugin for Firebase (ONLY once, not duplicate)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.bridgeit"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    defaultConfig {
        applicationId = "com.example.bridgeit"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // ✅ Import Firebase BoM (Bill of Materials)
    implementation(platform("com.google.firebase:firebase-bom:33.11.0"))

    // ✅ Add your Firebase SDKs here (example: Auth)
    implementation("com.google.firebase:firebase-auth-ktx")

    // 🔁 Add more Firebase SDKs as needed
    // implementation("com.google.firebase:firebase-firestore-ktx")
    // implementation("com.google.firebase:firebase-analytics-ktx")
}

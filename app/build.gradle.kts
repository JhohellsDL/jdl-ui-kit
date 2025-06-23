plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

android {
    namespace = "com.jdlstudios.jdl_ui_kit"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
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
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

afterEvaluate { // Esto asegura que el componente 'release' esté disponible
    publishing {
        publications {
            create<MavenPublication>("release") {
                // Define tus coordenadas únicas para la librería
                groupId = "com.jdlstudios.uikit"        // Tu organización/grupo (ej. dominio inverso)
                artifactId = "jdl-ui-kit"               // El nombre de tu artefacto de librería
                version = "1.0.0"                       // La versión de este lanzamiento específico

                // Especifica que estás publicando la variante 'release' de tu librería Android
                from(components["release"])
            }
        }
        repositories {
            mavenLocal() // Publica en tu repositorio Maven local (~/.m2/repository o ~/.gradle/caches/modules-2/files-2.1)
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
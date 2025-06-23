plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

val GITHUB_OWNER = "JhohellsDL"
val GITHUB_REPO = "jdl-ui-kit"
val LIBRARY_GROUP = "com.jdlstudios.uikit"
val LIBRARY_ARTIFACT_ID = "jdl-ui-kit"
val LIBRARY_VERSION = "1.0.1"


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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = LIBRARY_GROUP
                artifactId = LIBRARY_ARTIFACT_ID
                version = LIBRARY_VERSION



                from(components["release"])
            }
        }
        repositories {
            mavenLocal()
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/$GITHUB_OWNER/$GITHUB_REPO")
                credentials {
                    username = project.findProperty("gpr.user") as String?
                        ?: System.getenv("USERNAME_GITHUB")
                    password = project.findProperty("gpr.token") as String?
                        ?: System.getenv("TOKEN_GITHUB")
                }
            }
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
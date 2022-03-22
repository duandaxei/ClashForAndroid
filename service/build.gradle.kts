plugins {
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("com.android.library")
    id("com.google.devtools.ksp")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":common"))

    ksp(libs.kaidl.compiler)
    kapt(libs.androidx.room.compiler)

    implementation(libs.kotlin.coroutine)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.androidx.core)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.kaidl.runtime)
    implementation(libs.rikkax.multiprocess)
}

afterEvaluate {
    android {
        libraryVariants.forEach {
            sourceSets[it.name].java.srcDir(buildDir.resolve("generated/ksp/${it.name}/kotlin"))
        }
    }
}
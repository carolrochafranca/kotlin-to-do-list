plugins { alias(libs.plugins.android.application); alias(libs.plugins.kotlin.android); alias(libs.plugins.kotlin.compose); alias(libs.plugins.ksp) }

android { namespace = "br.com.carol.todolist"; compileSdk = 35
    defaultConfig { applicationId = "br.com.carol.todolist"; minSdk = 24; targetSdk = 35; versionCode = 1; versionName = "1.0" }
    buildFeatures { compose = true }
}
dependencies {
    implementation(libs.androidx.core.ktx); implementation(libs.androidx.lifecycle.runtime); implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom)); implementation(libs.androidx.compose.ui); implementation(libs.androidx.compose.ui.tooling.preview); implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.room.runtime); implementation(libs.androidx.room.ktx); ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.lifecycle.viewmodel.compose); implementation(libs.androidx.navigation.compose)
}


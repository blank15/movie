import Version.androidXAnnotations
import Version.androidXLegacySupport
import Version.androidXTestVersion
import Version.appCompatVersion
import Version.archLifecycleVersion
import Version.cardVersion
import Version.constraintLayoutVersion
import Version.espressoVersion
import Version.eventbusVersion
import Version.glideVersion
import Version.idleResourceVersion
import Version.junitVersion
import Version.koinVersion
import Version.kotlin_version
import Version.materialVersion
import Version.mockitoVersion
import Version.navVersion
import Version.navigation
import Version.pagingVersion
import Version.recyclerViewVersion
import Version.retrofit2Version
import Version.retrofitAdapter
import Version.roomVersion
import Version.rxandroidVersion
import Version.rxjavaVersion
import Version.sdp

object Release {
    const val versionCode = 1
    const val versionName = "1.0"

    const val buildToolsVersion = "29.0.0"
    const val compileSdkVersion = 28
    const val targetSdkVersion = 28
    const val minSdkVersion = 22
}

object Version {
    const val kotlin_version = "1.3.61"
    const val androidXVersion = "1.0.0"
    const val androidXTestVersion = "1.1.0"
    const val androidXAnnotations = "1.0.1"
    const val androidXLegacySupport = "1.0.0"
    const val materialVersion = "1.0.0"
    const val cardVersion = "1.0.0"
    const val recyclerViewVersion = "1.0.0"
    const val appCompatVersion = "1.0.2"
    const val constraintLayoutVersion = "1.1.3"
    const val roomVersion = "2.1.0"
    const val archLifecycleVersion="2.2.0"
    const val archVersion = "1.1.1"
    const val junitVersion = "4.12"
    const val mockitoVersion = "2.23.4"
    const val espressoVersion = "3.1.0"
    const val navigation = "1.0.0"
    const val sdp = "1.0.5"
    const val glideVersion = "4.9.0"
    const val koinVersion = "2.0.1"
    const val idleResourceVersion = "3.2.0"
    const val retrofit2Version = "2.7.1"
    const val retrofitAdapter = "2.4.0"
    const val rxandroidVersion = "2.1.1"
    const val rxjavaVersion = "2.2.2"
    const val okhttp3Version = "3.11.0"
    const val eventbusVersion = "3.1.1"
    const val lifecycleVersion = "2.2.0"
    const val coroutinesAdapter = "0.9.2"
    const val navVersion = "2.0.0"
    const val pagingVersion = "2.1.0"
}

object Android {

    const val koltin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    const val cardView = "androidx.cardview:cardview:$cardVersion"
    const val material = "com.google.android.material:material:$materialVersion"
    const val rview = "androidx.recyclerview:recyclerview:$recyclerViewVersion"
    const val constraint = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    const val anotation = "androidx.annotation:annotation:$androidXAnnotations"
    const val legacy = "androidx.legacy:legacy-support-v4:$androidXLegacySupport"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navVersion"
    const val navigaitonUi = "androidx.navigation:navigation-ui-ktx:$navVersion"
}

object Arch {
    const val room = "androidx.room:room-runtime:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomKTX = "androidx.room:room-ktx:$roomVersion"
    const val roomRx = "androidx.room:room-rxjava2:$roomVersion"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$archLifecycleVersion"
    const val navigationFragment = "android.arch.navigation:navigation-fragment-ktx:$navigation"
    const val navigationUI = "android.arch.navigation:navigation-ui-ktx:$navigation"
    const val lifecycleliveData = "androidx.lifecycle:lifecycle-livedata-ktx:$archLifecycleVersion"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:$archLifecycleVersion"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$archLifecycleVersion"
}

object Libraries {
    const val sdpAndroid = "com.intuit.sdp:sdp-android:$sdp"
    const val sspAndroid = "com.intuit.ssp:ssp-android:$sdp"

    // Depedency Injection
    const val koin = "org.koin:koin-android:$koinVersion"
    const val koinScope = "org.koin:koin-androidx-scope:$koinVersion"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:$koinVersion"
    const val koinTest = "org.koin:koin-test:$koinVersion"

    // Dependencies for Glide
    const val glide = "com.github.bumptech.glide:glide:$glideVersion"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"
    const val eventbus = "org.greenrobot:eventbus:$eventbusVersion"

    const val pagination = "androidx.paging:paging-runtime-ktx:$pagingVersion"

    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android1.3.5"
}

object Network {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:$retrofit2Version"
    const val retrofit2Converter = "com.squareup.retrofit2:converter-gson:$retrofit2Version"
    const val retrofit2Adapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitAdapter"
    const val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Version.coroutinesAdapter}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:$rxandroidVersion"
    const val rxjava = "io.reactivex.rxjava2:rxjava:$rxjavaVersion"
    const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3Version}"
}

object TestLib {
    // Dependencies for local unit tests
    const val junit = "junit:junit:$junitVersion"
    const val mockito = "org.mockito:mockito-core:$mockitoVersion"
    const val nhaarman = "com.nhaarman:mockito-kotlin:1.6.0"
    const val mockitoLine = "org.mockito:mockito-inline:2.22.0"

    const val archTesting = "androidx.arch.core:core-testing:$archLifecycleVersion"


    // Android Testing Support Library's runner and rules
    const val junitX = "androidx.test.ext:junit:$androidXTestVersion"
    const val coreTest = "androidx.test:core:$androidXTestVersion"
    const val testRule = "androidx.test:rules:$androidXTestVersion"
    const val archTestingRoom = "android.arch.persistence.room:testing:$archLifecycleVersion"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoVersion"
    const val coreTesting = "androidx.arch.core:core-testing:$archLifecycleVersion"


    // Dependencies for Idle Resource
    const val idleResource = "androidx.test.espresso:espresso-idling-resource:$idleResourceVersion"
}
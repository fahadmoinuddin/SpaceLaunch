apply {
    from("$rootDir/presentation-module.gradle")
}

dependencies {
    "api"(Retrofit.retrofit)
}
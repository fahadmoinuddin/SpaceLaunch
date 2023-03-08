apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.astronautDomain))

    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.retrofitKotlinSerialization)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
}
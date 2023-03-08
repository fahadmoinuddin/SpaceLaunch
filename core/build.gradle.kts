apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(Lifecycle.lifecycleRuntime)
    "implementation"(Google.material)
}
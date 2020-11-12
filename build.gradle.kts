plugins {
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    //JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks.withType<Test>{
    useJUnitPlatform()
}


tasks.register<Test>("Simple Custom Task") {
    val tag = "IntegrationTest"
    description = "runs all tests with the tag $tag"
    group = "custom tests"

    useJUnitPlatform {
        includeTags(tag)
    }
}

tasks.register<IntegrationTest>("Custom Type Task")

open class IntegrationTest : Test() {
    init {
        val nameSuffix = "IntegrationTest"
        description = "runs all tests ending with $nameSuffix"
        group = "custom tests"

        filter.includeTestsMatching("*$nameSuffix")
    }

    @TaskAction
    fun run(){
        println("unnecessary task action: " +
                "tests run because of another TaskAction defined in Test()"
        )
    }
}

plugins {
    id("hephaestus.common-conventions")
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "erethon"
            url = uri("https://reposilite.fyreum.de/snapshots/")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "${project.group}"
            artifactId = "hephaestus-engine"
            version = "${project.version}"

            from(components["java"])
        }
    }
}
plugins {
    id("hephaestus.runtime-bukkit-conventions")
    id("hephaestus.publishing-conventions")
    id("io.papermc.paperweight.userdev") version "1.7.1"
}

repositories {
    maven("https://libraries.minecraft.net/")
    maven("https://erethon.de/repo/")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }
}

dependencies {
    paperweight.devBundle("de.erethon.papyrus", "1.21-R0.1-SNAPSHOT") { isChanging = true }
    //paperweight.paperDevBundle("1.21-R0.1-SNAPSHOT") { isChanging = true }

    implementation(project(":hephaestus-runtime-bukkit-api"))
}

tasks {
    reobfJar {
        outputJar = file("build/libs/hephaestus-runtime-bukkit-adapt-v1_21_R1-reobf.jar")
    }
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            artifact(tasks.reobfJar) {
                classifier = "reobf"
            }
        }
    }
}
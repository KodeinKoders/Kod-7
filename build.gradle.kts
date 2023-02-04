plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

repositories {
    mavenCentral()
}

val copyImages = tasks.register<Copy>("copyImages") {
    from("imgs")
    into("docs/imgs")
}

tasks.asciidoctor {
    dependsOn(copyImages)
    sourceDir(rootDir)
    setOutputDir(rootDir.resolve("docs"))
}

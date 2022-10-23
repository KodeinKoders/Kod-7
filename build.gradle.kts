plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

repositories {
    mavenCentral()
}

tasks.asciidoctor {
    sourceDir(rootDir)
    setOutputDir(rootDir.resolve("docs"))
}

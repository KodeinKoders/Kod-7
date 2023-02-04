plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

repositories {
    mavenCentral()
}

tasks.asciidoctor {
    sourceDir(rootDir)
}

val copyImages = tasks.register<Copy>("copyImages") {
    from("imgs")
    into("docs/imgs")
}

val copyAdoc = tasks.register<Copy>("copyAdoc") {
    dependsOn(tasks.asciidoctor)
    from("build/docs/asciidoc") {
        rename {
            if (it == "README.html") "index.html"
            else it
        }
    }
    into("docs")
}

tasks.register("publish") {
    group = "publish"
    dependsOn(copyImages, copyAdoc)
}
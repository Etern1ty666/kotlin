plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

// Every lesson is a standalone file in src/main/kotlin/lessons with its own
// main(). This block turns each one into its own Gradle task, so
//
//     ./gradlew lesson05
//
// compiles everything and runs only Lesson05Loops.kt. Drop a new
// LessonNNName.kt into that folder and the task appears by itself.

val lessonsDir = layout.projectDirectory.dir("src/main/kotlin/lessons").asFile

/** "Lesson05Loops.kt" -> "05". Used for the task name. */
fun lessonNumber(fileName: String): String? =
    Regex("""^Lesson(\d+)""").find(fileName)?.groupValues?.get(1)

/** Reads the `package ...` line so the task knows the generated class name. */
fun packageOf(file: File): String? =
    file.useLines { lines ->
        lines.firstOrNull { it.trimStart().startsWith("package ") }
            ?.trim()
            ?.removePrefix("package ")
            ?.trim()
    }

val lessonFiles = (lessonsDir.listFiles() ?: emptyArray())
    .filter { it.isFile && it.name.endsWith(".kt") }
    .sortedBy { it.name }

val lessonTaskNames = mutableListOf<String>()

lessonFiles.forEach { file ->
    val number = lessonNumber(file.name) ?: return@forEach
    val className = file.nameWithoutExtension + "Kt"
    val pkg = packageOf(file)
    val mainClassName = if (pkg.isNullOrBlank()) className else "$pkg.$className"

    val taskName = "lesson$number"
    lessonTaskNames += taskName

    tasks.register<JavaExec>(taskName) {
        group = "lessons"
        description = "Run ${file.name}"
        mainClass.set(mainClassName)
        classpath = sourceSets["main"].runtimeClasspath
        // lets lessons 7 and 28 read what you type in the terminal
        standardInput = System.`in`
    }
}

tasks.register("lessons") {
    group = "lessons"
    description = "List every lesson task"
    val names = lessonTaskNames.toList()
    val titles = lessonFiles.map { it.nameWithoutExtension }
    doLast {
        println("Available lessons (run with ./gradlew <task> -q --console=plain):")
        names.forEachIndexed { i, name -> println("  $name  ->  ${titles[i]}.kt") }
    }
}

kotlin {
    jvmToolchain(21)
}

plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

// Every file in src/main/kotlin/lessons has its own main(). This block turns
// each one into its own Gradle task:
//
//     ./gradlew lesson05     -> runs Lesson05Loops.kt
//     ./gradlew runMain      -> runs main.kt  (your own scratch files)
//     ./gradlew runFile -Pfile=main.kt
//
// Drop a new file into that folder and its task appears by itself.

val lessonsDir = layout.projectDirectory.dir("src/main/kotlin/lessons").asFile

/** "Lesson05Loops.kt" -> "05", "main.kt" -> null. */
fun lessonNumber(fileName: String): String? =
    Regex("""^Lesson(\d+)""").find(fileName)?.groupValues?.get(1)

/** Reads the `package ...` line, if the file has one. */
fun packageOf(file: File): String? =
    file.useLines { lines ->
        lines.firstOrNull { it.trimStart().startsWith("package ") }
            ?.trim()
            ?.removePrefix("package ")
            ?.trim()
    }

/**
 * The class the Kotlin compiler generates for a file: the file name with a
 * capital first letter plus "Kt", inside the file's package.
 * main.kt -> main.MainKt,  Lesson05Loops.kt -> lesson05.Lesson05LoopsKt
 */
fun mainClassOf(file: File): String {
    val className = file.nameWithoutExtension.replaceFirstChar { it.uppercase() } + "Kt"
    val pkg = packageOf(file)
    return if (pkg.isNullOrBlank()) className else "$pkg.$className"
}

val lessonFiles = (lessonsDir.listFiles() ?: emptyArray())
    .filter { it.isFile && it.name.endsWith(".kt") }
    .sortedBy { it.name.lowercase() }

// task name -> file name, for the `lessons` listing below
val taskIndex = linkedMapOf<String, String>()

lessonFiles.forEach { file ->
    val number = lessonNumber(file.name)
    // Non-lesson files get a "run" prefix so a file called Build.kt or Test.kt
    // cannot collide with a Gradle task of the same name.
    val taskName = if (number != null) {
        "lesson$number"
    } else {
        "run" + file.nameWithoutExtension.replaceFirstChar { it.uppercase() }
    }
    if (taskName in taskIndex) return@forEach
    taskIndex[taskName] = file.name

    tasks.register<JavaExec>(taskName) {
        group = "lessons"
        description = "Run ${file.name}"
        mainClass.set(mainClassOf(file))
        classpath = sourceSets["main"].runtimeClasspath
        // lets the lessons that call readLine() read what you type
        standardInput = System.`in`
    }
}

// Runs whichever file you name. Used by the "run the file I am editing"
// task in .vscode/tasks.json, which passes the open file's name.
tasks.register<JavaExec>("runFile") {
    group = "lessons"
    description = "Run one file: ./gradlew runFile -Pfile=main.kt"
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
    mainClass.set(
        providers.provider {
            val requested = project.findProperty("file") as String?
                ?: error("Name the file, e.g. ./gradlew runFile -Pfile=main.kt")
            val base = requested.substringAfterLast('/').removeSuffix(".kt")
            val file = lessonsDir.resolve("$base.kt")
            require(file.isFile) {
                "No such file: src/main/kotlin/lessons/$base.kt"
            }
            mainClassOf(file)
        }
    )
}

tasks.register("lessons") {
    group = "lessons"
    description = "List every runnable file"
    val index = LinkedHashMap(taskIndex)
    doLast {
        println("Run with ./gradlew <task> -q --console=plain:")
        val width = index.keys.maxOfOrNull { it.length } ?: 0
        index.forEach { (task, file) -> println("  ${task.padEnd(width)}  ->  $file") }
    }
}

kotlin {
    jvmToolchain(21)
}

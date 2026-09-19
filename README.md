# Kotlin from scratch — lessons 1–28

Course examples, one runnable file per lesson. Every file has its own `main()`
and its own package, so each one is self-contained: you can read it top to
bottom, run it on its own, or paste it into
[play.kotlinlang.org](https://play.kotlinlang.org) without touching anything else.

```
app/src/main/kotlin/lessons/
  Lesson01Intro.kt
  Lesson02Variables.kt
  ...
  Lesson28TodoList.kt
```

## Running a lesson

From the terminal:

```bash
./gradlew lesson05 -q --console=plain
```

`lesson01` … `lesson28`. To see the whole list:

```bash
./gradlew lessons -q --console=plain
```

You don't need a JDK installed — Gradle downloads the one it needs on the
first run (`gradle/gradle-daemon-jvm.properties`). The first build takes a
minute; after that it is instant.

## Running from VS Code

Open **this** folder (`kotlin/first`) in VS Code — not the folder above it,
otherwise VS Code never sees `.vscode/` and nothing below will show up.

There are three ways to run a lesson, easiest first.

### 1. Shift+Cmd+B

Open a `.kt` file and press **⇧⌘B** (*Terminal → Run Build Task*) — it runs
**the file you are looking at**, in the integrated terminal. Works with no
extensions at all.

The same menu has *Run a lesson*, which asks you to pick one from a list
instead.

### 2. The Gradle panel

Install **Gradle for Java** (`vscjava.vscode-gradle`), then click the elephant
icon in the left sidebar:

```
GRADLE PROJECTS
└── kotlin-lessons
    └── app
        └── Tasks
            └── lessons
                ├── lesson01   ▶
                ├── lesson02   ▶
                └── ...
```

Hover a task and press ▶.

If the panel stays empty, it is the JDK: the `java` on this machine is
version 8 and Gradle 9 needs 17 or newer. `.vscode/settings.json` points the
extension at a newer JDK — check that the path in `java.import.gradle.java.home`
still exists on your machine, then *Developer: Reload Window*.

### 3. F5

Press **F5** and pick a lesson. This uses the debug adapter bundled with the
**Kotlin** extension (`fwcd.kotlin`) — the first run downloads it, which takes
a couple of minutes. Breakpoints work here; the other two ways just run.

## Lessons that ask for input

Lesson 7 (commented out by default) and lesson 28 read from the keyboard.
The Gradle tasks forward your terminal input, so just run them and type:

```bash
./gradlew lesson28 -q --console=plain
```

**⇧⌘B** works for these too. The Gradle panel's ▶ does not — it runs tasks
outside a real terminal, so there is nowhere to type.

## Adding a lesson

Drop a file into `app/src/main/kotlin/lessons/` with a `fun main()` in it.
The build script scans that folder, so the task appears on its own:

| File | Task |
|------|------|
| `Lesson29Coroutines.kt` | `./gradlew lesson29` |
| `main.kt` | `./gradlew runMain` |
| `Scratch.kt` | `./gradlew runScratch` |

Anything named `LessonNN…` becomes `lessonNN`; everything else gets a `run`
prefix, so a file called `Build.kt` cannot collide with Gradle's own `build`
task. Give the file a `package` of its own if it declares names that already
exist elsewhere — see the note on packages below.

Or skip the task names entirely and run a file by name:

```bash
./gradlew runFile -Pfile=main.kt
```

That is what **⇧⌘B** uses under the hood.

## A word on `package`

Each lesson file starts with its own `package` line. It is not required by
Kotlin — a file without one still compiles — but here it is doing real work:
the course reuses names (`Student` in lessons 12 and 24, `Circle` in 15 and
20, and 28 functions called `main`), and two declarations with the same name
cannot live in the same package. Separate packages keep them apart.

The package also decides the class name the JVM sees, which is what the
Gradle task and `launch.json` point at: `Lesson05Loops.kt` with
`package lesson05` becomes `lesson05.Lesson05LoopsKt`.

## What is where

| # | File | Topic |
|---|------|-------|
| 01 | `Lesson01Intro.kt` | `main`, `println`, comments |
| 02 | `Lesson02Variables.kt` | `val`/`var`, basic types, string templates |
| 03 | `Lesson03Math.kt` | arithmetic, integer division trap, `%` |
| 04 | `Lesson04Conditions.kt` | `if` as an expression, `when`, smart cast |
| 05 | `Lesson05Loops.kt` | `while`, `do-while`, `for`, ranges, `break`/`continue`, labels |
| 06 | `Lesson06Arrays.kt` | `arrayOf`, `IntArray`, indices, `joinToString` |
| 07 | `Lesson07StringsAndInput.kt` | `toInt` vs `toIntOrNull`, `readLine()` |
| 08 | `Lesson08Functions.kt` | parameters, defaults, named args, recursion |
| 09 | `Lesson09Practice.kt` | practice: grades and an average |
| 10 | `Lesson10NullSafety.kt` | `?.`, `?:`, `!!`, `let`, `as?` |
| 11 | `Lesson11Classes.kt` | classes, methods, computed properties |
| 12 | `Lesson12Constructors.kt` | primary/secondary constructors, `init` |
| 13 | `Lesson13Inheritance.kt` | `open`, `override`, `super` |
| 14 | `Lesson14Visibility.kt` | `private`, `protected`, `internal` |
| 15 | `Lesson15AbstractAndInterfaces.kt` | abstract classes vs interfaces |
| 16 | `Lesson16Practice.kt` | practice: employee hierarchy |
| 17 | `Lesson17Memory.kt` | stack vs heap, `==` vs `===` |
| 18 | `Lesson18ToString.kt` | `Any.toString()` |
| 19 | `Lesson19EqualsHashCode.kt` | `equals`/`hashCode`, `data class` |
| 20 | `Lesson20Polymorphism.kt` | dynamic dispatch, `is`, `as?` |
| 21 | `Lesson21Exceptions.kt` | `try`/`catch`/`finally`, custom exceptions |
| 22 | `Lesson22Extensions.kt` | extension functions |
| 23 | `Lesson23Generics.kt` | generic classes, functions, constraints |
| 24 | `Lesson24ListCollection.kt` | `List`, `MutableList`, `filter`/`map`/chains |
| 25 | `Lesson25Encapsulation.kt` | `private set`, custom setters, `field` |
| 26 | `Lesson26MapCollection.kt` | `Map`, `MutableMap`, destructuring |
| 27 | `Lesson27SetCollection.kt` | `Set`, `union`/`intersect`/`subtract` |
| 28 | `Lesson28TodoList.kt` | final task: a console to-do list |

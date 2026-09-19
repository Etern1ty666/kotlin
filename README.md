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

1. Open this folder in VS Code.
2. Accept the recommended extensions when prompted (`.vscode/extensions.json`):
   - **Kotlin** (`fwcd.kotlin`) — highlighting and completion
   - **Gradle for Java** (`vscjava.vscode-gradle`) — a Gradle panel where every
     `lessonNN` task has a ▶ button next to it
3. Run a lesson either way:
   - **⇧⌘B** (or *Terminal → Run Build Task*) → pick a lesson from the list
   - or open the Gradle panel in the sidebar → `app` → *Tasks* → *lessons* →
     click ▶ on `lesson05`

### Debugging

VS Code cannot launch Kotlin directly, so you attach to the JVM instead:

1. *Terminal → Run Task* → **Debug a lesson** → pick a lesson.
   It prints `Listening for transport dt_socket at address: 5005` and waits.
2. Press **F5** and choose *Attach to a running lesson (port 5005)*.

Needs the *Extension Pack for Java* extension.

## Lessons that ask for input

Lesson 7 (commented out by default) and lesson 28 read from the keyboard.
The Gradle tasks forward your terminal input, so just run them and type:

```bash
./gradlew lesson28 -q --console=plain
```

## Adding a lesson

Drop a new file into `app/src/main/kotlin/lessons/` named `LessonNNSomething.kt`
with `package lessonNN` and a `fun main()`. The `lessonNN` Gradle task appears
on its own — the build script scans the folder.

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

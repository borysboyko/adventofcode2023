package com.borysboyko.adventofcode2023.Day1

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val linesOfText = File("day1input.txt").readText().split('\n')
        var sum = 0

        for (line in linesOfText) {
            // Forward
            for (i in line.indices) {
                if (Character.isDigit(line[i])) {
                    sum += (Character.getNumericValue(line[i]) * 10)
                    break
                } else {
                    val currentString = line.substring(i)
                    if (currentString.startsWith("zero")) {
                        sum += 0
                        break
                    } else if (currentString.startsWith("one")) {
                        sum += 10
                        break
                    } else if (currentString.startsWith("two")) {
                        sum += 20
                        break
                    } else if (currentString.startsWith("three")) {
                        sum += 30
                        break
                    } else if (currentString.startsWith("four")) {
                        sum += 40
                        break
                    } else if (currentString.startsWith("five")) {
                        sum += 50
                        break
                    } else if (currentString.startsWith("six")) {
                        sum += 60
                        break
                    } else if (currentString.startsWith("seven")) {
                        sum += 70
                        break
                    } else if (currentString.startsWith("eight")) {
                        sum += 80
                        break
                    } else if (currentString.startsWith("nine")) {
                        sum += 90
                        break
                    }
                }
            }

            // Backward
            for (i in line.indices.reversed()) {
                if (Character.isDigit(line[i])) {
                    sum += (Character.getNumericValue(line[i]))
                    break
                } else {
                    val currentString = line.substring(i)
                    if (currentString.startsWith("zero")) {
                        sum += 0
                        break
                    } else if (currentString.startsWith("one")) {
                        sum += 1
                        break
                    } else if (currentString.startsWith("two")) {
                        sum += 2
                        break
                    } else if (currentString.startsWith("three")) {
                        sum += 3
                        break
                    } else if (currentString.startsWith("four")) {
                        sum += 4
                        break
                    } else if (currentString.startsWith("five")) {
                        sum += 5
                        break
                    } else if (currentString.startsWith("six")) {
                        sum += 6
                        break
                    } else if (currentString.startsWith("seven")) {
                        sum += 7
                        break
                    } else if (currentString.startsWith("eight")) {
                        sum += 8
                        break
                    } else if (currentString.startsWith("nine")) {
                        sum += 9
                        break
                    }
                }
            }
        }

        println(sum)
    }

    println("\nExecution time in milliseconds: $executionTime")
}

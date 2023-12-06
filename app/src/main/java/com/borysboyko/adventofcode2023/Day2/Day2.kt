package com.borysboyko.adventofcode2023.Day2

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    // Not counting reading the file into execution time.
    val text = File("day2input.txt").readText()

    val executionTime = measureTimeMillis {
        val linesOfText = text.split('\n')

        var redMaxCount = 12
        var greenMaxCount = 13
        var blueMaxCount = 14

        var totalGameSum = 0
        var badGameSum = 0
        var powerSum = 0

        outer@ for (i in linesOfText.indices) {
            val modifier = if (i < 10) {
                8
            } else if (i < 100) {
                9
            } else {
                10
            }

            if (linesOfText[i].isEmpty()) {
                continue@outer
            }

            val gameNum = i + 1

            totalGameSum += gameNum

            var redCount = 0
            var greenCount = 0
            var blueCount = 0

            var currentNumber = 0
            var markedBad = false

            inner@ for (j in linesOfText[i].indices) {
                while (j < modifier) {
                    continue@inner
                }

                if (linesOfText[i][j].isDigit()) {
                    currentNumber += if (linesOfText[i][j + 1].isDigit()) {
                        Character.getNumericValue(linesOfText[i][j]) * 10
                    } else {
                        Character.getNumericValue(linesOfText[i][j])
                    }
                } else if (linesOfText[i][j] == 'r') {
                    if (!markedBad && currentNumber > redMaxCount) {
                        badGameSum += gameNum
                        markedBad = true
                    }

                    redCount = if (currentNumber > redCount) {
                        currentNumber
                    } else {
                        redCount
                    }
                    currentNumber = 0
                } else if (linesOfText[i][j] == 'g') {
                    if (!markedBad && currentNumber > greenMaxCount) {
                        badGameSum += gameNum
                        markedBad = true
                    }

                    greenCount = if (currentNumber > greenCount) {
                        currentNumber
                    } else {
                        greenCount
                    }
                    currentNumber = 0
                } else if (linesOfText[i][j] == 'b') {
                    if (!markedBad && currentNumber > blueMaxCount) {
                        badGameSum += gameNum
                        markedBad = true
                    }

                    blueCount = if (currentNumber > blueCount) {
                        currentNumber
                    } else {
                        blueCount
                    }
                    currentNumber = 0
                }
            }

            powerSum += (redCount * greenCount * blueCount)
        }

        println("(Part 1) gameSum: " + (totalGameSum - badGameSum))
        println("(Part 2) powerSum: $powerSum")
    }

    println("\nExecution time in milliseconds: $executionTime")
}

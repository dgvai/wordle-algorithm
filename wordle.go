package main

import (
	"fmt"
	"strings"
)

func Wordle(guess string, solution string) []string {
	var splitSolution = []rune(solution)
	var splitGuess = []rune(guess)

	var solutionCharsTaken = make([]bool, len(splitSolution))
	for i := range solutionCharsTaken {
		solutionCharsTaken[i] = false
	}

	var statuses = make([]string, len(splitGuess))

	/*
	Correct Cases
	*/

	for i,letter := range splitGuess {
		if(letter == splitSolution[i]) {
			statuses[i] = "correct"
			solutionCharsTaken[i] = true
			continue
		}
	}

	/*
	Absent Cases
	*/

	for i, letter := range splitGuess {
		if (statuses[i] != "") {
			continue
		}

		if(!strings.ContainsRune(solution, letter)) {
			statuses[i] = "absent"
			continue
		}

		/*
		Present Cases
		*/

		var indexOfPresentChar = strings.IndexRune(solution, letter)

		if (indexOfPresentChar > -1) {
			statuses[i] = "present"
			solutionCharsTaken[indexOfPresentChar] = true 
			continue
		} else {
			statuses[i] = "absent"
			continue
		}
	}

	return statuses


}

func main() {
	fmt.Print(Wordle("agshs","sdsds"))
}
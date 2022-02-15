def Wordle(guess, solution):

    splitSolution = list(solution)
    splitGuess = list(guess)

    solutionCharsTaken = list(map(lambda x: False, splitSolution))

    statuses = [None] * len(guess)


    # Correct Cases

    for (i, letter) in enumerate(splitGuess):
        if(letter == splitSolution[i]):
            statuses[i] = 'correct'
            solutionCharsTaken[i] = True
            continue
    
    # Absent Cases

    for (i, letter) in enumerate(splitGuess):

        if(statuses[i]) : continue

        if(letter not in splitSolution):
            statuses[i] = 'absent'
            continue

        # Present Cases
        
        indexOfPresentChar = splitSolution.index(letter) if not solutionCharsTaken[splitSolution.index(letter)] else -1

        if(indexOfPresentChar > -1):
            statuses[i] = 'present'
            solutionCharsTaken[indexOfPresentChar] = True
            continue
        else:
            statuses[i] = 'absent'
            continue

    return statuses
    
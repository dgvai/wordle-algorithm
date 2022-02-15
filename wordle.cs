using System;
using System.Linq;
public static class Wordle
{
    public static string[] Wordle(string guess, string solution) 
    {
        char[] splitSolution = solution.ToCharArray();
        char[] splitGuess = guess.ToCharArray();

        bool[] solutionCharsTaken = Enumerable.Repeat(false, splitSolution.Length).ToArray();

        string[] statuses = new string[guess.Length];

        /*
        Correct Cases
        */

        foreach(var item in splitGuess.Select((letter, i) => new { i, letter })) {
            if(item.letter == splitSolution[item.i]) {
                statuses[item.i] = "correct";
                solutionCharsTaken[item.i] = true;
                continue;
            }
        }

        /*
        Absent Cases
        */

        foreach(var item in splitGuess.Select((letter, i) => new { i, letter })) {

            if(!String.IsNullOrEmpty(statuses[item.i])) continue;

            if(!Array.Exists(splitSolution, elem => elem == item.letter)) {
                statuses[item.i] = "absent";
                continue;
            }

            /*
            Present Cases
            */

            int indexOfPresentChar = Array.FindIndex(splitSolution, x => x == item.letter);
            
            if(indexOfPresentChar > -1) {
                if(!solutionCharsTaken[indexOfPresentChar]) {
                    statuses[item.i] = "present";
                    solutionCharsTaken[indexOfPresentChar] = true;
                } else {
                    statuses[item.i] = "absent";
                }
                continue;
                
            } else {
                statuses[item.i] = "absent";
                continue;
            }
        }

        return statuses;
    }
}
<?php 

function Wordle($guess, $solution) {
    $splitSolution = str_split($solution);
    $splitGuess = str_split($guess);

    $solutionCharsTaken = array_map(function($v) {
        return false;
    }, $splitSolution);

    $statuses = [];

    /*
    Correct Cases
    */

    foreach($splitGuess as $i => $letter) {
        if($letter === $splitSolution[$i]) {
            $statuses[$i] = 'correct';
            $solutionCharsTaken[$i] = true;
            continue ;
        }
    }

    /*
    Absent Cases
    */

    foreach($splitGuess as $i => $letter) {
        
        if(isset($statuses[$i])) continue;

        if(!in_array($letter, $splitSolution)) {
            $statuses[$i] = 'absent';
            continue;
        }

        /*
        Present Cases
        */
        
        $indexOfPresentChar = !$solutionCharsTaken[array_search($letter, $splitSolution)] ? array_search($letter, $splitSolution) : -1;

        if($indexOfPresentChar > -1) {
            $statuses[$i] = 'present';
            $solutionCharsTaken[$indexOfPresentChar] = true;
            continue;
        } else {
            $statuses[$i] = 'absent';
            continue;
        }
    }

    return $statuses;
}
import java.util.*;

class wordle {

    public static List<String> Wordle(String guess, String solution) {

        final int LENGTH = solution.length();

        List<Character> splitSolution = new ArrayList<>(LENGTH);
        List<Character> splitGuess = new ArrayList<>(LENGTH);
        List<Boolean> solutionCharsTaken = new ArrayList<>(LENGTH);
        List<String> statuses = new ArrayList<String>(LENGTH);

        for(char ch : solution.toCharArray()) {
            splitSolution.add(ch);
        }

        for(char ch : guess.toCharArray()) {
            splitGuess.add(ch);
            solutionCharsTaken.add(false);
            statuses.add(null);
        }

        /*
        Correct Cases
        **/

        int i = 0;

        for(char ch: splitGuess) {
            if(ch == splitSolution.get(i)) {
                statuses.set(i, "correct");
                solutionCharsTaken.set(i, true);
                i++;
                continue;
            }
        }

        /**
         * Absent Cases
         */

        int j = 0;

        for(char ch: splitGuess) {
            if(statuses.get(j) != null) {
                j++;
                continue;
            }

            if(!splitSolution.contains(ch)) {
                statuses.set(j, "absent");
                j++;
                continue;
            }

            /**
             * Present Cases
             */

            int indexOfPresentChar = !solutionCharsTaken.get(splitSolution.indexOf(ch)) ? splitSolution.indexOf(ch) : -1;

            if(indexOfPresentChar > -1) {
                statuses.set(j, "present");
                solutionCharsTaken.add(j, true);
                j++;
                continue;
            } else {
                statuses.set(j, "absent");
                j++;
                continue;
            }
        }

        return statuses;

        
    }

    public static void main(String args[]) {
        List<String> statuses = wordle.Wordle("night","nilgt");

        for(String st: statuses) {
            System.out.println(st);
        }
    }
}


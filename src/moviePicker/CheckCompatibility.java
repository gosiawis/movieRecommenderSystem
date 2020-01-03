package moviePicker;

import java.util.ArrayList;
import java.util.Random;

public class CheckCompatibility {

    private ArrayList<Integer> scores;
    private ArrayList<Integer> bestScores;

    public CheckCompatibility() {
        this.scores = new ArrayList<Integer>();
        this.bestScores = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }
    public ArrayList<Integer> getBestScores() {
        if(checkHowManyBest()) {
            System.out.println("Dobranych filmów było więcej niż trzy. Aby uprościć wybór ograniczymy ich ilość do trzech.");
            this.bestScores = random3Best();
        }
        return bestScores;
    }

    public void setScores(ArrayList<String[]> base, ArrayList<Integer> options) {
        for (String[] movie: base ) {
            Integer score = 0;
            //checkYear
            if(checkYear(movie[1], options.get(0)))
                score++;
            //checkPrincess
            if(checkOption(movie[2], options.get(1)))
                score++;
            //checkMusical
            if(checkOption(movie[3], options.get(2)))
                score++;
            //checkAnimation
            if(checkAnimationType(movie[4], options.get(3)))
                score++;
            //checkAnimals
            if(checkOption(movie[5], options.get(4)))
                score++;
            //checkPart
            if(checkPart(movie[6], options.get(5)))
                score++;
            this.scores.add(score);
        }

    }

    private boolean checkYear(String year, Integer option) {
        Integer yearNumber = Integer.parseInt(year);
        if(option.equals(1) && yearNumber<=2000)
                return true;
        if (option.equals(2) && yearNumber>2000)
                return true;
        if (option.equals(3))
            return true;
        return false;
    }
    private boolean checkOption(String characteristic, Integer option) {
        Integer characteristicNumber = Integer.parseInt(characteristic);
        if(option.equals(1) && characteristicNumber == 1)
                return true;
        if (option.equals(2) && characteristicNumber == 0)
                return true;
        if (option.equals(3))
            return true;
        return false;
    }
    private boolean checkAnimationType(String animationType, Integer option) {
        Integer animationTypeNumber = Integer.parseInt(animationType);
        if(option.equals(1) && animationTypeNumber == 2)
            return true;
        if (option.equals(2) && animationTypeNumber == 3)
            return true;
        if (option.equals(3))
            return true;
        return false;
    }
    private boolean checkPart(String part, Integer option) {
        Integer partNumber = Integer.parseInt(part);
        if(option.equals(1) && partNumber == 1)
            return true;
        if (option.equals(2) && !(partNumber == 1))
            return true;
        if (option.equals(3))
            return true;
        return false;
    }

    public ArrayList<Integer> checkScores() {
        for(int i=0; i<this.scores.size(); i++) {
            if(this.scores.get(i).equals(6))
                bestScores.add(i);
        }
        if(bestScores.size()==0) {
            System.out.println("Nie udało się nam znaleźć filmu idealnego, ale może mamy w zanadrzu coś prawie prawie doskonałego.");
            for(int i=0; i<this.scores.size(); i++) {
                if(this.scores.get(i).equals(5))
                    bestScores.add(i);
            }
        }
        if(bestScores.size()==0) {
            System.out.println("Nie udało się nam znaleźć filmu prawie idealnego, szukamy dalej.");
            for(int i=0; i<this.scores.size(); i++) {
                if(this.scores.get(i).equals(4))
                    bestScores.add(i);
            }
        }
        if(bestScores.size()==0) {
            System.out.println("Not this time either - szukamy dalej");
            for(int i=0; i<this.scores.size(); i++) {
                if(this.scores.get(i).equals(3))
                    bestScores.add(i);
            }
        }
        if(bestScores.size()==0) {
            System.out.println("No gdzie się podział ten film idealny ?!");
            for(int i=0; i<this.scores.size(); i++) {
                if(this.scores.get(i).equals(2))
                    bestScores.add(i);
            }
        }
        if(bestScores.size()==0) {
            System.out.println("No jak tu nie ma to już nie wiem gdzie jest...");
            for(int i=0; i<this.scores.size(); i++) {
                if(this.scores.get(i).equals(1))
                    bestScores.add(i);
            }
        }
        if(bestScores.size()==0) {
            System.out.println("No to ostatnia nadzieja");
            for(int i=0; i<this.scores.size(); i++) {
                if(this.scores.get(i).equals(0))
                    bestScores.add(i);
            }
        }
        if(bestScores.size()==0)
            System.out.println("Nie udało się nam znaleźć filmu dla ciebie i bardzo nam przykro z tego powodu :(");
        return bestScores;
    }

    public boolean checkHowManyBest () {
        if(this.bestScores.size()>3)
            return true;
        return false;
    }

    public ArrayList<Integer> random3Best () {
        int bestScoresSize = this.bestScores.size();
        ArrayList<Integer> best3Movies = new ArrayList();
        Random random = new Random();
        for(int i = 0; i<3; i++) {
            Integer randomIndex = random.nextInt(bestScoresSize);
            if(checkRandom(best3Movies, randomIndex)) {
                best3Movies.add(randomIndex);
            }
        }
        return best3Movies;
    }

    public boolean checkRandom (ArrayList<Integer> indexes, Integer randomIndex) {
        boolean randomBool = true;
        for (Integer pomIndex:indexes) {
            if(pomIndex.equals(randomIndex))
                randomBool = false;
            if(pomIndex == randomIndex)
                randomBool = false;
        }
        return randomBool;
    }
}

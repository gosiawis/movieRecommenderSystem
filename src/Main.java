import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	    // get movies database
        CSVReader csvReader = new CSVReader();
        try {
            csvReader.setBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //display questions and gather answers
        OptionsGetter optionsGetter = new OptionsGetter();
        optionsGetter.setOptions();

        CheckCompatibility checkCompatibility = new CheckCompatibility();
        checkCompatibility.setScores(csvReader.getBase(), optionsGetter.getOptions());
        checkCompatibility.checkScores();

        System.out.println("Proponowane filmy:");
        for(Integer best : checkCompatibility.getBestScores()) {
            System.out.println((csvReader.getBase().get(best))[0]);
        }
    }
}

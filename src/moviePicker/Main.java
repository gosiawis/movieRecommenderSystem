package moviePicker;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    // get movies database
        CSVReader csvReader = new CSVReader();
        try {
            csvReader.setBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Witaj w systemie eksperckim Disney Movie Picker!");
        System.out.println("");
        System.out.println("System, który masz przed sobą pomoże Ci wybrać animację wytwórni Disney do obejrzenia,\nktóra najlepiej będzie odpowiedać Twoim oczekiwaniom.");
        System.out.println("Zaraz zostanie Ci zadane 6 pytań. Proszę udziel na nie odpowiedzi 1, 2 lub 3.\nPo udzieleniu odpowiedzi naciśnij przycisk ENTER.");
        System.out.println("Na zakończenie programu zostanie Ci przedstawiony film, najlepiej opdpowiadający Twoim oczekiwaniom.");
        System.out.println("Jeżeli nie uda nam się znaleźć filmu idealnego to postaramy się znaleźć taki,\nktóry będzie najbliższy spełnieniu oczekiwań.");
        System.out.println("Jeżeli wybranych filmów będzie więcej niż 3 to spośród wybranych wylosujemy 3, aby ułatwić Ci wybór.");
        System.out.println("Miłego oglądnia!\n");
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

package moviePicker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OptionsGetter {

    private ArrayList<Integer> options;

    public OptionsGetter() {
        this.options = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getOptions() {
        return options;
    }

    public void setOptions() throws IOException {
        // get questions database
        TXTReader txtReader = new TXTReader();
        txtReader.setQuestions();
        for (String[] quest: txtReader.getQuestions()) {
            for (String part: quest) {
                System.out.println(part);
                // get answer
            }
            Integer pomOption = null;
            try {
                pomOption = scanOption();
            } catch (Exception e) {
                System.out.println("Podana opcja nie pasuje do schematu 1/2/3. Spróbuj ponownie.");
                pomOption = scanOption();
            }
            while(checkOption(pomOption)) {
                try {
                    pomOption = scanOption();
                } catch (Exception e) {
                    System.out.println("Podana opcja nie pasuje do schematu 1/2/3. Spróbuj ponownie.");
                    pomOption = scanOption();
                }
            }
            this.options.add(pomOption);
        }
    }

    public Integer scanOption() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wybrana opcja: ");
        String opt = scanner.nextLine();
        Integer optionNumber = Integer.parseInt(opt);
        return optionNumber;
    }

    public boolean checkOption(Integer option) {
        if(option.equals(1) || option.equals(2) || option.equals(3))
            return false;
        else {
            System.out.println("Podana opcja nie mieści się w zakresie. Spróbuj ponownie.");
            return true;
        }
    }
}

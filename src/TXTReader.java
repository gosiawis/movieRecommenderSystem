import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TXTReader {

    private ArrayList<String[]> questions;

    public ArrayList<String[]> getQuestions() {
        return questions;
    }

    public TXTReader() {
        this.questions = new ArrayList<String[]>();
    }

    public void setQuestions() throws IOException {
        Scanner scanner = new Scanner(new File("src//questions"));
        ArrayList<String> pom = new ArrayList<>();
        while(scanner.hasNextLine()) {
            pom.add(scanner.nextLine());
        }
        for (String quest:pom) {
            this.questions.add(quest.split("\\*"));
        }

    }
}

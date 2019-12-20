import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    private ArrayList<String[]> base;

    public CSVReader() {
        this.base = new ArrayList<String[]>();
    }

    public ArrayList<String[]> getBase() {
        return base;
    }

    public void setBase() throws IOException {
        //this.baza = new ArrayList<String[]>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src\\movies.csv"));
        String row = null;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(";");
            this.base.add(data);
        }
        csvReader.close();
    }
}

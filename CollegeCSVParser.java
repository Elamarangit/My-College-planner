import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollegeCSVParser {

    public static List<College> parseCSV(String filePath) {
        List<College> colleges = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip header
                }

                // Handle quoted CSV fields
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                try {
                    String name = stripQuotes(values[3]);
                    String state = stripQuotes(values[5]);
                    String control = stripQuotes(values[15]);
                    String inStateTuition = stripQuotes(values[200]);
                    String outStateTuition = stripQuotes(values[201]);
                    String satVR25 = stripQuotes(values[23]);
                    String satVR75 = stripQuotes(values[24]);
                    String satMT25 = stripQuotes(values[25]);
                    String satMT75 = stripQuotes(values[26]);
                    String actCM25 = stripQuotes(values[37]);
                    String actCM75 = stripQuotes(values[38]);
                    String acceptanceRate = stripQuotes(values[21]);
                    String studentBodySize = stripQuotes(values[178]);

                    College college = new College(
                            name, state, control,
                            inStateTuition, outStateTuition,
                            satVR25, satVR75, satMT25, satMT75,
                            actCM25, actCM75, acceptanceRate, studentBodySize
                    );

                    colleges.add(college);

                } catch (Exception e) {
                    System.err.println("⚠️ Skipping line due to error: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }

        return colleges;
    }

    private static String stripQuotes(String s) {
        return s == null ? "" : s.replace("\"", "").trim();
    }
}

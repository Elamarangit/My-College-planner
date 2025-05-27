import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CollegeDataParser {
    public static ArrayList<College> parseCollegeData(String filePath) {
        ArrayList<College> colleges = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header line
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                // Extract relevant data from CSV
                String name = values[3].replace("\"", ""); // INSTNM
                String state = values[5].replace("\"", ""); // STABBR
                
                // Handle acceptance rate (ADM_RATE)
                double acceptanceRate = -1; // Default value if not available
                if (!values[36].isEmpty() && !values[36].equals("NULL") && !values[36].equals("NA")) {
                    try {
                        acceptanceRate = Double.parseDouble(values[36]);
                    } catch (NumberFormatException e) {
                        // If parsing fails, keep the default value
                    }
                }
                
                // Handle SAT score (SAT_AVG)
                int satScore = -1; // Default value if not available
                if (values[52].isEmpty() || values[52].equals("NULL") || values[52].equals("NA")) {
                    // If SAT_AVG is not available, try to calculate average from SATVRMID and SATMTMID
                    if (!values[45].isEmpty() && !values[45].equals("NULL") && !values[45].equals("NA") &&
                        !values[46].isEmpty() && !values[46].equals("NULL") && !values[46].equals("NA")) {
                        try {
                            int satVR = Integer.parseInt(values[45]);
                            int satMT = Integer.parseInt(values[46]);
                            satScore = (satVR + satMT) / 2;
                        } catch (NumberFormatException e) {
                            // If parsing fails, keep the default value
                        }
                    }
                } else {
                    try {
                        satScore = Integer.parseInt(values[52]);
                    } catch (NumberFormatException e) {
                        // If parsing fails, keep the default value
                    }
                }
                
                // Handle ACT score (ACTCMMID)
                int actScore = -1; // Default value if not available
                if (!values[51].isEmpty() && !values[51].equals("NULL") && !values[51].equals("NA")) {
                    try {
                        actScore = Integer.parseInt(values[51]);
                    } catch (NumberFormatException e) {
                        // If parsing fails, keep the default value
                    }
                }
                
                // GPA is not directly available in the dataset, so we'll set it to -1
                double gpa = -1;
                
                // Create College object and add to list
                colleges.add(new College(name, state, acceptanceRate, satScore, actScore, gpa));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return colleges;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class CollegeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "Most-Recent-Cohorts-Institution_05192025.csv"; // Path to your CSV file
        ArrayList<College> allColleges = CollegeDataParser.parseCollegeData(filePath);

        System.out.println("Welcome to the College Finder!");

        boolean continueSearch = true;

        while (continueSearch) {
            // Input: Preferred State
            String preferredState = "";
            while (true) {
                System.out.print("\nPreferred State (or type 'any'): ");
                preferredState = scanner.nextLine().trim();
                if (!preferredState.isEmpty()) {
                    break;
                }
                System.out.println("Invalid input. Please enter a state abbreviation or 'any'.");
            }

            // Input: Max Acceptance Rate
            double maxAcceptanceRate = -1;
            while (true) {
                System.out.print("Maximum Acceptance Rate (0.0 - 1.0 or -1 for any): ");
                try {
                    maxAcceptanceRate = Double.parseDouble(scanner.nextLine());
                    if ((maxAcceptanceRate >= 0.0 && maxAcceptanceRate <= 1.0) || maxAcceptanceRate == -1) {
                        break;
                    }
                } catch (NumberFormatException ignored) {}
                System.out.println("Invalid input. Please enter a decimal between 0.0 and 1.0 or -1.");
            }

            // Input: Min SAT Score
            int minSatScore = -1;
            while (true) {
                System.out.print("Minimum SAT Score (or -1 for any): ");
                try {
                    minSatScore = Integer.parseInt(scanner.nextLine());
                    if (minSatScore >= -1 && minSatScore <= 1600) {
                        break;
                    }
                } catch (NumberFormatException ignored) {}
                System.out.println("Invalid input. Please enter a number between 400 and 1600 or -1.");
            }

            // Input: Min ACT Score
            int minActScore = -1;
            while (true) {
                System.out.print("Minimum ACT Score (or -1 for any): ");
                try {
                    minActScore = Integer.parseInt(scanner.nextLine());
                    if (minActScore >= -1 && minActScore <= 36) {
                        break;
                    }
                } catch (NumberFormatException ignored) {}
                System.out.println("Invalid input. Please enter a number between 1 and 36 or -1.");
            }

            // Input: Min GPA
            double minGpa = -1;
            while (true) {
                System.out.print("Minimum GPA (or -1 for any): ");
                try {
                    minGpa = Double.parseDouble(scanner.nextLine());
                    if ((minGpa >= 0.0 && minGpa <= 4.0) || minGpa == -1) {
                        break;
                    }
                } catch (NumberFormatException ignored) {}
                System.out.println("Invalid input. Please enter a number between 0.0 and 4.0 or -1.");
            }

            // Filter colleges
            ArrayList<College> matchingColleges = new ArrayList<>();
            for (College college : allColleges) {
                boolean matches = true;

                if (!preferredState.equalsIgnoreCase("any") && !college.getState().equalsIgnoreCase(preferredState)) {
                    matches = false;
                }
                if (maxAcceptanceRate != -1 && college.getAcceptanceRate() != -1 && college.getAcceptanceRate() > maxAcceptanceRate) {
                    matches = false;
                }
                if (minSatScore != -1 && college.getSatScore() != -1 && college.getSatScore() < minSatScore) {
                    matches = false;
                }
                if (minActScore != -1 && college.getActScore() != -1 && college.getActScore() < minActScore) {
                    matches = false;
                }
                if (minGpa != -1 && college.getGpa() != -1 && college.getGpa() < minGpa) {
                    matches = false;
                }

                if (matches) {
                    matchingColleges.add(college);
                }
            }

            // Display results
            if (matchingColleges.isEmpty()) {
                System.out.println("\nNo colleges match your preferences.");
            } else {
                System.out.println("\nMatching Colleges:");
                for (College college : matchingColleges) {
                    System.out.println(college);
                }
            }

            // Ask if user wants to search again
            String response;
            while (true) {
                System.out.print("\nWould you like to search again? (yes/no): ");
                response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("yes") || response.equals("no")) {
                    break;
                }
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
            }

            continueSearch = response.equals("yes");
        }

        System.out.println("\nThank you for using College Finder. Goodbye!");
        scanner.close();
    }
}

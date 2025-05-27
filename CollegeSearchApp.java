import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CollegeSearchApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<College> colleges = CollegeCSVParser.parseCSV("colleges.csv"); // Update path if needed

        System.out.println("🎓 Welcome to the College Finder!");
        System.out.println("You'll enter preferences for college attributes.");
        System.out.println("🔍 Leave a field blank to skip filtering by that attribute.\n");

        boolean keepGoing = true;
        while (keepGoing) {

            String statePref = promptString(scanner, "📍 State (e.g., CA, NY):");

            String controlPref = promptControl(scanner);

            String maxInState = promptDouble(scanner, "💰 Max In-State Tuition:");
            String maxOutState = promptDouble(scanner, "💰 Max Out-of-State Tuition:");

            String satVR25Min = promptInt(scanner, "🧠 Min SAT Verbal 25th Percentile:");
            String satMT25Min = promptInt(scanner, "🧠 Min SAT Math 25th Percentile:");

            String actCM25Min = promptInt(scanner, "🧠 Min ACT Composite 25th Percentile:");

            String maxAcceptRate = promptDouble(scanner, "📈 Max Acceptance Rate (0–1):");
            String maxSize = promptInt(scanner, "👥 Max Student Body Size:");

            List<College> filtered = colleges.stream().filter(c -> {
                return (statePref.isEmpty() || c.getState().equalsIgnoreCase(statePref)) &&
                       (controlPref.isEmpty() || c.getControl().equals(controlPref)) &&
                       (maxInState.isEmpty() || parseDouble(c.getInStateTuition()) <= parseDouble(maxInState)) &&
                       (maxOutState.isEmpty() || parseDouble(c.getOutStateTuition()) <= parseDouble(maxOutState)) &&
                       (satVR25Min.isEmpty() || parseInt(c.getSatVR25()) >= parseInt(satVR25Min)) &&
                       (satMT25Min.isEmpty() || parseInt(c.getSatMT25()) >= parseInt(satMT25Min)) &&
                       (actCM25Min.isEmpty() || parseInt(c.getActCM25()) >= parseInt(actCM25Min)) &&
                       (maxAcceptRate.isEmpty() || parseDouble(c.getAcceptanceRate()) <= parseDouble(maxAcceptRate)) &&
                       (maxSize.isEmpty() || parseInt(c.getStudentBodySize()) <= parseInt(maxSize));
            }).collect(Collectors.toList());

            System.out.println("\n🎯 Colleges matching your preferences:\n");
            if (filtered.isEmpty()) {
                System.out.println("😢 No colleges found with those preferences.\n");
            } else {
                for (College c : filtered) {
                    System.out.println("🏫 " + c.getName() + " (" + c.getState() + ")");
                    System.out.println("   🏛️ Control: " + c.getControl());
                    System.out.println("   💲 Tuition (In/Out): $" + c.getInStateTuition() + " / $" + c.getOutStateTuition());
                    System.out.println("   📚 SAT V25/M25: " + c.getSatVR25() + " / " + c.getSatMT25());
                    System.out.println("   🎯 ACT C25: " + c.getActCM25());
                    System.out.println("   📈 Acceptance Rate: " + c.getAcceptanceRate());
                    System.out.println("   👥 Size: " + c.getStudentBodySize());
                    System.out.println("---------------------------------------------------");
                }
            }

            System.out.print("\n🔁 Search again? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            keepGoing = again.equals("yes");
            System.out.println();
        }

        System.out.println("👋 Thanks for using College Finder!");
    }

    // Input validation helpers
    private static String promptString(Scanner scanner, String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim();
    }

    private static String promptControl(Scanner scanner) {
        while (true) {
            System.out.print("🏛️ Control (1 = Public, 2 = Private Non-Profit, 3 = Private For-Profit): ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equals("1") || input.equals("2") || input.equals("3")) {
                return input;
            }
            System.out.println("❌ Please enter 1, 2, 3 or leave blank.");
        }
    }

    private static String promptDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) return "";
            try {
                Double.parseDouble(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number or leave blank.");
            }
        }
    }

    private static String promptInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) return "";
            try {
                Integer.parseInt(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid whole number or leave blank.");
            }
        }
    }

    private static double parseDouble(String s) {
        try {
            return s.isEmpty() ? Double.MAX_VALUE : Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return Double.MAX_VALUE;
        }
    }

    private static int parseInt(String s) {
        try {
            return s.isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }
}

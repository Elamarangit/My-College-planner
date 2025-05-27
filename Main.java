import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<College> colleges = CollegeCSVParser.parseCSV("colleges.csv"); // <- update path as needed

        System.out.println("🎓 Welcome to the College Finder!");
        System.out.println("You’ll be asked to enter preferences for college attributes.");
        System.out.println("🔍 Leave a field blank if you want to skip filtering by that attribute.\n");

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("📝 Enter your college preferences (or press Enter to skip a field):");

            System.out.print("📍 State (e.g., CA, NY): ");
            String statePref = scanner.nextLine().trim();

            System.out.print("🏛️ Control (1 = Public, 2 = Private Non-Profit, 3 = Private For-Profit): ");
            String controlPref = scanner.nextLine().trim();

            System.out.print("💰 Max In-State Tuition: ");
            String maxInState = scanner.nextLine().trim();

            System.out.print("💰 Max Out-of-State Tuition: ");
            String maxOutState = scanner.nextLine().trim();

            System.out.print("🧠 Min SAT Verbal 25th Percentile: ");
            String satVR25Min = scanner.nextLine().trim();

            System.out.print("🧠 Min SAT Math 25th Percentile: ");
            String satMT25Min = scanner.nextLine().trim();

            System.out.print("🧠 Min ACT Composite 25th Percentile: ");
            String actCM25Min = scanner.nextLine().trim();

            System.out.print("📈 Max Acceptance Rate (0–1): ");
            String maxAcceptRate = scanner.nextLine().trim();

            System.out.print("👥 Max Student Body Size: ");
            String maxSize = scanner.nextLine().trim();

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

            System.out.println("\n🎯 Colleges that match your preferences:\n");
            if (filtered.isEmpty()) {
                System.out.println("😢 No colleges found with those preferences.\n");
            } else {
                for (College c : filtered) {
                    System.out.println("🏫 " + c.getName() + " (" + c.getState() + ")");
                    System.out.println("   📊 Control: " + c.getControl());
                    System.out.println("   💲 Tuition (In-State / Out-of-State): $" + c.getInStateTuition() + " / $" + c.getOutStateTuition());
                    System.out.println("   📚 SAT V25/M25: " + c.getSatVR25() + " / " + c.getSatMT25());
                    System.out.println("   🎯 ACT C25: " + c.getActCM25());
                    System.out.println("   📈 Acceptance Rate: " + c.getAcceptanceRate());
                    System.out.println("   👥 Student Body Size: " + c.getStudentBodySize());
                    System.out.println("---------------------------------------------------");
                }
            }

            System.out.print("\n🔁 Would you like to search again? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            keepGoing = again.equals("yes");
            System.out.println();
        }

        System.out.println("👋 Thanks for using College Finder! Goodbye.");
    }

    // Helper methods
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

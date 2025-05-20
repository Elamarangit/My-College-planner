import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to MyCollegePlanner! Lets see which college suits you best!" + "\n" +
        "lets first create a bank account for you to simulate your costs...");
        System.out.println("Please enter your name.");
        System.out.println();
        String nameInput = in.nextLine();
        String userName = nameInput;
        System.out.println("How much money would you like to start with?");
        System.out.println();
        double cashInput = in.nextInt();
        double amountInbank = cashInput;
        BankAccount newUser = new BankAccount(userName, amountInbank);
        System.out.println("Hello "+newUser.getAccHolder()+", let's get you started!");
        boolean codeRunning = true;
        while(codeRunning){
            System.out.println("Which college are you interested in? If you would like to see your balance: please type 'balance' or type 'e' to exit");
            String response = in.nextLine();
            if(response.equals("balance") || response.equals("Balance"));{
                System.out.println(newUser.toString());

            }
             if(response.equals("e") || response.equals("E")){
                System.out.println("Good luck for college!");
                codeRunning = false;
            }       
            else{
                codeRunning = false;
            }

            
            
        }
    }
}


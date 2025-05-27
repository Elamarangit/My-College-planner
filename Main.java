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
        System.out.println("Which college are you interested in? If you would like to see your balance: please type 'balance'" + "\n" +"Type 'deposit' if you want to add more money to your account" +
        "\n" + "Type 'e' to exit");
        while(codeRunning){
            String response = in.nextLine();
            if(response.equals("balance") || response.equals("Balance")){
                System.out.println(newUser.toString());
            }
            else if(response.equals("e") || response.equals("E")){
                System.out.println("Good luck for college!");
                codeRunning = false;
            }   
            else if(response.equals("deposit") || response.equals("Deposit")){
                System.out.println("How much would you like you to deposit?");
                double depositInput = in.nextInt();
                newUser.deposit(depositInput);
                System.out.println("You have deposited " + "$" + String.format("%.2f", depositInput) + " into your account!");
                System.out.println("Which collegeare you interested in? If you would like to see your balance: please type 'balance'" + "\n" +"Type 'deposit' if you want to add more money to your account" + "\n" + "Type 'e' to exit");
            }
            

            
            
        }
    }
}
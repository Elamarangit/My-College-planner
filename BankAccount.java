public class BankAccount{
    private String accountHolder;
    private double budget;

    public BankAccount(String holder, double amount){
        accountHolder = holder;
        budget = amount; 
    }

    public void deposit(double moneyDeposit){ //students could add more to their budget
        budget += moneyDeposit; 
    }
    
    public void withdraw(double moneyWithdrawn){
        if(budget - moneyWithdrawn < 0){
            System.out.println("You don't have enough money!");
        }
    }
    public double getBudget(){
        return budget;
    }

    public String getAccHolder(){
        return accountHolder;
    }
 
    public String toString(){
        return "Here's a quick summary of your bank account... " + "\n" + "Account name is: " +
        accountHolder + "\n" + "Your current budget is " + "$" + String.format("%.2f", budget);
    }
}
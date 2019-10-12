package SavingsAccount;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {

        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance()
    {
        return this.savingsBalance;
    }

    public static void modifyInterestRate(double newIR)
    {
        annualInterestRate = newIR;
    }

    public void calculateMonthlyInterest()
    {
        double monthlyInterest;
        monthlyInterest = (this.savingsBalance * annualInterestRate) / 12;
        this.savingsBalance += monthlyInterest;
    }

}

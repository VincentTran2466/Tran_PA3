package SavingsAccount;

public class Application {

    public static void main(String[] args)
    {
        SavingsAccount saver1;
        SavingsAccount saver2;

        saver1 = new SavingsAccount(2000);
        saver2 = new SavingsAccount(3000);
        double balance1;
        double balance2;
        double balance3;
        double balance4;

        SavingsAccount.modifyInterestRate(0.04);
        int total = 0;
        int month = 12;
        System.out.println("Setting Interest Rate to 4%");
        System.out.println("Month         Saver 1         Saver 2");
        for(int i = 0; i < month; i++)
        {
            saver1.calculateMonthlyInterest();
             balance1 = saver1.getSavingsBalance();
            saver2.calculateMonthlyInterest();
             balance2 = saver2.getSavingsBalance();
            System.out.printf((i+1) + "         $%.2f         $%.2f\n", balance1, balance2);
        }
        System.out.println("\nSetting Interest Rate to 5%\n");

        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        balance3 = saver1.getSavingsBalance();
        saver2.calculateMonthlyInterest();
        balance4 = saver2.getSavingsBalance();
        System.out.printf("13         $%.2f         $%.2f\n", balance3, balance4);

    }

}

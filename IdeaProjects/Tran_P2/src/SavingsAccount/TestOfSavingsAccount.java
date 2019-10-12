package SavingsAccount;

public class TestOfSavingsAccount {

    public static void main(String[] args)
    {
        SavingsAccount saver1;
        SavingsAccount saver2;

        saver1 = new SavingsAccount(2000);
        saver2 = new SavingsAccount(3000);

        SavingsAccount.modifyInterestRate(0.04);
        int total = 0;
        int month = 12;

        for(int i = 0; i < month; i++)
        {
            saver1.calculateMonthlyInterest();
            System.out.println("Month " + (i+1) + " balance for Saver 1 with a 4% interest rate: " + saver1.getSavingsBalance());
        }
        System.out.println("--------------------------------------------------------------------------------------");
        for(int i = 0; i < month; i++)
        {
            saver2.calculateMonthlyInterest();
            System.out.println("Month " + (i+1) + " balance for Saver 2 with a 4% interest rate: " + saver2.getSavingsBalance());
        }
        System.out.println("--------------------------------------------------------------------------------------");
        SavingsAccount.modifyInterestRate(0.05);
        for(int i = 0; i < month; i++)
        {
            saver1.calculateMonthlyInterest();
            System.out.println("Month " + (i+1) + " balance for Saver 1 with 5% interest rate: " + saver1.getSavingsBalance());
        }
        System.out.println("--------------------------------------------------------------------------------------");
        for(int i = 0; i < month; i++)
        {
            saver2.calculateMonthlyInterest();
            System.out.println("Month " + (i+1) + " balance for Saver 2 with 5% interest rate: " + saver2.getSavingsBalance());
        }
        System.out.println("--------------------------------------------------------------------------------------");

    }

}

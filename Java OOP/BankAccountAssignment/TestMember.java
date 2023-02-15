public class TestMember {

    public static void main (String[] args) {


        // set accounts                     checking  savings
        System.out.println("-----------------Initial Deposits");
        BankAccount member1 = new BankAccount(100.00, 533.00);
        BankAccount member2 = new BankAccount(200.00, 230.00);
        BankAccount member3 = new BankAccount(350.00, 610.00);


        System.out.println("-----------------Initial Bank Funds");
        System.out.printf("The banks total funds are : ");
        System.out.println(BankAccount.showMeTheMoney());        
        
        System.out.printf("Number Of Accounts In System: ");
        System.out.println(BankAccount.totalAccountsInBank());


        member1.getCheckingBalance();
        member1.getSavingsBalance();


        System.out.println("-----------------Set Deposites");
        member1.setCheckingDeposit(200.50);
        member1.setSavingsDeposit(123.00);


        member1.getCheckingBalance();
        member1.getSavingsBalance();


        System.out.println("-----------------The new total bank funds");
        System.out.printf("The banks total funds are : ");
        System.out.println(BankAccount.showMeTheMoney());        


        System.out.println("---------------- Get Both Account Balances");
        member1.getAllBalances();


        System.out.println("---------------- Test Checking Withdraw");
        member1.setCheckingWithdraw(200.00);
        System.out.println("---------------- Test Over Withdraw");
        member1.setCheckingWithdraw(200.00);
        System.out.printf("The new banks total funds are : ");
        System.out.println(BankAccount.showMeTheMoney());   


        System.out.println("---------------- Test Savings Withdraw");
        member1.setSavingsWithdraw(200.00);
        System.out.println("---------------- Test Over Withdraw");
        member1.setSavingsWithdraw(500.00);
        System.out.printf("The new banks total funds are : ");
        System.out.println(BankAccount.showMeTheMoney());   


        System.out.println("---------------- Test Get account #");
        member1.getAccountNumber();
        member2.getAccountNumber();
        member3.getAccountNumber();


    }
}
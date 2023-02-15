public class TestMember {

    public static void main (String[] args) {


        // set accounts                     checking  savings
        System.out.println("-----------------Initial Deposits");
        BankAccount member1 = new BankAccount(10400.00, 5533.00);

        System.out.println("---------------- Test Get account #");
        member1.getAccountNumber();




        System.out.println("-----------------Initial Total Bank Funds");
        System.out.printf("The banks total funds are : ");
        System.out.println(BankAccount.showMeTheMoney());        
        

        System.out.printf("Number Of Accounts In System: ");
        System.out.println(BankAccount.totalAccountsInBank());


        System.out.println("-----------------Get Balances");
        member1.getCheckingBalance();
        member1.getSavingsBalance();


        System.out.println("-----------------Set Deposites");
        member1.setCheckingDeposit(200.50);
        member1.setSavingsDeposit(123.00);


        System.out.println("-----------------Get Balances");
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
        member1.setCheckingWithdraw(20000.00);


        System.out.println("---------------- Test Savings Withdraw");
        member1.setSavingsWithdraw(200.00);
        System.out.println("---------------- Test Over Withdraw");
        member1.setSavingsWithdraw(50000.00);
        


        System.out.printf("The new banks total funds are : ");
        System.out.println(BankAccount.showMeTheMoney());   

    }
}
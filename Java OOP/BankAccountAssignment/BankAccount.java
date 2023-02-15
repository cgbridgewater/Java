public class BankAccount {

    // Account set up
    private Double checkingBalance = 0.00;
    private Double savingsBalance = 0.00;
    private int accountNumber = 200500;
    //Static 
    private static int numberOfAccounts = 0;
    private static Double totalMoniesInBank = 0.00;


    // method for creating default account
    public BankAccount(){
        numberOfAccounts++;
        this.accountNumber += numberOfAccounts;
    };


    // method for creating account
    public BankAccount(Double checkingBalance, Double savingsBalance) {
        System.out.println("New Account Created");
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
        totalMoniesInBank += checkingBalance;
        totalMoniesInBank += savingsBalance;
        this.accountNumber += numberOfAccounts;
    }

    // Savings Deposit Method // Tested 
    public void setSavingsDeposit(Double deposit) { 
        System.out.println("Savings deposited: $" + deposit);
        this.savingsBalance += deposit;
        totalMoniesInBank += deposit;
    }

    // Checking Deposit Method // Tested
    public void setCheckingDeposit(Double deposit) {  
        System.out.println("Checking deposited: $" + deposit);
        this.checkingBalance += deposit;
        totalMoniesInBank += deposit;
    }

    // Savings Withdraw Method // Tested
    public void setSavingsWithdraw(Double withdraw) {
            if (this.savingsBalance >= withdraw){
            this.savingsBalance -= withdraw;
            totalMoniesInBank -= withdraw;
            System.out.println("Savings withdrawn: $" + withdraw);
            System.out.println("Your new savings balance is: $" + this.savingsBalance);

            } else
            System.out.println("INSUFFICIENT FUNDS! please reduce amount to be withdrawn");
    }

    // Checking Withdaw Method // Tested
    public void setCheckingWithdraw(Double withdraw) {
            if (this.checkingBalance >= withdraw){
            this.checkingBalance -= withdraw;
            totalMoniesInBank -= withdraw;
            System.out.println("Checking withdrawn: $" + withdraw);
            System.out.println("Your new checking balance is: $" + this.checkingBalance);

            } else
            System.out.println("INSUFFICIENT FUNDS! please reduce amount to be withdrawn");
    }


    public void getAccountNumber() {
        System.out.println("Your Account Number is: " + this.accountNumber);
    }


    public void getAllBalances() {
        System.out.println("Your savings balance is: " + savingsBalance);
        System.out.println("Your checking balance is: " + checkingBalance);
    }

    public void getSavingsBalance() {  // Savings GETTER //  
        System.out.println("Your savings balance is: " + savingsBalance);
    }

    public void getCheckingBalance() {  // Checking Getter // 
        System.out.println("Your checking balance is: " + checkingBalance);
    }









        // This is static and can only be called on by the class name, ie:   Person.peopleCount();
        public static Double showMeTheMoney(){
            return totalMoniesInBank;
        }

        public static int totalAccountsInBank(){
            return numberOfAccounts;
        }



}
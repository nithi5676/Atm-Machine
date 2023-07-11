package atmMachine;

import java.util.Scanner;

public class AtmMachine {
    public static void main(String[] args) throws InvalidAmountException, InsufficientFundsException {

        Trancsaction trancsaction = new Trancsaction();
        trancsaction.setBalance(100000l);
        Scanner scanner = new Scanner(System.in);

        byte userInput;

        do {
            System.out.print("1. for Displaying Balance" + "\n" + "2. For Withdraw" + "\n" + "3. For Deposit" + "\n"
                    + "\n");
            userInput = scanner.nextByte();

            switch (userInput) {
                case 1: {
                    System.out
                            .println(
                                    "Your Balance is " + trancsaction.amountDisplay(trancsaction.getBalance()) + "\n1");
                    break;
                }
                case 2: {
                    System.out.println("Enter Amount to Withdraw: ");
                    long amountToWithDraw = scanner.nextLong();
                    // trancsaction.Withdraw(amountToWithDraw);

                    if (amountToWithDraw > 0 && amountToWithDraw <= trancsaction.getBalance()) {
                        System.out.println("Withraw SuccessFull\n");
                        // operation to update the amount
                        trancsaction.setBalance(trancsaction.getBalance() - amountToWithDraw);
                        System.out.println("Your Balance is here " + trancsaction.getBalance() + "\n");
                    }

                    else if (amountToWithDraw > trancsaction.getBalance()) {
                        throw new InsufficientFundsException("Your Balance is lesser!!!");
                    }

                    else if (amountToWithDraw < 0) {
                        throw new InvalidAmountException("amount is 0 or Negative");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter Amount to Deposit: ");
                    Long depositedMoney = scanner.nextLong();
                    // trancsaction.Deposit(depositedMoney);
                    try {
                        trancsaction.Deposit(trancsaction.getBalance());
                        if (depositedMoney > 0) {
                            trancsaction.setBalance(trancsaction.getBalance() + depositedMoney);
                            System.out.println("Current Balance after Deposit is " + trancsaction.getBalance() + "\n");
                        } else {
                            throw new InvalidAmountException("Invalid amount entered");
                        }

                    } catch (InvalidAmountException e) {
                        System.out.println("Exception occured " + e);
                    }
                    break;
                }
                default: {
                    System.out.println("Enter valid number");
                    break;
                }
            }

        } while (userInput != 4);
        scanner.close();

    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class PrivateDetails extends AtmMachine {
    private long balance;
    private long amount;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

}

class Trancsaction extends PrivateDetails {

    public long Withdraw(long amount) throws InsufficientFundsException, InvalidAmountException {

        return getBalance();
    }

    public long amountDisplay(long balance) {
        return balance;
    }

    public long Deposit(long amount) throws InvalidAmountException {
        return getBalance();
    }
}

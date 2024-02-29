package JAVA_Sem6;

import java.util.Scanner;
abstract class Account {
    double interestRate;
    double amount;

    abstract double calculateInterest() throws InvalidInputException;
}
class FDAccount extends Account {
    int noOfDays;
    int ageOfACHolder;

    FDAccount(double amount, int noOfDays, int ageOfACHolder) {
        this.amount = amount;
        this.noOfDays = noOfDays;
        this.ageOfACHolder = ageOfACHolder;
    }

    @Override
    double calculateInterest() throws InvalidInputException {
        if (amount <= 0 || noOfDays <= 0) {
            throw new InvalidInputException("Invalid amount or number of days");
        }

        if (amount < 10000000) { // Below 1 crore
            if (noOfDays >= 7 && noOfDays <= 14) {
                return ageOfACHolder >= 60 ? amount * 0.05 : amount * 0.045;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                return ageOfACHolder >= 60 ? amount * 0.0525 : amount * 0.0475;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                return ageOfACHolder >= 60 ? amount * 0.06 : amount * 0.055;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                return ageOfACHolder >= 60 ? amount * 0.075 : amount * 0.07;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                return ageOfACHolder >= 60 ? amount * 0.08 : amount * 0.075;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                return ageOfACHolder >= 60 ? amount * 0.085 : amount * 0.08;
            } else {
                throw new InvalidInputException("Invalid number of days for FD");
            }
        } else { // Above 1 crore
            if (noOfDays >= 7 && noOfDays <= 14) {
                return amount * 0.065;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                return amount * 0.0675;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                return amount * 0.0675;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                return amount * 0.08;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                return amount * 0.085;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                return amount * 0.1;
            } else {
                throw new InvalidInputException("Invalid number of days for FD");
            }
        }
    }
}

class SBAccount extends Account {
    String accountType;

    SBAccount(double amount, String accountType) {
        this.amount = amount;
        this.accountType = accountType;
    }

    @Override
    double calculateInterest() throws InvalidInputException {
        if (amount <= 0) {
            throw new InvalidInputException("Invalid amount for SB account");
        }

        switch (accountType.toLowerCase()) {
            case "normal":
                return amount * 0.04;
            case "nri":
                return amount * 0.06;
            default:
                throw new InvalidInputException("Invalid account type for SB account");
        }
    }
}

class RDAccount extends Account {
    int noOfMonths;
    double monthlyAmount;

    RDAccount(double monthlyAmount, int noOfMonths) {
        this.monthlyAmount = monthlyAmount;
        this.noOfMonths = noOfMonths;
    }

    @Override
    double calculateInterest() throws InvalidInputException {
        if (monthlyAmount <= 0 || noOfMonths <= 0) {
            throw new InvalidInputException("Invalid monthly amount or number of months for RD");
        }

        if (noOfMonths == 6) {
            return monthlyAmount * 6 * 0.075;
        } else if (noOfMonths == 9) {
            return monthlyAmount * 9 * 0.0775;
        } else if (noOfMonths == 12) {
            return monthlyAmount * 12 * 0.08;
        } else if (noOfMonths == 15) {
            return monthlyAmount * 15 * 0.0825;
        } else if (noOfMonths == 18) {
            return monthlyAmount * 18 * 0.085;
        } else if (noOfMonths == 21) {
            return monthlyAmount * 21 * 0.0875;
        } else {
            throw new InvalidInputException("Invalid number of months for RD");
        }
    }
}

class InvalidInputException extends Exception {
    InvalidInputException(String message) {
        super(message);
    }
}
public class Exp3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select the option:");
            System.out.println("1. Interest Calculator –SB");
            System.out.println("2. Interest Calculator –FD");
            System.out.println("3. Interest Calculator –RD");
            System.out.println("4. Exit");
            int option = scanner.nextInt();
            if (option == 4) {
                break;
            }
            try {
                switch (option) {
                    case 1:
                        System.out.println("Enter the Average amount in your account:");
                        double sbAmount = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        System.out.println("Enter the account type (normal/nri):");
                        String accountType = scanner.nextLine();
                        SBAccount sbAccount = new SBAccount(sbAmount, accountType);
                        System.out.println("Interest gained: Rs. " + sbAccount.calculateInterest());
                        break;
                    case 2:
                        System.out.println("Enter the FD amount:");
                        double fdAmount = scanner.nextDouble();
                        System.out.println("Enter the number of days:");
                        int fdDays = scanner.nextInt();
                        System.out.println("Enter your age:");
                        int age = scanner.nextInt();
                        FDAccount fdAccount = new FDAccount(fdAmount, fdDays, age);
                        System.out.println("Interest gained is: Rs. " + fdAccount.calculateInterest());
                        break;
                    case 3:
                        System.out.println("Enter the RD amount:");
                        double rdAmount = scanner.nextDouble();
                        System.out.println("Enter the number of months:");
                        int rdMonths = scanner.nextInt();
                        RDAccount rdAccount = new RDAccount(rdAmount, rdMonths);
                        System.out.println("Interest gained is: Rs. " + rdAccount.calculateInterest());
                        break;
                    default:
                        System.out.println("Invalid option. Please select again.");
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

package view;

import models.Account;
import models.AccountBuilder;
import models.User;
import models.UserBuilder;
import service.UserService;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserService userService = new UserService();

    public static void main(String[] args) {


        System.out.println("****WELCOME**** \n +" +
                "please enter what do you wanna do : ");
        showMenu();

    }

    public static void showMenu() {

        int answer;
        do {
            System.out.print("""
                    1.create account
                    2.update your info
                    3.show last three updates
                    4.withdraw
                    5.deposit
                    6.exit
                    your answer:\s""");
            switch (scanner.nextInt()) {
                case 1:
                    creatAccount();
                    break;
                case 2:
                    updateInformation();
                    break;
            }

        }
        while (true);
    }

    private static void creatAccount() {
        System.out.println("please enter your information to make your account");
        User newUserBankInformation = getNewUserBankInformation();
        System.out.println("please enter how much you wanna add to your balance");
        Double balance = scanner.nextDouble();
        Account account = AccountBuilder.getBuilder().withAccountNumber(getRandomAccountNumber())
                .withCvv2(getCvv2RandomNumber()).withCartNumber(getCartNumberRandomNumber())
                .withOpeningDate(new Date())
                .withSetUser(getNewUserBankInformation()).withSetUserBalance(balance).withSetUser(newUserBankInformation).build();
    }

    private static User getNewUserBankInformation() {
        System.out.print(" name: ");
        String fName = scanner.nextLine();
        System.out.print("family name: ");
        String lName = scanner.nextLine();
        System.out.print("national code: ");
        String nationalCode = scanner.nextLine();
        User user = UserBuilder.getBuilder().withFirstName(fName).withLastName(lName).withCreationDate(new Date()).withNationalCode(nationalCode).build();
        return user;
    }

    private static String getCartNumberRandomNumber() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }

    private static String getCvv2RandomNumber() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%04d", number);
    }

    private static String getRandomAccountNumber() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%010d", number);
    }

    private static void updateInformation() {

        System.out.println("please enter your nationalCode to continue ");
        scanner.nextLine();
        String nationalCode = scanner.next();
        User user = userService.findUserByNationalCode(nationalCode);
        if (user == null) {
            System.out.println("sorry !! the nationalCode is not true");
        }
        System.out.println(" which One do you want to change?\n1.first name\n2.last name\n3.national code");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("please write new name :");
                String newName = scanner.next();
                userService.updateUserName(user, newName);
                break;
            case 2:
                System.out.println("please write new last name : ");
                String newLastName = scanner.next();
                userService.updateUserFamilyName(user, newLastName);
                break;
            case 3:
                System.out.println("please write new national code : ");
                String newNationalCode = scanner.next();
                userService.updateUserNationalCode(user, newNationalCode);
                break;
        }
        System.out.println("*********was successfully done***********");
    }
}

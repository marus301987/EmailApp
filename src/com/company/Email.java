package com.company;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private final String company = "companydrift.com";
    private int mailboxCapacity;
    private int defaultPasswordLenght = 10;

    public Email(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email utworzony dla: " + firstName + " " + lastName);
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLenght);
        this.email = emailValue();

        System.out.println("Email: " + email);
        System.out.println("Hasło: " +password);
    }
    private String setDepartment() {
        String departmentName = null;
        int depNum;
        System.out.println("Wprowadź numer działu: \n1 dla Sprzedaży" +
                "\n2 dla Rozwoju \n3 dla Księgowości \n4 dla Żadnego");
        Scanner scanner = new Scanner(System.in);

        do {
            depNum = scanner.nextInt();
            switch (depNum) {
                case 1:
                    departmentName = "Sprzedaż";
                    System.out.println("Dział: Sprzedaż");
                    break;
                case 2:
                    departmentName = "Rozwój";
                    System.out.println("Dział: Rozwój");
                    break;
                case 3:
                    departmentName = "Dział: Księgowość";
                    System.out.println("Księgowość");
                    break;
                case 4:
                    departmentName = "";
                    System.out.println("Dział: Żaden");
                default:
                    System.out.println("Podaj właściwą wartość");
            }
        } while (depNum != 1 && depNum != 2 && depNum != 3 && depNum != 4);
        return departmentName;
    }
    private String randomPassword(int passLenght){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!#@*()^";
        char [] password = new char[passLenght];
        for (int i = 0; i < passLenght; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    private String emailValue(){
        if(department != ""){
            return firstName.toLowerCase() + "." + lastName.toLowerCase() +
                    "@" + department.toLowerCase() + "." + company;
        }else {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + company;
        }
    }
    public void setMailboxCapacity(int mailboxCapacity){
        this.mailboxCapacity = mailboxCapacity;
    }
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getMailboxCapacity () {
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }
    public String showInfo(){
        return  "Nazwa wyświetlana: " + firstName +" " + lastName +
                "\nEmail Firmowy: " + email +
                "\nPojemność skrzynki " + mailboxCapacity;

    }
}

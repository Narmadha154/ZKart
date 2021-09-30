package com.company.zkartshopping;

import java.util.*;

public class Runner {
    static List<String> customerList=CustomerDetails.readCustomerDetailsFromFile();
    static List<String> productList=CustomerDetails.readProductDetailsFromFile();
    public static void main(String[] args) {
        CreateObject.setCustomerObject();
       // CreateObject.setProductObject();
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("-------------Z-kart online shopping--------------");
            System.out.println("1).signup");
            System.out.println("2).Login");
            System.out.println("3).exit");
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    sc.nextLine();
                    System.out.println("Enter the emailId:");
                    String email=sc.nextLine();
                    if(!AccountCreation.checkAccount(email)){
                        System.out.println("Account already exists..please login..");
                        return;
                    }
                    System.out.println("Enter your name:");
                    String name=sc.nextLine();
                    System.out.println("Enter the password:");
                    String password=sc.nextLine();
                    System.out.println("Confirm password:");
                    String confirmPass=sc.nextLine();
                    if(!password.equals(confirmPass)){
                        System.out.println("password not matched");
                        return;
                    }
                    System.out.println("Enter the mobile number");
                    String mobile=sc.next();
                    String newPass="";
                    for(int j=0;j<password.length();j++){
                        newPass+=(char)(((int)password.charAt(j)+1));
                    }
                    Customer details=new Customer();
                    details.setName(name);
                    details.setEmailId(email);
                    details.setEncryptedPwd(newPass);
                    details.setMobileNo(mobile);
                    if(AccountCreation.createAccount(email,details)){
                        System.out.println("Account created successfully");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter your emailId:");
                    String emailId=sc.nextLine();
                    System.out.println("Enter the password:");
                    String pass=sc.nextLine();
                    if(Login.accountLogin(emailId,pass)){
                        System.out.println("Logged in successfully");
                    }
                    else {
                        System.out.println("Account not exists...Please create the account");
                    }
                    break;
                case 3:
                    return;
            }
        }
    }
}

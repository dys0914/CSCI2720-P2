package project2;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean quit = false;
        while(!quit){
            System.out.println("Enter a number to select your option: \n1: postfix conversion \n2: postfix evaluation \n3: quit.");
            String response = sc.nextLine();
            String exp;
            switch(response){
                case "1":
                    System.out.println("enter expression:");
                    exp = sc.nextLine();

                    if(PostfixConversion.validate(exp)){
                        System.out.println(PostfixConversion.convert(exp));
                    } else{
                        System.out.println("error detected in expression. Try again");
                    }
                    break;
                case "2":
                    System.out.println("enter expression:");
                    exp = sc.nextLine();

                    if(PostfixEvaluation.validate(exp)){
                        System.out.println(PostfixEvaluation.eval(exp));
                    } else{
                        System.out.println("error detected in expression. Try again");
                    }
                    break;
                case "3":
                    System.out.println("exiting.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("enter a valid number");
                    break;
            }
            System.out.println(".......................");

        }


    }
}

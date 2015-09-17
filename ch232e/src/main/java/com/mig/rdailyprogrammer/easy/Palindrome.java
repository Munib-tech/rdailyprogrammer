package com.mig.rdailyprogrammer.easy;

import java.util.Scanner;

/**
 * Created by mramos on 9/17/2015.
 */
public class Palindrome {

    public static void main(String[] args) {

        //there was no input method specified in the challenge, I choose the easiest
        Scanner input = new Scanner(System.in);
        int numberOfLinesToRead  = input.nextInt();
        StringBuilder stringToTest = new StringBuilder();
        while((numberOfLinesToRead--)>=0){
            stringToTest.append(input.nextLine());
        }

        boolean theStringIsPalindrome = isPalindrome(stringToTest);
        if(theStringIsPalindrome){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not a palindrome");
        }
    }



    public static boolean isPalindrome(StringBuilder str){
        String onlyWordChars = removeNotWordChars(str.toString());
        String reversedAndOnlyWordChars = removeNotWordChars(str.reverse().toString());

        return reversedAndOnlyWordChars.equalsIgnoreCase(onlyWordChars);
    }

    public static String removeNotWordChars(String str){
        return str.replaceAll("[^\\w]", "");
    }

}

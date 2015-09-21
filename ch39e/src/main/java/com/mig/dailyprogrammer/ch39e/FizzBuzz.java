package com.mig.dailyprogrammer.ch39e;

import java.util.stream.IntStream;

/**
 * Created by mramos on 8/28/2015.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        new FizzBuzz().printFizzBuzzRange(Integer.valueOf(args[0]));
    }

    /***
     * This method print in screen a range of tested number to see if they are "Fizz", "Buzz" or "FizzBuzz" numbers
     * @param n
     */
    public void printFizzBuzzRange(int n){
        IntStream.rangeClosed(1,n)
                .forEach(e-> System.out.println(isFizzOrBuzz(e)));
    }

    /***
     * If the number is divisible by 3 it will return "Fizz", if the number is divisible by 5 it will return Buzz
     * If the number is divisible both by 3 and 5 it will return FizzBuzz otherwise the String value of n will be
     * returned
     * @param n
     * @return
     */
    public String isFizzOrBuzz(int n){
        String whatIs = "";
        if(n%3==0) whatIs += "Fizz";
        if(n%5==0) whatIs += "Buzz";
        if (whatIs.length()==0) whatIs+=n;
        return whatIs;
    }
}

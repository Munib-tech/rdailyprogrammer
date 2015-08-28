import java.util.stream.IntStream;

/**
 * Created by mramos on 8/28/2015.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        checkFizzBuzzRange(Integer.valueOf(args[0]));
    }

    public static void checkFizzBuzzRange(int n){
        IntStream.rangeClosed(1,n).forEach(FizzBuzz::printFizzOrBuzz);
    }

    private static void printFizzOrBuzz(int n){
        String whatIs;
        if(n%3==0 && n%5==0){
            whatIs = "FizzBuzz";
        }else if(n%3==0){
            whatIs = "Fizz";
        }else if(n%5==0){
            whatIs = "Buzz";
        }else whatIs = String.valueOf(n);
        System.out.println(whatIs);
    }
}

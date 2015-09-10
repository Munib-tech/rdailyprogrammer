import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mramos on 9/10/2015.
 */
public class LettersInAlphabeticalOrder {
    public static void main(String[] args) {
        List<String> list = null;
        try {
            list = Files.readAllLines(Paths.get("./ch228e/src/main/resources/input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        checkWordsOrderWithFormat(list);
    }

    public static boolean isOrdered(String str){
        return isOrdered(str, Comparator.naturalOrder());
    }

    public static boolean isOrdered(String str, Comparator<String> order){
        str = str.toUpperCase();
        String ordered = str.chars().mapToObj(i -> (char) i).map(i-> String.valueOf(i))
                .sorted(order)
                .collect(Collectors.joining());
        return ordered.equals(str);
    }

    public static void checkWordsOrderWithFormat(List<String> list){
        for (String s : list) {
            String tmpSuffix = "";
            if(isOrdered(s))
                tmpSuffix+="IN ORDER";
            else if(isOrdered(s, Comparator.reverseOrder()))
                tmpSuffix+="REVERSE ORDER";
            else
                tmpSuffix+="NOT IN ORDER";
            System.out.printf("%s\t%s\n", s, tmpSuffix);
        }
    }

}

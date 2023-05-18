package Lambda.Lambda;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main4 {
    public static void main(String[] args) {

        String teststring = "a b c";

        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }

            }
        };


        Consumer<String> printThePartsLambda = sentence -> {
            String[] parts = sentence.split(" ");

            for (String part : parts) {
                System.out.println(part);
            }
        };
        Consumer<String> printThePartsForEach = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };


        UnaryOperator<String> everySecondString = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if (i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everySecondString.apply("1234567890"));
        System.out.println(everySecondCharacter(everySecondString, "1234567890"));

        Supplier<String> iLoveJava = () -> "I love java";

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < source.length(); i++){
            if (i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();

    }

    public static String everySecondCharacter(Function<String, String> func, String source){

        return func.apply(source);

    }
}

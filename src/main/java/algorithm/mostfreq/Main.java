package algorithm.mostfreq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by dmontero on 2/2/17.
 */
public class Main {

    private static final String message="\nUsage: java -jar app.jar N K\n" +
            "N = Number of lines to read from the input stream.\n"+
            "K = K-top frequent items to keep.";

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Missing parameters.\n" + message);
            System.exit(1);
        }


        long N=0;
        int K=0;
        try{
            N = toLong(args[0]);
            K = toInt(args[1]);
        }catch(Exception ex){
            System.out.println("Wrong parameters. N and K have to be numbers\n" + message);
            System.exit(1);
        }

        //Read from standard input
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines().limit(N);

        MostFrequent<String> mostFrequent = new MostFreqSpaceSaving<>(K);
        stream.forEach(line -> mostFrequent.add(line));
        mostFrequent.topItems().forEach(System.out::println);

    }


    private static long toLong(String arg){
        return Long.valueOf(arg);
    }

    private static int toInt(String arg){
        return Integer.valueOf(arg);
    }
}

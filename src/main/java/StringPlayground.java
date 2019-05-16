import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringPlayground {


    public static void main(String args3[])
    {

        List<String> args = Arrays.asList("sourav","sour","souravc","souravb");

        args.stream().sorted(
                Comparator.comparing(String::length).reversed().thenComparing((o1, o2) -> {
                    return o1.compareTo(o2);
                }).thenComparing(String::length)
        ).forEach(System.out::println);


        Map<Boolean,List<String>> map = args.stream().collect(Collectors.partitioningBy(

                (str)->{
                    return str.length()>3;
                }
        ));

        //map.forEach((key,val)->System.out.println(key.toString()+val.toString()));


    }
}



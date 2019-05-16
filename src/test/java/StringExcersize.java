import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringExcersize {

    private List<String> strings
    = Arrays.asList("this","is","a","list","anaother","stringvalue");

    private List<String> stringsnulls
            = Arrays.asList("this",null,"is","a",null,"list",null);

    @Test
    public void stringLengthSort()
    {
        Collections.sort(strings,
                (s1,s2)-> s1.length()-s2.length());
        System.out.println(strings);
    }


    @Test
    public void stringLengthSort_method_reference()
    {
        strings.stream().sorted(
                Comparator.comparingInt(String::length)
        .reversed()).forEach(System.out::println);
    }

    @Test
    public void stringlengthSort_lambda()
    {
        strings.stream().sorted(
                (a,b)->a.length()-b.length()
        ).forEach(System.out::println);
    }


    @Test
    public void stringlengthSort_lambdapredicate()
    {
        strings.stream().
                filter(s->s.length()%2==0).sorted(
                (a,b)->a.length()-b.length()
        ).
          collect(Collectors.toCollection(LinkedList::new))
                .forEach(System.out::println)
        ;
    }

    @Test
    public void stringlengthSort_lambda_length_map()
    {
        Map<String,Integer> map=strings.stream()
                .collect(Collectors.toMap(
                        String::toString
                        ,
                        String::length
                ));

        map.forEach((k,v)->System.out.println(k+":"+v));
    }

    @Test
    public void nulll__stringlengthSort_lambda_length_map()
    {

        this.stringsnulls
                .stream().
                filter(Objects::nonNull).
                filter(s->s.length()%2==0)
                .forEach(System.out::println);
    }


    @Test
    public void predicte_nonnulll__stringlengthSort_lambda_length_map()
    {

        Predicate<String> nonNull =Objects::nonNull;
        Predicate<String> evenLength = s->s.length()%2==0;

        Consumer<String> consumer1 = System.out::println;

        Consumer<String> consumer2 = System.out::print;
        //reducss the filter iteration using and
        this.stringsnulls
                .stream().
                filter(nonNull.and(evenLength))
                .forEach(consumer1.andThen(consumer2));
    }

    @Test
    public void some_peak_method()
    {
        Consumer<String> before = s->System.out.print("before");
        Consumer<String> beforeString = before.andThen(System.out::println);

        Consumer<String> after = s->System.out.print("after");
        Consumer<String> afterString = after.andThen(System.out::println);

        this.stringsnulls
                .stream().
           //     peek(beforeString).
                filter(Objects::nonNull).
                filter(s->s.length()%2==0).peek(afterString).
                forEach(System.out::println);
    }


    @Test
    public void doOperations_on_String()
    {

        List<String> stringssss = new ArrayList<>();
        stringssss.addAll(this.stringsnulls);
                stringssss.addAll(this.strings);

        stringssss.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(String::length,
                        Collectors.counting()))
                .forEach((a,b)->
                {

                    System.out.println(a+":"+b);
                });

    }


    @Test
    public void int_stream()
    {
        IntStream.range(100,200)
                .map(n->n*2)
                .filter(n->n%3==0)
                .forEach(System.out::println);
    }

    @Test
    public void int_stream_deferred()
    {
        int i = IntStream.range(100,200)
                .map(n->n*2)
                .filter(n->n%3==0)
                .findAny().orElse(0);

        System.out.println(i);
    }


    public  Predicate<String> lengthAbove20()
    {
        return str->str.length()>20;
    }

    @Test
    public void readFromAFile()
    {
        Path path = Paths.get("");

        try(Stream<String> strStream = Files.lines(path))
        {
         //   strStream.filter(lengthAbove20())
           //         .
        }
        catch(Exception e)
        {

        }
    }


    @Test
    public void reduce_stream_of_ints()
    {
        int i = IntStream.range(1,10)
                .reduce(Integer::sum).orElse(0);
        System.out.print(i);
    }

    @Test
    public void reduce_stream_of_ints_x_y_issue()
    {
        int i = IntStream.range(1,10)
                .reduce(0,Integer::sum);
        System.out.print(i);
    }
}


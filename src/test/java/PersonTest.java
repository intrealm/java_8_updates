import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonTest {


    @Test
    public void test_Person_NoArgs()
    {
        String []names = {"sourav","manish","sourav"};
        List<String> nameList = Arrays.asList(names);
        List<Person> persons = nameList.stream().map(Person::new).collect(Collectors.toList());
        Assert.assertEquals(nameList.size(),persons.size());

    }

    @Test
    public void test_Person_test_equals_hashcode()
    {
        String []names = {"sourav","manish","sourav"};
        List<String> nameList = Arrays.asList(names);
        Set<Person> persons = nameList.stream().map(Person::new).collect(Collectors.toSet());

        Assert.assertEquals(2,persons.size());
    }

    @Test
    public void test_constructorToArray()
    {
        String []names = {"sourav","manish","sourav"};
        List<String> nameList = Arrays.asList(names);

        Person [] persons =  nameList.stream().map(Person::new).toArray(Person[]::new);

        Assert.assertEquals(nameList.size(),persons.length);
    }
}

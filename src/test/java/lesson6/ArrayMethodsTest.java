package lesson6;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


@RunWith(value = Parameterized.class)
public class ArrayMethodsTest {

    Integer[] value;
    ArrayList<Integer> result;

    public ArrayMethodsTest(Integer[] value, ArrayList<Integer> result ) {
        this.value = value;
        this.result=result;
    }

    @Parameters
    public static Collection<Object[]> abracadabra() {
        return Arrays.asList(new Object[][]{
                        {new Integer[]{4,8,7,9,1,2},new ArrayList<>(Arrays.asList(8,7,9,1,2))},
                        {new Integer[]{6,8,7,4,2},new ArrayList<>(Collections.singletonList(2))},
                        {new Integer[]{0,8,4,1,2,7},new ArrayList<>(Arrays.asList(1,2,7))}
                }
        );
    }

    @Test
    public void getElementsAfter4Test() {
        ArrayMethods arrayMethods = new ArrayMethods(value);
        Assertions.assertEquals(arrayMethods.getElementsAfter4(),result);
    }
    @BeforeAll
    @Test
    public void ArrayMethodsConstructor() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Integer[] a = {1, 2, 4};
            new ArrayMethods(a);
        });
    }

    @Test
    public void checkListTest() {
        ArrayMethods arrayMethods = new ArrayMethods(value);
        Assertions.assertFalse(arrayMethods.is4or1);
    }
}

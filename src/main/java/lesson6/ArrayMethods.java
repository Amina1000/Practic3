package lesson6;

import java.util.*;

/**
 * homework lesson14
 *
 * @author Amina
 * 21.04.2021
 */
public class ArrayMethods {
    public List<Integer> list;
    public boolean is4or1;

    public ArrayMethods(Integer...a) {
        if(a.length < 4 ){
            throw new RuntimeException("Массив не может быть менее 4х элементов");
        }
        list = Arrays.asList(a);
    }
    public List<Integer> getElementsAfter4(){

        int a =0;

        for (int i = list.size()-1; i > -1; i--) {
            if (list.get(i) == 4) {
                a = i+1;
                break;
            }
        }
        return new ArrayList<>(list.subList(a, list.size()));
    }

    public void checkList(){
        if (list.contains(1) && list.contains(4)){
            list.forEach((Integer el) -> is4or1 = el == 1 || el == 4);
        }else {
            is4or1=false;
        }
    }

}

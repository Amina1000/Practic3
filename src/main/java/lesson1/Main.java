package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * homework lesson11
 *
 * @author Amina
 * 25.04.2021
 */
public class Main {
    public static void main(String[] args) {

        String[] str = {"семь", "раз", "отмерь",
                        "один", "раз", "отрежь"};
        //процедура решает две задачи. Задача 1,2
        changeElements(str,0,3);
        //Задача 3
        Apple apple = new Apple(1.5f,"яблоко");
        Orange orange = new Orange(1.5f,"апельсин");
        Box<Fruit>box1 = fillBox(apple,10, apple.getWeight());
        Box<Fruit>box2 = fillBox(orange,10, orange.getWeight());
         /*
         Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
         которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
         Можно сравнивать коробки с яблоками и апельсинами;
         Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
         Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно,
         в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
         Не забываем про метод добавления фрукта в коробку.

         */
        if (box1.compare(box2)){
            System.out.println("Коробки равны");
        }else System.out.println("Коробки не равны");
        box1.shift(box2);
        System.out.println(box1.toString());
        System.out.println(box2.toString());

    }
    /*
     1.Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
     2.Написать метод, который преобразует массив в ArrayList;
     */
    public static <T> void changeElements(T[] arr, int i, int j){
        List<T> list = new ArrayList<>(Arrays.asList(arr));
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        System.out.println(list.toString());
    }
    /*
    Задача 3:
    Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
    Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    Для хранения фруктов внутри коробки можно использовать ArrayList;
    Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     */
    public static<F extends Fruit> Box<F> fillBox(F fruit, int count, float weight){
        Box<F>box = new Box<>(fruit, count);
        System.out.println(box.toString());
        box.setWeight(weight);
        System.out.println("Вес: "+box.getWeight());
        return box;
    }

}

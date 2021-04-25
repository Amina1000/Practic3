package lesson1;

/**
 * homework lesson11
 *
 * @author Amina
 * 25.04.2021
 */
public class Apple extends Fruit{

    public Apple(float weight, String name) {
        super(weight,name);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}

package lesson1;

/**
 * homework lesson11
 *
 * @author Amina
 * 25.04.2021
 */
public class Orange extends Fruit{
    public Orange(float weight, String name) {
        super(weight,name);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}

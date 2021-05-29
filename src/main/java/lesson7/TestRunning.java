package lesson7;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * homework lesson7
 *
 * @author Amina
 * 28.05.2021
 */
public class TestRunning {

    private static final List<Method> testMethods = new LinkedList<>();
    private static final List<Method> afterTest = new ArrayList<>();
    private static final List<Method> beforeTest = new ArrayList<>();

    public static void main(String[] args) {
        Class<Cat> cats = Cat.class;
        start(cats);
        invokeAllMethods(cats);
    }

    public static void start(@NotNull Class<Cat> testClass) {

        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeTest.add(method);
            }
            if (method.getAnnotation(Test.class) != null) {
                testMethods.add(method);
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                afterTest.add(method);
            }
        }
        if (beforeTest.size() != 1 || afterTest.size() != 1) {
            throw new RuntimeException();
        }
    }

    private static void invokeAllMethods(@NotNull Class<Cat> testClass) {

        try {
            Constructor<Cat> catConstructor = testClass.getConstructor(String.class, int.class);
            Cat cat = catConstructor.newInstance("Murzik", 3);
            if (beforeTest.size() == 1) {
                Method beforeMethod = beforeTest.get(0);
                beforeMethod.setAccessible(true);
                beforeMethod.invoke(cat);
            }
            int priority = Priority.ONE.level;
            do {
                for (Method method : testMethods) {
                    if (method.getAnnotation(Test.class).priority().level == priority) {
                        method.setAccessible(true);
                        Class[] type = method.getParameterTypes();
                        if (type[0] == int.class){
                            method.invoke(cat,3);
                        }else if (type[0] == String.class){
                            method.invoke(cat,  "play");
                        }
                    }
                }
                priority++;
            } while (priority <= Priority.TEN.level);

            if (afterTest.size() == 1) {
                afterTest.get(0).invoke(cat);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

package lesson7;

/**
 * homework lesson7
 *
 * @author Amina
 * 28.05.2021
 */
public class Cat {

    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @BeforeSuite
    private void sayHello(){
        System.out.println(name + " Hello");
    }

    @AfterSuite
    public void sayBay(){
        System.out.println(name + " Bay");
    }

    @Test(priority = Priority.FOUR)
    private void sayMeow(int count){
        for (int i = 0; i < count; i++) {
            System.out.println("Meow "+ i);
        }
    }

    @Test(priority = Priority.EIGHT)
    private void sayMeow(String say){
        //for (String word:say) {
            System.out.println("Meow "+ say);
       // }
    }
}

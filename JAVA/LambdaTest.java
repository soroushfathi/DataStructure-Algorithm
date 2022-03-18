import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    interface ParaInterface{
        void showMessage(String name);
    }
    interface NameInterface{
        String showMessage(String firstName, String lastName);
    }

    public static void main(String[] args) {
        ParaInterface paraInterface = name -> System.out.println("hi " + name);
        paraInterface.showMessage("Soroush");

        NameInterface nameInterface = (firstName, lastName) -> firstName + " " + lastName;
        System.out.println(nameInterface.showMessage("Soroush", "Fathi"));

        List<String> strs = new ArrayList<>();
        strs.add("python");
        strs.add("C");
        strs.add("java script");
        strs.add("java");
        System.out.println("str list = " + strs);
        strs.sort((o1, o2) -> o1.length() - o2.length());
        strs.forEach(System.out::println);
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("Soroush");
        strList.add("Fathi");
        for (String s : strList) System.out.println(s);
        strList.forEach(System.out::println);
    }


}

import java.util.LinkedList;
import java.util.List;

public class GenericExamples {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList();
        list.add(1);
        Integer i = list.iterator().next();
    }
}

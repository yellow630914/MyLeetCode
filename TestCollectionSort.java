import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestCollectionSort {
    @Test
    public void testCollectionSort(){
        List<String> strList = new ArrayList<>();
        strList.add("h");
        strList.add("j");
        strList.add("l");
        strList.add("a");
        strList.add("n");
        System.out.println("ORIGINAL： " + strList);
        List<String> streamList = strList.stream().sorted().collect(Collectors.toList());
        System.out.println("STREAM： " + streamList);
        Collections.sort(strList);
        System.out.println("COLLECTIONS： " + strList);
    }
}

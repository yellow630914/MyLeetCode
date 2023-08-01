import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {

    @Test
    public void testGenerator(){
        System.out.println(generate(4));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> oriList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            oriList.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i){
                    oriList.get(i).add(1);
                } else {
                    int sum = oriList.get(i - 1).get(j) + oriList.get(i - 1).get(j -1);
                    oriList.get(i).add(sum);
                }
            }
        }
        return oriList;
    }
}

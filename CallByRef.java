import org.junit.jupiter.api.Test;

import java.util.*;

public class CallByRef {

    @Test
    public void testCallByRef(){
        String type1 = "款項匯出-USD";
        String type2 = "款項匯入-EUR";
        String type3 = "款項匯出_W-EUR";
        String type4 = "款項匯入-USD";
        String type5 = "款項匯入_W-AUD";
        String type6 = "款項匯出-AUD";
        String type7 = "款項匯入-TWD";
        String type8 = "款項匯出-TWD";
        Set<String> typeSet = new HashSet<>();
        typeSet.add(type1);
        typeSet.add(type2);
        typeSet.add(type3);
        typeSet.add(type4);
        typeSet.add(type5);
        typeSet.add(type6);
        typeSet.add(type7);
        typeSet.add(type8);
        List<String> typeList = this.sortStringSetToList(typeSet);
        System.out.println(typeList);
    }

    private List<String> sortStringSetToList(Set<String> keySet){
        List<String> list = new ArrayList<>();
        for (String str:keySet) {
            list.add(str);
        }
        Collections.sort(list);
        return list;
    }

}

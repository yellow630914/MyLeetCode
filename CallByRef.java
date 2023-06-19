import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CallByRef {

    @Test
    public void testCallByRef(){
        List<Man> men = new ArrayList<>();
        System.out.println(men);
        Random r = new Random();
        for (int i = 0;i < 10;i++) {
            men.add(new Man(i, r.nextInt(), true));
        }
        this.setSex(men);

        System.out.println(men);
        men.forEach(System.out::println);
    }

    private void setSex(List<Man> men){
        men.forEach(x -> x.setSex(false));
    }

    private class Man {
        private int id;

        private int old;

        private boolean sex;

        public Man(int id, int old, boolean sex) {
            this.id = id;
            this.old = old;
            this.sex = sex;
        }

        public Man() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Man{" +
                    "id=" + id +
                    ", old=" + old +
                    ", sex=" + sex +
                    '}';
        }
    }
}

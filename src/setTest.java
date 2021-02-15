import java.util.HashSet;
import java.util.Random;

public class setTest {
    public static void main(String[] args) {
        HashSet<Integer> data = new HashSet<>();
        System.out.println(data.add(1));
        System.out.println(data.add(1));
        for (int a:data) {
            System.out.println(a);
        }
        System.out.println("size:" + data.size());
        System.out.println();
        System.out.println(data.remove((1)));

        Random random = new Random(); //初始化随机对象
        System.out.println(random.nextInt(1));
    }
}

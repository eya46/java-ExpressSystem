import java.io.*;
import java.util.HashSet;
import java.util.Random;


public class setTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Random random = new Random();

        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("E://test.data"));
        Book data = (Book)oos.readObject();
        oos.close();
        //Book data = new Book();
        data.b.add(random.nextInt(100));
        data.b.add(random.nextInt(100));
        data.b.add(random.nextInt(100));

        data.Show();

        ObjectOutputStream os = new ObjectOutputStream((new FileOutputStream("E://test.data")));
        os.writeObject(data);
        os.close();
    }

    public static class Book implements Serializable {
        public int a = 666;
        public HashSet<Integer> b = new HashSet<Integer>(); //用于存储快递信息,方便查询
        public void Show(){
            for(int i:b){
                System.out.println(i);
            }
        }
    }
}

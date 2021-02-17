package SaveData;

import java.io.*;
import java.util.HashSet;

public class Save{
    public Do Load() throws IOException {
        Do data;

        try{
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("express.data"));
            data = new Do((HashSet<Express>)oos.readObject());
            oos.close();
            System.out.println("�ҵ��洢�ļ�,���سɹ�!");
            System.out.println("�洢�����:" + data.getNum());
            return data;
        }catch (Exception e) {
            data = new Do();
            System.out.println("�ޱ�������,�½��洢�ļ�!");
            return data;
        }
    }

    public boolean Save(Do p) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream("express.data")));
        try(oos) {
            oos.writeObject(p.Throw());
            oos.close();
            return true;
        }catch (Exception e){
            oos.close();
            return false;
        }
    }
}

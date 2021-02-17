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
            System.out.println("找到存储文件,加载成功!");
            System.out.println("存储快递数:" + data.getNum());
            return data;
        }catch (Exception e) {
            data = new Do();
            System.out.println("无本地数据,新建存储文件!");
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

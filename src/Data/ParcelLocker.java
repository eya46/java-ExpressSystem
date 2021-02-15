package Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class ParcelLocker {
    static int parcelLockerX = 10; //快递柜宽
    static int parcelLockerY = 6; //快递柜高
    static int maxNum = parcelLockerX * parcelLockerY;
    static int parcelNum = 0;
    static ArrayList<Integer> randomArr = new ArrayList<>(); //可下标索引方便随机生成
    static HashSet<Express> parcelInfo = new HashSet<>(); //用于存储快递信息,方便查询
    static Random random = new Random(); //初始化随机对象
    //Express express; //快递对象

    static {
        int temp = 0;
        while(true){
            randomArr.add(temp);
            temp += 1;
            if(temp > 60) break;
        }
    }

    public int getNum(){
        return parcelNum;
    }

    public boolean add(int code,Express e){
        if(parcelNum >= maxNum) return false;
        parcelNum += 1; //快递数量加1
        e.setLocation(randomArr.remove(random.nextInt(randomArr.size())));
        e.setCode(code);
        parcelInfo.add(e);
        //根据下标范围随机生成下标,remove根据下标删除,返回值为删除的元素
        return true;
    }
}

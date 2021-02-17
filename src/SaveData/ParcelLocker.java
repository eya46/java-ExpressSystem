package SaveData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class ParcelLocker {
    static int parcelLockerX = 10; //��ݹ��
    static int parcelLockerY = 6; //��ݹ��
    static int maxNum = parcelLockerX * parcelLockerY;
    static int parcelNum = 0;
    static ArrayList<Integer> randomArr = new ArrayList<>(); //���±����������������
    static HashSet<Express> parcelInfo; //���ڴ洢�����Ϣ,�����ѯ
    static Random random = new Random(); //��ʼ���������
    //Express express; //��ݶ���

    static {
        int temp = 0;
        while(true){
            randomArr.add(temp);
            temp += 1;
            if(temp > 60) break;
        }
    }

    public ParcelLocker(){
        parcelInfo = new HashSet<>();
    }

    public ParcelLocker(HashSet<Express> e){
        parcelInfo = e;
        parcelNum = parcelInfo.size();
    }

    public HashSet<Express> Throw(){
        return parcelInfo;
    }

    public int getNum(){
        return parcelNum;
    }

    public boolean add(int code, Express e){
        if(parcelNum >= maxNum) return false;
        parcelNum += 1; //���������1
        e.setLocation(randomArr.remove(random.nextInt(randomArr.size())));
        e.setCode(code);
        parcelInfo.add(e);
        //�����±귶Χ��������±�,remove�����±�ɾ��,����ֵΪɾ����Ԫ��
        return true;
    }
}

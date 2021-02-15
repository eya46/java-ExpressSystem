package Data;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * �����
 */

public class Express implements Comparable<Express>{
    //��ʾ��ݹ�˾,static���α����ظ�ռ�ÿռ�
    static String[] expressCompanies = {"Բͨ���","˳����","�й�����","��������","��ͨ���","�ϴ���"};
    static public String expressShow = "";
    static {  //����������ʾ�Ŀ�ݱ�
        for(int i=0;i<expressCompanies.length;i++){
            expressShow += i + "." + expressCompanies[i] + "\n";
        }
    }

    int danHao,code,location,company; //����,ȡ����,��ݹ�λ��,��ݹ�˾

    /**
     * ȫ�ι��췽��
     * @param danHao ��ݵ���
     * @param code ȡ����
     * @param location ��ݹ���
     * @param company ��ݹ�˾���
     */
    public Express(int danHao, int code, int location, int company) {
        this.danHao = danHao;
        this.code = code;
        this.location = location;
        this.company = company;
    }

    public Express(int danHao, int code, int company) {
        this.danHao = danHao;
        this.code = code;
        this.company = company;
    }

    public Express(int danHao, int company) {
        this.danHao = danHao;
        this.company = company;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setCode(int code){
        this.code = code;
    }

    public void setDanHao(int danHao) {
        this.danHao = danHao;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    @Override
    public int compareTo(Express o) { //����ȡ����Ƚ��Ƿ��ظ�
        return o.code;
    }

    @Override
    public String toString() {
        return "��ݵ���:" + this.danHao +
                " ȡ����:" + this.code +
                " ��ݹ�λ��:" + this.location +
                " ��ݹ�˾:" + this.expressCompanies[this.company];
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;//��ַ���
        }

        if(obj == null){
            return false;//�ǿ��ԣ���������ǿ�����x��x.equals(null)Ӧ�÷���false��
        }

        if(obj instanceof Express){
            //����������һ����Ԫ�����...,ifһ����Ч��
            return (((Express) obj).danHao == this.danHao)?true:false;
        }

        return false;
    }
}

package Data;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 快递类
 */

public class Express implements Comparable<Express>{
    //显示快递公司,static修饰避免重复占用空间
    static String[] expressCompanies = {"圆通快递","顺丰快递","中国邮政","京东物流","申通快递","韵达快递"};
    static public String expressShow = "";
    static {  //构造用于显示的快递表
        for(int i=0;i<expressCompanies.length;i++){
            expressShow += i + "." + expressCompanies[i] + "\n";
        }
    }

    int danHao,code,location,company; //单号,取件码,快递柜位置,快递公司

    /**
     * 全参构造方法
     * @param danHao 快递单号
     * @param code 取件码
     * @param location 快递柜编号
     * @param company 快递公司序号
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
    public int compareTo(Express o) { //根据取件码比较是否重复
        return o.code;
    }

    @Override
    public String toString() {
        return "快递单号:" + this.danHao +
                " 取件码:" + this.code +
                " 快递柜位置:" + this.location +
                " 快递公司:" + this.expressCompanies[this.company];
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;//地址相等
        }

        if(obj == null){
            return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }

        if(obj instanceof Express){
            //纯粹是想试一试三元运算符...,if一样的效果
            return (((Express) obj).danHao == this.danHao)?true:false;
        }

        return false;
    }
}

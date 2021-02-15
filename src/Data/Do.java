package Data;

public class Do extends ParcelLocker{
    public String expressShow = Express.expressShow;
    public String[] expressCompanies = Express.expressCompanies;

    /**
     *
     * @param info 信息
     * @param index 0:单号,1:取件码
     * @return
     */
    private Express search(int info,int index){
        if(parcelNum == 0) return null;
        if(index == 0){
            for(Express i:parcelInfo){
                if(i.danHao == info) return i;
            }
        }
        if (index == 1){
            for(Express i:parcelInfo){
                if(i.code == info) return i;
            }
        }
        return null;
    }

    /**
     *
     * @param info 要比较的信息
     * @param index 0:单号,1:取件码
     * @return
     */
    private boolean recheck(int info,int index){
        if(index == 0) {
            for (Express i : parcelInfo) {
                if (i.danHao == info) return true;
            }
        }else if(index == 1){
            for (Express i : parcelInfo) {
                if (i.code == info) return true;
            }
        }
        return false;
    }
    /**
     *
     * @param danHao
     * @param company
     * @return 0 存件成功
     * @return -1 快递柜已满
     * @return -2 单号重复
     * @return -3 快递公司溢出
     * @return -4 内部方法错误
     */
    public int save(int danHao,int company){
        if(parcelNum >= 60) return -1;
        if (company < 0 || company > expressCompanies.length - 1) return -3;

        int temp;
        Express express = new Express(danHao,company);
        if (parcelNum <= 0){
            temp = random.nextInt(900000) + 100000;
        }else{
            if(recheck(danHao,0)) return  -2;
            while (true){
                temp = random.nextInt(900000) + 100000;
                if(recheck(temp,1)) continue;
                break;
            }
        }
        return this.add(temp,express)?0:-4;
    }

    /**
     *
     * @param info
     * @param index 0:单号,1:取件码
     * @return
     */
    public boolean remove(int info,int index){
        Express temp = search(info,index);
        if(parcelInfo.remove(temp)) {
            parcelNum -= 1;
            //感觉在Do模块,而不是Show模块打印有点不好,但是要show修改也不方便,目前就这样吧,之后再说
            System.out.println(temp); //打印输出
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param danHao 单号.用于定位快递
     * @param info 修改为的信息
     * @param index 0:单号,1:快递公司
     * @return true || false
     */
    public boolean change(int danHao,int info,int index){
        if(index == 0) {
            if(recheck(info,0)) return false;
            Express temp = search(danHao,0);
            if(temp == null) return false;
            temp.setDanHao(info); //缺陷:没说明失败原因
            return true;
        }
        if(index == 1) {
            if (info < 0 || info > expressCompanies.length - 1) return false;
            Express temp = search(danHao,0);
            if(temp == null) return false;
            temp.setCompany(info);
            return true;
        }
        return false;
    }

    public void showAll(){
        int temp = 0;
        for (Express i:parcelInfo) {
            //System.out.println("1"); //测试
            System.out.println(temp + "." + i); //i相当于调用toString()
            temp += 1;
        }
    }
}

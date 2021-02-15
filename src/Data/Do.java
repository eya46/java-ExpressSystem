package Data;

public class Do extends ParcelLocker{
    public String expressShow = Express.expressShow;
    public String[] expressCompanies = Express.expressCompanies;

    /**
     *
     * @param info ��Ϣ
     * @param index 0:����,1:ȡ����
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
     * @param info Ҫ�Ƚϵ���Ϣ
     * @param index 0:����,1:ȡ����
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
     * @return 0 ����ɹ�
     * @return -1 ��ݹ�����
     * @return -2 �����ظ�
     * @return -3 ��ݹ�˾���
     * @return -4 �ڲ���������
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
     * @param index 0:����,1:ȡ����
     * @return
     */
    public boolean remove(int info,int index){
        Express temp = search(info,index);
        if(parcelInfo.remove(temp)) {
            parcelNum -= 1;
            //�о���Doģ��,������Showģ���ӡ�е㲻��,����Ҫshow�޸�Ҳ������,Ŀǰ��������,֮����˵
            System.out.println(temp); //��ӡ���
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param danHao ����.���ڶ�λ���
     * @param info �޸�Ϊ����Ϣ
     * @param index 0:����,1:��ݹ�˾
     * @return true || false
     */
    public boolean change(int danHao,int info,int index){
        if(index == 0) {
            if(recheck(info,0)) return false;
            Express temp = search(danHao,0);
            if(temp == null) return false;
            temp.setDanHao(info); //ȱ��:û˵��ʧ��ԭ��
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
            //System.out.println("1"); //����
            System.out.println(temp + "." + i); //i�൱�ڵ���toString()
            temp += 1;
        }
    }
}

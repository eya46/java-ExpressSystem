package Show;

import Input.Input;
import Data.Do;

public class Show {
    Input input = new Input(); //���봦��
    Do data = new Do();
    static String MAIN_MENU_SHOW = "=====��ӭʹ�ÿ��ֿ�ݹ�=====v3.0";
    static String MAIN_MENU_SELECT = "�������������:1-����Ա 2-�û� 0-�˳�";

    static String MANAGER_MENU_SHOW = "=====��ӭ�������Ա����=====";
    static String MANAGER_MENU_SELECT = "��ѡ�����:" + "1-���¼�� 2-ɾ����� 3-�޸Ŀ����Ϣ 4-�鿴���п�� 0-�˳��˽���";

    static String USER_MENU_SHOW = "=====��ӭ�����û�����=====";
    static String USER_MENU_SELECT = "��ѡ�����:" + "1-���ȡ�� 0-�˳��˽���";

    static String MANAGER_SAVE_MENU_SHOW = "=====��ӭ�������ԱԱ-���¼�����=====";

    static String MANAGER_DELETE_MENU_SHOW = "=====��ӭ�������ԱԱ-ɾ����ݽ���=====";

    static String MANAGER_MODIFY_MENU_SHOW = "=====��ӭ�������ԱԱ-�޸Ŀ����Ϣ����=====";

    static String MANAGER_SEE_MENU_SHOW = "=====��ӭ�������ԱԱ-�鿴���п�ݽ���=====";

    public void mainShow(){
        System.out.println("");
        System.out.println(MAIN_MENU_SHOW);
        System.out.println(MAIN_MENU_SELECT);
    }
    //������
    public boolean selectMain(int i){
        switch (i){
            case 1:selectManager();return false;
            case 2:selectUser();return false;
            case 0:return true;
            default:
                wrongSelect();
                return false;
        }
    }
    //����Ա����
    private int selectManager(){
        System.out.println("");
        System.out.println(MANAGER_MENU_SHOW);
        System.out.println(MANAGER_MENU_SELECT);
        int i = input.in(0);
        System.out.println("");
        switch (i){
            case 1:mSave();break;
            case 2:mDelete();break;
            case 3:mChange();break;
            case 4:mShowAll();break;
            case 0:return 0;
            default:
                wrongSelect();
                return selectManager();
        }
        return 0;
    }

    //�û�����
    private int selectUser(){
        System.out.println("");
        System.out.println(USER_MENU_SHOW);
        System.out.println(USER_MENU_SELECT);
        int i = input.in(0);
        System.out.println("");
        switch (i){
            case 1:uGet();break;
            case 0:return 0;
            default:
                wrongSelect();
                return selectUser();
        }
        return 0;
    }

    private boolean mSave(){
        System.out.println(MANAGER_SAVE_MENU_SHOW);
        System.out.println("�������ݵ���:");
        int danHao = input.in(0);
        System.out.println(data.expressShow);
        System.out.println("�������ݹ�˾���:");
        int xuHao = input.in(0);
        int result = data.save(danHao,xuHao);
        if(result == 0){
            System.out.println("����ɹ�!");
            return true;
        }else if(result == -1){
            System.out.println("�������!");
            return false;
        }else if(result == -2){
            System.out.println("�����ظ�!");
            return false;
        }else if(result == -3){
            System.out.println("��ݹ�˾������!");
            return false;
        }else if(result == -4){
            System.out.println("�ڲ���������!");
            return false;
        }
        return false;
    }

    private boolean mDelete(){
        System.out.println(MANAGER_DELETE_MENU_SHOW);
        System.out.println("������Ҫɾ���Ŀ�ݵ���:");
        int danHao = input.in(0);
        if(data.remove(danHao,0)){
            System.out.println("ɾ���ɹ�!");
            return true;
        }else{
            System.out.println("ɾ��ʧ��!");
            return false;
        }
    }

    private boolean mChange(){
        System.out.println(MANAGER_MODIFY_MENU_SHOW);
        System.out.println("������Ҫ�޸ĵĿ�ݵ���:");
        int danHao = input.in(0);
        System.out.println("������Ҫ�޸ĵ�ֵ");
        System.out.println("1.��ݵ���");
        System.out.println("2.��ݹ�˾");
        int num = input.in(0);
        switch (num){
            case 1:{
                System.out.print("�������µ�ֵ:");
                if(data.change(danHao,input.in(0),0)){
                    System.out.println("�޸ĳɹ�!");
                }else {
                    System.out.println("�޸�ʧ��!");
                }
                return true;
            }
            case 2:{
                System.out.println(data.expressShow);
                System.out.print("�������µ�ֵ:");
                if(data.change(danHao,input.in(0),1)){
                    System.out.println("�޸ĳɹ�!");
                }else {
                    System.out.println("�޸�ʧ��!");
                }
                return true;
            }
            default: {
                wrongSelect();
                return false;
            }
        }
    }

    private void mShowAll(){
        System.out.println(MANAGER_SEE_MENU_SHOW);
        System.out.println("�������:" + data.getNum());
        data.showAll();
    }

    private void uGet(){
        System.out.println("������ȡ����");

        if(data.remove(input.in(0),1)) {
            System.out.println("�뼰ʱ��ȡ���Ŀ��,��ӭ�´�ʹ��!");
        }else{
            System.out.println("ȡ��ʧ��");
        }


    }

    private void wrongSelect(){
        System.out.println("����ѡ��!");
    }
}

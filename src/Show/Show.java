package Show;

import Input.Input;
import Data.Do;

public class Show {
    Input input = new Input(); //输入处理
    Do data = new Do();
    static String MAIN_MENU_SHOW = "=====欢迎使用快乐快递柜=====v3.0";
    static String MAIN_MENU_SELECT = "请输入您的身份:1-管理员 2-用户 0-退出";

    static String MANAGER_MENU_SHOW = "=====欢迎进入管理员界面=====";
    static String MANAGER_MENU_SELECT = "请选择操作:" + "1-快递录入 2-删除快递 3-修改快递信息 4-查看所有快递 0-退出此界面";

    static String USER_MENU_SHOW = "=====欢迎进入用户界面=====";
    static String USER_MENU_SELECT = "请选择操作:" + "1-快递取出 0-退出此界面";

    static String MANAGER_SAVE_MENU_SHOW = "=====欢迎进入管理员员-快递录入界面=====";

    static String MANAGER_DELETE_MENU_SHOW = "=====欢迎进入管理员员-删除快递界面=====";

    static String MANAGER_MODIFY_MENU_SHOW = "=====欢迎进入管理员员-修改快递信息界面=====";

    static String MANAGER_SEE_MENU_SHOW = "=====欢迎进入管理员员-查看所有快递界面=====";

    public void mainShow(){
        System.out.println("");
        System.out.println(MAIN_MENU_SHOW);
        System.out.println(MAIN_MENU_SELECT);
    }
    //主界面
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
    //管理员界面
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

    //用户界面
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
        System.out.println("请输入快递单号:");
        int danHao = input.in(0);
        System.out.println(data.expressShow);
        System.out.println("请输入快递公司序号:");
        int xuHao = input.in(0);
        int result = data.save(danHao,xuHao);
        if(result == 0){
            System.out.println("存件成功!");
            return true;
        }else if(result == -1){
            System.out.println("快递已满!");
            return false;
        }else if(result == -2){
            System.out.println("单号重复!");
            return false;
        }else if(result == -3){
            System.out.println("快递公司序号溢出!");
            return false;
        }else if(result == -4){
            System.out.println("内部方法错误!");
            return false;
        }
        return false;
    }

    private boolean mDelete(){
        System.out.println(MANAGER_DELETE_MENU_SHOW);
        System.out.println("请输入要删除的快递单号:");
        int danHao = input.in(0);
        if(data.remove(danHao,0)){
            System.out.println("删除成功!");
            return true;
        }else{
            System.out.println("删除失败!");
            return false;
        }
    }

    private boolean mChange(){
        System.out.println(MANAGER_MODIFY_MENU_SHOW);
        System.out.println("请输入要修改的快递单号:");
        int danHao = input.in(0);
        System.out.println("请输入要修改的值");
        System.out.println("1.快递单号");
        System.out.println("2.快递公司");
        int num = input.in(0);
        switch (num){
            case 1:{
                System.out.print("请输入新的值:");
                if(data.change(danHao,input.in(0),0)){
                    System.out.println("修改成功!");
                }else {
                    System.out.println("修改失败!");
                }
                return true;
            }
            case 2:{
                System.out.println(data.expressShow);
                System.out.print("请输入新的值:");
                if(data.change(danHao,input.in(0),1)){
                    System.out.println("修改成功!");
                }else {
                    System.out.println("修改失败!");
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
        System.out.println("快递数量:" + data.getNum());
        data.showAll();
    }

    private void uGet(){
        System.out.println("请输入取件码");

        if(data.remove(input.in(0),1)) {
            System.out.println("请及时提取您的快递,欢迎下次使用!");
        }else{
            System.out.println("取件失败");
        }


    }

    private void wrongSelect(){
        System.out.println("错误选择!");
    }
}

import Input.Input;
import SaveShow.Show;

import java.io.IOException;

public class SaveMain {
    public static void main(String[] args) throws IOException {
        Show show = new Show(); //视图界面
        Input input = new Input(); //输入处理
        //视图界面显示与选择
        while(true) {
            //show.main();
            show.mainShow();
            if(show.selectMain(input.in(0))){
                if(show.Close()){
                    System.out.println("保存成功!");
                }else{
                    System.out.println("保存失败!");
                }
                break;
            } //进入管理员or用户界面
        }
    }
}

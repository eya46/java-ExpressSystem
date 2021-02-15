import Input.Input;
import Show.Show;

public class Main {
    public static void main(String[] args) {
        Show show = new Show(); //视图界面
        Input input = new Input(); //输入处理
        //视图界面显示与选择
        while(true) {
            //show.main();
            show.mainShow();
            if(show.selectMain(input.in(0))){break;} //进入管理员or用户界面
        }
    }
}

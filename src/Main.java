import Input.Input;
import Show.Show;

public class Main {
    public static void main(String[] args) {
        Show show = new Show(); //��ͼ����
        Input input = new Input(); //���봦��
        //��ͼ������ʾ��ѡ��
        while(true) {
            //show.main();
            show.mainShow();
            if(show.selectMain(input.in(0))){break;} //�������Աor�û�����
        }
    }
}

import Input.Input;
import SaveShow.Show;

import java.io.IOException;

public class SaveMain {
    public static void main(String[] args) throws IOException {
        Show show = new Show(); //��ͼ����
        Input input = new Input(); //���봦��
        //��ͼ������ʾ��ѡ��
        while(true) {
            //show.main();
            show.mainShow();
            if(show.selectMain(input.in(0))){
                if(show.Close()){
                    System.out.println("����ɹ�!");
                }else{
                    System.out.println("����ʧ��!");
                }
                break;
            } //�������Աor�û�����
        }
    }
}

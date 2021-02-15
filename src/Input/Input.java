package Input;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);
    static String INPUT_TIP = "��������:";
    static String WRONG_TIP = "����ȷ����!";
    public Input() { //����ʱ����

    }

    public int in(int i){ //����1
        while(true) {
            try {
                System.out.print(INPUT_TIP);
                return Integer.parseInt(input.nextLine());
            } catch (Exception err) {
                System.out.println(WRONG_TIP);
            }
        }
    }

    public int in2(int i){ //����2
        while(true){
            try{
                System.out.print(INPUT_TIP);
                return input.nextInt();
            }catch (Exception err){
                System.out.println(WRONG_TIP);
            }
        }
    }
    public String in(String i){ //�ع�ΪString
        while(true){
            try{
                System.out.print(INPUT_TIP);
                return input.nextLine();
            }catch (Exception err){
                System.out.println(WRONG_TIP);
            }
        }
    }
}


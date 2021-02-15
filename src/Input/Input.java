package Input;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);
    static String INPUT_TIP = "您的输入:";
    static String WRONG_TIP = "请正确输入!";
    public Input() { //构造时生成

    }

    public int in(int i){ //方法1
        while(true) {
            try {
                System.out.print(INPUT_TIP);
                return Integer.parseInt(input.nextLine());
            } catch (Exception err) {
                System.out.println(WRONG_TIP);
            }
        }
    }

    public int in2(int i){ //方法2
        while(true){
            try{
                System.out.print(INPUT_TIP);
                return input.nextInt();
            }catch (Exception err){
                System.out.println(WRONG_TIP);
            }
        }
    }
    public String in(String i){ //重构为String
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


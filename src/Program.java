import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
//    public static double inputDouble(){
//        Scanner in = new Scanner(System.in);
//        return Double.parseDouble(in.nextLine());
//    }
//    public static double [] equation2(double a,double b,double c){
//        double[] result = new double[2];
//        if (a==0){
//            if (b==0){
//                result = null;
//            }else {
//                result[0] = -c/b;
//                result[1] = -c/b;
//            }
//        }else{
//        double delta = Math.pow(b,2) - 4*a*c;
//            if (delta<0){
//                result = null;
//            }else if (delta == 0){
//                double x1 = -b/(2*a);
//                result[0] = x1;
//                double x2 = -b/(2*a);
//                result[1] = x2;
//            }
//            else {
//                double x1 = (-b+Math.sqrt(delta)/(2*a));
//                double x2 = (-b-Math.sqrt(delta)/(2*a));
//                result[0] = x1;
//                result[1] = x2;
//            }}
//
//        return result;
//    }
    public static void main(String[] args) {

//        double a = inputDouble();
//        double b = inputDouble();
//        double c = inputDouble();
//        double[] result = equation2(a,b,c);
//        if (result == null){
//            System.out.println("Vo nghiem");
//        }else if(result[0] == result [1]) {
//            System.out.println("Pt co nghiem duy nhat x = "+result[0]);
//
//        }else {
//            System.out.println("x1= " +result[0] + " \n" + "x2 = "+ result[1]);
//        }
//        Scanner in = new Scanner(System.in);
//        Human person1 = new Human();
//        Human person2 = new Human("Linh",24,"male");
//        Employee e1 = new Employee();
//        e1.eat();
        GamePanel panel = new GamePanel();
        JFrame window = new JFrame();
        window.setVisible(true);
        panel.setPreferredSize(new Dimension(600,600));
        panel.setBackground(Color.GREEN);
        window.add(panel);
        window.pack();
        window.setLocation(350,40);
//        window.setSize(600,700);


        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        System.out.println(System.currentTimeMillis());

        KeyAdapter keyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP){
                    KeyEvenPress.isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT){
                    KeyEvenPress.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT){
                    KeyEvenPress.isRightPress= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN){
                    KeyEvenPress.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEvenPress.isFirePress = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP){
                    KeyEvenPress.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT){
                    KeyEvenPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT){
                    KeyEvenPress.isRightPress= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S ||  e.getKeyCode()==KeyEvent.VK_DOWN){
                    KeyEvenPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEvenPress.isFirePress = false;
                }
            }
        };
        window.addKeyListener(keyHandler);
        panel.gameloop();
    }
}

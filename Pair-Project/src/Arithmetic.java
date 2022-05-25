import java.io.*;
import java.util.*;

public class Arithmetic {
    static Random rand = new Random();
    public static int transForm(int m){
        while(m==0){
            m=rand.nextInt(100);
        }
        return m;
    }
    public static String getString(int m){
        String str="";
        switch(m) {
            case 1:str = "+";
                break;
            case 2:str = "-";
                break;
            case 3:str = "*";
                break;
            case 4:str = "/";
                break;
        }
        return str;
    }
    private static int getCount(int a, int b, int c){
        int sum=0;
        switch(c) {
            case 1:sum=a+b;
                break;
            case 2:sum=a-b;
                break;
            case 3:sum=a*b;
                break;
            case 4:sum=a/b;
                break;
        }
        return sum;
    }

    public static void main(String[] args) {
        PrintStream ps;
        try {
            ps = new PrintStream("D:\\Arithmetic.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您想要的四则运算题目的数量：");
        int x = sc.nextInt();
        System.setOut(ps);
        System.out.println("以下是您想要的"+x+"道四则运算题目：");

        int y=0;
        while(y<x){
        int a=rand.nextInt(100);
        int b=rand.nextInt(100);

        if(a==0||b==0){
            if(a==0){
                a=transForm(a);
            }
            if(b==0){
                b=transForm(b);
            }
        }

        int c=rand.nextInt(4-1+1)+1;
        String d=getString(c);
        if(d.equals("-") || d.equals("%")){
            if(b>a){
                int k=a;
                a=b;
                b=k;
            }
        }

        int result=getCount(a,b,c);
        System.out.print(a+""+d+""+b+"="+result+"    ");
        System.out.println("这道题目的答案为："+result);
        y++;
        }
    }
}
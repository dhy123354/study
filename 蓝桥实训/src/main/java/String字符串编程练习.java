
import sun.text.resources.cldr.bn.FormatData_bn_IN;

import java.util.Scanner;

public class String字符串编程练习 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int years = 0, month = 0, days = 0;
        boolean isRui = false;
        System.out.println("请输入年份：");
        years = scan.nextInt();
        System.out.println("请输入月份：");
        month = scan.nextInt();
        System.out.println("\n*********" + years + "年" + month + "月 日曆表************");
        if (years % 4 == 0 && years % 100 != 0 && years % 400 == 0) {
            isRui = true;
        }
        //计算总天数
        int total = 0;
        for (int i = 1900; i < years; i++) {
            if ((years % 4 == 0 && years % 100 != 0) || years % 400 == 0) {
                total += 366;
            } else {
                total += 365;
            }
        }

        for (int i = 1; i <= month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;
                    break;
                case 2:
                    if (isRui) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                default:
                    System.out.println("");
            }
            if (i < month) {
                total += days;
            }
        }

        int fristofmonth = 0;
        int temp = 1 + total % 7;
        if (temp == 7){
            fristofmonth = 0;
        }else {
            fristofmonth = temp;
        }
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
        for(int k = 0; k < fristofmonth; k++){
            System.out.print("\t");
        }
        for(int m = 1; m <= days; m++){
            System.out.print( m + "\t");
            if((total + m) % 7 == 6){
                System.out.print("\n");
            }
        }
        scan.close();
    }
}

import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    Random rd = new Random();                                   // BASİK_MİNESWEEPER
                                                               //*=mayın -=mayın yok
    int line;                                                  //map[][] mayınlarının yerini görmen için senin için real[][] oyuncu için görmüyo
    int column;                                               // random sayesinde mayınları gelişigüzel atadık
    int mineNo;
    String[][] map;
    String[][] real;
    Scanner scan = new Scanner(System.in);

    public void start() {                                                       //mayın sayısını satı*sütun/4 verecek
        System.out.println("***Welcome to Mines Weeper Game***");             //satır sütun sayısı kullanıcıdan alınacak
        System.out.print("Enter the number of line:"); 
        line = scan.nextInt();
        System.out.print("Enter the number of column:");
        column = scan.nextInt();
        mineNo = (line * column) / 4;

        map = new String[line][column];
        real = new String[line][column];

        for (int i = 0; i < line; i++) {
            for (int k = 0; k < column; k++) {
                map[i][k] = "-";
                real[i][k] = "-";
            }
        }
        while (mineNo > 0) {
            int lineMineNo = rd.nextInt(line);                                     //mayınları random yerlere atadık
            int columnMineNo = rd.nextInt(column);
                                                           //atadığımız yerdeki - olanları mayına dönüştürerek * yaptık ama map'te yaptık real da gözükmemesi lazım.
            if (map[lineMineNo][columnMineNo].equals("-")) {                             //mayın sayısını azaltıyoruz çünkü1/4 ü olmalı dedik
                map[lineMineNo][columnMineNo] = "*";
                mineNo--;
            }
        }
    }

    public boolean check(int sLine, int sColumn) {                                    //SEÇİLEN YERİN ETRAFINDA MAYIN VAR MI KONTROL ETMEK İÇİN 
        int a1 = 0;
        if (sLine + 1 < line && map[sLine + 1][sColumn].equals("*")) {                 //seçilen yerin bir alt satırını kontrol ettik
            a1++;
        }
        if (sColumn + 1 < column && map[sLine][sColumn + 1].equals("*")) {            //seçilen yerin sağını kontrol ettik                 
            a1++;
        }
        if (sLine >= 1 && map[sLine - 1][sColumn].equals("*")) {                     //seçilen yerin bir üstünü kontrol ettik
            a1++;
        }
        if (sColumn >= 1 && map[sLine][sColumn - 1].equals("*")) {                //seçilen yerin sol tarafaını kontrol ettik
            a1++;
        }

        if (map[sLine][sColumn].equals("*")) {
           return true;
        } else {
        	 real[sLine][sColumn] = String.valueOf(a1);         //EĞER ETRAFINDA MAIN VARSA VE KULLANICI MAYINA BASMADIYSA KAÇ TANE MAYIN OLDUĞUNU SÖYLEMEK İÇİN
             return false;                           
                                                       //String.valueOf yaptık çünkü a1 integer ve real string bir ifade olduğu için onu stringe dönüştürmem lazım
        }
    }

    public void print() {
        for (int i = 0; i < line; i++) {
            for (int k = 0; k < column; k++) {
                System.out.print(map[i][k] + " ");                         //map[][] ve real[][] ı yazdırmak için olan kısım
            }
            System.out.println();
        }
        System.out.println("Real:");
        for (int i = 0; i < line; i++) {
            for (int k = 0; k < column; k++) {
                System.out.print(real[i][k] + " ");
            }
            System.out.println();
        }
    }
}

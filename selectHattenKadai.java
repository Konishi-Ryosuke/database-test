package jp.ac.chitose.dbe;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class selectHattenKadai {
    public static void main(String[] args) {
        System.out.println("学年を入力してください : ");
        Scanner scan = new Scanner(System.in);
        int gakunen = Integer.valueOf(scan.nextLine());

        try{
            PreExamDAO dao = new PreExamDAO();
            List<HattenKadai> hattenKadais = dao.selectKadai(gakunen);
            for (HattenKadai hattenKadai : hattenKadais){
                hattenKadai.print();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

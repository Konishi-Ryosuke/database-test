package jp.ac.chitose.dbe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreExamDAO {

  // ↓学籍番号（XXXXXXXX）は、Part.01で設定したあなたの学籍番号の値に書き換えること
  private static final String URL = "jdbc:h2:~/h2db/dbe;AUTO_SERVER=true";
  private static final String USER_NAME = "b2180950";
  private static final String USER_PASS = "b2180950";

  public List<PreExam> selectPreExams(int lessThan) throws SQLException{
    List<PreExam> returning = new ArrayList<PreExam>();
    String sql = "select * from 中間テスト where 得点 < ?";

    try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
         PreparedStatement stmt = conn.prepareStatement(sql)){
      stmt.setInt(1,lessThan);
      ResultSet results = stmt.executeQuery();
      while(results.next()){
        String col1 = results.getString("学生コード");
        int col2 = results.getInt("得点");
        PreExam preExam = new PreExam(col1,col2);
        returning.add(preExam);
      }
    }
    return returning;
  }
//テーブルのくっつけ方をggr
  //互いの学生コードを紐づける
  public List<HattenKadai> selectKadai(int gakunen) throws SQLException{
    List<HattenKadai> returning = new ArrayList<>();
    String sql = "select * from 学生情報 left outer join 中間テスト on 学生情報.学生コード = 中間テスト.学生コード where 学年 = ?";//左外部結合
    try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
        PreparedStatement stmt = conn.prepareStatement(sql)){
      stmt.setInt(1,gakunen);
      ResultSet results = stmt.executeQuery();
      while (results.next()){
        String col1 = results.getString("学生コード");
        String col2 = results.getString("氏");
        String col3 = results.getString("名");
        int col4 = results.getInt("得点");
        HattenKadai hattenkadai = new HattenKadai(col1,col2,col3,col4);
        returning.add(hattenkadai);
      }
    }
    return returning;
  }

  public int deletePreExam(String gakuseiCode) throws SQLException{
    String sql = "delete from 中間テスト where 学生コード = ?";
    int n = 0;
    try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
        PreparedStatement stmt = conn.prepareStatement(sql)){
      stmt.setString(1,gakuseiCode);
      n = stmt.executeUpdate();

    }
    return n;
  }

  public int insertPreExam(String gakuseiCode,int point) throws SQLException{
    String sql = "insert into 中間テスト values (?,?)";
    int n = 0;

    try(Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
        PreparedStatement stmt = conn.prepareStatement(sql)){
      stmt.setString(1,gakuseiCode);
      stmt.setInt(2,point);
      n = stmt.executeUpdate();
    }
    return n;
  }
  
}

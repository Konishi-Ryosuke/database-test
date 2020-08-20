package jp.ac.chitose.dbe;

public class HattenKadai {
    private String gakuseiCode;
    private String si;
    private String mei;
    private int point;

    public HattenKadai(String gakuseiCode,String si,String mei,int point){
        this.gakuseiCode = gakuseiCode;
        this.si = si;
        this.mei = mei;
        this.point = point;
    }

    public void print(){
        System.out.println(gakuseiCode + " " + si + mei + "の中間テストの点数は" + point);
    }


    public String getGakuseiCode() {
        return gakuseiCode;
    }

    public String getSi(){
        return si;
    }

    public String getMei(){
        return mei;
    }

    public int getPoint(){
        return point;
    }
}

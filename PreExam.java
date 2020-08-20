package jp.ac.chitose.dbe;

public class PreExam {
    private String gakuseiCode;
    private int point;

    public PreExam(String gakuseiCode,int point){
        this.gakuseiCode = gakuseiCode;
        this.point = point;
    }

    public void print(){
        System.out.println(gakuseiCode + "さんは" + point + "点");
    }

    public String getGakuseiCode(){
        return gakuseiCode;
    }

    public int getPoint(){
        return point;
    }
}

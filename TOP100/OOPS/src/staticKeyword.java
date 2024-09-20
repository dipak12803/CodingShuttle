class Studentss{
    String name;
    static String school;
    public static void changeSchool(){
        school="Kendriya Vidyalaya No.2 ";
    }

}
public class staticKeyword {
    public static void main(String[] args) {
        Studentss.school="KV 2";
        Studentss s1=new Studentss();
        s1.name="Virat";
        System.out.println(s1.school);
    }
}

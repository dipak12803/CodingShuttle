package bank;
public class Account{
    public String name;
    protected String email;
    private String password;

    //getter setter
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String pass){
        this.password=pass;
    }

}
class Bank{
    public static void main(String[] args) {
        Account a1=new Account();
        a1.name="DIPAKSBI";
        a1.email="dipak@gmail.com";
        a1.setPassword("2922");
        System.out.println(a1.getPassword());
    }
}

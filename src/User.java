public abstract class User {
    private String firstName;
    private String lastName;
    private String password;
    private int identifyNumber;
    private String role; // admin - user

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public abstract void add();
    public abstract void remove();
    public abstract void update();


}

public class User extends Account {
    User(String name, String surname, String password, String identifyNumber, String role){
        super(name, surname, password, identifyNumber, role);
        System.out.println("User created");
    }


}

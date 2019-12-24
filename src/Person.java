public class Person {
    private String name;
    private String lastname;
    private String identifyNumber;

    public Person(String name, String surname, String identifyNumber) {
        this.name = name;
        this.lastname = surname;
        this.identifyNumber = identifyNumber;
    }

    public Person(String name, String lastname) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }





}

public class Author extends Person {
    private int age;

    Author(String name, String lastname, int age){
        super(name, lastname);
        this.age = age;
        System.out.println("Author created :");
        System.out.println(name + "\t" + lastname + "\t" + age);
    }
}

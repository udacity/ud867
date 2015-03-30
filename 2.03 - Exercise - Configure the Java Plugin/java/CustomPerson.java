import com.udacity.gradle.Person;

public class CustomPerson extends Person {
    private String lastName;
    
    public CustomPerson(String name, String lastName) {
        super(name);
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
}
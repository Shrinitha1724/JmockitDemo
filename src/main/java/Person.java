public class Person {
    /************************* Person.java ****************/


    private String name;


    public Person(){
        name = "Default Shrini";
    }

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

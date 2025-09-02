package module5.dsa2.linkedlist.day32_33;

class Student {
    int age;
    String name;

    void display(){
        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
    }

    void sayHello(String name){
        System.out.println(this.name + " says hello to " + name);
    }
}

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 10;
        s1.name = "A";

        Student s2 = new Student();
        s2.age = 20;
        s2.name = "B";

        swap(s1, s2);

        s1.display();
    }

    private static void swap(Student s1, Student s2) {
        Student temp = s1;
        s1 = s2;
        s1.display();
        s2 = temp;
        s1.display();
        /**
         * s1 = 1000
         * s2 = 2000
         * temp = 1000
         * s1 = 2000
         * s2 = 1000
         * s1.display() ->
         */
    }
}
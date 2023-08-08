package main.java.chap06.GetterSetter;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Kildong", 30);

        //p1.name = "Dooly"; < 접근 불가
        p1.setName("Dooly"); //setter로 접근
        System.out.println(p1.getName()); //gettter로 접근
    }
}
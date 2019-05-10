public class Human {//Employee
    //thuoc tinh
    String name;
    int age;
    String sex;
    // ham tao
    public Human(){//Ham tao rong
        name  = "New Person";
        age = 20;
        sex = "male";
    }
    public Human(String name,int age,String sex){//Ham tao day du
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public  void eat(){
        System.out.println(name + "Eating...");
    }

    public  void sleep(){
        System.out.println(name + "Sleeping...");
    }
}

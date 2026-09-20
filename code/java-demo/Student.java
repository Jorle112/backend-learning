public class Student {
   
    private String name;
    private int age;
    private double score;

    // 构造方法（创建对象时自动调用）
    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void setAge(int age){
        if(age > 0 && age < 100){
            this.age = age;
        }else{
            System.out.println("年龄不合法:"+ age);
        }
    }

    public int getAge(){
        return age;
    }

    // 普通方法
    public void study() {
        System.out.println(name + " 正在学习，年龄" + age + "，分数" + score);
    }

    // main 入口——程序从这里开始执行

    public static void main(String[] args){
        Student s = new Student("李四",19,90.5);
        s.study();
    }
}
//dev分支加的注释

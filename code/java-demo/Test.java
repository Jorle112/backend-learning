public class Test {
    public static void main(String[] args) {
        Student s = new Student("张三", 20, 88.5);

        // 下面这行取消注释试试，会报错：
        // s.name = "李四";   // ❌ name is private

        // 下面这行取消注释试试，也会报错：
        // System.out.println(s.age); // ❌ age is private

        // 目前你只能调 study()，因为它是 public
        s.study();

        s.setAge(99);
        System.out.println(s.getAge());
    }
}

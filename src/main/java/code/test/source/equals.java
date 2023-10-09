package code.test.source;

public class equals {
    public static void main(String[] args) {
        A a1 = new A(1);
        A a2 = new A(1);

        System.out.println(a1 == a2);       // false
        System.out.println(a1.equals(a2));  // false

        String a = "a";
        
        System.out.println(a.equals("a"));

    }
}


class A {
    int age;

    public A(int age) {
        this.age = age;
    }

    public A() {
    }


    @Override
    public boolean equals(Object obj) {
        // 首先检查是否是同一个对象的引用
        if (this == obj) {
            return true;
        }

        // 检查对象是否为null，以及是否属于A类
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // 将obj转换为A类型
        A otherA = (A) obj;

        // 比较A对象的字段值是否相等
        return this.age == otherA.age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}

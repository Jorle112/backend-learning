# Java 的 main 方法与类结构

## main 写法是固定的吗？

是的，Java 程序的入口方法**必须**写成：

```java
public static void main(String[] args) { ... }
```

每一项的含义：

| 关键字 | 含义 | 为什么 |
|:---|:---|:---|
| `public` | 公开访问 | JVM 要从类外部调用 main，必须能访问到 |
| `static` | 静态方法 | JVM 启动时还没有对象，只能直接通过类名调用：`Student.main(args)` |
| `void` | 无返回值 | 程序结束不需要返回值给 JVM |
| `String[] args` | 命令行参数 | 允许运行时传参，比如 `java Student arg1 arg2` |

### 哪些能变？

```java
// ❌ 这些都不行
static public void main(String[] args)  // public 和 static 顺序可以换，但不建议
public void main(String[] args)         // 少了 static → 找不到入口
public static int main(String[] args)   // 返回值不是 void → 不是合法入口

// ✅ 这个可以（变长参数，等价写法）
public static void main(String... args)
```

> **面试常考**：main 能写成 `String... args` 吗？——能，变长参数等价于数组。

---

## 为什么要加 `public`？

Java 有四个访问权限级别：

| 修饰符 | 本类 | 同包 | 子类 | 任何地方 |
|:---|:---|:---|:---|:---|
| `private` | ✅ | ❌ | ❌ | ❌ |
| (默认，不写) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

- **类** 加 `public`：让别的类能使用这个类
- **方法** 加 `public`：让外部能调用这个方法
- **成员变量** 一般用 `private`：不让外部直接改（封装）

如果不写 `public`，类就是"包级私有"的，同包内的类能用，包外不行。JVM 在外部加载你的类，所以 main 所在的类必须是 `public`。

---

## Java 的类体规则

类体（`{ }` 里面）**只能放声明**，不能直接写执行语句：

```java
public class Student {
    // ✅ 可以：成员变量声明
    String name;

    // ✅ 可以：构造方法声明
    public Student(String name) { ... }

    // ✅ 可以：普通方法声明
    public void study() { ... }

    // ✅ 可以：静态块（类加载时执行一次）
    static { System.out.println("类被加载了"); }

    // ❌ 不可以：裸的执行语句
    // System.out.println("hello");
    // new Student().study();
}
```

执行语句必须放在方法体 / 构造方法体 / 静态块里面。

---

## 一个文件只能有一个 public 类

- 文件名必须和 `public` 类名完全一致（包括大小写）
- 一个 `.java` 文件可以有多个非 public 类，但只能有一个 public 类

```java
// Student.java
public class Student { ... }     // ✅ 只有它是 public，和文件名匹配
class Helper { ... }             // ✅ 非 public，OK
```

---

## 对比 C++

| | C++ | Java |
|:---|:---|:---|
| 入口 | `int main()` 全局函数 | `public static void main` 必须在类里 |
| 访问控制 | 写在类体里分段 (`public:` / `private:`) | 每个成员前面单独写 |
| 文件规则 | `.h` / `.cpp` 分离，一个文件可以有多个类 | 一个文件一个 `public` 类 |
| 入口返回值 | `int`，return 0 表示正常 | `void`，不返回值 |

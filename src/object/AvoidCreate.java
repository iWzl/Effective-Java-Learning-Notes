package object;

/**
 * @program: Effective Java
 * @description: 避免创建不必要的对象
 * @author: 王志立
 * @create: 2018-12-26 09:03
 **/
public class AvoidCreate {
    //todo 避免创建不必要的对象
    /* 1. 一般来说，最好能重用的对象而不是在每次需要的时候就创建一个相同功能的对象
     * 2. 重用方式既快速，又流行。如果对象是不可变的，他就始终可以被重用
     * 3. 对于同时提供静态工厂方法和构造器的不可变类，通常可以使用静态工厂方法为不是构造器，以避免创建不必要的对象
     * 4. 构造器在每次调用的时候都会创建一个新的对象，而静态工厂则从来不要求这样做，实际上也不会这样做
     * 5. 除了重用不可变对象以外，也可以重用那些已知不会修改的可变对象。
     * 6. 创建对象的成本非常大，应该尽可能的避免创建对象
     * 7. 要优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱
     * 8. 小对象的构造器只做少量的操作，小对象的创建和回收也是非常廉价的
     * 9. 当你应当重用现有对象的时候，请不要创建新的对象
    * */

    public static void main(String[] args) {
       //autoboxing();
      string();
    }

    private static void string(){
        //在常量池中创建并创建一个引用
        String s1 = "String";
        //由于常量池中含有，所以只创建一个引用
        String s2 = "String";
        System.out.println(s1.hashCode() == s2.hashCode());
        //先在常量池中查询一个String，将常量池中的String拷贝到堆中，创建一个堆的引用
        String s3 = new String("String");
        //从s3对象中获取常量池中的对象和s1对象比较
        System.out.println(s3.intern().hashCode() == s1.hashCode());
        //从s3对象中获取堆中的对象和s1对象比较
        System.out.println(s3.hashCode() == s1.hashCode());
        //在常量池中创建对象，将对象拷贝到堆中，创建堆的引用
        String s4 = new String("new String");
        //先在常量池中查询一个String，将常量池中的String拷贝到堆中，创建一个堆的引用
        String s5 = new String("new String");
        //比较堆中的两个对象
        System.out.println(s4 == s5);
        //比较常量池的两个对象
        System.out.println(s4.intern() == s5.intern());
        //比较堆中的两个对象的哈希Code
        System.out.println(s4.hashCode() == s5.hashCode());
        //比较堆对象和常量池对象
        System.out.println(s4.intern() == s4);
        //比较堆对象和常量池对象
        System.out.println(s4.intern() == s5);
    }

    private static void autoboxing() {
        long beginTime = System.currentTimeMillis();
        //使用基本类型和包装类型的差别很大Long/long
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println("用时：" + (System.currentTimeMillis() - beginTime));
    }

}

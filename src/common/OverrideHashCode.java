package common;

/**
 * @program: Effective Java
 * @description: 覆盖hashCode
 * @author: 王志立
 * @create: 2018-12-27 14:13
 **/
public class OverrideHashCode {
    //todo 覆盖了equals后要覆盖hashCode方法
    /* 1. 一个常见的错误的根源在于没有覆盖hashCode方法，在每个覆盖了equals的方法类。都必须覆盖hashCode方法，如果不覆盖，导致该类无法结合基于散列的集合一起工作：HashMap/hashSet/hashTable等
     * 2. 在应用执行期间，只要对象的equals方法的比较操作所用到的信息没有被修改，那个同一个对象的多次调用，hashCode方法都必须一日既往的返回同一个整数。
     * 3. 两个对象根据equals(Object)方法比较是相等的，那么调用这两个对象的任何一个对象的hashCode方法必须产生同样的整数结果
     * 4. 如果两个对象根据equals(Object)比较是不相等的，那么调用这两个对象的任意一个对象的hashCode方法，则不一定要产生不同的整数结果(给不相等的对象产生截然不同的整数结果，有可能提高散列表的性能)
     * 5. 如果类及hash的运算开销大，并且这个类的也是不可变的，就可以将这个类的hash值缓存在类中，避免重复的hash值的计算。
     * 6. 不要试图从散列码计算中排除掉一个对象的关键的部分来提高性能
     **/

    private final String string;
    private final short code;

    public OverrideHashCode(String string, short code) {
        this.string = string;
        this.code = code;
    }

    @Override
    public int hashCode() {
        //简单的模拟hash运算
        int hash;
        hash = code*2+string.hashCode()*3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof OverrideHashCode)) {
            return false;
        }
        OverrideHashCode overrideHashCode = (OverrideHashCode) obj;
        return overrideHashCode.code == code && overrideHashCode.string.equals(string);
    }


    public static void main(String[] args) {
        OverrideHashCode o1 = new OverrideHashCode("Demo", (short) 1);
        OverrideHashCode o2 = new OverrideHashCode("Demo", (short) 1);
        OverrideHashCode o3 = new OverrideHashCode("Test", (short) 2);
        System.out.println("o1的hash:"+o1.hashCode());
        System.out.println("o2的hash:"+o2.hashCode());
        System.out.println("o3的hash:"+o3.hashCode());
        System.out.println("o1/o2的比较:"+o1.equals(o2));
        System.out.println("o1/o3的比较:"+o1.equals(o3));
    }
}
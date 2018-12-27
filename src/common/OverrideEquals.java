package common;

/**
 * @program: Effective Java
 * @description: 覆盖equals的通用约定
 * @author: 王志立
 * @create: 2018-12-27 10:14
 **/
public class OverrideEquals {
    //todo 覆盖equals的通用约定
    /* 1. 不该覆盖equals的情况：
     *    类的每个实例本质都是唯一的，不关心类是否提供了“逻辑相等”的测试功能。
     *    超类已经覆盖了equals，从超类继承过来的行为对于之类也是合适的。
     *    类的私有的或是包私有的，可以确定他的equals方法永远不会被调用。
     * 2. 覆盖Object.equals:
     *    类具有自己特色的“逻辑相等的概念”（不同于对象相等的概念），而且超类还没有覆盖equals以实现期望的行为。
     * 3. 覆盖equals方法的通用约定
     *     自反性：对于任何非null的引用值X和Y，X.equals(X)的值要为true
     *     对称性：对于任何非空的引用值X和Y，当且仅当Y.equals(X)返回true时，X.equals(Y)也为true
     *     传递性：
     *     一致性： 只要任何非空的引用值x和y，只要equals的比较操作在对象中所用的信息没有被修改，多次调用x.equals(Y)就会一致地返回true，或者false
     *             对于非null的引用值X，X.equals(null)的值为false
     * 4. 没有一个类是孤立的一个类的实例通常传递给另一个类的实例
     * 5. 一旦违反了约定，当其他的对象面对你的类的时候，你完全不知道这些类对象的行为会怎么样
     * 6. 无法在扩展可实例化类的同时，即增加新的值的组件，又同时保留equals约定，除非放弃面向对象的优势带来的便利。
     * 7. 高质量的equals的诀窍在于
     *      * 使用 == 操作操作符检查“参数是否为这个对象的引用”
     *      * 使用instanceof操作符检查“参数是否是正确的类型”
     *      * 把参数转换成正确的类型
     *      * 对于类中的每个关键域，检查参数的域是否与该类的域相匹配：
     *          对于既不是float也不是double类型的基本类型域，可以使用==操作符
     *          对于对象引用域，可以递归的使用equals方法
     *          对于float和double，可以适应Float.compare/Double.compare方法，对于double/float存在NaN这样的特殊值、
     *          有些引用域的null是合法的，避免出现空指针异常，常使用(filed == null?o.filed ==null:field.equals(o.filed))
     *          如果是相同对象的引用(field == o.field || (field != null && field.equals(o.field)))
     * 8. 域的比较顺序会影响equals方法的性能，为了获得最佳性能，应该最先比较最有可能不一致的域，或者开销最小的域，最理想的情况是两个情况同时满足的域
     * 9. 覆盖域的时候总要覆盖hashCode
     * 10. 不要企图让equals方法太子智能
     * 11. 不要将equals声明中的Object对象替换其他的类型
    * */

    private String x;
    private String y;

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj instanceof OverrideEquals){
            //使用getClass测试代替instanceof测试，可以扩展实例化的类和证件新的值组件，同时保留equals约定
            //只有当对象具有实现的时候才能使对象等同
            return false;
        }
        OverrideEquals overrideEquals = (OverrideEquals)obj;
        return overrideEquals.x.equals(x) && overrideEquals.y.equals(y);
    }
}

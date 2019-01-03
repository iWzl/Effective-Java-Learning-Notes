package common;

/**
 * @program: Effective Java
 * @description: 谨慎覆盖clone
 * @author: 王志立
 * @create: 2019-01-03 10:34
 **/
public class OverrideClone implements Cloneable{
    private String string = "XXX";
    //todo 谨慎覆盖Clone方法
    /* 1. CloneAble接口的目的是作为一个mixin接口(mixin interface)这样的对象允许克隆
     * 2. CloneAble接口中没有包含任何的方法，但他决定了Object对象中受保护的clone方法实现的行为
     * 3. 类实现了CloneAble Object的Clone方法就会返回该对象的逐域拷贝，否则就会抛出异常
     * 4. 通常情况下，实现接口是为了表明类可以为他的客户端做什么，对于Cloneable方法，改变了超类中保护的方法的行为
     * 5. 如果覆盖了非final类中的clone方法，则应该返回一个通过调用super.clone() 方法返回的对象
     * 6. 永远不要让客户去做任何类库能够替客户完成的事情
     * 7. clone方法就是一个构造器，，必须确保他不会伤害到原来的对象吧，并且确保要正确的创建在克隆的对象中的约束条件。
     * 8. 如构造器一样，clone方法不应该出现在构造过程中，调用新对象的中的final方法。
     * 9. 另一个实现对象拷贝的方法是提供一个对象拷贝器
     * 10. 所有实现了Cloneable 接口的方法都应该有一个公有的方法覆盖clone，此公有方法首先调用super.clone,然后修正任何需要修正的域
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        OverrideClone overrideClone = new OverrideClone();
        System.out.println(overrideClone.toString()+"--->"+overrideClone.getString());
        OverrideClone overrideClone1 = overrideClone.clone();
        System.out.println(overrideClone1.toString()+"--->"+overrideClone1.getString());
    }

    public String getString() {
        return string;
    }

    @Override
    protected OverrideClone clone() throws CloneNotSupportedException {
        return (OverrideClone)super.clone();
    }
}

package classandinterface;

/**
 * @program: Effective Java
 * @description: 使可变性最小化
 * @author: 王志立
 * @create: 2019-01-07 08:30
 **/
public class SmallestVariability {
    //todo 使可变性最小化
    /* 1. 不可变类只是其实例不可被修改的类。每个实例的创建信息都必须在创建该实例的时候提供，并在整个生命周期内固定不变。
     * 2. 不要提供任何会修改对象状态的方法(mutator)
     * 3. 保证类不会被拓展。这样可以防止粗心或者恶意的子类假装对象状态已经改变，从而破坏该类的不仅可变行为。
     * 4. 使所类的域都是final的。通过系统的强制方式，清楚表明意图。
     * 5. 使所有的域都是成为私有：防止客户端获得访问域被引用的可变对象的权限，并防止客户端直接修改这些对象的值。
     * 6. 确保任何可变组件的互斥访问：如果类具有指向可变对象的域，则必须确保该类的客户端无法取得指向这些对象的引用
     *  ****************************************************************************************
     * 7. 不可变对象的本质上是安全的，他们不要求同步，可以被自由共享
     * 8. 不可变类可以提供一些静态工厂，把频繁被请求的实例缓存起来，当现在实例可以符合请求的时候，就不必要创建新的实例。
     * 9. 不可变对象可以被自由的共享：永远不要进行保护性拷贝，这些拷贝始终等于原始的对象，也不应该对不可变类提供clone方法，或是拷贝构造器
     * 10. 不仅可以共享不可变类甚至可以共享他们的内部信息
     * 11. 不可变类为其他的对象提供了大量的构建，无论是可变的，还是不可变的对象。如果知道一个复杂的对象内部的组件对象不会改变，要维护他的不可变行的约束也是比较容易的。
     * 12. 不可变类的唯一缺点是，对于每个不同的值都需要一个单独的对象。
     * 13. 坚决不要为每个get方法编写一个相应的set方法。除非有很好的理由让类称为不可变的类，否则就应该是不可变的。
     * 14. 对于一些类而言，其不可变性是不切实际的。如果类做成是不可变的，也应该尽可能的限制他的可能性。除非有令人信服的理由要使域变成是非final的，否则要使每个域都是final的
     * 15. 构造器应该创建完全初始化的对象，并建立起所有的约束关系。不要在构造器或者静态工厂之外提供公有的初始化方法，除非有令人信服的理由必须这样做。
    * */

    private final double re;
    private final double im;

    public SmallestVariability(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public SmallestVariability add(SmallestVariability c){
        return new SmallestVariability(re+c.re,im+c.im);
    }
    public SmallestVariability subtract(SmallestVariability c){
        return new SmallestVariability(re-c.re,im-c.im);
    }
    public SmallestVariability multiply(SmallestVariability c){
        double tmp = c.re*c.re + c.im*c.im;
        return new SmallestVariability((re*c.re-im*c.im)/tmp,(im*c.re+re * c.im)/tmp);
    }
    public SmallestVariability divide(SmallestVariability c){
        double tmp = c.re*c.re + c.im*c.im;
        return new SmallestVariability((re*c.re+im*c.im)/tmp,(im*c.re-re * c.im)/tmp);
    }

    @Override
    public int hashCode() {
        int result = 17 + Double.hashCode(re);
        result  = 31 * result + Double.hashCode(im);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof SmallestVariability)){
            return false;
        }
        SmallestVariability smallestVariability = (SmallestVariability)obj;
        return Double.compare(smallestVariability.im,im)==0&&Double.compare(smallestVariability.re,re)==0;
    }

    @Override
    public String toString() {
        return "SmallestVariability{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }

    public static void main(String[] args) {

    }
}

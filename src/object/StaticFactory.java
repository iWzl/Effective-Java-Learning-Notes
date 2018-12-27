package object;

/**
 * @program: Effective Java
 * @description: 考虑使用静态工厂方法代替构造器
 * @author: 王志立
 * @create: 2018-12-25 14:30
 **/
 public class StaticFactory {
    private static volatile StaticFactory staticFactory;
    private StaticFactory(){
        //构造器隐藏，适应静态工厂创建实例
        if(staticFactory != null){
            throw new AssertionError();
        }
    }
    public static StaticFactory getInstance(){
        //todo 考虑使用静态工厂方法代替构造器
        /* 第一大优势在于，有名称：如果构造其没有确切地描述正在返回的对象，那么使用静态工厂会更容易使用，产生的客户端代码也更容易阅读，当一个类需要多个带有相同的签名的构造器时，就使用静态工厂方法代替构造器，并且慎重地选择名称以便于突出他们之间的区别
         * 第二大优势在于，不必再每次调用他们的时候都创建一个新的实例：这使得可以使用预先构建好的实例，或者将构建的好实例缓存起来，进行重复利用，避免创建不必要的重复对象
         * 第三大优势在于，他们可以返回原类型的任何子类型对象，同时又不会使对象的类变成公有的。要求客户端通过接口来引用被返回的对象，而不是通过它的实现类来引用别返回的对象
         * 第四大优势在于，他们在创建参数化的实例对象的时候，他们使代码变得更将简洁
         * 缺点在余，类如果不含公有的或者受保护的构造器，就不能被之类实例化，他们对于其他的静态方法实际上没有任何区别。
         * 静态方法常用的名称：
         * valueOf/of：类型转换方法
         * getInstance 通过方法的参数返回实例（对于Singleton来说，该方法没有参数，返回单例）
         * newInstance 通过方法的参数创建新的实例
         * getType 工厂方法返回的对象类型
         * newType 跟newInstance类似，返回对象的类型
         * 在选择对象时间，切记第一反应就是创建公有构造类，而不先考虑静态工厂（非设计模式的静态工厂）
         */
        if(staticFactory ==null){
            //实现简单单例的创建
            staticFactory = new StaticFactory();
        }
        System.out.println("创建实例");
        return staticFactory;
    }

    public static void main(String[] args) {
        StaticFactory.getInstance();
    }

}


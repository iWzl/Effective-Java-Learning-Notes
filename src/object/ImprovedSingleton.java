package object;

/**
 * @program: Effective Java
 * @description: 强化Singleton属性
 * @author: 王志立
 * @create: 2018-12-25 18:53
 **/
public enum ImprovedSingleton {
    //todo 用私有构造器或者枚举类型强化Singleton属性
    /* 1. Singleton通常被用来代表那些性质上唯一的系统组件，使类成为Singleton会使他的客户端测试变得十分困难，因此无法给Singleton替换模拟实现
     * 2. 公有静态成员是个final域，保证了全局唯一性，一旦类被实例化，只会有一个实例对象，不多也不少。客户端的任何行为都不会改变这一点
     * 3. 公有的成员是个静态工厂方法，提供了灵活性，在不改变API的前提下，可以改变该类是否应该是Singleton的想法，工厂方法返回的是唯一的实例，但是他很容易被修改（每调用该方法的线程返回唯一一个实例）
     * 4. 但以上的两者对于享有特殊权限的客户端借助AccessibleObject.srtAccessible方法，调用私有构造器只能修改构造器，要求在创建第二个实例的时候抛出异常来进行防御
     * 5. 为了维护并保证Singleton，必须声明所有的实例域都是瞬时的，并提供一个readResolve方法。否则每次反序列化一个序列化实例时，都会创建一个新的实例。
     * 6. 从Java1.5发行版本开始，实现singleton还有第三种方法：编写一个包含单个元素的枚举类型，这种方法在功能上与公有域的=方法相近，但他更加整洁，无偿提供了序列化机制，绝对防止多次实例化，即使在面对复杂的序列化或者反射攻击的时候。
     * 7. 单元素的枚举类型已经成为实现singleton的最佳方法。
    **/

    INSTANCE;
    public void leaveTheBuilding(){
        System.out.println("单元素的枚举类型实现单例");
    }

    public static void main(String[] args) {
        ImprovedSingleton.INSTANCE.leaveTheBuilding();
    }
}

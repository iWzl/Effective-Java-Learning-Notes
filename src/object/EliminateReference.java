package object;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @program: Effective Java
 * @description: 消除过期的对象引用
 * @author: 王志立
 * @create: 2018-12-26 11:13
 **/
public class EliminateReference {
    //todo 消除过期的对象引用，避免出现内存泄露
    /* 1. 如下栈维护着对象的过期引用，永远都不会得到解除，凡是获取size意以外的元素都是过期的
     * 2. 在支持垃圾回收的语言中，内存泄漏是很隐蔽的（无意识的对象保存），如果一个引用被无意识的对象保存，垃圾回收机制不会处理这个所引用的对象，也不会处理这个对象所引用的其他对象
     * 3. 处理方式可以是这个对象过期，就将这个对象清空他的引用。
     * 4. 只要类是自己管理内存，程序员就应该警惕内存泄漏的情况
     * 5. 内存泄漏的另一个来源是缓存，一旦把内存放在缓存中，他就更容易被遗忘掉
     * 6. 第三个来源是监听器和其他回调，如果实现了一个api，客户端在这个APi中注册回调，却没有显示的取消注册除非采取动作，否则就会积聚，对此应该保存他们的弱引用。
     */
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public EliminateReference(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size ==0){
            throw new EmptyStackException();
        }
        return elements[--size];
        /*
        * Object result = elements[--size]
        * element[size] = null  //清空这个对象的引用
        * return result
        * */
    }

    private void ensureCapacity() {
        if(elements.length ==size){
            elements = Arrays.copyOf(elements,2*size+1);
        }
    }
}

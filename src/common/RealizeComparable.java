package common;

/**
 * @program: Effective Java
 * @description: 实现Comparable接口
 * @author: 王志立
 * @create: 2019-01-03 14:30
 **/
public class RealizeComparable {
    //todo 考虑实现Comparable接口
    /* 1. compareTo方法并没有在Object对象中声明。他是Comparable中的唯一的方法，不但允许进行简单的等同性比较，而且允许执行顺序比较。
     * 2. 一旦类实现了Comparable接口，就表明他们的内在排列关系，可以跟许多泛型算法以及依赖与该接口的集合实现进行协助。
     * 3. CompareTo方法的通用约定跟equal方法的相似
     */

    public static void main(String[] args) {

    }
}

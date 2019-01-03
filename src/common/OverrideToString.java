package common;

import java.util.Date;

/**
 * @program: Effective Java
 * @description: 始终要覆盖同toString方法
 * @author: 王志立
 * @create: 2019-01-03 09:53
 **/
public class OverrideToString {
    //todo 始终要覆盖toString方法
    /* 1. java.lang.Object中toString方法包含类的名称'@'符号散列表的无符号16进制表示法
     * 2. toString 返回的字符串应该是一个‘简洁但信息内容丰富并且易与表达的形式‘ 建议所有的子类都覆盖这个方法
     * 3. 遵守toString约定没有hashCode的那样重要，但是可以使类的使用更加舒适
     * 4. 在实际运用中，ToString应该返回对象包含的所有值得关注的信息
     * 5. 无论ToString中是否指定了格式，在文档中都应该明确表明你的意图
     * 6. 无论是否指定返回格式，都为toString返回值中包含的所有信息，提供一种编程式的访问途径。
     */

    public static void main(String[] args) {
        System.out.println(new OverrideToString().toString());
    }


    /**
     * 返回地区标准的当前时间的符串
     * 格式对象系统的时间格式标准
     * 星期X X月 XX XX:XX:XX CST XXX
     * 字符串一行显示
     */
    @Override
    public String toString() {
        return String.format("%tc",new Date());
    }
}

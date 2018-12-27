package object;

/**
 * @program: Effective Java
 * @description: 多个构造器
 * @author: 王志立
 * @create: 2018-12-25 18:47
 **/
public class MultipleTectonic {
    private final String name;
    private final String age;
    private final String email;
    private final String tel;

    private MultipleTectonic(MultipleTectonic.Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.tel = builder.tel;
    }

    public static class Builder{
        //todo 当遇到多个构造器参数时，要考虑使用构造器。
        /* 静态工厂和构造器有个共同的局限性：他们都不能很好的拓展到大量的可选参数。
         * 1. 使用重叠构造器模式，安全
         * 2. 使用JavaBeans，有很好的额可读性
         * 3. 使用Builder的模式创建
         * 4. 如果类的构造器或者静态工厂中有多个参数，设计这种类时，Builder模式就是不错的选择
         * 5. 与传统的构造器相比，使用builder模式的客户端将更易阅读和编写，构造器也比JavaBeans 更加安全。
         */

        private final String name;
        private String age;
        private String email;
        private String tel;
        private Builder(String name){
            this.name = name;
        }
        Builder email(String email){
            this.email = email;
            return this;
        }
        Builder age(String age){
            this.age = age;
            return this;
        }
        Builder tel(String tel){
            this.tel = tel;
            return this;
        }
        MultipleTectonic build(){
            return new MultipleTectonic(this);
        }
    }
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
    public static void main(String[] args) {
        MultipleTectonic multipleTectonic= new Builder("name")
                .age("12")
                .email("XXXX@XX.XX")
                .tel("123456789")
                .build();
        System.out.println(multipleTectonic);
    }
}

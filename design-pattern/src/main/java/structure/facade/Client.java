package structure.facade;


/**
 * TODO 门面模式
 * 为子系统中的一组接口提供一个一致的接口，门面模式定义了一个高层接口，这个即可使得这一子系统更加容易使用
 * 主要用于简化客户端调用，将所有内部调用封装起来对外暴露一个统一的入口
 *
 * @author Mr.He
 * 2023/2/25 18:47
 * e-mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name mrhe
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.func();
    }
}

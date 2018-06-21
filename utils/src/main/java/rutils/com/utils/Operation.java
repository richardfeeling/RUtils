package rutils.com.utils;

/**
 * 请求发出之前和成功之后的调用接口
 */
public interface Operation {

    /**
     * 请求发出之前调用, 主要用来显示 自定义Loading. 也可以用来做数据预处理.
     */
    void preOp();

    /**
     * 请求数据返回之后调用, 主要用来关闭 自定义Loading. 也可以用来做数据处理.
     * 若用来关闭Loading, 请确定此方法的调用发生在主线程里.
     */
    void endOp();

}

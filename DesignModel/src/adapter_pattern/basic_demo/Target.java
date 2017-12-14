package adapter_pattern.basic_demo;

/**
 * Created by cmr on 2017/12/14.
 * 适配器模式：又称变压器模式或包装模式
 * 将一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配
 * 而无法在一起工作的两个类能够在一起工作
 * Target 期望接口
 */
public interface Target {
    //目标角色有自己的方法
    void request();
}

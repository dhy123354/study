package 工厂模式;

public class 工厂方法模式 {
    public static void main(String[] args) {
        Factory1 factory = new FactoryA();
        factory.createProduct();
        factory = new FactoryB();
        factory.createProduct();
    }
}

interface Product1{}
interface Factory1{
    //声明产生产品类的方法
    public Product1 createProduct();
}

class ProductA1 implements Product1{
    public ProductA1(){
        System.out.println("ProductA1");
    }
}

class ProductB1 implements Product1{
    public ProductB1(){
        System.out.println("ProductB1");
    }
}

class FactoryA implements Factory1{
    //实现工厂类的方法生成产品类A
    @Override
    public Product1 createProduct() {
        return new ProductA1();
    }
}

class FactoryB implements Factory1{
    //实现工厂类的方法生成产品类B
    @Override
    public Product1 createProduct() {
        return new ProductB1();
    }
}

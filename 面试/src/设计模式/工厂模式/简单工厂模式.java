package 工厂模式;

public class 简单工厂模式 {
    public static void main(String[] args) {
        Factory.create("ProductA");
        Factory.create("ProductB");
    }
}
interface Product{
    //声明所需继承的共同接口，也可以是抽象类
}

class ProductA implements Product{
    public  ProductA(){
        System.out.println("ProductA");
    }
}

class ProductB implements Product{
    public  ProductB(){
        System.out.println("ProductB");
    }
}

class Factory{
    public static Product create(String str){
        //生成productA
        if (str.equalsIgnoreCase("ProductA")){
            return new ProductA();
        }else {
            //生成ProductB
            if(str.equalsIgnoreCase("ProductB"))
            {
                return new ProductB();
            }
            return null;
        }
    }
}


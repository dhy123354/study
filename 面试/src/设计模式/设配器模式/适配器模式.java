package 设配器模式;

public class 适配器模式 {
    public static void main(String[] args) {
        SmallPort smallPort = new SmallPort() {
            @Override
            public void userSmallPort() {
                System.out.println("使用的是手机的接口");
            }
        };
        //需要一个大的接口才可以连上电脑，小口转化为大口
        BigPort bigPort = new SmallToBig(smallPort);
        bigPort.userBigPort();
    }
}

interface BigPort{
    public void userBigPort();//使用的大口
}

interface SmallPort{
    public void userSmallPort();//使用小口
}

class SmallToBig implements BigPort{

    private SmallPort smallPort;//小口

    public SmallToBig(SmallPort smallPort){
        this.smallPort=smallPort;
    }
    @Override
    public void userBigPort() {
        this.smallPort.userSmallPort();
    }
}

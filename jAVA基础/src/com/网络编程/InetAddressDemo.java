package com.网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("192.168.1.66");

        String name = address.getHostName();

        String ip = address.getHostAddress();

        System.out.println("主机名" + name);
        System.out.println("IP地址" + ip);
    }
}

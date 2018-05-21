package com.ziroom.iot;

public class Test {

    public static void main(String[] args) {
        byte byte0=0;
        byte byte1=0x7a;

        int length= (byte0<<8 & 0xFF00) +(byte1 & 0xFF);

        System.out.printf("length "+length);
    }
}

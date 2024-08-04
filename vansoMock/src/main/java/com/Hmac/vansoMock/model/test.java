package com.Hmac.vansoMock.model;

public class test {
    public static Integer tu (int a, int b){
        try{
            return a/b;
        }finally {
            System.out.println("finay");
        }
    }

    public static void main(String[] args) {
        try{
            test.tu(10,0);
        }catch(Exception e){
            System.out.println("exce");
        }
    }
}


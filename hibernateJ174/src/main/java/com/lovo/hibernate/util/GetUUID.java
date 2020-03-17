package com.lovo.hibernate.util;

import java.util.UUID;

public class GetUUID {
    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            //获得一个UUID
            String str = UUID.randomUUID().toString();
          str=  str.replaceAll("-","");
            System.out.println(str);
        }
    }
}

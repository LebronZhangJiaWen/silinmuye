package com.muyenet.muye.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhangjiawen on 2017/12/13.
 */
public class GetPropertiesUtil {
    public Properties getProp() {
        return prop;
    }

    private Properties prop ;


   public  GetPropertiesUtil(){
       InputStream in =  GetPropertiesUtil.class.getClassLoader().getResourceAsStream("muye.properties");
      // FileInputStream in2 = new FileInputStream("muye.properties");
       this.prop = new Properties();
       try {
           prop.load(in);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}

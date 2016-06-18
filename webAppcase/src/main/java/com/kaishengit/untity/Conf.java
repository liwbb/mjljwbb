package com.kaishengit.untity;



import com.kaishengit.exception.DataAccessException;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取etc下的config.properties文件
 * @author Administrator
 */

public class Conf {
    private static Properties properties=new Properties();
    static{
        try {
            properties.load(Conf.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new DataAccessException("读取配置文件失败",e);
        }

    }
    public static String get(String key){
        return properties.getProperty(key);

    }
    public static String get(String key,String defaultValue){
        return properties.getProperty(key,defaultValue);

    }
}

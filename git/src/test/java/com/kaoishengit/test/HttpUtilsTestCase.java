package com.kaoishengit.test;

import com.kaishengit.Util.HttpUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class HttpUtilsTestCase {
    private Logger logger= LoggerFactory.getLogger(HttpUtilsTestCase.class);
    @Test
    public void HttpUtilTest(){
       String name= HttpUtil.getResquestText("http://blog.sina.com.cn/rss/1220218113.xml");
        logger.debug("name{}"+name);

    }
}

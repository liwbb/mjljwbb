package com.kashengit.test;

import com.kashengit.untity.EmailUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestEmailUtil {


    @Test
    public void testEamilUtilCase(){
        Logger logger= LoggerFactory.getLogger(TestEmailUtil.class);
        EmailUtil.sendEmail("zhuxiaoxue0104@126.com","我在办公室等你","带上资料过来");
    }
}

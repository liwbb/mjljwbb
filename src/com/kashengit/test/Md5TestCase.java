package com.kashengit.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Md5TestCase {
    @Test
    public void testMd5(){
        Logger logger= LoggerFactory.getLogger(Md5TestCase.class);
        String str="ssss";
        //8f60c8102d29fcd525162d02eed4566b
        //891a096317bbb4c0f59600ff233fe79c
        String salt="#$%$^%&%&^";
        String md5= DigestUtils.md5Hex(str+salt);
        logger.info(md5);
        //2e62702e3ef34511483f7806dc8471b423880a61
        //11416a750500773efc3148af9915fe30d827e3bb2ad75312c2459c35b27b99b3a225ffe19777619b408af25aff258e0f60c7239f7b709632110f4210529b6870
        String sha1=DigestUtils.sha512Hex(str+salt);
        logger.info("秘聞是{}",sha1);
    }




}

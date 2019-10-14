package com.mankan.plumad.test;

import com.alibaba.fastjson.JSON;
import com.mankan.plumad.ConsumerBootstrap;
import com.mankan.plumad.util.IpInfoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: youtiao
 * @create: 2019-10-14 12:58
 * @description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerBootstrap.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IpInfoUtilTest {

    @Autowired
    private IpInfoUtil ipInfoUtil;

    @Test
    public void test() {
        System.out.println(ipInfoUtil.getIpInfo("60.12.218.81"));
    }

}

package com.womai.platform;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml",
        "classpath:applicationContext-provider.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GeneralSpringTest extends AbstractJUnit4SpringContextTests {
}

package com.transition;



import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.transaction.service.AccountService;
/**
 * 编程式事务测试
 * @author zlq
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class SpringTransitionTest {
	
	private static Logger logger = Logger.getLogger(SpringTransitionTest.class);

	@Autowired
	AccountService accountService;
	
	@Test
	public void transferable(){
		accountService.transfer("aaa", "bbb", 200d);
		logger.info("test over...");
	}
}

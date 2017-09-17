package com.transition;



import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.transaction2.service.AccountService;
/**
 * 声明式事务
 * @author zlq
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis2.xml")
public class SpringTransitionTest2 {
	
	private static Logger logger = Logger.getLogger(SpringTransitionTest2.class);

	@Autowired
	AccountService accountService;
	
	@Test
	public void transferable(){
		accountService.transfer("aaa", "bbb", 200d);
		logger.info("test over...");
	}
}

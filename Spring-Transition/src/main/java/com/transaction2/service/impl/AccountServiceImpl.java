package com.transaction2.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction2.dao.AccountDao;
import com.transaction2.service.AccountService;
/**
 * 采用的声明式事务，注解方式
 * @author zlq
 * propagation	:事务的传播行为
 * isolation	:事务的隔离级别
 * readOnle		:只读信息
 * rollBack-for	：发送哪些异常回滚
 * noRollbackFor:发送哪些异常不回滚
 */
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
public class AccountServiceImpl implements AccountService {

	@Resource
	AccountDao accountDao;


	public void transfer(String out, String in, double money) {

		accountDao.reduceAccount(out, money);
		 int a = 1/0;
		accountDao.addAccount(in, money);

	}

}

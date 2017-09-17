package com.transaction.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.transaction.dao.AccountDao;
import com.transaction.service.AccountService;
/**
 * 编程式事务
 * @author zlq
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	@Resource
	AccountDao accountDao;
	
	//注入事务管理模版
	@Autowired
	private TransactionTemplate template;
	
	public void transfer(String out, String in, double money) {
		template.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				accountDao.reduceAccount(out, money);
				//int a = 1/0;
				accountDao.addAccount(in, money);
			}
		});
		
	}

}

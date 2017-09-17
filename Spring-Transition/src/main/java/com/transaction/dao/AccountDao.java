package com.transaction.dao;

public interface AccountDao {

	/**
	 * 存钱
	 * @param accout ：账户
	 * @param money  ：金额
	 */
	public void addAccount(String name, double money);

	/**
	 * 取钱
	 * @param accout ：账户
	 * @param money  ：金额
	 */
	public void reduceAccount(String name, double money);
}

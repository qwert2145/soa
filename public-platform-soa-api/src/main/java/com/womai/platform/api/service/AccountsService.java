package com.womai.platform.api.service;


import com.womai.platform.api.model.AccountsApi;

import java.util.HashMap;
import java.util.List;

public interface AccountsService {
	void deleteById(int id);
	int insertAccounts(AccountsApi record);
	AccountsApi selectById(int id);
	int updateAccounts(AccountsApi record);
	List<AccountsApi> selectList();
	List<Integer> selectIds();
	List<AccountsApi> selectListByPage(HashMap<String, Integer> offsetLimit);
	int getCount();
}

package com.womai.platform.service.impl;

import com.womai.platform.api.model.AccountsApi;
import com.womai.platform.api.service.AccountsService;
import com.womai.platform.dao.mapper.AccountsMapper;
import com.womai.platform.dao.model.Accounts;
import com.womai.platform.service.utils.DomainUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wlb on 2015/10/21.
 */
public class AccountsServiceImpl implements AccountsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountsServiceImpl.class);
    private AccountsMapper accountsMapper;

    public AccountsMapper getAccountsMapper() {
        return accountsMapper;
    }

    public void setAccountsMapper(AccountsMapper accountsMapper) {
        this.accountsMapper = accountsMapper;
    }

    @Override
    public void deleteById(int id) {
        accountsMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insertAccounts(AccountsApi record) {
        Accounts accounts = new Accounts();
        try {
            new DomainUtil().copy(record, accounts);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        accountsMapper.insert(accounts);
        return 0;
    }

    @Override
    public AccountsApi selectById(int id) {
        Accounts accounts = accountsMapper.selectByPrimaryKey(id);
        AccountsApi accountsApi = new AccountsApi();
        try {
            new DomainUtil().copy(accounts, accountsApi);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return accountsApi;
    }

    @Override
    public int updateAccounts(AccountsApi record) {
        Accounts accounts = new Accounts();
        try {
            new DomainUtil().copy(record, accounts);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        accountsMapper.updateByPrimaryKey(accounts);
        return 0;
    }

    @Override
    public List<AccountsApi> selectList() {
        List<Accounts> accountsList =  accountsMapper.selectList();
        List<AccountsApi> accountsApis = new ArrayList<AccountsApi>();
        for (int i = 0; i < accountsList.size(); i++) {
            AccountsApi accountsApi = new AccountsApi();
            try {
                new DomainUtil().copy(accountsList.get(i), accountsApi);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
            accountsApis.add(accountsApi);
        }
        return accountsApis;
    }

    @Override
    public List<Integer> selectIds() {
        return accountsMapper.selectIds();
    }

    @Override
    public List<AccountsApi> selectListByPage(HashMap<String, Integer> offsetLimit) {
        List<Accounts> accountsList = accountsMapper.selectListByPage(offsetLimit);
        List<AccountsApi> accountsApis = new ArrayList<AccountsApi>();
        for (int i = 0; i < accountsList.size(); i++) {
            AccountsApi accountsApi = new AccountsApi();
            try {
                new DomainUtil().copy(accountsList.get(i), accountsApi);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
            accountsApis.add(accountsApi);
        }
        return accountsApis;
    }

    @Override
    public int getCount() {
        return accountsMapper.getCount();
    }
}

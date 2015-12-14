package com.womai.platform;

import com.womai.platform.api.model.AccountsApi;
import com.womai.platform.api.service.AccountsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AccountsServiceTest extends GeneralSpringTest {
    @Autowired
    AccountsService accountsService;

    @Test
    public void selectTest() {
        AccountsApi accountsApi = accountsService.selectById(1);
        System.out.println(accountsApi.getId() + " ++++");
    }

    @Test
    public void insertTest() {
        AccountsApi accountsApi = new AccountsApi();
        accountsApi.setAccountName("account1");
        accountsApi.setAccountType(1);
        accountsApi.setAppid("appid1");
        accountsApi.setAppsecert("secret1");
        accountsApi.setCreatedAt(new Date());
        accountsApi.setId(1);
        accountsApi.setIsvoid(1);
        accountsApi.setSourceId("source1");
        accountsService.insertAccounts(accountsApi);
    }

    @Test
    public void deleteTest() {
        accountsService.deleteById(1);
        accountsService.selectById(1);
    }

    @Test
    public void selectListTest() {
        List<AccountsApi> accountsApis = accountsService.selectList();
        for (AccountsApi accountsApi : accountsApis) {
            System.out.println(accountsApi.getAccountName());
        }
    }
}

package com.womai.platform;

import com.womai.platform.dao.mapper.AccountsMapper;
import com.womai.platform.dao.model.Accounts;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AccountsTest extends GeneralSpringTest {

    @Autowired
    private AccountsMapper accountsMapper;

    @Test
    public void insertTest() {
        Accounts accounts = new Accounts();
        accounts.setAccountName("account1");
        accounts.setAccountType(1);
        accounts.setAppid("appid1");
        accounts.setAppsecert("secret1");
        accounts.setCreatedAt(new Date());
        accounts.setId(1);
        accounts.setIsvoid(1);
        accounts.setSourceId("source1");
        int count = accountsMapper.insert(accounts);
        System.out.println(count + " =================");
    }

    @Test
    public void selectByIdTest() {
        Accounts accounts = accountsMapper.selectByPrimaryKey(1);
        System.out.println(accounts.getAccountName() + "++++++++++");
        System.out.println("======================");
        Accounts accounts1 = accountsMapper.selectByPrimaryKey(1);
        System.out.println(accounts1.getAccountName() + "+++++++++++");
    }

    @Test
    public void selectList() {
        List<Accounts> accountsList = accountsMapper.selectList();
        for (Accounts accounts : accountsList) {
            System.out.println(accounts.getAccountName() + "++++++++++");
        }
    }

    @Test
    public void selectIds() {
        List<Integer> ids = accountsMapper.selectIds();
        for (Integer id : ids) {
            System.out.println(id + "++++++++++");
        }
    }

	@Test
	public void selectListByPageTest() {
		HashMap<String, Integer> pamamMap = new HashMap<String, Integer>();
		pamamMap.put("offset", 1);
		pamamMap.put("limit", 2);
		List<Accounts> accountsList = accountsMapper.selectListByPage(pamamMap);
		for (int i = 0; i < accountsList.size(); i++) {
			System.out.println(accountsList.get(i).getAccountName());
		}
	}
}

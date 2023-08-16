package com.cyy.cyyinterface;

import com.cyy.cyyclientsdk.client.cyyClient;
import com.cyy.cyyclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CyyInterfaceApplicationTests {

	@Resource
	private cyyClient cclient;
	@Test
	void contextLoads() {
		String res1 = cclient.getname01("ccc");
		User user = new User();
		user.setUserName("ccc2");
		String res2 = cclient.getname03(user);
		System.out.println(res1);
		System.out.println(res2);
	}

}

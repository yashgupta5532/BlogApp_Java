package com.codewithyash.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithyash.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest(){
		String className=userRepo.getClass().getName();
		String packageName=userRepo.getClass().getPackageName();
		System.out.println(className + "/n" + packageName);
	}

}

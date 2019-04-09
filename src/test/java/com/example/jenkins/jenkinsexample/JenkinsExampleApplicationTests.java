package com.example.jenkins.jenkinsexample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JenkinsExampleApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void runningTests() {
		//TODO
		Assert.assertEquals("1", "1");
	}

}

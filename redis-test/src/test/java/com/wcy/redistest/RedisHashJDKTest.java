package com.wcy.redistest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wangchengyang.domain.Employee;
import com.wangchengyang.utils.RandomUitl;
import com.wangchengyang.utils.StringUtil;

//注入spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//引入spring-beans.xml文件
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class RedisHashJDKTest {
	//测试json的存储方法
	@Resource
	//引入redis模板
	private RedisTemplate<String,Serializable> redisTemplate;
	@Test
	public void insert_test() {
		//for循环1000000条
		Map<String,Employee> employees=new HashMap<>();
		for (int i = 1; i < 100000; i++) {
			employees.put("e_"+i, new Employee(i, StringUtil.generateChineseName()+StringUtil.randomChineseString(2),"13"+RandomUitl.randomString(9),StringUtil.randomChineseString(10),StringUtil.generateChinesesex()+
					StringUtil.randomChineseString(1),StringUtil.generateChineseemail()+StringUtil.randomChineseString(13)));
					
		}
		//设置开始的时间
		long startTimes = System.currentTimeMillis();
		redisTemplate.opsForHash().putAll("e_keys", employees);
		long endTimes = System.currentTimeMillis();
		//计算出存储的时间
		System.out.println("采用hash,JDK存储序列化的时间是:"+(endTimes-startTimes));
		
	}

}

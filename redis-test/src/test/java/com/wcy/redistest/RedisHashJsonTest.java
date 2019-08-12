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
//引入spring-beans.xml2文件
@ContextConfiguration(locations="classpath:spring-beans2.xml")
public class RedisHashJsonTest {
	//测试json的存储方法
@Resource
//引入redis模板
private RedisTemplate<String,Serializable> redisTemplate;
@Test
public void test_insert() {
	Map<String, Employee> employees=new HashMap<>();
	//for循环1000000条
	for (int i = 1; i < 100000; i++) {
		employees.put("e_"+i, new Employee(i,StringUtil.generateChineseName()+StringUtil.randomChineseString(2),
				"13"+RandomUitl.randomString(9),StringUtil.randomChineseString(10),StringUtil.generateChinesesex()+
				StringUtil.randomChineseString(1),StringUtil.generateChineseemail()+StringUtil.randomChineseString(13)));
	}
	//设置开始的时间
	long startTimes = System.currentTimeMillis();
	redisTemplate.opsForHash().putAll("e_json_keys", employees);
	//设置结束时间
	long endTimes = System.currentTimeMillis();
	//计算出存储的时间
	System.out.println("采用hash,json的方法存储序列化的时间是:"+(endTimes-startTimes));
}
}

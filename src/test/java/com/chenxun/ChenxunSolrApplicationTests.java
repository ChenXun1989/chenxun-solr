package com.chenxun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chenxun.solr.model.Product;
import com.chenxun.solr.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChenxunSolrApplicationTests {
	
	@Autowired
	private ProductRepository productRepository;

	@Test
	public void contextLoads() {
		productRepository.deleteAll();
		long count=productRepository.count();
		Assert.assertTrue("empty count", count==0);
		Product product=new Product();
		product.setId("product-001");
		product.setName("xxx");
		Map<String,String> map=new HashMap<>();
		map.put("key01", "abc");
		map.put("key02", "123");
		product.setMap(map);	
		productRepository.save(product);
		
		Product product1=new Product();
		product1.setId("product-002");	
		product1.setName("yyy");
		Map<String,String> map1=new HashMap<>();
		map1.put("key01", "abc1");
		map1.put("key02", "1234");
		product1.setMap(map1);		
		productRepository.save(product1);
		
		count=productRepository.count();
		Assert.assertTrue(count==2);
		
		
		Iterator<Product> it=productRepository.findByName("yyy").iterator();
		while(it.hasNext()){
			Assert.assertTrue( it.next().getId().equals("product-002"));
		}
		
		
		
	}

}

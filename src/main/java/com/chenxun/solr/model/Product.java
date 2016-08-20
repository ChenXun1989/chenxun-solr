/**
 * Project Name:chenxun-solr
 * File Name:Product.java
 * Package Name:com.chenxun.solr.model
 * Date:2016年8月20日下午4:48:36
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.solr.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Dynamic;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.stereotype.Component;

/**
 * ClassName:Product <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月20日 下午4:48:36 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@SolrDocument(solrCoreName="example") // Solr collection name
@Data
public class Product {
	
	  @Field("id")                  // Specify field name in solr
      @Id  
	  private String id;
	
	  @Field
	  private float price;
	  
	  @Field
	  private String name;
	  
	  @Field("*_s")
	  @Dynamic
	  private Map<String,String> map =new HashMap<String, String>();


	 

	

	}


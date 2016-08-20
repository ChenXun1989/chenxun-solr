/**
 * Project Name:chenxun-solr
 * File Name:ProductRepository.java
 * Package Name:com.chenxun.solr.repository
 * Date:2016年8月20日下午4:54:24
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.solr.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.chenxun.solr.model.Product;

/**
 * ClassName:ProductRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月20日 下午4:54:24 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface ProductRepository  extends SolrCrudRepository<Product, String>{
	
	
	Iterable<Product>  findByName(String name);
	
	
	 
	 

}


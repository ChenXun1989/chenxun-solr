/**
 * Project Name:chenxun-solr
 * File Name:SolrConfig.java
 * Package Name:com.chenxun.solr.config
 * Date:2016年8月20日下午3:11:32
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.chenxun.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.convert.CustomConversions;
import org.springframework.data.solr.core.convert.MappingSolrConverter;
import org.springframework.data.solr.core.convert.SolrConverter;
import org.springframework.data.solr.core.mapping.SimpleSolrMappingContext;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * ClassName:SolrConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月20日 下午3:11:32 <br/>
 * 
 * @author 陈勋
 * @version
 * @since JDK 1.7
 * @see
 */
@Configuration
@EnableSolrRepositories(basePackages = { "com.chenxun.solr" }, multicoreSupport = true)
public class SolrConfig {

	@Value("${spring.data.solr.zk-host}")
	private String zkHost;

	@Bean
	public SolrClient solrClient() {
		return new CloudSolrClient(zkHost);
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient solrClient,SolrConverter solrConverter) throws Exception {
		SolrTemplate solrTemplate =  new SolrTemplate(solrClient);
		solrTemplate.setSolrConverter(solrConverter);
		return solrTemplate;
	}
	
	@Bean
	public SolrConverter solrConverter(SimpleSolrMappingContext simpleSolrMappingContext,CustomConversions customConversions){
		MappingSolrConverter solrConverter=new MappingSolrConverter(simpleSolrMappingContext);
		solrConverter.setCustomConversions(customConversions);		
		return solrConverter;
		
	}
	
	@Bean
	public SimpleSolrMappingContext simpleSolrMappingContext(){
		SimpleSolrMappingContext simpleSolrMappingContext=new SimpleSolrMappingContext();
		return simpleSolrMappingContext;
	}
	
	@Bean
	public CustomConversions customConversions(){
		CustomConversions customConversions=new CustomConversions();
	//	customConversions.registerConvertersIn(new GenericConversionService(){});
		return customConversions;
	}
	
    

}

package com.train.excel.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.train.excel.utils.JsonDateFormatSerializer;

/**
 * 发站代码过滤设置
 * 
 * @author and04
 *
 */
public class FromFilter {

	private Long id;
	private String code;
	
	@JsonSerialize(using = JsonDateFormatSerializer.class)
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}

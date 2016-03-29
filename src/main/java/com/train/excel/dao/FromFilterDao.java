package com.train.excel.dao;

import java.util.List;

import com.train.excel.domain.FromFilter;

public interface FromFilterDao {

	/**
	 * 
	 * @param ff
	 */
	void save(FromFilter ff);

	/**
	 * 
	 * @param id
	 */
	void deleteById(Long id);

	/**
	 * 
	 * @return
	 */
	List<String> getAllCode();
}

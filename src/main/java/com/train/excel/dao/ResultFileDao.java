package com.train.excel.dao;

import java.util.List;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.domain.ResultFile;

/**
 * 
 * @author and04
 *
 */
public interface ResultFileDao {

	/**
	 * 
	 * @param rf
	 */
	void save(ResultFile rf);

	/**
	 * 
	 * @param id
	 */
	void deleteById(Long id);

	/**
	 * 
	 * @param condition
	 * @return
	 */
	List<ResultFile> getWithCondition(FileDto condition);

	/**
	 * 
	 * @param condition
	 * @return
	 */
	int getCountWithCondition(FileDto condition);

	String getFilePathById(Long id);

	String getFileNameById(Long id);
}

package com.train.excel.service;

import java.io.IOException;
import java.util.List;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.domain.ResultFile;

/**
 * 
 * @author and04
 *
 */
public interface ResultFileService {

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
	
	/**
	 * 
	 * @param id
	 * @param realFilePath
	 * @throws IOException
	 */
	void deleteFileAndDb(Long id, String realFilePath) throws IOException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	String getFilePathById(Long id);
	
	String getFileNameById(Long id);
}

package com.train.excel.dao;

import java.util.List;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.domain.SourceFile;

/**
 * 
 * @author and04
 *
 */
public interface SourceFileDao {

	/**
	 * 
	 * @param md5
	 * @return
	 */
	SourceFile getByMd5(String md5);

	/**
	 * 
	 * @param sf
	 */
	void save(SourceFile sf);
	
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
	List<SourceFile> getWithCondition(FileDto condition);

	/**
	 * 
	 * @param condition
	 * @return
	 */
	int getCountWithCondition(FileDto condition);

	
	String getFilePathByfileId(String fileId);

}

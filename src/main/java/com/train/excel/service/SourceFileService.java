package com.train.excel.service;

import java.io.IOException;
import java.util.List;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.domain.ResultFile;
import com.train.excel.domain.SourceFile;

public interface SourceFileService {

	/**
	 * 
	 * @param md5
	 * @return
	 */
	SourceFile getByMd5(String md5);

	/**
	 * 保存
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

	/**
	 * 同步删除
	 * 
	 * @param id
	 * @param fileId
	 * @param filePath
	 * @throws IOException
	 */
	void deleteFileAndContent(Long id, String fileId, String filePath) throws IOException;

	/**
	 * 
	 * @param fileId
	 * @param realPath
	 * @return
	 * @throws IOException 
	 */
	ResultFile analysis(String srcFileId, String srcFileName, String realPath) throws IOException;

	/**
	 */
	String getFilePathByfileId(String fileId);
}

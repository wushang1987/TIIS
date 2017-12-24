/**
 * 
 */
package com.train.excel.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.dao.ResultFileDao;
import com.train.excel.domain.ResultFile;
import com.train.excel.service.ResultFileService;

/**
 * @author and04
 *
 */
@Named
public class ResultFileServiceImpl implements ResultFileService {

	@Inject
	private ResultFileDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.ResultFileService#save(com.train.excel.domain.
	 * ResultFile)
	 */
	@Override
	public void save(ResultFile rf) {
		dao.save(rf);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.ResultFileService#deleteById(java.lang.Integer)
	 */
	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.ResultFileService#getWithCondition(com.train.
	 * excel.controller.dto.FileDto)
	 */
	@Override
	public List<ResultFile> getWithCondition(FileDto condition) {
		return dao.getWithCondition(condition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.ResultFileService#getCountWithCondition(com.train
	 * .excel.controller.dto.FileDto)
	 */
	@Override
	public int getCountWithCondition(FileDto condition) {
		return dao.getCountWithCondition(condition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.train.excel.service.ResultFileService#deleteFileAndDb(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void deleteFileAndDb(Long id, String realFilePath) throws IOException {
		deleteById(id);
		Files.deleteIfExists(Paths.get(realFilePath));
	}

	@Override
	public String getFilePathById(Long id) {
		return dao.getFilePathById(id);
	}

	@Override
	public String getFileNameById(Long id) {
		// TODO Auto-generated method stub
		return dao.getFileNameById(id);
	}

}

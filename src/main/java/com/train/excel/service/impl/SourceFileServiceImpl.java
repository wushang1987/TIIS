/**
 * 
 */
package com.train.excel.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.util.StringUtils;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.dao.AnalysisResult4TrainDao;
import com.train.excel.dao.ResultFileDao;
import com.train.excel.dao.SourceFileDao;
import com.train.excel.dao.StationTrainDao;
import com.train.excel.domain.AnalysisResult4Train;
import com.train.excel.domain.ResultFile;
import com.train.excel.domain.SourceFile;
import com.train.excel.service.SourceFileService;
import com.train.excel.utils.ExcelUtil;
import com.train.excel.utils.FilePathConstants;
import com.train.excel.utils.ResultFileConstants;

/**
 * @author and04
 *
 */
@Named
public class SourceFileServiceImpl implements SourceFileService {

	@Inject
	private SourceFileDao dao;

	@Inject
	private StationTrainDao stDao;

	@Inject
	private AnalysisResult4TrainDao artDao;

	@Inject
	private ResultFileDao rfDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.train.excel.service.SourceFileService#getByMd5(java.lang.String)
	 */
	@Override
	public SourceFile getByMd5(String md5) {
		return dao.getByMd5(md5);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.SourceFileService#save(com.train.excel.domain.
	 * SourceFile)
	 */
	@Override
	public void save(SourceFile sf) {
		dao.save(sf);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.SourceFileService#deleteById(java.lang.String)
	 */
	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.SourceFileService#getWithCondition(com.train.
	 * excel.controller.dto.SourceFileDto)
	 */
	@Override
	public List<SourceFile> getWithCondition(FileDto condition) {
		return dao.getWithCondition(condition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.SourceFileService#getCountWithCondition(com.train
	 * .excel.controller.dto.SourceFileDto)
	 */
	@Override
	public int getCountWithCondition(FileDto condition) {
		return dao.getCountWithCondition(condition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.SourceFileService#deleteFileAndContent(java.lang.
	 * String, java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteFileAndContent(Long id, String fileId, String filePath) throws IOException {
		dao.deleteById(id);
		stDao.deleteByFileId(fileId);
		Files.deleteIfExists(Paths.get(filePath));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.train.excel.service.SourceFileService#analysis(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ResultFile analysis(String srcFileId, String srcFileName, String realPath) throws IOException {
		if (!StringUtils.hasText(srcFileName)) {
			srcFileName = ResultFileConstants.DEFUAL_RESULT_FILE_NAME;
		}
		Path resultFilePath = Paths.get(realPath, srcFileName + FilePathConstants.FILE_EXTENSION_NAME_XLSX);
		List<AnalysisResult4Train> AnalysisResult4Trains = artDao.getAllAnalysisResult(srcFileId);
		return getResultFile(AnalysisResult4Trains, srcFileId, resultFilePath);
	}

	/**
	 * 
	 * @param sts
	 * @param os
	 * @return
	 * @throws IOException
	 */
	private ResultFile getResultFile(List<AnalysisResult4Train> AnalysisResult4Trains, String srcFileId, Path resultFilePath) throws IOException {

		// 写文件
		ExcelUtil.writeResultFile(AnalysisResult4Trains, resultFilePath.toFile());

		// 保存结果文件数据
		ResultFile rf = new ResultFile();
		rf.setCreateTime(new Date());
		rf.setFileName(resultFilePath.getFileName().toString());
		rf.setFilePath(resultFilePath.toString());
		rf.setSrcFileId(srcFileId);
		rfDao.save(rf);
		return rf;
	}

	@Override
	public String getFilePathByfileId(String fileId) {
		return dao.getFilePathByfileId(fileId);
	}

}

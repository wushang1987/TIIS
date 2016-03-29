package com.train.excel.dao;

import java.util.List;

import com.train.excel.domain.AnalysisResult4Train;

/**
 * 
 * @author and04
 *
 */
public interface AnalysisResult4TrainDao {
	
	/**
	 * 获取所有的分析结果
	 * @return
	 */
	List<AnalysisResult4Train> getAllAnalysisResult(String fileId);
}

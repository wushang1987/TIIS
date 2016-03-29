package com.train.excel.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.train.excel.dao.AnalysisResult4TrainDao;
import com.train.excel.domain.AnalysisResult4Train;
import com.train.excel.service.AnalysisResult4TrainService;

@Named
public class AnalysisResult4TrainServiceImpl implements AnalysisResult4TrainService {

	@Inject
	private AnalysisResult4TrainDao dao;
	
	@Override
	public List<AnalysisResult4Train> getAllAnalysisResult(String fileId) {
		return dao.getAllAnalysisResult(fileId);
	}

}

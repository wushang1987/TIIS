/**
 * 
 */
package com.train.excel.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.train.excel.dao.StationTrainDao;
import com.train.excel.domain.StationTrain;
import com.train.excel.service.StationTrainService;

/**
 * @author and04
 *
 */
@Named
public class StationTrainServiceImpl implements StationTrainService {

	@Inject
	private StationTrainDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.StationTrainService#save(com.train.excel.domain.
	 * StationTrain)
	 */
	@Override
	public void save(StationTrain st) {
		dao.save(st);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.train.excel.service.StationTrainService#deleteByFileId(java.lang.
	 * String)
	 */
	@Override
	public void deleteByFileId(String fileId) {
		dao.deleteByFileId(fileId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.train.excel.service.StationTrainService#getByFileId(java.lang.String)
	 */
	@Override
	public List<StationTrain> getByFileId(String fileId) {
		return dao.getByFileId(fileId);
	}

}

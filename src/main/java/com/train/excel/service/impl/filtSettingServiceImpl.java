package com.train.excel.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.dao.FromFilterDao;
import com.train.excel.dao.ResultFileDao;
import com.train.excel.domain.FromFilter;
import com.train.excel.service.FiltSettingService;

@Named
public class filtSettingServiceImpl implements FiltSettingService {

	@Inject
	private FromFilterDao dao;
	
	@Override
	public void save(FromFilter ff) {
		// TODO Auto-generated method stub
		dao.save(ff);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<FromFilter> getAllCode(FileDto condition) {
		// TODO Auto-generated method stub
		return  dao.getAllCode(condition);
	}

	@Override
	public int getFromFiltCodeCount() {
		// TODO Auto-generated method stub
		return dao.getFromFiltCodeCount();
	}

}

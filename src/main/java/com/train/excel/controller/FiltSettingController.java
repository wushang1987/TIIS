package com.train.excel.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.domain.FromFilter;
import com.train.excel.domain.ResultFile;
import com.train.excel.domain.SourceFile;
import com.train.excel.domain.Status;
import com.train.excel.service.FiltSettingService;
import com.train.excel.service.SourceFileService;
import com.train.excel.utils.FilePathConstants;

@RestController
@RequestMapping("/fz")
public class FiltSettingController {

	@Inject
	private FiltSettingService filt;

	/**
	 * 显示设置列表内容
	 * @return
	 */
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public Object list(FileDto condition) {
		Map<String, Object> map = new HashMap<>();
		List<FromFilter> fromFilt = filt.getAllCode(condition);
		int count = filt.getFromFiltCodeCount();
		map.put("data", fromFilt);
		map.put("recordsTotal", count);
		map.put("recordsFiltered", count);
		map.put("draw", condition.getDraw());
		return map;
	}
	
	/**
	 * 新增一个过滤条件
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/addFilt/{filtCode}", method = RequestMethod.POST)
	public void addFilt(@PathVariable String filtCode) {
		FromFilter fromFilter = new FromFilter();
		
		Date date = new Date();
		fromFilter.setCode(filtCode);
		fromFilter.setCreateTime(date);
		filt.save(fromFilter);
	}
	
	/**
	 * 删除一个过滤条件
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/delFilt/{id}", method = RequestMethod.POST)
	public void delFilt(@PathVariable Long id) {
		filt.deleteById(id);
	}



}

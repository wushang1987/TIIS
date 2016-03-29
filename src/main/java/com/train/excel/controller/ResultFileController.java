package com.train.excel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.train.excel.controller.dto.FileDto;
import com.train.excel.domain.ResultFile;
import com.train.excel.domain.Status;
import com.train.excel.service.ResultFileService;

@RestController
@RequestMapping("/rf")
public class ResultFileController {

	@Inject
	private ResultFileService service;

	@Inject
	private ServletContext sc;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(path = "/list", method = RequestMethod.POST)
	public Object list(FileDto condition) {
		Map<String, Object> map = new HashMap<>();
		List<ResultFile> files = service.getWithCondition(condition);
		int count = service.getCountWithCondition(condition);
		map.put("data", files);
		map.put("recordsTotal", count);
		map.put("recordsFiltered", count);
		map.put("draw", condition.getDraw());
		return map;
	}

	/**
	 * delete
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(path = "/delete/{id}/{filepath}", method = RequestMethod.DELETE)
	public Object deleteById(@PathVariable("id") Long id, @PathVariable("filepath") String filePath)
			throws IOException {
		String realFilePath = sc.getRealPath(filePath);
		service.deleteFileAndDb(id, realFilePath);
		return new Status();
	}

}

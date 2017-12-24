package com.train.excel.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	@RequestMapping(path = "/list", method = RequestMethod.GET)
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
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public Object deleteById(@PathVariable("id") Long id)
			throws IOException {
		String filePath = service.getFilePathById(id);
//		String realFilePath = sc.getRealPath(filePath );
		
		service.deleteFileAndDb(id, filePath);
		return new Status();
	}
	
	@RequestMapping(path = "/download/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downLoad(@PathVariable("id") Long id) throws Exception {

		String filepath = service.getFilePathById(id); // 这里调用获取文件路径的方法
		String fileName = service.getFileNameById(id);
		InputStream in = new FileInputStream(filepath);
		byte[] body = IOUtils.toByteArray(in);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
		return result;
	}


}

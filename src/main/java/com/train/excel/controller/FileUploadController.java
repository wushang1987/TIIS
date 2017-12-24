package com.train.excel.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.train.excel.domain.Status;
import com.train.excel.service.FileUpLoadService;
import com.train.excel.utils.FilePathConstants;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

	@Inject
	private FileUpLoadService service;

	@Inject
	private ServletContext sc;

	/**
	 * 上传Excel
	 * 
	 * @param name
	 * @param file
	 * @return8
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 */
	@RequestMapping(path = "/excel", method = RequestMethod.POST)
	public Status handleFormUpload(MultipartFile file) throws Exception {
		if (file != null && !file.isEmpty()) {
			String destPath = sc.getRealPath(FilePathConstants.UPLOAD_SRC_FILE_PATH);
			return service.saveContentAndfile(file, destPath);
		}
		return new Status(1, "这个文件是空的");
	}

}

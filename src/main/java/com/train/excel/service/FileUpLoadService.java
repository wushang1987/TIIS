package com.train.excel.service;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.train.excel.domain.Status;

/**
 * 
 * @author and04
 *
 */
public interface FileUpLoadService {

	/**
	 * 保存文件内容和文件信息到数据库
	 * 
	 * @param file
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 */
	Status saveContentAndfile(MultipartFile file, String destPath)
			throws IOException, EncryptedDocumentException, InvalidFormatException;

}

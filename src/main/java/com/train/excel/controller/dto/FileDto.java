package com.train.excel.controller.dto;

import com.train.excel.domain.Page;

/**
 * 
 * @author and04
 *
 */
public class FileDto extends Page {

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}

package com.train.excel.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.train.excel.utils.JsonDateFormatSerializer;

/**
 * 源文件
 * 
 * @author and04
 *
 */
public class SourceFile {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 文件Id
	 */
	private String fileId;

	/**
	 * 文件名字
	 */
	private String fileName;

	/**
	 * 文件路径
	 */
	private String filePath;

	/**
	 * md5摘要
	 */
	private String md5;

	/**
	 * 上传时间
	 */
	@JsonSerialize(using = JsonDateFormatSerializer.class)
	private Date uploadTime;

	public String getFileId() {
		return fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public Long getId() {
		return id;
	}

	public String getMd5() {
		return md5;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}

package com.train.excel.domain;

/**
 * 
 * @author and04
 *
 */
public class Status {

	private String msg = "OK";
	private int code;

	public Status() {

	}

	public Status(String msg) {
		this.msg = msg;
	}

	public Status(int code, String msg) {
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}

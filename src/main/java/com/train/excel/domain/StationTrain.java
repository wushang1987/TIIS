package com.train.excel.domain;

import java.util.Date;

/**
 * 到站的车辆信息
 * 
 * @author and04
 *
 */
public class StationTrain {

	/**
	 * 
	 */
	private Long id;

	/**
	 * 车次
	 */
	private String trainCode;

	/**
	 * 文件Id
	 */
	private String fileId;

	/**
	 * 日期
	 */
	private Date date;

	/**
	 * 序号
	 */
	private String serialNum;

	/**
	 * 车号
	 */
	private String trainNum;

	/**
	 * 车种车型
	 */
	private String trainType;

	/**
	 * 换长
	 */
	private Double changeLong;

	/**
	 * 自重
	 */
	private Double selfWeight;

	/**
	 * 载重
	 */
	private Double loadWeight;

	/**
	 * 货物名称
	 */
	private String goodsName;

	/**
	 * 发站
	 */
	private String fromStation;

	/**
	 * 发局
	 */
	private String fromBureau;

	/**
	 * 到站
	 */
	private String toStation;

	/**
	 * 到局
	 */
	private String toBureau;

	/**
	 * 收货人
	 */
	private String consignee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public Double getChangeLong() {
		return changeLong;
	}

	public void setChangeLong(Double changeLong) {
		this.changeLong = changeLong;
	}

	public Double getSelfWeight() {
		return selfWeight;
	}

	public void setSelfWeight(Double selfWeight) {
		this.selfWeight = selfWeight;
	}

	public Double getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(Double loadWeight) {
		this.loadWeight = loadWeight;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getFromBureau() {
		return fromBureau;
	}

	public void setFromBureau(String fromBureau) {
		this.fromBureau = fromBureau;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public String getToBureau() {
		return toBureau;
	}

	public void setToBureau(String toBureau) {
		this.toBureau = toBureau;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getTrainCode() {
		return trainCode;
	}

	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}
}

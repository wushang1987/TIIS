package com.train.excel.domain;

/**
 * 分析结果对象
 * 
 * @author and04
 *
 */
public class AnalysisResult4Station {

	private String trainCode;
	private String fromStation;
	private String toStation;
	private Integer disobeyCount;
	private Double disobeyWeight;

	public String getTrainCode() {
		return trainCode;
	}

	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public Integer getDisobeyCount() {
		return disobeyCount;
	}

	public void setDisobeyCount(Integer disobeyCount) {
		this.disobeyCount = disobeyCount;
	}

	public Double getDisobeyWeight() {
		return disobeyWeight;
	}

	public void setDisobeyWeight(Double disobeyWeight) {
		this.disobeyWeight = disobeyWeight;
	}

}

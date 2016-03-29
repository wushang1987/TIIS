package com.train.excel.domain;

import java.util.List;

public class AnalysisResult4Train {

	private String trainCode;
	private List<AnalysisResult4Station> aras;
	private Integer disobeyCountAll;
	private Double disobeyWeightAll;
	private Double weightAll;

	public String getTrainCode() {
		return trainCode;
	}

	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}

	public List<AnalysisResult4Station> getAras() {
		return aras;
	}

	public void setAras(List<AnalysisResult4Station> aras) {
		this.aras = aras;
	}

	public Integer getDisobeyCountAll() {
		return disobeyCountAll;
	}

	public void setDisobeyCountAll(Integer disobeyCountAll) {
		this.disobeyCountAll = disobeyCountAll;
	}

	public Double getDisobeyWeightAll() {
		return disobeyWeightAll;
	}

	public void setDisobeyWeightAll(Double disobeyWeightAll) {
		this.disobeyWeightAll = disobeyWeightAll;
	}

	public Double getWeightAll() {
		return weightAll;
	}

	public void setWeightAll(Double weightAll) {
		this.weightAll = weightAll;
	}

}

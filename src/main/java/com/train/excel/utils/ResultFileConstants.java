package com.train.excel.utils;

import java.util.ArrayList;
import java.util.List;

public class ResultFileConstants {

	public static final List<String> RESULT_FILE_TITLE = new ArrayList<>();
	public static final String DEFUAL_RESULT_FILE_NAME = "resultFile";

	static {
		RESULT_FILE_TITLE.add("车次");
		RESULT_FILE_TITLE.add("发站");
		RESULT_FILE_TITLE.add("到站");
		RESULT_FILE_TITLE.add("违流车数");
		RESULT_FILE_TITLE.add("违流吨数（载重合计）");
		RESULT_FILE_TITLE.add("违流车数合计");
		RESULT_FILE_TITLE.add("违流吨数合计");
		RESULT_FILE_TITLE.add("总吨数（总载重合计）");
		RESULT_FILE_TITLE.add("违流百分比（c/d）");
		RESULT_FILE_TITLE.add("违流周量(c*距离)");
		RESULT_FILE_TITLE.add("违流运费（F*0.18）");
	}
}

package com.train.excel.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.train.excel.domain.AnalysisResult4Train;
import com.train.excel.domain.StationTrain;

/**
 * Excel 工具类
 * 
 * @author and04
 *
 */
public class ExcelUtil {

	/**
	 * 
	 * @param AnalysisResult4Trains
	 * @param os
	 * @throws IOException
	 */
	public static void writeResultFile(List<AnalysisResult4Train> AnalysisResult4Trains, File file) throws IOException {

		try (Workbook wk = new SXSSFWorkbook(100); OutputStream os = new FileOutputStream(file);) {
			Sheet sheet = wk.createSheet("result");
			writeTile(sheet); // 写标题
			writeContent(sheet, AnalysisResult4Trains); // 写内容
			wk.write(os);
		}
	}

	// 写内容
	private static void writeContent(Sheet sheet, List<AnalysisResult4Train> analysisResult4Trains) {
		int rowadd = 0;
		for (int i = sheet.getLastRowNum(); i < analysisResult4Trains.size(); i++) {
			AnalysisResult4Train analysisResult4Train = analysisResult4Trains.get(i);
			int subSize = analysisResult4Train.getAras().size();
			for (int j = 0; j < subSize; j++) {
				Row row = sheet.createRow(rowadd + j + 1);
				row.createCell(0).setCellValue(analysisResult4Train.getTrainCode());
				row.createCell(1).setCellValue(analysisResult4Train.getAras().get(j).getFromStation());
				row.createCell(2).setCellValue(analysisResult4Train.getAras().get(j).getToStation());
				row.createCell(3).setCellValue(analysisResult4Train.getAras().get(j).getDisobeyCount());
				row.createCell(4).setCellValue(analysisResult4Train.getAras().get(j).getDisobeyWeight());
				row.createCell(5).setCellValue(analysisResult4Train.getDisobeyCountAll());
				row.createCell(6).setCellValue(analysisResult4Train.getDisobeyWeightAll());
				row.createCell(7).setCellValue(analysisResult4Train.getWeightAll());
				row.createCell(8).setCellValue("待定");
				row.createCell(9).setCellValue("待定");
				row.createCell(10).setCellValue("待定");
			}
			sheet.addMergedRegion(new CellRangeAddress(rowadd + 1, rowadd + subSize, 0, 0));
//			sheet.addMergedRegion(new CellRangeAddress(i + 1, i + subSize, 5, 5));
//			sheet.addMergedRegion(new CellRangeAddress(i + 1, i + subSize, 6, 6));
//			sheet.addMergedRegion(new CellRangeAddress(i + 1, i + subSize, 7, 7));
//			sheet.addMergedRegion(new CellRangeAddress(i + 1, i + subSize, 8, 8));
//			sheet.addMergedRegion(new CellRangeAddress(i + 1, i + subSize, 9, 9));
//			sheet.addMergedRegion(new CellRangeAddress(i + 1, i + subSize, 10, 10));
			rowadd += subSize;
		}
		
		for (int i = 5; i < 11; i++) {
			sheet.addMergedRegion(new CellRangeAddress(1, sheet.getLastRowNum(), i, i));
		}
		

	}

	// 写标题
	private static void writeTile(Sheet sheet) {
		Row titleRow = sheet.createRow(0);
		List<String> titles = ResultFileConstants.RESULT_FILE_TITLE;
		for (int i = 0; i < titles.size(); i++) {
			titleRow.createCell(i).setCellValue(titles.get(i));
		}
	}

	/**
	 * 解析Excel
	 * 
	 * @param in
	 * @param fileId
	 * @param upLoadTime
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static List<StationTrain> excel2List(InputStream in, String fileId, Date upLoadTime) throws EncryptedDocumentException, InvalidFormatException, IOException {

		List<StationTrain> list = new ArrayList<>();
		if (in == null) {
			return list;
		}
		try (Workbook wk = WorkbookFactory.create(in)) {
			if (wk == null) {
				return list;
			}
			for (Sheet sheet : wk) {
				if (sheet.getLastRowNum() > 0) {
					String firstStr = getCellValue(sheet.getRow(0).getCell(0, Row.CREATE_NULL_AS_BLANK));
					if ("序号".equals(firstStr)) {
						for (Row row : sheet) {
							StationTrain st = new StationTrain();
							if (row.getRowNum() == 0) {
								continue;
							}
							st.setSerialNum(getCellValue(row.getCell(0, Row.CREATE_NULL_AS_BLANK)));
							st.setTrainNum(getCellValue(row.getCell(1, Row.CREATE_NULL_AS_BLANK)));
							st.setTrainType(getCellValue(row.getCell(2, Row.CREATE_NULL_AS_BLANK)));
							st.setChangeLong(Double.parseDouble(getCellValue(row.getCell(3, Row.CREATE_NULL_AS_BLANK))));
							st.setSelfWeight(Double.parseDouble(getCellValue(row.getCell(4, Row.CREATE_NULL_AS_BLANK))));
							st.setLoadWeight(Double.parseDouble(getCellValue(row.getCell(5, Row.CREATE_NULL_AS_BLANK))));
							st.setGoodsName(getCellValue(row.getCell(6, Row.CREATE_NULL_AS_BLANK)));
							st.setFromStation(getCellValue(row.getCell(7, Row.CREATE_NULL_AS_BLANK)));
							st.setFromBureau(getCellValue(row.getCell(8, Row.CREATE_NULL_AS_BLANK)));
							st.setToStation(getCellValue(row.getCell(9, Row.CREATE_NULL_AS_BLANK)));
							st.setToBureau(getCellValue(row.getCell(10, Row.CREATE_NULL_AS_BLANK)));
							st.setConsignee(getCellValue(row.getCell(11, Row.CREATE_NULL_AS_BLANK)));
							st.setFileId(fileId);
							st.setDate(upLoadTime);
							st.setTrainCode(sheet.getSheetName());
							list.add(st);
						}
					}
				}
			}
			return list;
		} finally {
			in.close();
		}
	}

	/*
	 * 获取各种类型的单元格的值， 并转换成字符串
	 */
	private static String getCellValue(Cell cell) {
		String value = null;
		int cellType = cell.getCellType();
		switch (cellType) {
		case Cell.CELL_TYPE_NUMERIC:
			value = String.valueOf(cell.getNumericCellValue());
			if (value.endsWith(".0")) {
				value = value.split("\\.")[0];
			}
			break;
		case Cell.CELL_TYPE_BLANK:
			value = null;
			break;
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA:
			value = cell.getCellFormula();
			break;
		default:
			break;
		}
		return value;
	}

}

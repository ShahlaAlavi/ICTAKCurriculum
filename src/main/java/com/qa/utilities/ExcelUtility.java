package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook excelBook;
	public static XSSFSheet excelSheet;
	public static String  getDataSheet0(int rowNum,int ColNum) throws IOException
	{
		FileInputStream inp=new FileInputStream("C:\\KKEMmarch\\ICTAKCurriculum\\src\\main\\resources\\TestData.xlsx");
		excelBook = new XSSFWorkbook(inp);
		excelSheet = excelBook.getSheetAt(0);
		DataFormatter df=new DataFormatter();
		String value = df.formatCellValue(excelSheet.getRow(rowNum).getCell(ColNum));
		return value;
	}
	public static String  getDataSheet1(int rowNum,int ColNum) throws IOException
	{
		FileInputStream inp=new FileInputStream("C:\\\\KKEMmarch\\\\ICTAKCurriculum\\\\src\\\\main\\\\resources\\\\TestData.xlsx");
		excelBook = new XSSFWorkbook(inp);
		excelSheet = excelBook.getSheetAt(1);
		DataFormatter df=new DataFormatter();
		String value = df.formatCellValue(excelSheet.getRow(rowNum).getCell(ColNum));
		return value;
	}

}

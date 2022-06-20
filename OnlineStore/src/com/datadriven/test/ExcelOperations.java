package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader reader=new Xls_Reader("C:\\Users\\lenovo\\Documents\\ToolsQA\\OnlineStore\\src\\com\\testdata\\EbayTestDataDriven.xlsx");
	//reader.addSheet("HomePage");
	
	if(!reader.isSheetExist("HomePage")){
		reader.addSheet("HomePage"); 
	}
	int colCount=reader.getColumnCount("RegTestData");
	System.out.println(colCount);
	int RowNum=reader.getCellRowNum("RegTestData", "firstname", "Pooja");
	System.out.println(RowNum);
}
}
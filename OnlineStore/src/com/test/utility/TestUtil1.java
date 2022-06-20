package com.test.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil1 {
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet Sheet;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\lenovo\\Documents\\ToolsQA\\OnlineStore\\src\\com\\testdata\\CRMLoginTestdata.xlsx";//Created a static variable having path of excel sheet.
public static Object[][] getTestData(String sheetName)
{
	FileInputStream file=null;
	try {
		file=new FileInputStream(TESTDATA_SHEET_PATH);//created the FileInputStream  class object and passed the Location of sheet.
		
		
		
	}
	catch(FileNotFoundException e) {
		
		e.printStackTrace();
		
	}
try {
	book=WorkbookFactory.create(file);//WorkbookFactory is present in Apache poi will create a file andd will get one book object
	}catch(IOException e) {
		
		e.printStackTrace();
	}


Sheet = book.getSheet(sheetName);
Object[][] data=new Object[Sheet.getLastRowNum()][ Sheet.getRow(0).getLastCellNum()];
for(int i=0; i< Sheet.getLastRowNum();i++) {
	for(int k=0;k< Sheet.getRow(0).getLastCellNum();k++) {
		
		data[i][k]=Sheet.getRow(i+1).getCell(k).toString();
	}
	
}
return data;

}


}



/*Sequnece:
	create a fileinputstream object and pass the path
	then using workbookFactory.create(file) method will create a file will get workbook class object.
	and using workbook class obect we are caliing getsheet method will return one  sheetclass object 
	throuugh sheetclass object  we are calling getLastRowNum()][sheet.getRow(0).getLastCellNum() method
	and iterating the array and returning data.
	return data is  two dimensional array.first[] is row and second is column.
	
	*
	*
	*/
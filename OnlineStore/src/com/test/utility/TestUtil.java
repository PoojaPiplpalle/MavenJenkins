package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public  class TestUtil {
	public static Xls_Reader reader;
	public static ArrayList<Object[]> GetDatafromexcel() {
		ArrayList<Object[]> mydata= new ArrayList<Object[]>();//Created the Arraylist Object and and it contains Object array[].
		try {
			
			reader=new Xls_Reader("C:\\Users\\lenovo\\Documents\\ToolsQA\\OnlineStore\\src\\com\\testdata\\EbayTestDataDriven.xlsx");
		
		}catch(Exception e)
		{
			
			e.printStackTrace();
		}//Tommorow the file will not be present so it will give exception file not found exception so we are storing in try catch block.
		for(int rowNum=2;rowNum<=reader.getRowCount("RegTestData");rowNum++) {
			String FirstName=reader.getCellData("RegTestData", "firstname", rowNum);
			String Surname=reader.getCellData("RegTestData", "surname", rowNum);
			String EmailAddress=reader.getCellData("RegTestData", "emailaddress", rowNum);
			String EmailAddress1=reader.getCellData("RegTestData", "emailaddress", rowNum);

			String Password=reader.getCellData("RegTestData", "password", rowNum);
			
			Object ob[]= {FirstName,Surname,EmailAddress,EmailAddress1,Password};
			mydata.add(ob);
			
			 
		}
		return mydata;//This method(GetDatafromexcel()) is returning my data and my data is arraylist which contains object array
		
	}

}

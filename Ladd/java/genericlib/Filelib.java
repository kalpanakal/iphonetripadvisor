package genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Filelib {
	
	/*
	 * @author kalpana
	 */
	/**
	 * reading data from excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellNum
	 */
	public  String getcellData(String sheetName,int rownum,int cellNum) throws Throwable {

		FileInputStream fis = new FileInputStream("D:\\flip\\Ladd\\src\\test\\resources\\data\\excel.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String cellvalue= workbook.getSheet(sheetName).getRow(rownum).getCell(cellNum).getStringCellValue();
		Reporter.log(cellvalue,true);
	return cellvalue;
	}
	
		
	}



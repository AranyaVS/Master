package LoginUtility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData
{
	public static Object[][] readData(String ExcelFileName)
	{
		try {
			XSSFWorkbook book = new XSSFWorkbook("./TestData/"+ExcelFileName+".xlsx");
			XSSFSheet sheet = book.getSheetAt(0);
		//	getting row and coloum count for iteration
			int rowcount =sheet.getLastRowNum();
			int colcount =sheet.getRow(0).getLastCellNum();
			// creating 2d array to return data to @dataprovider
			Object[][] array = new Object[rowcount][colcount];
			for(int i=1;i<=rowcount;i++)
			{
				XSSFRow row=sheet.getRow(i);
				for(int j=0;j<colcount;j++)
				{
					XSSFCell cell=row.getCell(j);
					String data = cell.getStringCellValue();
					array[i-1][j] = data;
				}
			}
			book.close();
			return array;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*public static Object[][] readData1(String excelFileName) {
		// TODO Auto-generated method stub
		return null;
	}*/
}

package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadXLS 
{
	public static void main(String[] args) throws IOException
	{
		//XSSFSheet sheet=getSheet("Testcases");
		//getRowNumber(sheet,"login");
		//System.out.println(getColName(sheet, "login"));
		//System.out.println(getRowCount(sheet));
		//printdataFromXLS(sheet);
		//System.out.println(getCellData(sheet, getRowNumber(sheet, "OpenMyPortFolio"), getColNumber(sheet, "Description")));
		//System.out.println(getCellData("Testcases","LoginRediff", "Description"));
		//System.out.println(getColCount("Testcases"));
//		String path = System.getProperty("user.dir");
//		System.out.println(path);
		//System.out.println(getCellData("LoginRediff", 3, 3));

	}
	public static XSSFSheet getSheet(String sheetName) throws IOException
	{
		String path = System.getProperty("user.dir")+"/TestData.xlsx";
//		System.out.println(path);
		File f = new File(path);
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook book = new XSSFWorkbook(fs);
		XSSFSheet sheet = book.getSheet(sheetName);
		return sheet;
	}

	public static void printdataFromXLS(String sheetName) throws IOException
	{
		XSSFSheet sheet=getSheet(sheetName);
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		while (itr.hasNext())                 
		{  
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next();  
				switch (cell.getCellType())               
				{  
				case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
				{
					System.out.print(cell.getStringCellValue() + "\t\t\t");  
					//System.out.print(cell.getColumnIndex());
					break;
				}
				case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
				{
					System.out.print(cell.getNumericCellValue() + "\t\t\t");
					//System.out.print(cell.getColumnIndex());
					break;
				}
				default:  
				}  
			}  
			System.out.println("");

		}  
	}

	public static int getRowNumber(String sheetName,String searchkey) throws IOException
	{
		XSSFSheet sheet=getSheet(sheetName);
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		while (itr.hasNext())                 
		{  
			Row row = itr.next();  

			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next();  
				if(cell.getStringCellValue().equals(searchkey))
				{
					//System.out.println(row.getRowNum());
					return cell.getRowIndex()+1;
				}
			}  

		}
		return -1;  
	}

	public static int getColNumber(String sheetName,String searchkey) throws IOException
	{
		XSSFSheet sheet=getSheet(sheetName);
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		while (itr.hasNext())                 
		{  
			Row row = itr.next();  

			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next();  
				if(cell.getStringCellValue().equals(searchkey))
				{
					//System.out.println(row.getRowNum());
					return cell.getColumnIndex()+1;
				}
			}  

		}
		return -1;  
	}
	public static String getColName(String sheetName,String searchkey) throws IOException
	{
		XSSFSheet sheet=getSheet(sheetName);
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		while (itr.hasNext())                 
		{  
			Row row = itr.next();  

			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next();  
				if(cell.getStringCellValue().equals(searchkey))
				{
					break;
				}
			} 
			cellIterator = row.cellIterator();
			Cell cell = cellIterator.next();
			return cell.getStringCellValue();
		}
		return null;  
	}


	public static String getCellData(String sheetName,int rowNum,int colNum) throws IOException
	{
		XSSFSheet sheet=getSheet(sheetName);
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		while (itr.hasNext())                 
		{  
			Row row = itr.next(); 
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next(); 
				if(cell.getColumnIndex()==colNum-1)
				{
					if(cell.getRowIndex()==rowNum-1)
					{
						//System.out.println("Row : "+(cell.getRowIndex()+1));
						//System.out.println("Col : "+(cell.getColumnIndex()+1));
						//System.out.println("Cell data : "+cell.getStringCellValue());
						return cell.getStringCellValue();
					}
				}
			}  
		}
		return null;  
	}

	public static String getCellData(String sheetName, String rowNam,String colNam) throws IOException
	{
		XSSFSheet sheet =getSheet(sheetName);
		int colNum=getColNumber(sheetName, colNam);
		int rowNum=getRowNumber(sheetName, rowNam);
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		while (itr.hasNext())                 
		{  
			Row row = itr.next(); 
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next(); 
				if(cell.getColumnIndex()==colNum-1)
				{
					if(cell.getRowIndex()==rowNum-1)
					{
						//System.out.println("Row : "+(cell.getRowIndex()+1));
						//System.out.println("Col : "+(cell.getColumnIndex()+1));
						//System.out.println("Cell data : "+cell.getStringCellValue());
						return cell.getStringCellValue();
					}
				}
			}  


		}
		return null;  
	}

	public static int getRowCount(String sheetName) throws IOException
	{
		XSSFSheet sheet =getSheet(sheetName);

		if(sheet==null)
			return -1;
		else
		{
			int count =sheet.getLastRowNum();
			return count; 
		}

	}

	public static int getColCount(String sheetName) throws IOException
	{
		XSSFSheet sheet =getSheet(sheetName);

		if(sheet==null)
			return -1;
		else
		{
			int count =sheet.getRow(0).getLastCellNum();
			return count; 
		}

	}
}

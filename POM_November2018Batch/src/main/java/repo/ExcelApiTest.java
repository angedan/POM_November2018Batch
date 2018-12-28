package repo;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelApiTest {
	
	public FileInputStream fis = null; // to read from the file
	public FileOutputStream fos = null; // to write into the file
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public String xlFilePath = null;
	
	
	
	public ExcelApiTest (String xlFilePath ) throws IOException
	
	{
		this.xlFilePath= xlFilePath;
		fis=new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
		
		
	}
	
	//@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, int colNum, int rowNum)
	{
		try
		{
			sheet= workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
					{
				      String cellValue=String.valueOf(cell.getNumericCellValue());
				      if(HSSFDateUtil.isCellDateFormatted(cell))
				      {
				    	  DateFormat df = new SimpleDateFormat("dd/MM/yy");
				    	  Date date=cell.getDateCellValue();
				    	  cellValue = df.format(date);
				      }
				      return cellValue;
				      
			       }
		
		
		else if (cell.getCellType()==CellType.BLANK)
		{
			return "";
		}
		else 
		{
			return String.valueOf(cell.getBooleanCellValue());
			
		}
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
			return "row" + rowNum + "or Column" + colNum+ "does not exist in the excel";
		
		}
		
	
	}
		
	public String getCellData(String sheetName, String colName, int rowNum)
	{
		try
		{
			int col_Num= -1;
			sheet = workbook.getSheet(sheetName);
			row=sheet.getRow(0);
			for (int i=0; i < row.getLastCellNum(); i++)
			{
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num= i;
			}
			row=sheet.getRow(rowNum);
			cell=row.getCell(col_Num);
			
			if(cell.getCellType()==CellType.STRING)
			
			return cell.getStringCellValue();
			
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
					{
				      String cellValue=String.valueOf(cell.getNumericCellValue());
				      if(HSSFDateUtil.isCellDateFormatted(cell))
				      {
				    	  DateFormat df = new SimpleDateFormat("dd/MM/yy");
				    	  Date date=cell.getDateCellValue();
				    	  cellValue = df.format(date);
				      }
				      return cellValue;
				      
			       }
			else if (cell.getCellType()==CellType.BLANK)
			return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "row" + rowNum + "or Column" + colName+ "does not exist in the excel";
		
		}
		
	}
	public int getRowCount (String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() +1;
		return rowCount;
	}
    public int getColumnCount(String sheetName )
    {
    	sheet= workbook.getSheet(sheetName);
    	row=sheet.getRow(0);
    	int colCount = row.getLastCellNum();
    	return colCount;
    	
    	
    }
    public boolean setCellData (String sheetName, int colNum, int rowNum, String value)
    {
    	   try
    	   {
    		   sheet =workbook.getSheet(sheetName);
    		   row=sheet.getRow(rowNum);
    		   if (row==null)
    		   {
    			   row=sheet.createRow(rowNum);
    		   }
    		   
    		   cell= row.getCell(colNum);
    		   if(cell==null)
    		    {
    			   cell=row.createCell(colNum);
    		    }
    		   
    		   cell.setCellValue(value);
    		   
    		   
    		   String xlFilePath = null;
			fos = new FileOutputStream(xlFilePath);
    		   workbook.write(fos);
    		   fos.close();
    		   
    	   }
    	   catch (Exception e)
    	   {
    		   e.printStackTrace();
    		   return false;
    	   }
    	   return true;
    }
    public boolean setCellData(String sheetName, String colName, int rowNum, String value )
    {
    	try
    	{
    		int colNum=-1;
    		sheet=workbook.getSheet(sheetName);
    		
    		row = sheet.getRow(0);
    		for (int i=0 ; i <row.getLastCellNum(); i++)
    		{
    			if (row.getCell(i).getStringCellValue().trim().equals(colName))
    			{
    				colNum=i;
    			}
    		}
    		
    		sheet.autoSizeColumn(colNum);
    		row=sheet.getRow(rowNum-1);
    		if (row==null)
    		{
    			row=sheet.createRow(rowNum-1);
    		}
    		
    		cell= row.getCell(colNum);
    		if(cell==null)
    		{
    			cell=row.createCell(colNum);
    		}
    		
    		cell.setCellValue(value);
    		
    		fos =new FileOutputStream(xlFilePath);
    		workbook.write(fos);
    		fos.close();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		return false;
       	}
    	return true;
    	
    }
}

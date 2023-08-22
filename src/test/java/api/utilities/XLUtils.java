/*package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

    private String path;

    public XLUtils(String path) {
        this.path = path;
    }

    public int getRowCount(String xlsheet) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            return ws.getLastRowNum();
        }
    }

    public int getCellCount(String xlsheet, int rownum) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            return row.getLastCellNum();
        }
    }

    public String getCellData(String xlsheet, int rownum, int colnum) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            XSSFCell cell = row.getCell(colnum);
            if (cell == null) {
                return "";
            }
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }
    }

    public void setCellData(String xlsheet, int rownum, int colnum, String data) throws IOException {
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            if (row == null) {
                row = ws.createRow(rownum);
            }
            XSSFCell cell = row.createCell(colnum);
            cell.setCellValue(data);
            try (FileOutputStream fo = new FileOutputStream(path)) {
                wb.write(fo);
            }
        }
    }
}
*/

package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	String path;
	
	
	
	public XLUtils (String path) {
		this.path = path;
	}
	 
	public int getRowCount(String xlsheet) throws IOException 
	{
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount= ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}
	
	
	public int getCellCount(String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public String getCellData(String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
	
}




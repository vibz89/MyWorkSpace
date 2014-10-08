package com.itrain.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
	           int count = 0;
	           List tempList = new ArrayList();
			   FileInputStream file = new FileInputStream(new File("C:\\Users\\mine\\Desktop\\excelReadtest\\test.xls"));
	           //Get the workbook instance for XLS file
			   XSSFWorkbook workbook = new XSSFWorkbook(file);
			   //Get first sheet from the workbook
			   XSSFSheet sheet = workbook.getSheetAt(0);
	           //Iterate through each rows from first sheet 
			   Iterator<Row> rowIterator = sheet.iterator();
			   while(rowIterator.hasNext()) {
				   count++;
			   Row row = rowIterator.next();
			   //For each row, iterate through each columns
			   Iterator<Cell> cellIterator = row.cellIterator();
			   
			  /**Add the loop to read all the column and remove the count condition**/
			   // while(cellIterator.hasNext()) {
			   //Cell cell = cellIterator.next();
			   System.out.println("count---"+count);
			   if(count<55){
				   System.out.println("In side count---"+count);  
				   Cell cell = row.getCell(3);
				   
				   System.out.println("cell type::"+cell.getCellType());
			   switch(cell.getCellType()) {
			   case Cell.CELL_TYPE_BOOLEAN: tempList.add(cell.getBooleanCellValue());
				   							System.out.print(cell.getBooleanCellValue() + "\n");
											break;
			   
			   case Cell.CELL_TYPE_NUMERIC:  tempList.add(cell.getNumericCellValue());
				   								System.out.print(cell.getNumericCellValue() + "\n");  				
												break;
			   case Cell.CELL_TYPE_STRING:	 tempList.add(cell.getStringCellValue());
				   								System.out.print(cell.getStringCellValue() + "\n");
												break;
				}
			   	
			   }
			   
			   
				}
				System.out.println("Array List printing");     
				//}
				file.close();
				
				for (Object row : tempList) {
					System.out.println("--"+row.toString().trim());
				}
				
				/**Add below code to write into a new excel**/
				//FileOutputStream out = new FileOutputStream(new File("C:\\Users\\mine\\Desktop\\excelReadtest\\test.xls"));
				//workbook.write(out);
				//out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace(); 
				} 
	}

}

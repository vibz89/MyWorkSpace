package com.itrain.excel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
  
public class ReadExcel { 
  
    public static void main( String [] args ) { 
        try { 
     
             InputStream input = new BufferedInputStream( 
                        new FileInputStream("C:\\Users\\mine\\Desktop\\excelReadtest\\test.xls")); 
             
            XSSFWorkbook wb = new XSSFWorkbook(input); 
            XSSFSheet sheet = wb.getSheetAt(0); 
              
              
            Iterator rows = sheet.rowIterator();  
            while( rows.hasNext() ) {    
                XSSFRow row = (XSSFRow) rows.next(); 
                System.out.println("\n"); 
                Iterator cells = row.cellIterator(); 
                while( cells.hasNext() ) { 
                      
                    XSSFCell cell = (XSSFCell) cells.next(); 
                    if(XSSFCell.CELL_TYPE_NUMERIC==cell.getCellType()) 
                    System.out.print( cell.getNumericCellValue()+"     " ); 
                    else
                    if(XSSFCell.CELL_TYPE_STRING==cell.getCellType()) 
                        System.out.print( cell.getStringCellValue()+"     " ); 
                    else
                        if(XSSFCell.CELL_TYPE_BOOLEAN==cell.getCellType()) 
                        System.out.print( cell.getBooleanCellValue()+"     " ); 
                        else
                            if(XSSFCell.CELL_TYPE_BLANK==cell.getCellType()) 
                                System.out.print( "BLANK     " ); 
                                else
                            System.out.print("Unknown cell type"); 
                    
                } 
                  
                  
            } 
             
              
        } catch ( IOException ex ) { 
            ex.printStackTrace(); 
        } 
    } 
      
} 

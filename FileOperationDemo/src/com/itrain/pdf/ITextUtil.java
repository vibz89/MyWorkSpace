package com.itrain.pdf;
import com.lowagie.text.DocumentException;

import com.lowagie.text.pdf.PdfPageEventHelper;

import com.lowagie.text.Document;

import com.lowagie.text.Element;

import com.lowagie.text.Font;

import com.lowagie.text.FontFactory;

import com.lowagie.text.PageSize;

import com.lowagie.text.Paragraph;

import com.lowagie.text.Phrase;

import com.lowagie.text.Rectangle;

import com.lowagie.text.pdf.BaseFont;

import com.lowagie.text.pdf.PdfPTable;

import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ITextUtil extends PdfPageEventHelper {

/** * Declare variable of type BaseFont */

public BaseFont helv;

/** Creates a new instance of ITextUtil*/

public ITextUtil() { }

/* This method will create a PDF using iText library and will return the string containing the filepath of the PDF created and its name(or an error message in case of an exception) */

public String generateITextPDF(String filePath) {

// step1

Document document = new Document(PageSize.A4, 30, 30, 120, 100);

boolean isException = false; String message = "";

try {

// step2

PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream( filePath + "iText.pdf"));

writer.setPageEvent(new ITextUtil());

// step3

document.open();

//generate the table

document.add(getYourSpecialTable());

} catch (Exception de) {

de.printStackTrace();

isException = true;

message = "Problem. Please close the PDF if its already open.";

} finally {

//Close the document object

document.close();

if (isException == false) {

//if there has been no exception print the success message

message = "filePath=" + filePath + "iText.pdf&file=iText.pdf";

} return message;

}

}

/* This is an overridden method that is called at the end of the page */

@Override

public void onEndPage(PdfWriter writer, Document document) {

try {

Rectangle page = document.getPageSize();

//we will print the header using the code below

PdfPTable headTable = getHeader(writer);

//total width of the table is set

headTable.setTotalWidth(page.width() - document.leftMargin() - document.rightMargin());

//the table is printed at the spcific location

headTable.writeSelectedRows(0, -1, document.leftMargin(), 800, writer.getDirectContent());

//we will print the footer using the code below

PdfPTable footTable = getFooterSignatures();

footTable.setTotalWidth(page.width() - document.leftMargin() - document.rightMargin());

footTable.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin() + 20,     writer.getDirectContent());

} catch (DocumentException ex) {

ex.printStackTrace();

}

}

private PdfPTable getFooterSignatures() throws DocumentException {

	Font fontStyleFooters = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD);
	
	//the following code will create a table with 2 columns
	
	PdfPTable footTable = new PdfPTable(2);
	
	//now we set the widths of each of the columns
	
	footTable.setWidths(new int[]{50, 50});
	
	//set the width of the table
	
	footTable.setWidthPercentage(100);
	
	//set the padding
	
	footTable.getDefaultCell().setPadding(2);
	
	//the border width is set below. it can be any floating point value
	
	//you could use 0.5f for a thin border that gives a good look to the table
	
	//since we are using 0 border width, the border wont apppear on this particular table
	
	footTable.getDefaultCell().setBorderWidth(0);
	
	//below we set the alignment of the cell values
	
	//each time you change the alignment, it applies to all the cells coming after it
	
	footTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
	//the following line will add a cell to the table with value "Signature1"
	
	//notice fontStyleFooters? that is the font that we created in the beginning of this method
	
	footTable.addCell(new Phrase("Signature1", fontStyleFooters));
	
	//this cell will be blank. Yes! we can directly type in a string too above, but in order to
	
	//use special fonts for special cell values, we are using a Phrase above
	
	footTable.addCell("");
	footTable.addCell("\n");
	footTable.addCell("\n");
	footTable.addCell(new Phrase("Signature2", fontStyleFooters)); 
	footTable.addCell(new Phrase("Signature3", fontStyleFooters));
	return footTable;

}

private PdfPTable getHeader(PdfWriter writer) throws DocumentException {

	String rightHeader =" Maruti Suzuki Company \n Vendor: Maruti \n Shop Location: Bangalore IN \n Car: IN KA 123123 \n Submit Date 3/3/2014 6:47:46 PM \n ";
	PdfPTable headTable = new PdfPTable(3);
	headTable.setWidths(new int[]{40, 20, 40}); 
	headTable.setWidthPercentage(100); 
	headTable.getDefaultCell().setPadding(0); 
	headTable.getDefaultCell().setBorder(0); 
	headTable.getDefaultCell().setBorderWidth(0); 
	
	headTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); 
	headTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
	headTable.getDefaultCell().setBorderWidth(0); 
	headTable.getDefaultCell().setColspan(3);
	headTable.addCell(new Phrase("Customer Responsibility Estimate",FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
	headTable.addCell(""); 
	headTable.addCell(getHeaderDetails()); 
	
	
	
	/*headTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	headTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
	headTable.addCell(new Phrase(rightHeader,FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL))); 
	headTable.addCell(new Phrase("\n\n\n\n\nCustomerID: 319816",FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL))); 
	headTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT); 
	headTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_UNDEFINED);
	headTable.addCell(new Phrase("Cust Status: UNREVIEWED ",FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL)));
	headTable.getDefaultCell().setBorderWidth(0); 
	headTable.getDefaultCell().setColspan(3); 
	headTable.addCell(""); 
	headTable.addCell(getYourNameInHeader()); 
	headTable.addCell(""); */
	return headTable;

}


private PdfPTable getHeaderDetails() throws DocumentException {
	String rightHeader =" Maruti Suzuki Company \n Vendor: Maruti \n Shop Location: Bangalore IN \n Car: IN KA 123123 \n Submit Date 3/3/2014 6:47:46 PM \n ";
	
	PdfPTable headerTable = new PdfPTable(3);
	headerTable.setWidths(new int[]{40, 20, 40});
	headerTable.setWidthPercentage(100);
	headerTable.getDefaultCell().setPadding(0); 
	headerTable.getDefaultCell().setBorder(0);
	headerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	headerTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
	headerTable.addCell(new Phrase(rightHeader,FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL))); 
	headerTable.addCell(new Phrase("\n\n\n\n\nCustomerID: 5584424",FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL))); 
	headerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT); 
	headerTable.addCell(new Phrase("Cust Status: UNREVIEWED ",FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL)));
	
	return headerTable;
	
}	
	





private PdfPTable getYourSpecialTable() throws DocumentException {

	PdfPTable specialTable = new PdfPTable(6); specialTable.setWidths(new int[]{63, 10, 5, 10, 5, 7});
	specialTable.setWidthPercentage(100); specialTable.getDefaultCell().setPadding(2);
	Font fontStyleHeaders = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD);
	specialTable.getDefaultCell().setColspan(1); specialTable.getDefaultCell().setBorderWidth(0.5f); 
	specialTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT); 
	//the following code will print the header row of the table specialTable.addCell("Header1"); 
	specialTable.addCell(new Phrase("Header2", fontStyleHeaders));
	specialTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT); 
	specialTable.addCell(new Phrase("Header3", fontStyleHeaders)); 
	specialTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT); 
	specialTable.addCell(new Phrase("Header4", fontStyleHeaders)); 
	specialTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT); 
	specialTable.addCell(new Phrase("Header5", fontStyleHeaders)); 
	specialTable.addCell(new Phrase("Header6", fontStyleHeaders));
	Font fontStyleCells = FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL);
	
	//this for loop should print 100 rows of the table
	
	for (int i = 0; i < 100; i++) { 
		specialTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT); 
		specialTable.addCell(new Phrase("Cell 1"+ i, fontStyleCells));
		specialTable.addCell(new Phrase("Cell 2"+ i, fontStyleCells)); 
		specialTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT); 
		specialTable.addCell(new Phrase("Cell 3"+ i, fontStyleCells)); 
		specialTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT); 
		specialTable.addCell(new Phrase("Cell 4"+ i, fontStyleCells)); 
		specialTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT); 
		specialTable.addCell(new Phrase("Cell 5"+ i, fontStyleCells));
		specialTable.addCell(new Phrase("Cell 6"+ i, fontStyleCells));
	}
	
	return specialTable;

}

private PdfPTable getYourNameInHeader() throws DocumentException {

	PdfPTable headerTable = new PdfPTable(3);
	headerTable.setWidths(new int[]{35, 35, 30});
	headerTable.setWidthPercentage(100);
	headerTable.getDefaultCell().setPadding(2); 
	headerTable.getDefaultCell().setBorderWidth(0);
	headerTable.addCell(new Phrase("Name: My Name", FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
	headerTable.addCell(new Phrase("Company: My Company", FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
	headerTable.addCell(new Phrase("Designation: My Designation", FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD))); 
	return headerTable; 
}

}
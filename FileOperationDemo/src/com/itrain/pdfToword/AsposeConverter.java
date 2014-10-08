package com.itrain.pdfToword;

public class AsposeConverter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Open the source PDF document
		com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document("C:\\Users\\mine\\Desktop\\TestJar\\test.pdf");

		// Save the file into Microsoft document format
		pdfDocument.save("C:\\Users\\mine\\Desktop\\TestJar\\test.doc",com.aspose.pdf.SaveFormat.Doc);


	}

}

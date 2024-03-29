package com.itrain.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileCopyNIO {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File in = new File("C:\\Users\\mine\\Desktop\\excelReadtest\\newStyle.xls");
		File on = new File("C:\\Users\\mine\\Desktop\\excelReadtest\\copyNewStyle.xls");
		fileCopy(in,on);
	}
	
	public static void fileCopy( File in, File out ) throws IOException     {
		FileChannel inChannel = new FileInputStream( in ).getChannel();         
		FileChannel outChannel = new FileOutputStream( out ).getChannel();         
		try        { 
			//          inChannel.transferTo(0, inChannel.size(), outChannel);
			// original -- apparently has trouble copying large files on Windows   
			// magic number for Windows, 64Mb - 32Kb)   
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = inChannel.size(); 
			long position = 0;   
			while ( position < size )             {
				position += inChannel.transferTo( position, maxCount, outChannel );
				} 
			}         
		finally        {             
			if ( inChannel != null )             {  
				inChannel.close();             
				}   
			if ( outChannel != null )             {  
				outChannel.close();  
				}        
			} 
		} 
		
}

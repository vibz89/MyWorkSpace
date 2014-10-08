package com.itrain.directory;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainDirTestClass {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Filter fil = new Filter();
		
		File[] filname = fil.finder("C:/Users/mine/Desktop/Working Folder/2014/");
		
		for (File file : filname) {
			

			System.out.println("file ::: "+ file.getName()+"   date --"+file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date(file.lastModified());
			 
			System.out.println("After Format : " + sdf.format(file.lastModified()));
//			System.out.println("whether great than ::" + (System.currentTimeMillis() - date.getTime() > 7 * 24 * 3600 * 1000));
			System.out.println("Current date ::" + sdf.format(System.currentTimeMillis()));
			
			
		}
	}

}

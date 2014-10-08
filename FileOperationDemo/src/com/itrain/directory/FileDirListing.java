package com.itrain.directory;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileDirListing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File dir = new File("C:\\Users\\mine\\Desktop\\AngularJS"); 
		  String[] children = dir.list(); 
		  if (children == null) { 
		      System.out.println("Either dir does not exist or is not a directory"); 
		  } else { 
			  System.out.println("Total files::"+children.length);
		      for (int i=0; i < children.length; i++) { 
		          // Get filename of file or directory 
		          String filename = children[i]; 
		          System.out.println("Filename:::"+filename);
		      } 
		  } 
		    
		  // It is also possible to filter the list of returned files. 
		  // This example does not return any files that start with `.'. 
		  FilenameFilter filter = new FilenameFilter() { 
		      public boolean accept(File dir, String name) { 
		          return !name.startsWith("."); 
		      } 
		  }; 
		  children = dir.list(filter); 
		    
		    
		  // The list of files can also be retrieved as File objects 
		  File[] files = dir.listFiles(); 
		    for (File file1 : files) {
				System.out.println(file1.getName());
			}
		  // This filter only returns directories 
		  FileFilter fileFilter = new FileFilter() { 
		      public boolean accept(File file) { 
		          return file.isDirectory(); 
		      } 
		  }; 
		  files = dir.listFiles(fileFilter);

	}
	
/*	// Process all files and directories under dir 
	 public static void visitAllDirsAndFiles(File dir) { 
	     process(dir); 
	   
	     if (dir.isDirectory()) { 
	         String[] children = dir.list(); 
	         for (int i=0; i<children.length; i++) { 
	             visitAllDirsAndFiles(new File(dir, children[i])); 
	         } 
	     } 
	 } 
	   
	 // Process only directories under dir 
	 public static void visitAllDirs(File dir) { 
	     if (dir.isDirectory()) { 
	         process(dir); 
	   
	         String[] children = dir.list(); 
	         for (int i=0; i<children.length; i++) { 
	             visitAllDirs(new File(dir, children[i])); 
	         } 
	     } 
	 } 
	   
	 // Process only files under dir 
	 public static void visitAllFiles(File dir) { 
	     if (dir.isDirectory()) { 
	         String[] children = dir.list(); 
	         for (int i=0; i<children.length; i++) { 
	             visitAllFiles(new File(dir, children[i])); 
	         } 
	     } else { 
	         process(dir); 
	     } 
	 }*/

}

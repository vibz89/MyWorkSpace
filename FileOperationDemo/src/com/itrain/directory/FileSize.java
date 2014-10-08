package com.itrain.directory;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class FileSize {

	public static void main(String[] args) {
		fileInfo(new File("C:/Users/mine/Documents/userdata/WIP/pdf/MergePDF.java"));
		fileInfo(new File("commons-codec-1.3.jar"));
		fileInfo(new File("BigFile.mp3"));
	}

	public static void fileInfo(File file) {
		System.out.println("File name: " + file.getName());
		long fileSize = file.length();
		System.out.println("File size: " + fileSize);
		String fileSizeDisplay = FileUtils.byteCountToDisplaySize(fileSize);
		System.out.println("Size Display: " + fileSizeDisplay);
		System.out.println();
	}
}

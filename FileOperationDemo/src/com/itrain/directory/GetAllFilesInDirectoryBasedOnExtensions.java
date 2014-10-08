package com.itrain.directory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GetAllFilesInDirectoryBasedOnExtensions {

	public static void main(String[] args) throws IOException {

		File dir = new File("C:/Users/mine/Desktop/Working Folder/2014/");
		String[] extensions = new String[] { "txt", "jsp" };
		System.out.println("Getting all .txt and .jsp files in " + dir.getCanonicalPath()
				+ " including those in subdirectories");
		List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
		for (File file : files) {
			System.out.println("file: " + file.getCanonicalPath());
		}

	}

}

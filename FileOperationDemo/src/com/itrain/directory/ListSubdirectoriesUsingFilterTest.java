package com.itrain.directory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.filefilter.DirectoryFileFilter;

public class ListSubdirectoriesUsingFilterTest {

	public static void main(String[] args) throws IOException {
		File directory = new File(".");
		File[] subdirs = directory.listFiles((FileFilter) DirectoryFileFilter.DIRECTORY);
		for (File dir : subdirs) {
			System.out.println("Directory: " + dir.getName());
		}

	}

}

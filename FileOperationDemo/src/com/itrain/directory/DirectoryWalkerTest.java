package com.itrain.directory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;

public class DirectoryWalkerTest {

	public static void main(String[] args) throws IOException {

		File dir = new File("C:/Users/mine/Desktop/Working Folder/2014/");

		MyDirectoryWalker walker = new MyDirectoryWalker();
		List<File> txtFiles = walker.getTxtFiles(dir);

		System.out.println("\nFiles ending with .txt with a depth of 3 or less");
		for (File txtFile : txtFiles) {
			System.out.println("file:" + txtFile.getCanonicalPath());
		}

	}

	public static class MyDirectoryWalker extends DirectoryWalker {
		public MyDirectoryWalker() {
			super();
		}

		public List<File> getTxtFiles(File dir) throws IOException {
			List<File> results = new ArrayList<File>();
			walk(dir, results);
			return results;
		}

		protected void handleFile(File file, int depth, Collection results) throws IOException {
			if (file.getCanonicalPath().endsWith(".txt")) {
				if (depth > 3) {
					System.out.println("depth is " + depth + ", so " + file.getCanonicalPath() + " will be skipped");
				} else {
					System.out.println("depth is " + depth + ", so " + file.getCanonicalPath() + " will be added");
					results.add(file);
				}
			} else {
				System.out.println("file doesn't end in .txt, so " + file.getCanonicalPath() + " will be skipped");
			}
		}

		protected boolean handleDirectory(File directory, int depth, Collection results) {
			return true;

		}
	}
}

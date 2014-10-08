package com.itrain.directory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.filefilter.HiddenFileFilter;

public class ListHiddenAndVisibleFilesTest {

	public static void main(String[] args) throws IOException {
		File directory = new File(".");

		System.out.println("Hidden Files:");
		File[] hiddenFiles = directory.listFiles((FileFilter) HiddenFileFilter.HIDDEN);
		for (File hiddenFile : hiddenFiles) {
			System.out.println("hidden file: " + hiddenFile.getCanonicalPath());
		}

		System.out.println("\nVisible Files:");
		File[] visibleFiles = directory.listFiles((FileFilter) HiddenFileFilter.VISIBLE);
		for (File visibleFile : visibleFiles) {
			System.out.println("visible file: " + visibleFile.getCanonicalPath());
		}
	}
}

package com.itrain.directory;

import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;

public class GetDriveFreeSpace {

	public static void main(String[] args) throws IOException {
		long freeSpaceKb = FileSystemUtils.freeSpaceKb("C:");
		System.out.println("Free space on C (in KB): " + freeSpaceKb);
	}

}

package com.sample1;

import java.nio.charset.StandardCharsets;

//https://www.youtube.com/watch?v=4j5_vLEhrkM

// No need to do any changes in provider or consumer



public class MultipleAdapterPatternWithFactory {

	public static String GDRIVE = "GDRIVE";
	public static String DROPBOX = "DROPBOX";

	public static void main(String args[]) {
		String fileName = "";
		IDownloader downloader = AdapterFactory.getAdapter(GDRIVE);
		System.out.println(new String(downloader.downloadFile(fileName), StandardCharsets.UTF_8));
		
		downloader = AdapterFactory.getAdapter(DROPBOX);
		System.out.println(new String(downloader.downloadFile(fileName), StandardCharsets.UTF_8));
	}

}

interface IDownloader {
	byte[] downloadFile(String fileName);
}


//GoogleDriveAdapter starts.........
	class GoogleDriveAdapter implements IDownloader {
		public byte[] downloadFile(String fileName) {
			GoogleDrive gDrive = new GoogleDrive();
			return gDrive.downloadFile(gDrive.signIn(), fileName);
		}
	}

	class GoogleDrive {

		public AuthToken signIn() {
			return new AuthToken("1234#pass");
		}

		public byte[] downloadFile(AuthToken authToken, String fileName) {
			return "GDRIVE_FILE".getBytes();
		}
	}

	class AuthToken {
		AuthToken(String authStr) {

		}
	}
	
//GoogleDriveAdapter ends.........

//DropBoxAdapter starts.........
	class DropBoxAdapter implements IDownloader {
		public byte[] downloadFile(String fileName) {
			DropBox dropBox = new DropBox();
			return dropBox.downloadFile(dropBox.getCredentials(), fileName);
		}
	}

class DropBox{
	
	public String[] getCredentials() {
		return new String[] {"userName","password"};
	}
	
	public byte[] downloadFile(String[] credentials, String fileName) {		
		return "DROPBOX_FILE".getBytes();
	}
}
//DropBoxAdapter ends.........

//get Adapter from Factory

class AdapterFactory {
	public static IDownloader getAdapter(String adapterType) {
		switch (adapterType) {
		case "GDRIVE":
			return new GoogleDriveAdapter();
		default:
			return new DropBoxAdapter();
		}
	}
}

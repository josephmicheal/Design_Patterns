package com.structural.adapter;


//https://www.youtube.com/watch?v=4j5_vLEhrkM

// No need to do any changes in provider or consumer

public class AdapterDesignPattern {

	public static void main(String args[]) {
		String fileName = "";
		IDownloader downloader = new AdapterDesignPattern().new GoogleDriveAdapter();
		downloader.downloadFile(fileName);
	}
	
	interface IDownloader{
		byte[] downloadFile(String fileName);
	}

	class GoogleDriveAdapter implements IDownloader{
		public byte[] downloadFile(String fileName) {
			GoogleDrive gDrive = new GoogleDrive();
			return gDrive.downloadFile(gDrive.signIn(), fileName);
		}
	}



	class GoogleDrive{
		
		public AuthToken signIn() {
			return new AuthToken("1234#pass");
		}
		
		public byte[] downloadFile(AuthToken authToken, String fileName) {
			
			return null;
		}
	}

	class AuthToken {
		AuthToken(String authStr){
			
		}
	}


}



package mybi.data;

import java.io.File;
import java.io.IOException;

public class MybiHandling {

	// 파일을 읽고 데이터베이스에 넣는다.
	// 0. 읽을 파일 검증
	// 1. 파일을 읽어서 arrayList<MabiRecord>에 넣는다 -->

	// 2. 파일을 다 변환 후 루핑
	// 2.1 객체를 하나하나 읽어서 addBatch()
	// 2.2 마지막 객체까지 끝나면
	// 2.3 executeBatch();

	// 3. 끝 ( 열린 모든 객체들을 닫는다)

	public static void main(String[] args) throws IOException {
		DataHandler dataHandler = new DataHandler();
		//System.out.println("args[0]=> " + args[0]);

		
		File dir = new File("/home/charisma0629/mybi/archive");
		if (dir.isDirectory()) {
			File[] subNote = dir.listFiles();
			for (File dirName : subNote) {
				System.out.println("dirName "+dirName);
				 
				for(File file :dirName.listFiles()) {
					System.out.println("file path "+file.getAbsolutePath());
					dataHandler.testReadDataFiles(file.getAbsolutePath());
				}
				
				 
			}
		}

	}

	
}

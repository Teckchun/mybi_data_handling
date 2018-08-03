package mybi.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import mybi.database.DatabaseManager;
import mybi.header.MybiHead;
import mybi.header.MybiRecord;
import mybi.header.MybiTailar;

/**
 * @author Administrator
 *
 */
public class DataHandler {

	private static final int FIXED_BYTE_SIZE = 260;
	private String fileName;
	private String path;
//	private String fileSize;
	private List<MybiRecord> list;
	/**
	 * @throws IOException
	 * 
	 */
	public void testReadDataFiles(String fileName) throws IOException {

		
		File file = new File(fileName);// 새로운 파일이 들어오면 이 파일명은 어떻게 바꿀까?

		//validate(file); // 파일 검증 1)file 존재 여부 2)260바이트씩 잘라서 들어오는지 여부

		FileInputStream inputStream = new FileInputStream(file);

		//System.out.println("file size: " + file.length());
		//System.out.println("byte 단위: " + FIXED_BYTE_SIZE);
		System.out.println("loop size: " + (file.length() / FIXED_BYTE_SIZE));

		byte[] b = new byte[FIXED_BYTE_SIZE];
	
		dataInputDB(inputStream, b,file);

	}

	private void dataInputDB(FileInputStream inputStream, byte[] b,File file) throws IOException {
		int count = 0;
		list=new ArrayList<>();

		MybiHead mybiHead = new MybiHead();
		MybiTailar mybiTailar = new MybiTailar();
		//MybiMata mybiMata = new MybiMata();

		DatabaseManager manager = new DatabaseManager();

		while ((count = inputStream.read(b)) != -1) {
			if (b[0] == 0x48) { // Head
				mybiHead.pack(b);
			} else if (b[0] == 0x44) { // record
				MybiRecord mybiRecord = new MybiRecord();
				if(b[1] != 0x20){
					String str = new String(b, "euc-kr");
					String subStr = str.substring(str.lastIndexOf("                                         ") + 41);
					str = str.substring(0,str.lastIndexOf("                                         ") + 41);
					b = (subStr + (str)).getBytes(Charset.forName("euc-kr"));
				}
				mybiRecord.pack(b);
				mybiRecord.setFileName(file.getAbsolutePath());
				mybiRecord.setRawRecord(new String(b, "euc-kr"));
				System.out.println("==> " + new String(b, "euc-kr"));
				list.add(mybiRecord);
			} else if (b[0] == 0x54) { // tail
				mybiTailar.pack(b);
			} else {
				//System.out.println("b[0]=식별할 수 없는 값." + count);
				// System.exit(-1); // 고민
			}

		}
		manager.RecordSQL(list);
		//mybiMata.setTitle(this.fileName);
		//mybiMata.setSize(this.fileSize);
		//mybiMata.setPath(this.path);
		//mybiMata.setUpdated();
		//mybiMata.setTime(file);
		
		
		//manager.MataSQL(mybiMata);
		

		if (inputStream != null) {
			inputStream.close();
		}

	}

	private void validate(File file) {
		
		if (file.isFile()) {
			long totalBytes = file.length();
			if ((totalBytes % FIXED_BYTE_SIZE) != 0) {
				System.err.println("파일 검증에러, 260 * N 이 아님");
				System.exit(-1);
			}
		} else {
			System.out.println("파일이 없습니다.");
			System.exit(-1);
		}
	}

	/**
	 * 
	 */
	public String fileInput() {

/*		SimpleDateFormat formatDateFormat = new SimpleDateFormat("MMdd", Locale.KOREA);
		Date date = new Date();

		String dTime = formatDateFormat.format(date);*/
		this.path = "Data/"; // filename: CBUS0101
		
		this.fileName = "CBUS0222"; // "CBUS" + dTime
		String absolute_path = path + fileName;

		return absolute_path;
	}

}

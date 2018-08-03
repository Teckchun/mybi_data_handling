package mybi.header;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MybiRecord {
   
   private byte[] DATA구분; //1   D
   private byte[] 사업자번호; //10
   private byte[] 운수사; //20
   private byte[] 카드거래일자; //8
   private byte[] 카드번호; //20
   private byte[] 카드거래시간; //6
   private byte[] 카드사구분; //2
   private byte[] 카드사명;//20
   private byte[] 단말코드;//8
   private byte[] 버스구분;//10
   private byte[] 차량번호;//20
   private byte[] 노선코드; //8
   private byte[] 정류장코드; //8
   private byte[] 정류장명; //30
   
   private byte[] 일반건수; //2
   private byte[] 학생건수; //2
   private byte[] 소인건수;// 2
   private byte[] 기타건수;// 2
   private byte[] 거래금액;//7
   private byte[] 환승FLAG;//3
   private byte[] 이전노선코드; //8
   
   private byte[] 이전거래일자; //8
   private byte[] 이전거래시간; //6
   private byte[] 이전정류장코드; //8
   private byte[] 이전정류장명; //30
   private byte[] FILLER; //11
   private String fileName;

   public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public void pack(byte[] subSize){
      this.DATA구분 = Arrays.copyOfRange(subSize, 0, 1);
      this.사업자번호 = Arrays.copyOfRange(subSize, 1, 11);
      this.운수사 = Arrays.copyOfRange(subSize, 11, 31);
      this.카드거래일자 = Arrays.copyOfRange(subSize, 31, 39);
      this.카드번호 = Arrays.copyOfRange(subSize, 39, 59);
      this.카드거래시간 = Arrays.copyOfRange(subSize, 59, 65);
      this.카드사구분 = Arrays.copyOfRange(subSize, 65, 67);
      this.카드사명 = Arrays.copyOfRange(subSize, 67, 87);
      this.단말코드 = Arrays.copyOfRange(subSize, 87, 95);
      this.버스구분 = Arrays.copyOfRange(subSize, 95, 105);
      this.차량번호 = Arrays.copyOfRange(subSize, 105, 125);
      this.노선코드 = Arrays.copyOfRange(subSize, 125, 133);
      this.정류장코드 = Arrays.copyOfRange(subSize, 133, 141);
      this.정류장명 = Arrays.copyOfRange(subSize, 141, 171);
      this.일반건수 = Arrays.copyOfRange(subSize, 171, 173);
      this.학생건수 = Arrays.copyOfRange(subSize, 173, 175);
      this.소인건수 = Arrays.copyOfRange(subSize, 175, 177);
      this.기타건수 = Arrays.copyOfRange(subSize, 177, 179);
      this.거래금액 = Arrays.copyOfRange(subSize, 179, 186);
      this.환승FLAG = Arrays.copyOfRange(subSize, 186, 189);
      this.이전노선코드 = Arrays.copyOfRange(subSize, 189, 197);
      this.이전거래일자 = Arrays.copyOfRange(subSize, 197, 205);
      this.이전거래시간 = Arrays.copyOfRange(subSize, 205, 211);
      this.이전정류장코드 = Arrays.copyOfRange(subSize, 211, 219);
      this.이전정류장명 = Arrays.copyOfRange(subSize, 219, 249);
      this.FILLER = Arrays.copyOfRange(subSize, 249, 260);
	   
	   // Based on Documentations
//	      this.DATA구분 = Arrays.copyOfRange(subSize, 0, 1);
//	      this.사업자번호 = Arrays.copyOfRange(subSize, 1, 11);
//	      this.운수사 = Arrays.copyOfRange(subSize, 11, 21);
//	      this.카드거래일자 = Arrays.copyOfRange(subSize, 21, 29);
//	      this.카드번호 = Arrays.copyOfRange(subSize, 29, 49);
//	      this.카드거래시간 = Arrays.copyOfRange(subSize, 49, 55);
//	      this.카드사구분 = Arrays.copyOfRange(subSize, 55, 57);
//	      this.카드사명 = Arrays.copyOfRange(subSize, 57, 69);
//	      this.단말코드 = Arrays.copyOfRange(subSize, 69, 77);
//	      this.버스구분 = Arrays.copyOfRange(subSize, 77, 87);
//	      this.차량번호 = Arrays.copyOfRange(subSize, 87, 97);
//	      this.노선코드 = Arrays.copyOfRange(subSize, 97, 117);
//	      this.정류장코드 = Arrays.copyOfRange(subSize, 117, 125);
//	      this.정류장명 = Arrays.copyOfRange(subSize, 125, 135);
//	      this.일반건수 = Arrays.copyOfRange(subSize, 135, 137);
//	      this.학생건수 = Arrays.copyOfRange(subSize, 137, 139);
//	      this.소인건수 = Arrays.copyOfRange(subSize, 139, 141);
//	      this.기타건수 = Arrays.copyOfRange(subSize, 141, 143);
//	      this.거래금액 = Arrays.copyOfRange(subSize, 143, 150);
//	      this.환승FLAG = Arrays.copyOfRange(subSize, 150, 153);
//	      this.이전노선코드 = Arrays.copyOfRange(subSize, 153, 155);
//	      this.이전거래일자 = Arrays.copyOfRange(subSize, 155, 162);
//	      this.이전거래시간 = Arrays.copyOfRange(subSize, 162, 164);
//	      this.이전정류장코드 = Arrays.copyOfRange(subSize, 164, 171);
//	      this.이전정류장명 = Arrays.copyOfRange(subSize, 171, 173);
//	      this.FILLER = Arrays.copyOfRange(subSize, 173, 180);
   }
   
   public byte[] getDATA구분() {
      return DATA구분;
   }

   public void setDATA구분(byte[] dATA구분) {
      DATA구분 = dATA구분;
   }

   public byte[] get사업자번호() {
      return 사업자번호;
   }

   public void set사업자번호(byte[] 사업자번호) {
      this.사업자번호 = 사업자번호;
   }

   public byte[] get운수사() {
      return 운수사;
   }

   public void set운수사(byte[] 운수사) {
      this.운수사 = 운수사;
   }

   public byte[] get카드거래일자() {
      return 카드거래일자;
   }

   public void set카드거래일자(byte[] 카드거래일자) {
      this.카드거래일자 = 카드거래일자;
   }

   public byte[] get카드번호() {
      return 카드번호;
   }

   public void set카드번호(byte[] 카드번호) {
      this.카드번호 = 카드번호;
   }

   public byte[] get카드거래시간() {
      return 카드거래시간;
   }

   public void set카드거래시간(byte[] 카드거래시간) {
      this.카드거래시간 = 카드거래시간;
   }

   public byte[] get카드사구분() {
      return 카드사구분;
   }

   public void set카드사구분(byte[] 카드사구분) {
      this.카드사구분 = 카드사구분;
   }

   public byte[] get카드사명() {
      return 카드사명;
   }

   public void set카드사명(byte[] 카드사명) {
      this.카드사명 = 카드사명;
   }

   public byte[] get단말코드() {
      return 단말코드;
   }

   public void set단말코드(byte[] 단말코드) {
      this.단말코드 = 단말코드;
   }

   public byte[] get버스구분() {
      return 버스구분;
   }

   public void set버스구분(byte[] 버스구분) {
      this.버스구분 = 버스구분;
   }

   public byte[] get차량번호() {
      return 차량번호;
   }

   public void set차량번호(byte[] 차량번호) {
      this.차량번호 = 차량번호;
   }

   public byte[] get노선코드() {
      return 노선코드;
   }

   public void set노선코드(byte[] 노선코드) {
      this.노선코드 = 노선코드;
   }

   public byte[] get정류장코드() {
      return 정류장코드;
   }

   public void set정류장코드(byte[] 정류장코드) {
      this.정류장코드 = 정류장코드;
   }

   public byte[] get정류장명() {
      return 정류장명;
   }

   public void set정류장명(byte[] 정류장명) {
      this.정류장명 = 정류장명;
   }

   public byte[] get일반건수() {
      return 일반건수;
   }

   public void set일반건수(byte[] 일반건수) {
      this.일반건수 = 일반건수;
   }

   public byte[] get학생건수() {
      return 학생건수;
   }

   public void set학생건수(byte[] 학생건수) {
      this.학생건수 = 학생건수;
   }

   public byte[] get소인건수() {
      return 소인건수;
   }

   public void set소인건수(byte[] 소인건수) {
      this.소인건수 = 소인건수;
   }

   public byte[] get기타건수() {
      return 기타건수;
   }

   public void set기타건수(byte[] 기타건수) {
      this.기타건수 = 기타건수;
   }

   public byte[] get거래금액() {
      return 거래금액;
   }

   public void set거래금액(byte[] 거래금액) {
      this.거래금액 = 거래금액;
   }

   public byte[] get환승FLAG() {
      return 환승FLAG;
   }

   public void set환승FLAG(byte[] 환승flag) {
      환승FLAG = 환승flag;
   }

   public byte[] get이전노선코드() {
      return 이전노선코드;
   }

   public void set이전노선코드(byte[] 이전노선코드) {
      this.이전노선코드 = 이전노선코드;
   }

   public byte[] get이전거래일자() {
      return 이전거래일자;
   }

   public void set이전거래일자(byte[] 이전거래일자) {
      this.이전거래일자 = 이전거래일자;
   }

   public byte[] get이전거래시간() {
      return 이전거래시간;
   }

   public void set이전거래시간(byte[] 이전거래시간) {
      this.이전거래시간 = 이전거래시간;
   }

   public byte[] get이전정류장코드() {
      return 이전정류장코드;
   }

   public void set이전정류장코드(byte[] 이전정류장코드) {
      this.이전정류장코드 = 이전정류장코드;
   }

   public byte[] get이전정류장명() {
      return 이전정류장명;
   }

   public void set이전정류장명(byte[] 이전정류장명) {
      this.이전정류장명 = 이전정류장명;
   }

   public byte[] getFILLER() {
      return FILLER;
   }

   public void setFILLER(byte[] fILLER) {
      FILLER = fILLER;
   }

   public byte[] unpack() throws IOException{
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      baos.write(DATA구분);
      baos.write(사업자번호);
      baos.write(운수사);
      baos.write(카드거래일자);
      baos.write(카드번호);
      baos.write(카드거래시간);
      baos.write(카드사구분);
      baos.write(카드사명);
      baos.write(단말코드);
      baos.write(버스구분);
      baos.write(차량번호);
      baos.write(노선코드);
      baos.write(정류장코드);
      baos.write(정류장명);
      baos.write(일반건수);
      baos.write(학생건수);
      baos.write(소인건수);
      baos.write(기타건수);
      baos.write(거래금액);
      baos.write(환승FLAG);
      baos.write(이전노선코드);
      baos.write(이전거래일자);
      baos.write(이전거래시간);
      baos.write(이전정류장코드);
      baos.write(이전정류장명);
      baos.write(FILLER);
      
      return baos.toByteArray();
      
   }

@Override
public String toString() {
	return "MybiRecord [DATA구분=" + Arrays.toString(DATA구분) + ", 사업자번호=" + Arrays.toString(사업자번호) + ", 운수사="
			+ Arrays.toString(운수사) + ", 카드거래일자=" + Arrays.toString(카드거래일자) + ", 카드번호=" + Arrays.toString(카드번호)
			+ ", 카드거래시간=" + Arrays.toString(카드거래시간) + ", 카드사구분=" + Arrays.toString(카드사구분) + ", 카드사명="
			+ Arrays.toString(카드사명) + ", 단말코드=" + Arrays.toString(단말코드) + ", 버스구분=" + Arrays.toString(버스구분) + ", 차량번호="
			+ Arrays.toString(차량번호) + ", 노선코드=" + Arrays.toString(노선코드) + ", 정류장코드=" + Arrays.toString(정류장코드)
			+ ", 정류장명=" + Arrays.toString(정류장명) + ", 일반건수=" + Arrays.toString(일반건수) + ", 학생건수=" + Arrays.toString(학생건수)
			+ ", 소인건수=" + Arrays.toString(소인건수) + ", 기타건수=" + Arrays.toString(기타건수) + ", 거래금액=" + Arrays.toString(거래금액)
			+ ", 환승FLAG=" + Arrays.toString(환승FLAG) + ", 이전노선코드=" + Arrays.toString(이전노선코드) + ", 이전거래일자="
			+ Arrays.toString(이전거래일자) + ", 이전거래시간=" + Arrays.toString(이전거래시간) + ", 이전정류장코드=" + Arrays.toString(이전정류장코드)
			+ ", 이전정류장명=" + Arrays.toString(이전정류장명) + ", FILLER=" + Arrays.toString(FILLER) + "]";
}


   
   
}

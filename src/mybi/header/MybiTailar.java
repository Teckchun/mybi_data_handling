package mybi.header;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MybiTailar {
   private byte[] DATA구분; //1  T
   private byte[] 정산일자; //8
   private byte[] 마이비가맹점번호; //15
   private byte[] 총거래건수; //7
   private byte[] 총거래금액; //9
   private byte[] FILLER; //220
   
   public byte[] getDATA구분() {
      return DATA구분;
   }

   public void setDATA구분(byte[] dATA구분) {
      DATA구분 = dATA구분;
   }

   public byte[] get정산일자() {
      return 정산일자;
   }

   public void set정산일자(byte[] 정산일자) {
      this.정산일자 = 정산일자;
   }

   public byte[] get마이비가맹점번호() {
      return 마이비가맹점번호;
   }

   public void set마이비가맹점번호(byte[] 마이비가맹점번호) {
      this.마이비가맹점번호 = 마이비가맹점번호;
   }

   public byte[] get총거래건수() {
      return 총거래건수;
   }

   public void set총거래건수(byte[] 총거래건수) {
      this.총거래건수 = 총거래건수;
   }

   public byte[] get총거래금액() {
      return 총거래금액;
   }

   public void set총거래금액(byte[] 총거래금액) {
      this.총거래금액 = 총거래금액;
   }

   public byte[] getFILLER() {
      return FILLER;
   }

   public void setFILLER(byte[] fILLER) {
      FILLER = fILLER;
   }

   public void pack(byte[] subSize){
      this.DATA구분 = Arrays.copyOfRange(subSize, 0, 1);
      this.정산일자 = Arrays.copyOfRange(subSize, 1, 9);
      this.마이비가맹점번호 = Arrays.copyOfRange(subSize, 9, 24);
      this.총거래건수 = Arrays.copyOfRange(subSize, 24, 31);
      this.총거래금액 = Arrays.copyOfRange(subSize, 31, 40);
      this.FILLER = Arrays.copyOfRange(subSize, 40, 260);

   }
   
   public byte[] unpack() throws IOException{
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      baos.write(DATA구분);
      baos.write(정산일자);
      baos.write(마이비가맹점번호);
      baos.write(총거래건수);
      baos.write(총거래금액);
      baos.write(FILLER);
      
      return baos.toByteArray();
      
   }
}

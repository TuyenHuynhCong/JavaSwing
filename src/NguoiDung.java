
import com.sun.xml.internal.bind.v2.model.core.ID;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class NguoiDung {
    private int ID, SoLuong, GiaNhap, GiaBan;
    private String TenHang;
    private Date NgayNhap, NgayHetHan;
  public NguoiDung(int ID,int SoLuong,int GiaNhap, int GiaBan, String TenHang, Date NgayNhap, Date NgayHetHan){
  
  this.ID=ID;
  this.SoLuong=SoLuong;
  this.GiaNhap=GiaNhap;
  this.GiaBan=GiaBan;
  this.TenHang=TenHang;
  this.NgayNhap=NgayNhap;
  this.NgayHetHan=NgayHetHan;
      
  }
  public int getID(){
      return ID;
  }
  public int getSoLuong(){
      return SoLuong;
  }
  public int getGiaNhap(){
      return GiaNhap;
  }
  public int getGiaBan(){
      return GiaBan;
  }
  public String getTenHang()
  {
      return TenHang;
  }
  public Date getNgayNhap(){
      return NgayNhap;
              
  }
  public Date getNgayHetHan()
  {
      return NgayHetHan;
  }
  
}


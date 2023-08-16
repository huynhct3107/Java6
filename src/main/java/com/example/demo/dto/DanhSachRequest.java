package com.example.demo.dto;

import com.example.demo.model.DanhSachYeuThich;
import com.example.demo.model.KhachHang;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class DanhSachRequest {
    public Date ngayTao;
    public Date ngayCapNhap;
    public String ghiChu;
    public Integer trangThai;
    public String maKhachHang;

    public DanhSachYeuThich map(DanhSachYeuThich ds) {
        ds.setNgayTao(this.getNgayTao());
        ds.setNgayCapNhap(this.getNgayCapNhap());
        ds.setGhiChu(this.getGhiChu());
        ds.setTrangThai(Integer.valueOf(this.getTrangThai()));
        ds.setKhachHang(KhachHang.builder()
                .maKhachHang(Long.valueOf(this.getMaKhachHang()))
                .build());
        return ds;
    }
}

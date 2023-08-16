package com.example.demo.repository;


import com.example.demo.dto.DanhSachCustom;
import com.example.demo.model.DanhSachYeuThich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhSachYeuThichRepository extends JpaRepository<DanhSachYeuThich, UUID> {
    @Query(value = "SELECT dbo.DanhSachYeuThich.MaDanhSach, dbo.DanhSachYeuThich.NgayTao, dbo.DanhSachYeuThich.NgayCapNhap, dbo.DanhSachYeuThich.GhiChu, dbo.DanhSachYeuThich.TrangThai, dbo.KhachHang.TenKhachHang, \n" +
            "                  dbo.KhachHang.GioiTinh\n" +
            "FROM     dbo.DanhSachYeuThich INNER JOIN\n" +
            "                  dbo.KhachHang ON dbo.DanhSachYeuThich.NguoiSoHuu = dbo.KhachHang.MaKhachHang", nativeQuery = true)
    List<DanhSachCustom> getCus();

    @Query(value = "SELECT dbo.DanhSachYeuThich.MaDanhSach, dbo.DanhSachYeuThich.NgayTao, dbo.DanhSachYeuThich.NgayCapNhap, dbo.DanhSachYeuThich.GhiChu, dbo.DanhSachYeuThich.TrangThai, dbo.KhachHang.TenKhachHang, \n" +
            "                  dbo.KhachHang.GioiTinh\n" +
            "FROM     dbo.DanhSachYeuThich INNER JOIN\n" +
            "                  dbo.KhachHang ON dbo.DanhSachYeuThich.NguoiSoHuu = dbo.KhachHang.MaKhachHang", nativeQuery = true)
    Page<DanhSachCustom> getCusAll(Pageable pageable);
}

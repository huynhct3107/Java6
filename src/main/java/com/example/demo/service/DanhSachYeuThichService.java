package com.example.demo.service;

import com.example.demo.dto.DanhSachCustom;
import com.example.demo.dto.DanhSachRequest;
import com.example.demo.model.DanhSachYeuThich;
import com.example.demo.model.KhachHang;
import com.example.demo.repository.DanhSachYeuThichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DanhSachYeuThichService {
    @Autowired
    private DanhSachYeuThichRepository repository;

    public Page<DanhSachYeuThich> getALl(Integer page) {
        Pageable pageable = PageRequest.of(page, 2);
        return repository.findAll(pageable);
    }

    public List<DanhSachYeuThich> getALls(Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return repository.findAll(pageable).getContent();
    }

    public List<DanhSachCustom> getCus() {
        return repository.getCus();
    }

    public List<DanhSachCustom> getCusAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return repository.getCusAll(pageable).getContent();
    }

    public DanhSachYeuThich add(DanhSachRequest request) {
        DanhSachYeuThich danhSachYeuThich = request.map(new DanhSachYeuThich());
        return repository.save(danhSachYeuThich);
    }

    public DanhSachYeuThich update(UUID ma, DanhSachRequest request) {
        Optional<DanhSachYeuThich> optional = repository.findById(ma);
        return optional.map(ds -> {
            ds.setNgayTao(request.getNgayTao());
            ds.setNgayCapNhap(request.getNgayCapNhap());
            ds.setGhiChu(request.getGhiChu());
            ds.setTrangThai(request.getTrangThai());
            ds.setKhachHang(KhachHang.builder()
                    .maKhachHang(Long.valueOf(request.getMaKhachHang()))
                    .build());
            return repository.save(ds);
        }).orElse(null);
    }

    public String delete(UUID ma) {
        Optional<DanhSachYeuThich> optional = repository.findById(ma);
        DanhSachYeuThich danhSachYeuThich = optional.orElse(null);
        if (danhSachYeuThich != null) {
            repository.delete(danhSachYeuThich);
            return "Thanh cong";
        } else {
            return "Khong tim thay ma";
        }
    }

    public DanhSachYeuThich detail(UUID ma) {
        Optional<DanhSachYeuThich> optional = repository.findById(ma);
        return optional.isPresent() ? optional.get() : null;
    }

    public List<DanhSachYeuThich> loc() {
        return repository.findAll().stream()
                .filter(o -> o.getTrangThai() >= 0 && o.getTrangThai() <= 1)
                .collect(Collectors.toList());
    }

    public DanhSachYeuThich max() {
        return repository.findAll().stream()
                .max(Comparator.comparing(DanhSachYeuThich::getNgayTao))
                .get();
    }
}

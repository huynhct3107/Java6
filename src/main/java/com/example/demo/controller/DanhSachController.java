package com.example.demo.controller;

import com.example.demo.dto.DanhSachRequest;
import com.example.demo.service.DanhSachYeuThichService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/danhSach")
public class DanhSachController {
    @Autowired
    private DanhSachYeuThichService service;

    @GetMapping("/pt1")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", value = "page") Integer page) {
        return ResponseEntity.ok(service.getALl(page));
    }

    @GetMapping("/pt2")
    public ResponseEntity<?> getAlls(@RequestParam(defaultValue = "0", value = "page") Integer page) {
        return ResponseEntity.ok(service.getALls(page));
    }

    @GetMapping("/pt4")
    public ResponseEntity<?> getCusAll(@RequestParam(defaultValue = "0", value = "page") Integer page) {
        return ResponseEntity.ok(service.getCusAll(page));
    }

    @GetMapping("/pt3")
    public ResponseEntity<?> getCus() {
        return ResponseEntity.ok(service.getCus());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid DanhSachRequest request, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.ok(service.add(request));
        }
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@RequestBody @Valid DanhSachRequest request, BindingResult result, @PathVariable UUID ma) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.ok(service.update(ma, request));
        }
    }

    @DeleteMapping("/remove/{ma}")
    public ResponseEntity<?> removes(@PathVariable UUID ma) {
        return ResponseEntity.ok(service.delete(ma));
    }

    @GetMapping("/detail/{ma}")
    public ResponseEntity<?> detail(@PathVariable UUID ma) {
        return ResponseEntity.ok(service.detail(ma));
    }

    @GetMapping("/loc")
    public ResponseEntity<?> loc() {
        return ResponseEntity.ok(service.loc());
    }

    @GetMapping("/max")
    public ResponseEntity<?> max() {
        return ResponseEntity.ok(service.max());
    }

}

package com.demo.component_scan.controller;

import com.demo.component_scan.dto.request.KMRequest;
import com.demo.component_scan.dto.response.KMResponse;
import com.demo.component_scan.service.KMService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/km")
@FieldDefaults(makeFinal = true)
@RequiredArgsConstructor
public class KMController {
    KMService service;

    @PostMapping
    public ResponseEntity<KMResponse> checkKm(@RequestBody KMRequest request){
        return ResponseEntity.ok(service.checkKM(request));
    }
}

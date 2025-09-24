package com.demo.component_scan.service;


import com.demo.component_scan.dto.request.KMRequest;
import com.demo.component_scan.dto.response.KMResponse;

public interface KMService {

    KMResponse checkKM(KMRequest request);
}

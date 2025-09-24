package com.demo.component_scan.mapper;

import com.demo.component_scan.dto.request.KMRequest;
import com.demo.component_scan.dto.response.KMResponse;
import org.mapstruct.Mapper;

@Mapper
public interface KMMapper {

    KMResponse toResponse(KMRequest request);
}

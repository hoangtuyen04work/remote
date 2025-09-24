package com.demo.component_scan.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class KMRequest {
    String KMCode;
    @NotBlank(message = "KM Name is required")
    String KMName;
}

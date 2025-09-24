package com.demo.component_scan.service;

import com.demo.component_scan.dto.request.KMRequest;
import com.demo.component_scan.dto.response.KMResponse;
import com.demo.component_scan.mapper.KMMapper;
import com.demo.component_scan.repo.KMRepository;
import com.demo.component_scan.utils.CodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true)
@RequiredArgsConstructor
public class KMServiceImpl implements KMService {
    KMRepository repository;
    KMMapper mapper;

    @Override
    public KMResponse checkKM(KMRequest request){
        checkKMCode(request);
        checkKMName(request);
        return mapper.toResponse(request);
    }

    private void checkKMName(KMRequest request){
        if(repository.coundKMName(request.getKMName()) != 1){
            throw new IllegalArgumentException("KM name is already exist");
        }
    }

    private void checkKMCode(KMRequest request){
        if(request.getKMCode() == null || request.getKMCode().isEmpty()){
            request.setKMCode(generateKMCode());
        }

        String NewKMCode = CodeGenerator.nextCode(request.getKMCode());
        if(repository.coundKMCode(request.getKMCode()) != 0){
            throw new IllegalArgumentException("KM code is already exist");
        }

        request.setKMCode(NewKMCode);
    }

    private String generateKMCode(){
        // thực hiện tạo mới KMCode ( e lấy KMCode lớn nhất ở DB rồi cộng vào)
        return repository.findFirstByKMCode()
                .orElse("00");
    }
}

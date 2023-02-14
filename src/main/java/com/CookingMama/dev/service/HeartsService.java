package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.dto.Hearts;
import com.CookingMama.dev.domain.request.AddHeartsRequest;
import com.CookingMama.dev.domain.response.HeartsResponse;
import com.CookingMama.dev.repository.HeartsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HeartsService {
    private final HeartsRepository heartsRepository;

    public Integer addHearts(AddHeartsRequest request){
        return heartsRepository.addHearts(request);

    }

    public List<HeartsResponse> showHearts(Integer userId){
        List<Hearts> hearts = heartsRepository.showHearts(userId);
        List<HeartsResponse> responses = hearts.stream()
                .map(HeartsResponse::new)
                .collect(Collectors.toList());
        return responses;
    }
}

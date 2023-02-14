package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.Hearts;
import com.CookingMama.dev.domain.request.AddHeartsRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeartsRepository {
    Integer addHearts(AddHeartsRequest request);

    List<Hearts> showHearts(Integer userId);
}

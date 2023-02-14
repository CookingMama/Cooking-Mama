package com.CookingMama.dev.repository;

import com.CookingMama.dev.domain.dto.Items;
import com.CookingMama.dev.domain.request.ItemRegistRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemRegistRepository {
    Integer insertItemRegist(ItemRegistRequest request);
}

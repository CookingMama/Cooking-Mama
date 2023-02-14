package com.CookingMama.dev.service;

import com.CookingMama.dev.domain.dto.Items;
import com.CookingMama.dev.domain.request.ItemRegistRequest;
import com.CookingMama.dev.repository.ItemRegistRepository;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemRegistService {
    private final ItemRegistRepository itemRegistRepository;

    public void insertItemRegist(ItemRegistRequest request){
        Integer items = itemRegistRepository.insertItemRegist(request);
    }

}

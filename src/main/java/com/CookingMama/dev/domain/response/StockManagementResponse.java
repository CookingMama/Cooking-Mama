package com.CookingMama.dev.domain.response;

import com.CookingMama.dev.domain.dto.Items;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor
public class StockManagementResponse {
    private String categoryName;
    private String itemName;
    private String itemOption;
    private Integer itemPrice;
    private String itemImage;
    private String itemInfo;
    private Integer itemCount;
}

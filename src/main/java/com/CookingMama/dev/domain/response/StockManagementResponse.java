package com.CookingMama.dev.domain.response;

import com.CookingMama.dev.domain.dto.Items;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor
public class StockManagementResponse {

    private String itemImage;
    private Integer category;
    private String itemName;
    private String itemOption;
    private Integer itemPrice;
    private Integer itemCount;
    public StockManagementResponse(Items items){
        this.itemImage = items.getItemImage();
        this.category = items.getCategory();
        this.itemName = items.getItemName();
        this.itemOption = items.getItemOption();
        this.itemPrice = items.getItemPrice();
        this.itemCount = items.getItemCount();
    }
}

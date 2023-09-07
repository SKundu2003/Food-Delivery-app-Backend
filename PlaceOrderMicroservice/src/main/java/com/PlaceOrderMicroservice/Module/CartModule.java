package com.PlaceOrderMicroservice.Module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartModule {
    private Integer cartId;
//    private Integer userId;
//    private Integer menuId;
//    private Integer restaurantId;
//    private String restaurantName;
    private String menuName;
    private Integer quantity;
    private Integer totalPrice;
}

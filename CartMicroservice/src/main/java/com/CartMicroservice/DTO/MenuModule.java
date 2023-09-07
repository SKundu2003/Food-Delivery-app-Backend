package com.CartMicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuModule {
    private Integer menuId;
    private Integer restaurantId;
    private String restaurantName;
    private String menuName;
    private Integer menuPrice;
}

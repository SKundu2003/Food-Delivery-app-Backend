package com.CartMicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdAndQuantityDTO {
    private Integer cartId;
    private Integer menuId;
    private Integer quantity;
}

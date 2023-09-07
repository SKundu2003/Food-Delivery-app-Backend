package com.PlaceOrderMicroservice.Module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_module")
public class OrderModule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    private Integer cartId;
    //    private Integer userId;
//    private Integer menuId;
//    private Integer restaurantId;
//    private String restaurantName;
    private String menuName;
    private Integer quantity;
    private Integer totalPrice;

}

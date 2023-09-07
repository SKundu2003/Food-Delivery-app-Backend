package com.CartMicroservice.Controller;

import com.CartMicroservice.Client.MenuItemFeignClient;
import com.CartMicroservice.DTO.IdAndQuantityDTO;
import com.CartMicroservice.DTO.MenuModule;
import com.CartMicroservice.Module.CartModule;
import com.CartMicroservice.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

@RestController
public class CartController {

    @Autowired
    private MenuItemFeignClient menuItemFeignClient;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/addCart")
    public String addCart(@RequestBody IdAndQuantityDTO idAndQuantityDTO) {
        MenuModule menuById = menuItemFeignClient.getMenuById(idAndQuantityDTO.getMenuId());
        int quantity = idAndQuantityDTO.getQuantity();
        int price = menuById.getMenuPrice();
        int totalPrice = quantity * price;

        String menuName = menuById.getMenuName();
        if (idAndQuantityDTO.getCartId() != null) {
            //if cart is already present then update the quantity and total price
            if (cartRepository.existsById(idAndQuantityDTO.getCartId())) {
                CartModule cartModule = cartRepository.findById(idAndQuantityDTO.getCartId()).get();
                quantity = cartModule.getQuantity() + quantity;
                cartModule.setQuantity(quantity);
                totalPrice = cartModule.getTotalPrice() + totalPrice;
                cartModule.setTotalPrice(totalPrice);
                menuName = cartModule.getMenuName() + " , " + menuName;
                cartModule.setMenuName(menuName);
                cartRepository.save(cartModule);
                return "Cart Updated Successfully" + "your cart id is " + cartModule.getCartId();
            }else{
                return "Cart Not Found";
            }
        }else{
            //if cart is not present then create a new cart
            CartModule cartModule = new CartModule();
            cartModule.setQuantity(quantity);
            cartModule.setTotalPrice(totalPrice);
            cartModule.setMenuName(menuName);
            cartRepository.save(cartModule);
            return "Cart Added Successfully" + "your cart id is " + cartModule.getCartId();
        }
    }

    @GetMapping("/getCartById/{cartId}")
    public CartModule getCartById(@PathVariable Integer cartId) {
        return cartRepository.findByCartId(cartId);
    }


    @Transactional
    @DeleteMapping("/deleteCartById/{cartId}")
    public String deleteCartById(@PathVariable Integer cartId) {
        cartRepository.deleteByCartId(cartId);
        return "Cart Deleted Successfully";
    }

}

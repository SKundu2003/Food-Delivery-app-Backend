package com.PlaceOrderMicroservice.Client;


import com.PlaceOrderMicroservice.Module.CartModule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Client side load balancing
@FeignClient("cartservice")
public interface CartServiceFeignClient {

    @GetMapping(value = "/getCartById/{cartId}",consumes = "application/int")
    public CartModule getCartById(@PathVariable Integer cartId);


    @DeleteMapping("/deleteCartById/{cartId}")
    public String deleteCartById(@PathVariable Integer cartId);
}

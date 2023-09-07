package com.CartMicroservice.Client;

import com.CartMicroservice.DTO.MenuModule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurantservice")
public interface MenuItemFeignClient {
    @GetMapping(value = "/menu/{menuId}",consumes = "application/int")
    public MenuModule getMenuById(@PathVariable Integer menuId);
}

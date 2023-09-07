package com.PlaceOrderMicroservice.Controller;

import com.PlaceOrderMicroservice.Client.CartServiceFeignClient;
import com.PlaceOrderMicroservice.Module.CartModule;
import com.PlaceOrderMicroservice.Module.OrderModule;
import com.PlaceOrderMicroservice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartServiceFeignClient cartServiceFeignClient;

    @GetMapping("/order/{cartId}")
    public String placeOrder(@PathVariable Integer cartId) {
        CartModule cartById = cartServiceFeignClient.getCartById(cartId);
//        System.out.println(cartById.getCartId());
        if (cartById != null) {
            OrderModule orderModule = new OrderModule();
            orderModule.setCartId(cartById.getCartId());
            orderModule.setMenuName(cartById.getMenuName());
            orderModule.setQuantity(cartById.getQuantity());
            orderModule.setTotalPrice(cartById.getTotalPrice());
            orderRepository.save(orderModule);
            //delete the cart after placing the order
            String s = cartServiceFeignClient.deleteCartById(cartId);
            return "Order Placed Successfully and " + s + " your order id is " + orderModule.getOrderId();
        } else {
            return "Cart Not Found";
        }
    }

    @GetMapping("/getOrderById/{orderId}")
    public OrderModule getOrderById(@PathVariable Integer orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @DeleteMapping("/deleteOrderById/{orderId}")
    public String deleteOrderById(@PathVariable Integer orderId) {
        orderRepository.deleteById(orderId);
        return "Order Deleted Successfully";
    }
}

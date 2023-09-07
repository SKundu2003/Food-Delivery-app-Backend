package com.PlaceOrderMicroservice.Repository;

import com.PlaceOrderMicroservice.Module.OrderModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModule, Integer> {
    public OrderModule findByOrderId(Integer orderId);

}

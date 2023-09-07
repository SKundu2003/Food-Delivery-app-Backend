package com.CartMicroservice.Repository;

import com.CartMicroservice.Module.CartModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartModule, Integer> {
    public CartModule findByCartId(Integer cartId);
    public void deleteByCartId(Integer cartId);
}

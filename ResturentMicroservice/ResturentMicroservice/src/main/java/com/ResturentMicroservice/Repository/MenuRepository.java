package com.ResturentMicroservice.Repository;

import com.ResturentMicroservice.Module.MenuModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuModule, Integer> {
    public List<MenuModule> findAllByRestaurantId(Integer restaurantId);
    public MenuModule findByMenuId(Integer menuId);
}

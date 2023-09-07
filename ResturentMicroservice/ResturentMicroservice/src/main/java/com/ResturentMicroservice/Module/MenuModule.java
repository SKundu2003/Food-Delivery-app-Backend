package com.ResturentMicroservice.Module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu_item")
public class MenuModule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer menuId;
    private Integer restaurantId;
    private String restaurantName;
    private String menuName;
    private Integer menuPrice;
}

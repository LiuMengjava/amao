package com.amao.springboot.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private Integer itemPrice;
}

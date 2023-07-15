package com.shop.shop.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;                      // 다대일 단방향

    @ManyToOne
    @JoinColumn(name = "order_id")          // 한 번의 주문에 여러 개의 상품을 주문하는 것을 고려
    private Order order;

    private int orderPrice;                 // 주문가격
    private int count;                      // 수량
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}

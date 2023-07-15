package com.shop.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="cart_item")
public class CartItem {

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne                              // 다대일 관계 매핑 (하나의 장바구니, 여러 개 상품)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne                              // 다대일 관계 매핑 (하나의 상품, 여러 장바구니의 장바구니 상품)
    @JoinColumn(name = "item_id")
    private Item item;

    private int count;                      // 같은 상품을 장바구니에 몇 개 담을지 저장

}

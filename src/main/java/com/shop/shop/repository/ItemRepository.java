package com.shop.shop.repository;

import com.shop.shop.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * 상품 조회
     */
    List<Item> findByItemNm(String itemNm);

    /**
     * 상품명과 상품 상세 설명을 OR 이용하여 조회
     */
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    /**
     * LessThan - 파라미터로 넘어온 price 변수보다 값이 작은 상품 데이터를 조회
     */
    List<Item> findByPriceLessThan(Integer price);

    /**
     * OrderBy로 정렬하기
     */
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    /**
     * @Query를 이용한 검색 처리
     */
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    /**
     * @Query-nativeQuery 속성을 활용
     */
    @Query(value = "select * from item i where i.item_detail like"
        + " %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

}

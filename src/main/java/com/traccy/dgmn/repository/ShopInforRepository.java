package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.ShopInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopInforRepository extends JpaRepository<ShopInformation, Long> {

  @Query(value = "select * from shop_infors si where si.status = 1", nativeQuery = true)
  ShopInformation getDefaultShopInformation();

  @Query(value = "select count(*) from shop_infors si", nativeQuery = true)
  int countNumberOfShop();

}

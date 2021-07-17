package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

  @Query(value = "select * from images i where i.product_id = ?1 and i.is_avatar = 1", nativeQuery = true)
  Image getAvatar(long productId);

  @Query(value = "select * from images i where i.product_id = ?1 and i.is_avatar = 0", nativeQuery = true)
  List<Image> getOptionalImage(long productId);
}

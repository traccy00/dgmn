package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}

package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Unit;

public interface UnitService {

  boolean checkExistById(long id);

  Unit getUnitByName(String name);

  void saveUnit(Unit unit);
}

package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Unit;

public interface UnitService {

  boolean checkExistById(long id);

  Unit getUnitByName(String name);

  Unit saveUnit(Unit unit);

  Unit getUnitById(long id);
}

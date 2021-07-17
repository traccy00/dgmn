package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.entity.Unit;
import com.traccy.dgmn.repository.UnitRepository;
import com.traccy.dgmn.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {

  @Autowired
  UnitRepository unitRepository;

  @Override
  public boolean checkExistById(long id) {
    return unitRepository.existsById(id);
  }

  @Override
  public Unit getUnitByName(String name) {
    return unitRepository.findByName(name);
  }

  @Override
  public Unit saveUnit(Unit unit) {
    Unit unit1 = unitRepository.save(unit);
    return unit1;
  }

  @Override
  public Unit getUnitById(long id) {
    return unitRepository.findById(id);
  }
}

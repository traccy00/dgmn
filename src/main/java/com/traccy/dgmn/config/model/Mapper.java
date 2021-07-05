package com.traccy.dgmn.config.model;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Mapper {

  public static <T, R> R copyFrom(T from, Class<R> type) {
    Class<R> typeResponseClass = type;

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    R response = modelMapper.map(from, typeResponseClass);

    return response;
  }
}

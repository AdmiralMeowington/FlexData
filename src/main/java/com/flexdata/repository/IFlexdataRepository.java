package com.flexdata.repository;

import com.flexdata.model.FlexdataEntity;

import java.util.List;

public interface IFlexdataRepository {
    FlexdataEntity getByHash(String hash);
    List<FlexdataEntity> getListOfPublicAndAlive(int amount);
    void add(FlexdataEntity entity);
}

package com.flexdata.repository;

import com.flexdata.exeptions.NotFoundFlexdataEntityException;
import com.flexdata.model.FlexdataEntity;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlexdataRepositoryLocalStorage implements IFlexdataRepository{

    private final Map<String,FlexdataEntity> _storageLocal = new ConcurrentHashMap<>();
    @Override
    public FlexdataEntity getByHash(String hash) {
        FlexdataEntity pasteEntity = _storageLocal.get(hash);
        if(pasteEntity == null){
            throw new NotFoundFlexdataEntityException("Paste not found with hash: "+hash);
        }
        return pasteEntity;
    }

    @Override
    public List<FlexdataEntity> getListOfPublicAndAlive(int amount) {
        LocalDateTime currentTime = LocalDateTime.now();

        return _storageLocal.values().stream()
                .filter(FlexdataEntity::getIsPublic)
                .filter(pasteEntity-> pasteEntity.getExpirationTime().isAfter(currentTime))
                .sorted(Comparator.comparing(FlexdataEntity::getId).reversed())
                .limit(amount)
                .toList();
    }

    @Override
    public void add(FlexdataEntity entity) {
        _storageLocal.put(entity.getHash(), entity);
    }
}

package com.flexdata.service;

import com.flexdata.api.mapper.FlexdataMapper;
import com.flexdata.api.properties.FlexdataServiceProperties;
import com.flexdata.api.request.IFlexdataRequest;
import com.flexdata.api.responce.FlexdataUrlResponse;
import com.flexdata.api.responce.IFlexdataResponse;
import com.flexdata.api.responce.IFlexdataUrlResponse;
import com.flexdata.exeptions.NotFoundFlexdataEntityException;
import com.flexdata.model.FlexdataEntity;
import com.flexdata.repository.IFlexdataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class FlexdataService implements IFlexdataService{

    private final FlexdataServiceProperties _properties;
    private final IFlexdataRepository _repository;
    private final FlexdataMapper _mapper;
    private AtomicInteger idGenerator = new AtomicInteger(0);
    @Override
    public IFlexdataResponse getByHash(String hash) {
        FlexdataEntity entity = _repository.getByHash(hash);
        if (entity == null) {
            System.out.println("No paste found with hash: " + hash);
            throw new NotFoundFlexdataEntityException("No paste found with hash: " + hash);
        }
        return _mapper.toResponse(entity);
    }

    @Override
    public List<IFlexdataResponse> getRecentPublicPosts() {
        List<FlexdataEntity> list = _repository.getListOfPublicAndAlive(_properties.getPublicListSize());
        return _mapper.toResponseList(list);
    }

    @Override
    public IFlexdataUrlResponse createNew(IFlexdataRequest request) {
        int hash = generateId();
        String hashString = Integer.toHexString(hash);

        FlexdataEntity entity = _mapper.toEntity(request, hash, hashString);
        _repository.add(entity);

        return new FlexdataUrlResponse(_properties.getHost() + "/" + entity.getHash());
    }
    private int generateId() {
        return idGenerator.getAndIncrement();
    }
}

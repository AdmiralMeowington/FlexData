package com.flexdata.api.mapper;

import com.flexdata.api.request.IFlexdataRequest;
import com.flexdata.api.request.PublicStatus;
import com.flexdata.api.responce.FlexdataResponse;
import com.flexdata.api.responce.IFlexdataResponse;
import com.flexdata.model.FlexdataEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlexdataMapper {
    public IFlexdataResponse toResponse(FlexdataEntity entity) {
        return new FlexdataResponse(entity.getData(), entity.getIsPublic());
    }

    public List<IFlexdataResponse> toResponseList(List<FlexdataEntity> entities) {
        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public FlexdataEntity toEntity(IFlexdataRequest request, int id, String hash) {
        FlexdataEntity entity = new FlexdataEntity();
        entity.setId(id);
        entity.setHash(hash);
        entity.setData(request.getData());
        entity.setIsPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        entity.setExpirationTime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        return entity;
    }
}

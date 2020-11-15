package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.FeatureRepo;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.error.NotFoundException;
import ir.cliqmind.am.mapper.FeatureBuilder;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {

    private static final Logger log = LoggerFactory.getLogger(FeatureServiceImpl.class);

    @Autowired
    private FeatureRepo featureRepo;

    private FeatureBuilder featureBuilder;

    private ResponseMessageBuilder responseMessageBuilder;

    @Autowired
    public FeatureServiceImpl(){
        featureBuilder = new FeatureBuilder();
        responseMessageBuilder = new ResponseMessageBuilder();
    }

    @Override
    public Feature add(AddFeatureRequest body) {
        ir.cliqmind.am.domain.Feature newEntity = featureRepo.save(featureBuilder.add(body, true));
        return featureBuilder.feature(newEntity, 0);
    }

    @Override
    public ResponseMessage edit(EditFeatureRequest body) {
        ir.cliqmind.am.domain.Feature entity = findFeature(body.getId());
        if(entity == null){
            throw new NotFoundException("feature does not exist");
        }
        entity.setName(body.getName());
        entity.setDescription(body.getDescription());
        featureRepo.save(entity);
        return responseMessageBuilder.success();
    }

    @Override
    public ResponseMessage activate(ActivateFeatureRequest body) {
        return activate(body.getId(), true);
    }

    @Override
    public ResponseMessage deactivate(DeactivateFeatureRequest body) {
        return activate(body.getId(), false);
    }

    @Override
    public GetFeaturesResponse get(GetFeaturesRequest body) {
        return featureBuilder.get(featureRepo.find(body.getIds(), body.isActive()));
    }

    @Override
    public GetActiveFeaturesResponse getActive(GetActiveFeaturesRequest body) {
        return null;
    }

    private ResponseMessage activate(Integer id, boolean active){
        ir.cliqmind.am.domain.Feature entity = findFeature(id);
        if(entity == null){
            throw new NotFoundException("feature does not exist");
        }
        entity.setActive(active);
        featureRepo.save(entity);
        return responseMessageBuilder.success();
    }

    private ir.cliqmind.am.domain.Feature findFeature(Integer id){
        return featureRepo.findById(id).orElse(null);
    }

}

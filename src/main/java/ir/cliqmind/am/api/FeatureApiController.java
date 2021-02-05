package ir.cliqmind.am.api;

import ir.cliqmind.am.dao.FeatureRepo;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.error.NotFoundException;
import ir.cliqmind.am.error.ValidationException;
import ir.cliqmind.am.mapper.FeatureMapper;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import ir.cliqmind.am.utils.PaginationUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/feature")
public class FeatureApiController {

    @Autowired
    private FeatureRepo featureRepo;

    private FeatureMapper featureMapper;

    private ResponseMessageBuilder responseMessageBuilder;

    @Autowired
    public FeatureApiController(){
        featureMapper = new FeatureMapper();
        responseMessageBuilder = new ResponseMessageBuilder();
    }

    @Transactional
    @PutMapping("/{id}/activate")
    public ResponseEntity<ResponseMessage> activateFeature(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(activate(id, true), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<ResponseMessage> deactivateFeature(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(activate(id, false), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("")
    public ResponseEntity<Feature> addFeature(@Valid @RequestBody AddFeatureRequest body) {
        ir.cliqmind.am.domain.Feature newEntity = featureRepo.save(featureMapper.add(body, true));
        Feature response = featureMapper.feature(newEntity, 0);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> editFeature(@PathVariable("id") Integer id, @Valid @RequestBody EditFeatureRequest body) {
        ir.cliqmind.am.domain.Feature entity = featureRepo.findById(id).orElseThrow(() -> new NotFoundException("feature does not exist"));
        entity.setName(body.getName());
        entity.setDescription(body.getDescription());
        featureRepo.save(entity);
        return new ResponseEntity<>(responseMessageBuilder.success(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/active")
    public ResponseEntity<Features> getActiveFeatures(@Valid GetActiveFeaturesRequest body) {
        if(body.getOwnerId()==null){
            throw new ValidationException("ownerid is empty");
        }
        Features response = featureMapper.features(featureRepo.getActive(body.getOwnerId()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("")
    public ResponseEntity<Features> getFeatures(GetFeaturesRequest body, Pageable pageable) {
        List<Integer> ids = body.getIds();
        if(ids!=null && ids.size() == 0){
            ids = null;
        }
        Page<ir.cliqmind.am.domain.Feature> page = featureRepo.find(ids, body.isActive(), pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(featureMapper.features(page.getContent()));
    }

    private ResponseMessage activate(Integer id, boolean active){
        ir.cliqmind.am.domain.Feature entity = featureRepo.findById(id).orElseThrow(() -> new NotFoundException("feature does not exist"));
        entity.setActive(active);
        featureRepo.save(entity);
        return responseMessageBuilder.success();
    }

}

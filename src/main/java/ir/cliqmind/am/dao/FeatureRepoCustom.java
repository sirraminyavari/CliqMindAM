package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Feature;

import java.util.List;
import java.util.UUID;

public interface FeatureRepoCustom {

    List<Feature> getActive(UUID ownerId);

}

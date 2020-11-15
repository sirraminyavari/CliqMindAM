package ir.cliqmind.am.service;

public interface FeatureService {

    ir.cliqmind.am.dto.Feature add(ir.cliqmind.am.dto.AddFeatureRequest body);

    ir.cliqmind.am.dto.ResponseMessage edit(ir.cliqmind.am.dto.EditFeatureRequest body);

    ir.cliqmind.am.dto.ResponseMessage activate(ir.cliqmind.am.dto.ActivateFeatureRequest body);

    ir.cliqmind.am.dto.ResponseMessage deactivate(ir.cliqmind.am.dto.DeactivateFeatureRequest body);

    ir.cliqmind.am.dto.GetFeaturesResponse get(ir.cliqmind.am.dto.GetFeaturesRequest body);

    ir.cliqmind.am.dto.GetActiveFeaturesResponse getActive(ir.cliqmind.am.dto.GetActiveFeaturesRequest body);

}

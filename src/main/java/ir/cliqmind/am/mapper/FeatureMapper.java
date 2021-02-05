package ir.cliqmind.am.mapper;

public class FeatureMapper {

    public ir.cliqmind.am.domain.Feature add(ir.cliqmind.am.dto.AddFeatureRequest input, boolean active){
        ir.cliqmind.am.domain.Feature result = new ir.cliqmind.am.domain.Feature();
        result.setDescription(input.getDescription());
        result.setName(input.getName());
        result.setActive(active);
        return result;
    }

    public ir.cliqmind.am.dto.Feature feature(ir.cliqmind.am.domain.Feature input, int amount){
        return new ir.cliqmind.am.dto.Feature()
                .active(input.getActive())
                .amount(amount)
                .description(input.getDescription())
                .id(input.getId())
                .name(input.getName());
    }

    public ir.cliqmind.am.dto.Features features(Iterable<ir.cliqmind.am.domain.Feature> input) {
        ir.cliqmind.am.dto.Features result = new ir.cliqmind.am.dto.Features();
        input.forEach(f -> result.add(feature(f,0)));
        return result;
    }

}

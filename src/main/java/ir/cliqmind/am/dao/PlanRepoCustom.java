package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Plan;

public interface PlanRepoCustom {

    Plan add(Plan plan);

    void edit(Plan plan);

    void setFeatures(Plan plan);

    void setPrice(Plan plan);

}

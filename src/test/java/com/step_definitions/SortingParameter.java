package com.step_definitions;

import com.structure.SortingType;
import io.cucumber.java.ParameterType;

public class SortingParameter {
    @ParameterType(".*")
    public SortingType sort_type(String sort_type) {
        sort_type= sort_type.replace("\"","");
        for (SortingType sortingType : SortingType.values()){
            if (sortingType.getValue().equals(sort_type)){
                return sortingType;
            }
        }
        throw new IllegalArgumentException("sort type not found");
    }

}

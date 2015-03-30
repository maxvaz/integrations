package com.dridco.inmuebles.zz;

import java.io.Serializable;

/**
 * 
 * @author mtaboada
 * 
 */
public enum ProviderUserPermission implements Serializable {

    PUBLISH_POST {
        @Override
        public RealEstateTypeEnum getRealEstateTypeApply() {
            return RealEstateTypeEnum.BUILDING_UNIT;
        }
    },
    PUBLISH_BP_POST {
        @Override
        public RealEstateTypeEnum getRealEstateTypeApply() {
            return RealEstateTypeEnum.BUILDING_PROJECT;
        }
    };

    public abstract RealEstateTypeEnum getRealEstateTypeApply();
}

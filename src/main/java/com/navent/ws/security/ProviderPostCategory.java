package com.navent.ws.security;

/**
 * @author pfenoglio
 * @author aobara
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
public enum ProviderPostCategory {
    ZP, SOM, EXTERNAL, DMAPAS;

    public static ProviderPostCategory getByProviderId(Long id) {
        switch (id.intValue()) {
        case ProviderPost.DEFAULT_POST_PROVIDER_ID_AS_INT:
        case 2:
        case 3:
        case 4:
            return ZP;
        case 6:
        case 7:
            return DMAPAS;
        case 5:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
            return SOM;
        case 8:
            return EXTERNAL;
        case 100:
            /* MERCADOI */
            return EXTERNAL;
        case ProviderPost.M2_POST_PROVIDER_ID_AS_INT:
            /* ROBOT COLOMBIA */
            return EXTERNAL;
        default:
            return EXTERNAL;
        }
    }

    public boolean isInternal() {
        return this == ZP;
    }

}

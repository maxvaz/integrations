package com.dridco.inmuebles.zz;

import org.apache.commons.lang.StringUtils;

public class BusinessDomain {

	private String countryCode;

	public BusinessDomain(String pais) {
		if (StringUtils.isEmpty(pais)) {
			countryCode = "AR";
		}
		this.countryCode = pais;
	}
	
	public String getCountryCode() {
		return countryCode;
	}

}

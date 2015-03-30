package com.dridco.inmuebles.zz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.validation.AbstractErrors;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class SimpleErrors extends AbstractErrors {
	private static final long serialVersionUID = 1L;
	private final List<FieldError> fieldErrors;
	private final List<ObjectError> globalErrors;
	private final String objectName;
	private final Object target;

	public SimpleErrors(String objectName, Object target) {
		this.objectName = objectName;
		this.target = target;
		this.fieldErrors = new ArrayList<>();
		this.globalErrors = new ArrayList<>();
	}

	@Override
	public void addAllErrors(Errors errors) {
		this.fieldErrors.addAll(errors.getFieldErrors());
	}

	@Override
	public List<FieldError> getFieldErrors() {
		return Collections.unmodifiableList(this.fieldErrors);
	}

	@Override
	public Object getFieldValue(String field) {
		try {
			return PropertyUtils.getProperty(this.target, field);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ObjectError> getGlobalErrors() {
		return Collections.unmodifiableList(this.globalErrors);
	}

	@Override
	public String getObjectName() {
		return this.objectName;
	}

	@Override
	public void reject(String errorCode, Object[] errorArgs,
			String defaultMessage) {
		ObjectError error = new ObjectError(this.getNestedPath(),
				new String[] { errorCode }, errorArgs, defaultMessage);

		this.globalErrors.add(error);
	}

	@Override
	public void rejectValue(String field, String errorCode, Object[] errorArgs,
			String defaultMessage) {
		FieldError error = new FieldError(this.getObjectName() + "."
				+ this.getNestedPath(), field, this.getFieldValue(field),
				false, new String[] { errorCode }, errorArgs, defaultMessage);

		this.fieldErrors.add(error);
	}

}

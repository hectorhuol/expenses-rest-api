package com.financial.analisys.expenses.rest.api.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.financial.analisys.expenses.api.exceptions.TechnicalException;

public class BOUtils {
	
	private BOUtils(){}

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T transformObject(Object objectSource,
			Class<T> destinationType) {
		try {
			String json = getJSON(objectSource);
			T type = objectMapper.readValue(json, destinationType);
			return type;

		} catch (Exception e) {
			throw new TechnicalException("The object could not be transformed",
					e);
		}
	}

	public static <T> List<T> transformObjectList(Object objectSource,
			Class<T> destinationType) {
		try {
			String json = getJSON(objectSource);
			CollectionType javaType = objectMapper.getTypeFactory()
					.constructCollectionType(List.class, destinationType);
			List<T> type = objectMapper.readValue(json, javaType);
			return type;

		} catch (Exception e) {
			throw new TechnicalException("The list could not be transformed", e);
		}
	}

	public static <T> T transformObject(Object objectSource,
			Class<T> destinationType, String[] excludedFields) {
		try {
			String json = getJSON(objectSource);
			json = excludeFields(json, excludedFields);
			T type = objectMapper.readValue(json, destinationType);
			return type;

		} catch (Exception e) {
			throw new TechnicalException("The object could not be transformed",
					e);
		}
	}

	public static <T> List<T> transformObjectList(Object objectSource,
			Class<T> destinationType, String[] excludedFields) {
		try {
			String json = getJSON(objectSource);
			json = excludeFields(json, excludedFields);
			CollectionType javaType = objectMapper.getTypeFactory()
					.constructCollectionType(List.class, destinationType);
			List<T> type = objectMapper.readValue(json, javaType);
			return type;

		} catch (Exception e) {
			throw new TechnicalException("The list could not be transformed", e);
		}
	}

	private static String getJSON(Object objectSource)
			throws JsonProcessingException {
		String json = null;
		if (objectSource != null)
			json = objectMapper.writeValueAsString(objectSource);
		return json;
	}

	public static boolean isObjectNull(Object object) {
		return object != null;
	}

	private static String excludeFields(String json, String[] excludedFields){
		String newJSON = null;
		for (String field : excludedFields) {
			newJSON = getReplaceFieldValue(field, json);
		}
		return newJSON;
	}

	private static String getReplaceFieldValue(String field, String json) {
		String regEx = "\"" + field + "\":\"[^,]*\"";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(json);
		String newJSON = deleteField(matcher);
		return (newJSON == null) ? json : newJSON;
	}

	private static String deleteField(Matcher matcher) {
		if (matcher.find())
			return matcher.replaceAll("").replace("{,", "{").replace(",}", "}")
					.replace(",,", ",");
		return null;
	}
}

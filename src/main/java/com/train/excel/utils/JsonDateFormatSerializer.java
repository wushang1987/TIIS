package com.train.excel.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateFormatSerializer extends JsonSerializer<Date> {

	/**
	 * 
	 */
	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		String datStr = new SimpleDateFormat(DateFormatStrConstants.DATE_FORMAT_STR).format(value);
		gen.writeString(datStr);
	}

}

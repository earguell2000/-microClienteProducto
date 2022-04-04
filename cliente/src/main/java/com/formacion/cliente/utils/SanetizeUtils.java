package com.formacion.cliente.utils;

import javax.annotation.Generated;

import org.apache.commons.lang.StringEscapeUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.HtmlUtils;

/**
 * The Class SanetizeUtils.
 */
@Generated(value = "")
public class SanetizeUtils {

	/** The Constant ERROR. */
	private static final String ERROR = "ERROR";

	/** Logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SanetizeUtils.class);

	/**
	 * Sanetize string.
	 *
	 * @param input the input
	 * @return the string
	 */
	public String sanetize(String input) {
		String result = null;
		try {
			result = ESAPI.encoder().encodeForHTML(HtmlUtils.htmlEscape(
					(ESAPI.validator().getValidInput("Validation", input, "SafeString", Integer.MAX_VALUE, false)))
					.replace('\n', '_').replace('\r', '_'));
		} catch (org.owasp.esapi.errors.ValidationException e) {
			LOGGER.error(ERROR, e);
			throw new RuntimeException("Error al sanetizar string");
		}
		result = StringEscapeUtils.unescapeHtml(result);
		return StringEscapeUtils.unescapeHtml(result);
	}
	
	/**
	 * Sanetize headers.
	 *
	 * @param header the header
	 * @return the string
	 */
	public String sanetizeHeaders(String header) {
		String result = null;
		try {
			result = ESAPI.encoder().encodeForHTML(HtmlUtils.htmlEscape(
					ESAPI.validator().getValidInput("Validacion", header, "SafeString", Integer.MAX_VALUE, false)))
					.replace('\n', '_').replace('\r', '_').replaceAll("\\n\r", "");
		} catch (IntrusionException e) {
			LOGGER.error(ERROR, e);
			throw new RuntimeException("Error al sanetizar headers, Intrusion");
		} catch (ValidationException e) {
			LOGGER.error(ERROR, e);
			throw new RuntimeException("Error al sanetizar headers, Validation");
		}
		result = StringEscapeUtils.unescapeHtml(result);
		return StringEscapeUtils.unescapeHtml(result);
	}


}

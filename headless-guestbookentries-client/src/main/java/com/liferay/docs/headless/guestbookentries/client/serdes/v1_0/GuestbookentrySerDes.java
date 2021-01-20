package com.liferay.docs.headless.guestbookentries.client.serdes.v1_0;

import com.liferay.docs.headless.guestbookentries.client.dto.v1_0.Guestbookentry;
import com.liferay.docs.headless.guestbookentries.client.json.BaseJSONParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

/**
 * @author dmetz
 * @generated
 */
@Generated("")
public class GuestbookentrySerDes {

	public static Guestbookentry toDTO(String json) {
		GuestbookentryJSONParser guestbookentryJSONParser =
			new GuestbookentryJSONParser();

		return guestbookentryJSONParser.parseToDTO(json);
	}

	public static Guestbookentry[] toDTOs(String json) {
		GuestbookentryJSONParser guestbookentryJSONParser =
			new GuestbookentryJSONParser();

		return guestbookentryJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Guestbookentry guestbookentry) {
		if (guestbookentry == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (guestbookentry.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append(String.valueOf(guestbookentry.getCreator()));
		}

		if (guestbookentry.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(guestbookentry.getEmail()));

			sb.append("\"");
		}

		if (guestbookentry.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append("\"");

			sb.append(_escape(guestbookentry.getId()));

			sb.append("\"");
		}

		if (guestbookentry.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(guestbookentry.getMessage()));

			sb.append("\"");
		}

		if (guestbookentry.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(guestbookentry.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		GuestbookentryJSONParser guestbookentryJSONParser =
			new GuestbookentryJSONParser();

		return guestbookentryJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Guestbookentry guestbookentry) {
		if (guestbookentry == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (guestbookentry.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(guestbookentry.getCreator()));
		}

		if (guestbookentry.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(guestbookentry.getEmail()));
		}

		if (guestbookentry.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(guestbookentry.getId()));
		}

		if (guestbookentry.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(guestbookentry.getMessage()));
		}

		if (guestbookentry.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(guestbookentry.getName()));
		}

		return map;
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static class GuestbookentryJSONParser
		extends BaseJSONParser<Guestbookentry> {

		@Override
		protected Guestbookentry createDTO() {
			return new Guestbookentry();
		}

		@Override
		protected Guestbookentry[] createDTOArray(int size) {
			return new Guestbookentry[size];
		}

		@Override
		protected void setField(
			Guestbookentry guestbookentry, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					guestbookentry.setCreator(
						CreatorSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					guestbookentry.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					guestbookentry.setId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					guestbookentry.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					guestbookentry.setName((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}
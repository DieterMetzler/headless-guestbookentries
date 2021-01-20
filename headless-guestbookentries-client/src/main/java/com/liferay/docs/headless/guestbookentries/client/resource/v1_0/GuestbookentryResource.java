package com.liferay.docs.headless.guestbookentries.client.resource.v1_0;

import com.liferay.docs.headless.guestbookentries.client.dto.v1_0.Guestbookentry;
import com.liferay.docs.headless.guestbookentries.client.http.HttpInvoker;
import com.liferay.docs.headless.guestbookentries.client.pagination.Page;
import com.liferay.docs.headless.guestbookentries.client.pagination.Pagination;
import com.liferay.docs.headless.guestbookentries.client.serdes.v1_0.GuestbookentrySerDes;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author dmetz
 * @generated
 */
@Generated("")
public class GuestbookentryResource {

	public static Page<Guestbookentry> getGuestbookentriesPage(
			String search, String filterString, Pagination pagination,
			String sortString)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			getGuestbookentriesPageHttpResponse(
				search, filterString, pagination, sortString);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, GuestbookentrySerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse getGuestbookentriesPageHttpResponse(
			String search, String filterString, Pagination pagination,
			String sortString)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		if (search != null) {
			httpInvoker.parameter("search", String.valueOf(search));
		}

		if (filterString != null) {
			httpInvoker.parameter("filter", filterString);
		}

		if (pagination != null) {
			httpInvoker.parameter("page", String.valueOf(pagination.getPage()));
			httpInvoker.parameter(
				"pageSize", String.valueOf(pagination.getPageSize()));
		}

		if (sortString != null) {
			httpInvoker.parameter("sort", sortString);
		}

		httpInvoker.path(
			"http://localhost:8080/o/headless-guestbookentries/v1.0/guestbookentries");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Guestbookentry postGuestbookentry(
			Guestbookentry guestbookentry)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = postGuestbookentryHttpResponse(
			guestbookentry);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return GuestbookentrySerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse postGuestbookentryHttpResponse(
			Guestbookentry guestbookentry)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(guestbookentry.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/headless-guestbookentries/v1.0/guestbookentries");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteGuestbookentry(String entryId) throws Exception {
		HttpInvoker.HttpResponse httpResponse =
			deleteGuestbookentryHttpResponse(entryId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteGuestbookentryHttpResponse(
			String entryId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/headless-guestbookentries/v1.0/guestbookentries/{entryId}",
			entryId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Guestbookentry getGuestbookentry(String entryId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = getGuestbookentryHttpResponse(
			entryId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return GuestbookentrySerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getGuestbookentryHttpResponse(
			String entryId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/headless-guestbookentries/v1.0/guestbookentries/{entryId}",
			entryId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Guestbookentry patchGuestbookentry(
			String entryId, Guestbookentry guestbookentry)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = patchGuestbookentryHttpResponse(
			entryId, guestbookentry);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return GuestbookentrySerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse patchGuestbookentryHttpResponse(
			String entryId, Guestbookentry guestbookentry)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(guestbookentry.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PATCH);

		httpInvoker.path(
			"http://localhost:8080/o/headless-guestbookentries/v1.0/guestbookentries/{entryId}",
			entryId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Guestbookentry putGuestbookentry(
			String entryId, Guestbookentry guestbookentry)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = putGuestbookentryHttpResponse(
			entryId, guestbookentry);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return GuestbookentrySerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putGuestbookentryHttpResponse(
			String entryId, Guestbookentry guestbookentry)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(guestbookentry.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/headless-guestbookentries/v1.0/guestbookentries/{entryId}",
			entryId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		GuestbookentryResource.class.getName());

}
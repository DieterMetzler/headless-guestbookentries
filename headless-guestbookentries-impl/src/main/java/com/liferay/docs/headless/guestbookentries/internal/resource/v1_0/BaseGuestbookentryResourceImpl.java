package com.liferay.docs.headless.guestbookentries.internal.resource.v1_0;

import com.liferay.docs.headless.guestbookentries.dto.v1_0.Guestbookentry;
import com.liferay.docs.headless.guestbookentries.resource.v1_0.GuestbookentryResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author dmetz
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseGuestbookentryResourceImpl
	implements GuestbookentryResource {

	@Override
	@GET
	@Operation(
		description = "Retrieves the list of guestbookentries. Results can be paginated, filtered, searched, and sorted."
	)
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "search"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/guestbookentries")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Guestbookentry")})
	public Page<Guestbookentry> getGuestbookentriesPage(
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Create a new Guestbookentry.")
	@POST
	@Path("/guestbookentries")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Guestbookentry")})
	public Guestbookentry postGuestbookentry(Guestbookentry guestbookentry)
		throws Exception {

		return new Guestbookentry();
	}

	@Override
	@DELETE
	@Operation(
		description = "Deletes the Guestbookentry and returns a 204 if the operation succeeds."
	)
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "entryId")})
	@Path("/guestbookentries/{entryId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Guestbookentry")})
	public void deleteGuestbookentry(
			@NotNull @Parameter(hidden = true) @PathParam("entryId") String
				entryId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Retrieves the guestbookentry via its ID.")
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "entryId")})
	@Path("/guestbookentries/{entryId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Guestbookentry")})
	public Guestbookentry getGuestbookentry(
			@NotNull @Parameter(hidden = true) @PathParam("entryId") String
				entryId)
		throws Exception {

		return new Guestbookentry();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(
		description = "Replaces the Guestbookentry with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	@PATCH
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "entryId")})
	@Path("/guestbookentries/{entryId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Guestbookentry")})
	public Guestbookentry patchGuestbookentry(
			@NotNull @Parameter(hidden = true) @PathParam("entryId") String
				entryId,
			Guestbookentry guestbookentry)
		throws Exception {

		Guestbookentry existingGuestbookentry = getGuestbookentry(entryId);

		if (guestbookentry.getEmail() != null) {
			existingGuestbookentry.setEmail(guestbookentry.getEmail());
		}

		if (guestbookentry.getMessage() != null) {
			existingGuestbookentry.setMessage(guestbookentry.getMessage());
		}

		if (guestbookentry.getName() != null) {
			existingGuestbookentry.setName(guestbookentry.getName());
		}

		preparePatch(guestbookentry, existingGuestbookentry);

		return putGuestbookentry(entryId, existingGuestbookentry);
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(
		description = "Replaces the Guestbookentry with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	@PUT
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "entryId")})
	@Path("/guestbookentries/{entryId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Guestbookentry")})
	public Guestbookentry putGuestbookentry(
			@NotNull @Parameter(hidden = true) @PathParam("entryId") String
				entryId,
			Guestbookentry guestbookentry)
		throws Exception {

		return new Guestbookentry();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(
		Guestbookentry guestbookentry, Guestbookentry existingGuestbookentry) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}
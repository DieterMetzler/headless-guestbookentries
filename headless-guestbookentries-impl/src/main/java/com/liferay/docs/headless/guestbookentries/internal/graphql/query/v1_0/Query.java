package com.liferay.docs.headless.guestbookentries.internal.graphql.query.v1_0;

import com.liferay.docs.headless.guestbookentries.dto.v1_0.Guestbookentry;
import com.liferay.docs.headless.guestbookentries.resource.v1_0.GuestbookentryResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author dmetz
 * @generated
 */
@Generated("")
public class Query {

	public static void setGuestbookentryResourceComponentServiceObjects(
		ComponentServiceObjects<GuestbookentryResource>
			guestbookentryResourceComponentServiceObjects) {

		_guestbookentryResourceComponentServiceObjects =
			guestbookentryResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Guestbookentry> getGuestbookentriesPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_guestbookentryResourceComponentServiceObjects,
			this::_populateResourceContext,
			guestbookentryResource -> {
				Page paginationPage =
					guestbookentryResource.getGuestbookentriesPage(
						search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Guestbookentry getGuestbookentry(
			@GraphQLName("entryId") String entryId)
		throws Exception {

		return _applyComponentServiceObjects(
			_guestbookentryResourceComponentServiceObjects,
			this::_populateResourceContext,
			guestbookentryResource -> guestbookentryResource.getGuestbookentry(
				entryId));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			GuestbookentryResource guestbookentryResource)
		throws Exception {

		guestbookentryResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<GuestbookentryResource>
		_guestbookentryResourceComponentServiceObjects;

}
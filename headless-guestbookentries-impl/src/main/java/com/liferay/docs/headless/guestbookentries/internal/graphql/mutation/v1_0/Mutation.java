package com.liferay.docs.headless.guestbookentries.internal.graphql.mutation.v1_0;

import com.liferay.docs.headless.guestbookentries.dto.v1_0.Guestbookentry;
import com.liferay.docs.headless.guestbookentries.resource.v1_0.GuestbookentryResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author dmetz
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setGuestbookentryResourceComponentServiceObjects(
		ComponentServiceObjects<GuestbookentryResource>
			guestbookentryResourceComponentServiceObjects) {

		_guestbookentryResourceComponentServiceObjects =
			guestbookentryResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Guestbookentry postGuestbookentry(
			@GraphQLName("guestbookentry") Guestbookentry guestbookentry)
		throws Exception {

		return _applyComponentServiceObjects(
			_guestbookentryResourceComponentServiceObjects,
			this::_populateResourceContext,
			guestbookentryResource -> guestbookentryResource.postGuestbookentry(
				guestbookentry));
	}

	@GraphQLInvokeDetached
	public void deleteGuestbookentry(@GraphQLName("entryId") String entryId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_guestbookentryResourceComponentServiceObjects,
			this::_populateResourceContext,
			guestbookentryResource ->
				guestbookentryResource.deleteGuestbookentry(entryId));
	}

	@GraphQLInvokeDetached
	public Guestbookentry patchGuestbookentry(
			@GraphQLName("entryId") String entryId,
			@GraphQLName("guestbookentry") Guestbookentry guestbookentry)
		throws Exception {

		return _applyComponentServiceObjects(
			_guestbookentryResourceComponentServiceObjects,
			this::_populateResourceContext,
			guestbookentryResource ->
				guestbookentryResource.patchGuestbookentry(
					entryId, guestbookentry));
	}

	@GraphQLInvokeDetached
	public Guestbookentry putGuestbookentry(
			@GraphQLName("entryId") String entryId,
			@GraphQLName("guestbookentry") Guestbookentry guestbookentry)
		throws Exception {

		return _applyComponentServiceObjects(
			_guestbookentryResourceComponentServiceObjects,
			this::_populateResourceContext,
			guestbookentryResource -> guestbookentryResource.putGuestbookentry(
				entryId, guestbookentry));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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
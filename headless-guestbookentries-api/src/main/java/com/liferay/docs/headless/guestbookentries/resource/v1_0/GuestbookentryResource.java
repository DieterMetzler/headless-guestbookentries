package com.liferay.docs.headless.guestbookentries.resource.v1_0;

import com.liferay.docs.headless.guestbookentries.dto.v1_0.Guestbookentry;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-guestbookentries/v1.0
 *
 * @author dmetz
 * @generated
 */
@Generated("")
public interface GuestbookentryResource {

	public Page<Guestbookentry> getGuestbookentriesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public Guestbookentry postGuestbookentry(Guestbookentry guestbookentry)
		throws Exception;

	public void deleteGuestbookentry(String entryId) throws Exception;

	public Guestbookentry getGuestbookentry(String entryId) throws Exception;

	public Guestbookentry patchGuestbookentry(
			String entryId, Guestbookentry guestbookentry)
		throws Exception;

	public Guestbookentry putGuestbookentry(
			String entryId, Guestbookentry guestbookentry)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}
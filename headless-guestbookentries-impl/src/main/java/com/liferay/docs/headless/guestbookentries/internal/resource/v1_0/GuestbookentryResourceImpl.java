package com.liferay.docs.headless.guestbookentries.internal.resource.v1_0;

import com.liferay.docs.guestbook.service.GuestbookEntryService;
import com.liferay.docs.headless.guestbookentries.resource.v1_0.GuestbookentryResource;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author dmetz
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/guestbookentry.properties",
	scope = ServiceScope.PROTOTYPE, service = GuestbookentryResource.class
)
public class GuestbookentryResourceImpl extends BaseGuestbookentryResourceImpl {
	
	@Override
	public void deleteGuestbookentry(@NotNull String entryId) throws Exception {
	  // super easy case, just pass through to the service layer.
	  _guestbookEntryService.deleteGuestbookEntry(entryId);
	}
	
	@Reference
	private GuestbookEntryService _guestbookEntryService;

}
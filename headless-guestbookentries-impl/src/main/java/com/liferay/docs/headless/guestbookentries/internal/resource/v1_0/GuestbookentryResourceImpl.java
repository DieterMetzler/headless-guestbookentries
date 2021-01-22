package com.liferay.docs.headless.guestbookentries.internal.resource.v1_0;

import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.docs.guestbook.service.GuestbookEntryService;
import com.liferay.docs.headless.guestbookentries.dto.v1_0.Guestbookentry;
import com.liferay.docs.headless.guestbookentries.resource.v1_0.GuestbookentryResource;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		try {
	  // super easy case, just pass through to the service layer.
	  _guestbookEntryService.deleteGuestbookEntry(entryId);
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public Guestbookentry getGuestbookentry(@NotNull String entryId) throws Exception {
		try {
			// fetch the entity class...
			GuestbookEntry pge = _guestbookEntryService.getGuestbookEntry(entryId);

			return _toGuestbookEntry(pge);
		} catch (Exception e) {
			_log.error("Error getting guestbookentry [" + entryId + "]: " + e.getMessage(), e);
			throw e;
		}
	}
	
	protected Guestbookentry _toGuestbookEntry(GuestbookEntry pge) throws Exception {
		return new Guestbookentry() {{
			name = pge.getName();
			email = pge.getEmail();
			message = pge.getMessage();
			id = pge.getSurrogateId();
		}};
	}
	
	@Reference
	private GuestbookEntryService _guestbookEntryService;
	
	private static final Logger _log = LoggerFactory.getLogger(GuestbookentryResourceImpl.class);
	
}
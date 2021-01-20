package com.liferay.docs.headless.guestbookentries.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author dmetz
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/headless-guestbookentries",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=HeadlessGuestbookentries"
	},
	service = Application.class
)
@Generated("")
public class HeadlessGuestbookentriesApplication extends Application {
}
package com.liferay.docs.headless.guestbookentries.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.docs.headless.guestbookentries.client.dto.v1_0.Guestbookentry;
import com.liferay.docs.headless.guestbookentries.client.http.HttpInvoker;
import com.liferay.docs.headless.guestbookentries.client.pagination.Page;
import com.liferay.docs.headless.guestbookentries.client.pagination.Pagination;
import com.liferay.docs.headless.guestbookentries.client.resource.v1_0.GuestbookentryResource;
import com.liferay.docs.headless.guestbookentries.client.serdes.v1_0.GuestbookentrySerDes;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author dmetz
 * @generated
 */
@Generated("")
public abstract class BaseGuestbookentryResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();
		testLocale = LocaleUtil.getDefault();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		Guestbookentry guestbookentry1 = randomGuestbookentry();

		String json = objectMapper.writeValueAsString(guestbookentry1);

		Guestbookentry guestbookentry2 = GuestbookentrySerDes.toDTO(json);

		Assert.assertTrue(equals(guestbookentry1, guestbookentry2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		Guestbookentry guestbookentry = randomGuestbookentry();

		String json1 = objectMapper.writeValueAsString(guestbookentry);
		String json2 = GuestbookentrySerDes.toJSON(guestbookentry);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetGuestbookentriesPage() throws Exception {
		Guestbookentry guestbookentry1 =
			testGetGuestbookentriesPage_addGuestbookentry(
				randomGuestbookentry());

		Guestbookentry guestbookentry2 =
			testGetGuestbookentriesPage_addGuestbookentry(
				randomGuestbookentry());

		Page<Guestbookentry> page =
			GuestbookentryResource.getGuestbookentriesPage(
				null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(guestbookentry1, guestbookentry2),
			(List<Guestbookentry>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetGuestbookentriesPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Guestbookentry guestbookentry1 = randomGuestbookentry();

		guestbookentry1 = testGetGuestbookentriesPage_addGuestbookentry(
			guestbookentry1);

		for (EntityField entityField : entityFields) {
			Page<Guestbookentry> page =
				GuestbookentryResource.getGuestbookentriesPage(
					null,
					getFilterString(entityField, "between", guestbookentry1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(guestbookentry1),
				(List<Guestbookentry>)page.getItems());
		}
	}

	@Test
	public void testGetGuestbookentriesPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Guestbookentry guestbookentry1 =
			testGetGuestbookentriesPage_addGuestbookentry(
				randomGuestbookentry());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Guestbookentry guestbookentry2 =
			testGetGuestbookentriesPage_addGuestbookentry(
				randomGuestbookentry());

		for (EntityField entityField : entityFields) {
			Page<Guestbookentry> page =
				GuestbookentryResource.getGuestbookentriesPage(
					null, getFilterString(entityField, "eq", guestbookentry1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(guestbookentry1),
				(List<Guestbookentry>)page.getItems());
		}
	}

	@Test
	public void testGetGuestbookentriesPageWithPagination() throws Exception {
		Guestbookentry guestbookentry1 =
			testGetGuestbookentriesPage_addGuestbookentry(
				randomGuestbookentry());

		Guestbookentry guestbookentry2 =
			testGetGuestbookentriesPage_addGuestbookentry(
				randomGuestbookentry());

		Guestbookentry guestbookentry3 =
			testGetGuestbookentriesPage_addGuestbookentry(
				randomGuestbookentry());

		Page<Guestbookentry> page1 =
			GuestbookentryResource.getGuestbookentriesPage(
				null, null, Pagination.of(1, 2), null);

		List<Guestbookentry> guestbookentries1 =
			(List<Guestbookentry>)page1.getItems();

		Assert.assertEquals(
			guestbookentries1.toString(), 2, guestbookentries1.size());

		Page<Guestbookentry> page2 =
			GuestbookentryResource.getGuestbookentriesPage(
				null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Guestbookentry> guestbookentries2 =
			(List<Guestbookentry>)page2.getItems();

		Assert.assertEquals(
			guestbookentries2.toString(), 1, guestbookentries2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(guestbookentry1, guestbookentry2, guestbookentry3),
			new ArrayList<Guestbookentry>() {
				{
					addAll(guestbookentries1);
					addAll(guestbookentries2);
				}
			});
	}

	@Test
	public void testGetGuestbookentriesPageWithSortDateTime() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Guestbookentry guestbookentry1 = randomGuestbookentry();
		Guestbookentry guestbookentry2 = randomGuestbookentry();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				guestbookentry1, entityField.getName(),
				DateUtils.addMinutes(new Date(), -2));
		}

		guestbookentry1 = testGetGuestbookentriesPage_addGuestbookentry(
			guestbookentry1);

		guestbookentry2 = testGetGuestbookentriesPage_addGuestbookentry(
			guestbookentry2);

		for (EntityField entityField : entityFields) {
			Page<Guestbookentry> ascPage =
				GuestbookentryResource.getGuestbookentriesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(guestbookentry1, guestbookentry2),
				(List<Guestbookentry>)ascPage.getItems());

			Page<Guestbookentry> descPage =
				GuestbookentryResource.getGuestbookentriesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(guestbookentry2, guestbookentry1),
				(List<Guestbookentry>)descPage.getItems());
		}
	}

	@Test
	public void testGetGuestbookentriesPageWithSortString() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Guestbookentry guestbookentry1 = randomGuestbookentry();
		Guestbookentry guestbookentry2 = randomGuestbookentry();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				guestbookentry1, entityField.getName(), "Aaa");
			BeanUtils.setProperty(
				guestbookentry2, entityField.getName(), "Bbb");
		}

		guestbookentry1 = testGetGuestbookentriesPage_addGuestbookentry(
			guestbookentry1);

		guestbookentry2 = testGetGuestbookentriesPage_addGuestbookentry(
			guestbookentry2);

		for (EntityField entityField : entityFields) {
			Page<Guestbookentry> ascPage =
				GuestbookentryResource.getGuestbookentriesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(guestbookentry1, guestbookentry2),
				(List<Guestbookentry>)ascPage.getItems());

			Page<Guestbookentry> descPage =
				GuestbookentryResource.getGuestbookentriesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(guestbookentry2, guestbookentry1),
				(List<Guestbookentry>)descPage.getItems());
		}
	}

	protected Guestbookentry testGetGuestbookentriesPage_addGuestbookentry(
			Guestbookentry guestbookentry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostGuestbookentry() throws Exception {
		Guestbookentry randomGuestbookentry = randomGuestbookentry();

		Guestbookentry postGuestbookentry =
			testPostGuestbookentry_addGuestbookentry(randomGuestbookentry);

		assertEquals(randomGuestbookentry, postGuestbookentry);
		assertValid(postGuestbookentry);
	}

	protected Guestbookentry testPostGuestbookentry_addGuestbookentry(
			Guestbookentry guestbookentry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteGuestbookentry() throws Exception {
		Guestbookentry guestbookentry =
			testDeleteGuestbookentry_addGuestbookentry();

		assertHttpResponseStatusCode(
			204,
			GuestbookentryResource.deleteGuestbookentryHttpResponse(
				guestbookentry.getId()));

		assertHttpResponseStatusCode(
			404,
			GuestbookentryResource.getGuestbookentryHttpResponse(
				guestbookentry.getId()));

		assertHttpResponseStatusCode(
			404, GuestbookentryResource.getGuestbookentryHttpResponse(0L));
	}

	protected Guestbookentry testDeleteGuestbookentry_addGuestbookentry()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetGuestbookentry() throws Exception {
		Guestbookentry postGuestbookentry =
			testGetGuestbookentry_addGuestbookentry();

		Guestbookentry getGuestbookentry =
			GuestbookentryResource.getGuestbookentry(
				postGuestbookentry.getEntryId());

		assertEquals(postGuestbookentry, getGuestbookentry);
		assertValid(getGuestbookentry);
	}

	protected Guestbookentry testGetGuestbookentry_addGuestbookentry()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPatchGuestbookentry() throws Exception {
		Guestbookentry postGuestbookentry =
			testPatchGuestbookentry_addGuestbookentry();

		Guestbookentry randomPatchGuestbookentry = randomPatchGuestbookentry();

		Guestbookentry patchGuestbookentry =
			GuestbookentryResource.patchGuestbookentry(
				postGuestbookentry.getId(), randomPatchGuestbookentry);

		Guestbookentry expectedPatchGuestbookentry =
			(Guestbookentry)BeanUtils.cloneBean(postGuestbookentry);

		_beanUtilsBean.copyProperties(
			expectedPatchGuestbookentry, randomPatchGuestbookentry);

		Guestbookentry getGuestbookentry =
			GuestbookentryResource.getGuestbookentry(
				patchGuestbookentry.getId());

		assertEquals(expectedPatchGuestbookentry, getGuestbookentry);
		assertValid(getGuestbookentry);
	}

	protected Guestbookentry testPatchGuestbookentry_addGuestbookentry()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutGuestbookentry() throws Exception {
		Guestbookentry postGuestbookentry =
			testPutGuestbookentry_addGuestbookentry();

		Guestbookentry randomGuestbookentry = randomGuestbookentry();

		Guestbookentry putGuestbookentry =
			GuestbookentryResource.putGuestbookentry(
				postGuestbookentry.getId(), randomGuestbookentry);

		assertEquals(randomGuestbookentry, putGuestbookentry);
		assertValid(putGuestbookentry);

		Guestbookentry getGuestbookentry =
			GuestbookentryResource.getGuestbookentry(putGuestbookentry.getId());

		assertEquals(randomGuestbookentry, getGuestbookentry);
		assertValid(getGuestbookentry);
	}

	protected Guestbookentry testPutGuestbookentry_addGuestbookentry()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Guestbookentry guestbookentry1, Guestbookentry guestbookentry2) {

		Assert.assertTrue(
			guestbookentry1 + " does not equal " + guestbookentry2,
			equals(guestbookentry1, guestbookentry2));
	}

	protected void assertEquals(
		List<Guestbookentry> guestbookentries1,
		List<Guestbookentry> guestbookentries2) {

		Assert.assertEquals(guestbookentries1.size(), guestbookentries2.size());

		for (int i = 0; i < guestbookentries1.size(); i++) {
			Guestbookentry guestbookentry1 = guestbookentries1.get(i);
			Guestbookentry guestbookentry2 = guestbookentries2.get(i);

			assertEquals(guestbookentry1, guestbookentry2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Guestbookentry> guestbookentries1,
		List<Guestbookentry> guestbookentries2) {

		Assert.assertEquals(guestbookentries1.size(), guestbookentries2.size());

		for (Guestbookentry guestbookentry1 : guestbookentries1) {
			boolean contains = false;

			for (Guestbookentry guestbookentry2 : guestbookentries2) {
				if (equals(guestbookentry1, guestbookentry2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				guestbookentries2 + " does not contain " + guestbookentry1,
				contains);
		}
	}

	protected void assertValid(Guestbookentry guestbookentry) {
		boolean valid = true;

		if (guestbookentry.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (guestbookentry.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (guestbookentry.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (guestbookentry.getMessage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (guestbookentry.getName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Guestbookentry> page) {
		boolean valid = false;

		Collection<Guestbookentry> guestbookentries = page.getItems();

		int size = guestbookentries.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		Guestbookentry guestbookentry1, Guestbookentry guestbookentry2) {

		if (guestbookentry1 == guestbookentry2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						guestbookentry1.getCreator(),
						guestbookentry2.getCreator())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						guestbookentry1.getEmail(),
						guestbookentry2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						guestbookentry1.getId(), guestbookentry2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						guestbookentry1.getMessage(),
						guestbookentry2.getMessage())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						guestbookentry1.getName(), guestbookentry2.getName())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected Collection<EntityField> getEntityFields() throws Exception {
		if (!(_guestbookentryResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_guestbookentryResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField -> Objects.equals(entityField.getType(), type)
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		Guestbookentry guestbookentry) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("creator")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(guestbookentry.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			sb.append("'");
			sb.append(String.valueOf(guestbookentry.getId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("message")) {
			sb.append("'");
			sb.append(String.valueOf(guestbookentry.getMessage()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(guestbookentry.getName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Guestbookentry randomGuestbookentry() throws Exception {
		return new Guestbookentry() {
			{
				email = RandomTestUtil.randomString();
				id = RandomTestUtil.randomString();
				message = RandomTestUtil.randomString();
				name = RandomTestUtil.randomString();
			}
		};
	}

	protected Guestbookentry randomIrrelevantGuestbookentry() throws Exception {
		Guestbookentry randomIrrelevantGuestbookentry = randomGuestbookentry();

		return randomIrrelevantGuestbookentry;
	}

	protected Guestbookentry randomPatchGuestbookentry() throws Exception {
		return randomGuestbookentry();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseGuestbookentryResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.docs.headless.guestbookentries.resource.v1_0.
		GuestbookentryResource _guestbookentryResource;

}
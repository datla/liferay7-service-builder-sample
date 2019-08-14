package uk.ac.uea.www.course.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import uk.ac.uea.www.course.constants.CoursePortletKeys;
import uk.ac.uea.www.course.model.Foo;
import uk.ac.uea.www.course.service.FooLocalService;
import uk.ac.uea.www.course.service.FooLocalServiceUtil;

/**
 * @author hrr19sxu
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + CoursePortletKeys.Course,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"field1=field1" }, service = Portlet.class)
public class CoursePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	public void addFoo(ActionRequest actionRequest, ActionResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String name = ParamUtil.getString(actionRequest, "name");
		System.out.println("Foo portlet called" + name);
		Foo foo = FooLocalServiceUtil.createFoo(CounterLocalServiceUtil.increment());
		foo.setField1(name);
		foo.setField2(true);
		foo.setField4(new Date());
		getFooLocalService().addFoo(foo);
			
	}
	
	public FooLocalService getFooLocalService() {
		return _fooLocalService;
	}
	
	@Reference
	private volatile FooLocalService _fooLocalService;

}

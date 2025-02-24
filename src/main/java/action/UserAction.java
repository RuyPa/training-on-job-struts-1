package action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.MappingDispatchAction;

import dao.UserDao;
import form.UserForm;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import consts.Consts.Status;
import consts.Consts.Attribute;

import java.util.List;

public class UserAction extends MappingDispatchAction {

	UserDao userDao = new UserDao();


	public ActionForward gett(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DynaActionForm dynaUserListForm = (DynaActionForm) form;
		return getDynaUsersAction(mapping, dynaUserListForm);
	}

	private ActionForward getDynaUsersAction(ActionMapping mapping, DynaActionForm dynaUserListForm) {
		List<User> users = userDao.getUsers();
		dynaUserListForm.set(Attribute.ITEMS, users);
		return mapping.findForward(Status.SUCCESS);
	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		return createUserAction(mapping, userForm);
	}

	private ActionForward createUserAction(ActionMapping mapping, UserForm userForm) {
		userDao.createUser(userForm);
		return mapping.findForward(Status.SUCCESS);
	}
}


//	<action path="/addUser"
//	        type="action.UserAction"
//	        name="userForm"
//	        parameter="add">
//	    <forward name="success" path="/list.do"/>
//	</action>
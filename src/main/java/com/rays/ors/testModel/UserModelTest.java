package com.rays.ors.testModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.ors.bean.UserBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.exception.RecordNotFoundException;
import com.rays.ors.model.UserModel;

/**
 * User Model Test classes
 *
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 *
 */
public class UserModelTest {

	/**
	 * Model object to test
	 */

	public static UserModel model = new UserModel();

	/**
	 * Main method to call test methods.
	 *
	 * @param args
	 * @throws ParseException
	 * @throws DuplicateRecordException
	 */
	public static void main(String[] args) throws ParseException, DuplicateRecordException {
		// testAdd();
		// testDelete();
		testUpdate();
		// testFindByPK();
		// testFindByLogin();
		// testGetRoles();
		// testSearch();
		// testList();
		// testAuthenticate();
		// testRegisterUser();
		// testchangePassword();
		// testforgetPassword();
		// testresetPassword();

	}

	/**
	 * Tests add a User
	 *
	 * @throws ParseException
	 * @throws DuplicateRecordException
	 */
	public static void testAdd() throws ParseException, DuplicateRecordException {

		try {

			UserBean bean = new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			bean.setId(8L);
			bean.setFirstName("Daya");
			bean.setLastName("S");
			bean.setLogin("Daya_S@gmail.com");
			bean.setPassword("dy12345");
			bean.setDob(sdf.parse("01/19/1997"));
			bean.setMobileNo("12345578");
			bean.setRoleId(3L);
			bean.setUnSuccessfulLogin(2);
			bean.setGender("Male");
			bean.setLastLogin(new Timestamp(new Date().getTime()));
			bean.setLock("No");
			bean.setRegisteredIP("6.1.0.5");
			bean.setLastLoginIP("6.1.0.5");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
			bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

			long pk = model.add(bean);
			UserBean addedbean = model.findByPK(pk);
			System.out.println("Test add succ");
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests delete a User
	 */
	public static void testDelete() {

		try {
			UserBean bean = new UserBean();
			long pk = 3L;
			bean.setId(pk);
			model.delete(bean);
			System.out.println("Test Delete successful " + bean.getId());
			UserBean deletedbean = model.findByPK(pk);
			if (deletedbean == null) {
				System.out.println("Test Delete fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests update a User
	 * 
	 * @throws ParseException
	 */
	public static void testUpdate() throws ParseException {

		try {// UserBean bean = model.findByPK(1L);
			UserBean bean = new UserBean();
			// SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			bean.setLogin("prateekkumarverma97@gmail.com");
			bean.setPassword("prtk1897");
			bean.setMobileNo("8109514495");
			bean.setRoleId(1L);
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
			bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
			bean.setId(4L);
			
			model.update(bean);

			/*
			 * bean.setFirstName("Jayesh"); bean.setLastName("Agrawal");
			 * bean.setLogin("jayAgrawal210@gmail.com"); bean.setPassword("jy12345");
			 * bean.setDob(sdf.parse("12/15/1990")); bean.setMobileNo("8555166566");
			 */
			/*
			 * bean.setUnSuccessfulLogin(3); bean.setGender("Male"); bean.setLastLogin(new
			 * Timestamp(new Date().getTime())); bean.setLock("Yes");
			 * bean.setRegisteredIP("342.4.1.98"); bean.setLastLoginIP("12.0.0.14");
			 * bean.setCreatedBy("Mahajan"); bean.setCreatedDateTime(new Timestamp(new
			 * Date().getTime()));
			 */

			// UserBean updatedbean = model.findByPK(1L);
			// if (!"ranjit".equals(updatedbean.getLogin())) {
			// System.out.println("Test Update fail");
			// }
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests find a User by PK.
	 */
	public static void testFindByPK() {
		try {
			UserBean bean = new UserBean();
			long pk = 1L;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println("ID: " + bean.getId());
			System.out.println("First Name: " + bean.getFirstName());
			System.out.println("Last Name" + bean.getLastName());
			System.out.println("Login: " + bean.getLogin());
			System.out.println("Password: " + bean.getPassword());
			System.out.println("DOB: " + bean.getDob());
			System.out.println("Mobile No: " + bean.getMobileNo());
			System.out.println("Role Id: " + bean.getRoleId());
			System.out.println("Unsuccessful Login: " + bean.getUnSuccessfulLogin());
			System.out.println("Gender: " + bean.getGender());
			System.out.println("Last Login: " + bean.getLastLogin());
			System.out.println("User Lock: " + bean.getLock());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests find a User by Login.
	 */
	public static void testFindByLogin() {
		try {
			UserBean bean = new UserBean();
			bean = model.findByLogin("Keshav@gmail.com");
			if (bean == null) {
				System.out.println("Test Find By Login fail");
			}
			System.out.println("ID: " + bean.getId());
			System.out.println("First Name: " + bean.getFirstName());
			System.out.println("Last Name" + bean.getLastName());
			System.out.println("Login: " + bean.getLogin());
			System.out.println("Password: " + bean.getPassword());
			System.out.println("DOB: " + bean.getDob());
			System.out.println("Mobile No: " + bean.getMobileNo());
			System.out.println("Role Id: " + bean.getRoleId());
			System.out.println("Unsuccessful Login: " + bean.getUnSuccessfulLogin());
			System.out.println("Gender: " + bean.getGender());
			System.out.println("Last Login: " + bean.getLastLogin());
			System.out.println("User Lock: " + bean.getLock());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests get Roles.
	 */
	public static void testGetRoles() {

		try {
			UserBean bean = new UserBean();
			List list = new ArrayList();
			bean.setRoleId(2L);
			list = model.getRoles(bean);
			if (list.size() < 0) {
				System.out.println("Test Get Roles fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println("ID: " + bean.getId());
				System.out.println("First Name: " + bean.getFirstName());
				System.out.println("Last Name" + bean.getLastName());
				System.out.println("Login: " + bean.getLogin());
				System.out.println("Password: " + bean.getPassword());
				System.out.println("DOB: " + bean.getDob());
				System.out.println("Mobile No: " + bean.getMobileNo());
				System.out.println("Role Id: " + bean.getRoleId());
				System.out.println("Unsuccessful Login: " + bean.getUnSuccessfulLogin());
				System.out.println("Gender: " + bean.getGender());
				System.out.println("Last Login: " + bean.getLastLogin());
				System.out.println("User Lock: " + bean.getLock());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests get Search
	 */
	public static void testSearch() {

		try {
			UserBean bean = new UserBean();
			List list = new ArrayList();
			bean.setFirstName("Keshav");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getRoleId());
				System.out.println(bean.getUnSuccessfulLogin());
				System.out.println(bean.getGender());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests get List.
	 */
	public static void testList() {
		try {
			UserBean bean = new UserBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println("ID: " + bean.getId());
				System.out.println("First Name: " + bean.getFirstName());
				System.out.println("Last Name" + bean.getLastName());
				System.out.println("Login: " + bean.getLogin());
				System.out.println("Password: " + bean.getPassword());
				System.out.println("DOB: " + bean.getDob());
				System.out.println("Mobile No: " + bean.getMobileNo());
				System.out.println("Role Id: " + bean.getRoleId());
				System.out.println("Unsuccessful Login: " + bean.getUnSuccessfulLogin());
				System.out.println("Gender: " + bean.getGender());
				System.out.println("Last Login: " + bean.getLastLogin());
				System.out.println("User Lock: " + bean.getLock());
				System.out.println("Register IP: " + bean.getRegisteredIP());
				System.out.println("Last login IP: " + bean.getLastLoginIP());
				System.out.println("Created By " + bean.getCreatedBy());
				System.out.println("Modified By: " + bean.getModifiedBy());
				System.out.println("Created Datetime: " + bean.getCreatedDateTime());
				System.out.println("Modified Datetime: " + bean.getModifiedDateTime());
				System.out.println("-------------------------------------------------------------");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests authenticate User.
	 */
	public static void testAuthenticate() {

		try {
			UserBean bean = new UserBean();
			bean.setLogin("jayAgrawal210@gmail.com");
			bean.setPassword("jy12345");
			bean = model.authenticate(bean.getLogin(), bean.getPassword());
			if (bean != null) {
				System.out.println("Successfully login");

			} else {
				System.out.println("Invalied login Id & password");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests add a User register
	 *
	 * @throws ParseException
	 */

	public static void testRegisterUser() throws ParseException {
		try {
			UserBean bean = new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			bean.setId(5L);
			bean.setFirstName("Prateek");
			bean.setLastName("Verma");
			bean.setLogin("fgfj@gmail.com");
			bean.setPassword("htrysyjs");
			bean.setConfirmPassword("rgtehart");
			bean.setDob(sdf.parse("01/10/2005"));
			bean.setGender("Male");
			bean.setRoleId(4L);
			long pk = model.registerUser(bean);
			System.out.println("Successfully register");
			System.out.println("---------------------------------------------");
			System.out.println("First name: " + bean.getFirstName());
			System.out.println("Login Id: " + bean.getLogin());
			System.out.println("Last name: " + bean.getLastName());
			System.out.println("DOB: " + bean.getDob());
			System.out.println("----------------------------------------------");
			UserBean registerbean = model.findByPK(pk);
			if (registerbean != null) {
				System.out.println("Test registation fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests changepassword
	 *
	 * @throws ParseException
	 */
	public static void testchangePassword() {

		try {
			UserBean bean = model.findByLogin("ranjitchoudhary20@gmail.com");
			String oldPassword = bean.getPassword();
			bean.setId(15l);
			bean.setPassword("88");
			bean.setConfirmPassword("kk");
			String newPassword = bean.getPassword();
			try {
				model.changePassword(15L, oldPassword, newPassword);
				System.out.println("password has been change successfully");
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests fogetPassword
	 *
	 * @throws ParseException
	 */
	public static void testforgetPassword() {
		try {
			boolean b = model.forgetPassword("vipin11@gmail.com");

			System.out.println("Suucess : Test Forget Password Success");

		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests resetPassword
	 *
	 * @throws ParseException
	 */
	public static void testresetPassword() {
		UserBean bean = new UserBean();
		try {
			bean = model.findByLogin("ranjitchoudhary20@gmail.com");
			if (bean != null) {
				boolean pass = model.resetPassword(bean);
				if (pass = false) {
					System.out.println("Test Update fail");
				}
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}
}

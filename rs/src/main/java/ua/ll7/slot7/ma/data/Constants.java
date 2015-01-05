package ua.ll7.slot7.ma.data;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:05
 */
public class Constants {

	public final static String controllerEndpointAdmController = "/admController";
	public final static String controllerEndpointAnonController = "/anonController";
	public final static String controllerEndpointRUController = "/ruController";

	public final static String methodEndpointUserCreate = "/userCreate";
	public final static String methodEndpointUserList = "/userList";
	public final static String methodEndpointUserListPageable = "/userListPageable";

	public final static String methodEndpointCategoryCreate = "/categoryCreate";
	public final static String methodEndpointCategoryUpdate = "/categoryUpdate";
	public final static String methodEndpointCategoryList = "/categoryList";

	public final static String methodEndpointExpenseCreate = "/expenseCreate";

	public final static String divider = " : ";

	public final static String messageNotValidRequest = "Not valid request";

	public final static String dateFormatString = "dd-MM-yyyy";

	private Constants() {

	}
}

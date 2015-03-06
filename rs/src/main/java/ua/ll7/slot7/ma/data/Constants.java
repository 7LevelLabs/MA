package ua.ll7.slot7.ma.data;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:05
 */
public class Constants {

  public final static String controllerEndpointAdmController        = "/admController";
  public final static String controllerEndpointAnonController       = "/anonController";
  public final static String controllerEndpointRegisteredController = "/registeredController";

  public final static String methodEndpointUserCreate             = "/userCreate";
  public final static String methodEndpointUserCreateConfirmation = "/userCreateConfirmation";
  public final static String methodEndpointUserList               = "/userList";
  public final static String methodEndpointUserListPageable       = "/userListPageable";
  public final static String methodEndpointUserSetActive          = "/userSetActive";
  public final static String methodEndpointUserUpdateNickName     = "/userUpdateNickName";

  public final static String methodEndpointCategoryCreate = "/categoryCreate";
  public final static String methodEndpointCategoryUpdate = "/categoryUpdate";
  public final static String methodEndpointCategoryList   = "/categoryList";

  public final static String methodEndpointExpenseCreate = "/expenseCreate";
  public final static String methodEndpointExpenseList   = "/expenseList";

  public final static String methodEndpointCurrencyRateCreate     = "/currencyRateCreate";
  public final static String methodEndpointCurrencyRateGetCurrent = "/currencyRateGetCurrent";

  public final static String divider = " : ";

  public final static String messageNotValidRequest = "Not valid request";

  public final static String dateFormatString = "dd-MM-yyyy";

  public final static String userRole_ADMIN      = "ROLE_ADMIN";
  public final static String userRole_REGISTERED = "ROLE_REGISTERED";

  public final static int  userARTLength       = 5;
  public final static long userARTPeriodLength = 1000 * 60 * 60;

  public final static String emailSubjectCodaLong  = "[MA Service : Personal Expenses Accounting]";
  public final static String emailSubjectCodaShort = "[MA Service]";
  public final static String emailRegistrationConfirmation = "Registration Confirmation for ";

  private Constants() {

  }

  public enum UserRole {

    REGISTERED(1),
    ADMIN(10);

    private int value;

    private UserRole(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }
}

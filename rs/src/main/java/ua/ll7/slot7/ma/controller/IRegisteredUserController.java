package ua.ll7.slot7.ma.controller;

import org.springframework.http.ResponseEntity;
import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.request.*;
import ua.ll7.slot7.ma.data.response.MACategoryForTheUserVOListResponse;
import ua.ll7.slot7.ma.data.response.MACurrencyRateCurrentResponse;
import ua.ll7.slot7.ma.data.response.MAExpenseVOListResponse;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:08
 */
public interface IRegisteredUserController {

	public ResponseEntity<MAGenericResponse> categoryCreate(CategoryCreateRequest request);

	public ResponseEntity<MAGenericResponse> categoryUpdate(CategoryUpdateRequest request);

	public ResponseEntity<MACategoryForTheUserVOListResponse> categoryList();

	public ResponseEntity<MAGenericResponse> expenseCreate(ExpenseCreateRequest request);

	public ResponseEntity<MAExpenseVOListResponse> expenseList(ExpenseListPageableRequest request);

	public ResponseEntity<MACurrencyRateCurrentResponse> currencyRateCurrent(CurrencyRateCurrentRequest request);

	public ResponseEntity<MAGenericResponse> userUpdateNickName(UserUpdateNickNameRequest request);
}

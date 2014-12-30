package ua.ll7.slot7.ma.controller;

import org.springframework.http.ResponseEntity;
import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.request.CategoryCreateRequest;
import ua.ll7.slot7.ma.data.request.CategoryUpdateRequest;
import ua.ll7.slot7.ma.data.response.MACategoryForTheUserVOListResponse;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:08
 */
public interface IRegisteredUserController {

	public ResponseEntity<MAGenericResponse> categoryCreate(CategoryCreateRequest request);

	public ResponseEntity<MAGenericResponse> categoryUpdate(CategoryUpdateRequest request);

	public ResponseEntity<MACategoryForTheUserVOListResponse> categoryList();

}

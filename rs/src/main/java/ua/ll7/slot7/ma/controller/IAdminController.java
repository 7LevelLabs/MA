package ua.ll7.slot7.ma.controller;

import org.springframework.http.ResponseEntity;
import ua.ll7.slot7.ma.data.response.MAUserVOListResponse;

/**
 * MA
 * Velichko A.
 * 26.12.14 18:04
 */
public interface IAdminController {
	public ResponseEntity<MAUserVOListResponse> userList();
}

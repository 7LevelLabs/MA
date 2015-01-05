package ua.ll7.slot7.ma.controller.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ll7.slot7.ma.controller.IAdminController;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.response.MAUserVOListResponse;
import ua.ll7.slot7.ma.service.IBLService;

/**
 * @author Alex Velichko
 *         05.01.15 : 14:01
 */
@Controller
@RequestMapping(Constants.controllerEndpointAdmController)
public class AdminControllerImpl implements IAdminController {

	private static final Logger LOGGER = Logger.getLogger(AdminControllerImpl.class);

	@Autowired
	private IBLService blService;

	@Override
	@RequestMapping(value = Constants.methodEndpointUserList,
											 method = RequestMethod.GET,
											 consumes = MediaType.APPLICATION_JSON_VALUE,
											 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MAUserVOListResponse> userList() {
		MAUserVOListResponse response = new MAUserVOListResponse();
		response.setData1(blService.userList());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}


}

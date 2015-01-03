package ua.ll7.slot7.ma.controller.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.util.TestUtil;
import ua.ll7.slot7.ma.validator.IRequestValidator;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:maTestConf/maConfigMVCUnitTest.xml", "classpath:maTestConf/maConfigWebControllersTest.xml"})
@WebAppConfiguration
public class AnonymousControllerImplTest {

	private MockMvc mockMvc;

	@Autowired
	private IRequestValidator requestValidatorMock;

	@Autowired
	private IBLService blServiceMock;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		Mockito.reset(blServiceMock);
		Mockito.reset(requestValidatorMock);

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testRegisterNewUser() throws Exception {

		UserRegisterRequest request = new UserRegisterRequest();
		request.setData1("username");
		request.setData2("password");

		//setting up blServiceMock behavior
		when(blServiceMock.userCreate(any(String.class), any(String.class))).thenReturn(1L);

		//setting up requestValidatorMock behavior
		//void
		doNothing().when(requestValidatorMock).validate(any(UserRegisterRequest.class));

		mockMvc.perform(put(Constants.controllerEndpointAnonController + Constants.methodEndpointUserCreate)
																							.contentType(MediaType.APPLICATION_JSON)
																							.content(TestUtil.convertObjectToJsonBytes(request))
		)
												 .andExpect(status().isOk())
												 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
												 .andExpect(jsonPath("$.data1", is(1)));

		verify(blServiceMock, times(1)).userCreate(any(String.class), any(String.class));
		verifyNoMoreInteractions(blServiceMock);
	}

}
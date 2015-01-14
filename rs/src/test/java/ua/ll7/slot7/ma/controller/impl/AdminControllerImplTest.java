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
import ua.ll7.slot7.ma.data.vo.UserVO;
import ua.ll7.slot7.ma.service.IBLService;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:maTestConf/maConfigMVCUnitTest.xml", "classpath:maTestConf/maConfigWebControllersTest.xml"})
@WebAppConfiguration
public class AdminControllerImplTest {

	private MockMvc mockMvc;

	@Autowired
	private IBLService blServiceMock;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		Mockito.reset(blServiceMock);

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testUserList() throws Exception {

		List<UserVO> userVOs = new LinkedList<>();

		UserVO userVO1 = new UserVO();
		userVO1.setId(1);
		userVO1.setEmail("email1");
		userVO1.setName("name1");
		userVO1.setNick("nick1");
		userVO1.setActive(false);

		userVOs.add(userVO1);

		UserVO userVO2 = new UserVO();
		userVO2.setId(2);
		userVO2.setEmail("email2");
		userVO2.setName("name2");
		userVO2.setNick("nick2");
		userVO2.setActive(true);

		userVOs.add(userVO2);

		//setting up blServiceMock behavior
		when(blServiceMock.userList()).thenReturn(userVOs);

		mockMvc.perform(get(Constants.controllerEndpointAdmController + Constants.methodEndpointUserList)
													 .contentType(MediaType.APPLICATION_JSON)
		)
					 .andExpect(status().isOk())
					 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
					 .andExpect(jsonPath("$.statusCode", is("OK")))
					 .andExpect(jsonPath("$.data1[0].id", is(1)))
					 .andExpect(jsonPath("$.data1[1].id", is(2)))
		;

		verify(blServiceMock, times(1)).userList();
		verifyNoMoreInteractions(blServiceMock);
	}
}
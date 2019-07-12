package cn.jantd.jpa;

import cn.jantd.jpa.model.Address;
import cn.jantd.jpa.model.UserDetail;
import cn.jantd.jpa.model.UserInfo;
import cn.jantd.jpa.repository.AddressRepository;
import cn.jantd.jpa.repository.UserDetailRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailRepositoryTests {

	@Resource
	private AddressRepository addressRepository;
	@Resource
	private UserDetailRepository userDetailRepository;

	@Test
	public void testSaveAddress() {
		Address address=new Address();
		address.setUserId(1L);
		address.setCity("北京");
		address.setProvince("北京");
		address.setStreet("亦庄开发区");
		addressRepository.save(address);
	}

	@Test
	public void testSaveUserDetail() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		UserDetail userDetail=new UserDetail();
		userDetail.setUserId(3L);
		userDetail.setHobby("游戏");
		userDetail.setAge(28);
		userDetail.setIntroduction("爱旅游");
		userDetailRepository.save(userDetail);
	}

	@Test
	public void testUserInfo()  {
		List<UserInfo> userInfos=userDetailRepository.findUserInfo("钓鱼");
		for (UserInfo userInfo:userInfos){
			System.out.println("userInfo: "+userInfo.getUserName()+"-"+userInfo.getEmail()+"-"+userInfo.getHobby()+"-"+userInfo.getIntroduction());
		}
	}
}

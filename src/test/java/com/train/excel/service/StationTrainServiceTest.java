package com.train.excel.service;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.train.excel.domain.StationTrain;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class StationTrainServiceTest {

	@Inject
	private StationTrainService service;

	@Test
	public void test01Save() {
		StationTrain st = new StationTrain();
		st.setChangeLong(9900.123d);
		st.setConsignee("consignee");
		st.setDate(new Date());
		st.setFileId("fileId");
		st.setFromBureau("fromBureau");
		st.setFromStation("setFromStation");
		st.setGoodsName("setGoodsName");
		st.setLoadWeight(33.33d);
		st.setSerialNum("123");
		st.setSelfWeight(434.343d);
		st.setToBureau("setToBureau");
		st.setToStation("setToStation");
		st.setTrainNum("trainNum");
		st.setTrainType("trainType");
		service.save(st);
		Assert.assertTrue(st.getId() != null);
	}

	@Test
	public void test02GetByFileId() {
		service.getByFileId("fileId");
	}

	@Test
	public void test03DeleteByFileId() {
		service.deleteByFileId("fileId");
		service.getByFileId("fileId");
	}

}

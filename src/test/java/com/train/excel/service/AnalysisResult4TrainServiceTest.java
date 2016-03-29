package com.train.excel.service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.train.excel.domain.AnalysisResult4Train;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class AnalysisResult4TrainServiceTest {

	@Inject
	private AnalysisResult4TrainService service;
	
	@Test
	public void testGetAllAnalysisResult() {
		List<AnalysisResult4Train> list = service.getAllAnalysisResult("7422ab10-2ff2-4efb-946d-cfe9e7ddde1e");
		for (AnalysisResult4Train analysisResult4Train : list) {
			System.out.println(analysisResult4Train);
		}
	}

}

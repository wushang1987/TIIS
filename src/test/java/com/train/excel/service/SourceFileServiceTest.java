package com.train.excel.service;

import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.train.excel.domain.SourceFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class SourceFileServiceTest {

	@Inject
	private SourceFileService service;

	@Test
	public void testGetByMd5() {
		String md5 = UUID.randomUUID().toString();
		SourceFile file = service.getByMd5(md5);
		if (file != null) {
			Assert.assertEquals(md5, file.getMd5());
		}
	}

	@Test
	public void testSave() {
		SourceFile sf = new SourceFile();
		sf.setFileId("fdsfd");
		sf.setFileName("fileName");
		sf.setFilePath("fdsfsd");
		sf.setMd5("md5");
		sf.setUploadTime(new Date());
		service.save(sf);
		Assert.assertTrue(sf.getId() != null);
	}

}

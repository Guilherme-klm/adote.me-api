package com.adote.me;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

class ApplicationTests {

	@Test
	void contextLoads() throws IOException {
//		File fi = new File("C:\\Users\\guilh\\Downloads\\ashley.jpg");
//		byte[] fileContent = Files.readAllBytes(fi.toPath());
//		System.out.println(fileContent);

		BufferedImage image = ImageIO.read(new File("C:\\Users\\guilh\\Downloads\\ashley.jpg"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", baos);
		byte[] bytes = baos.toByteArray();
		String encoded = Base64.getEncoder().encodeToString(bytes);

		var stringBuffer = new StringBuffer();

		var rootDir = "C:\\Users\\guilh\\OneDrive\\dev\\FUNDATEC\\LP 4\\adote.me\\imagemString.txt";

		String theString2 = IOUtils.toString(new FileInputStream(rootDir), "UTF-8");

		byte[] decode = Base64.getDecoder().decode(theString2);
		System.out.println(decode);

		InputStream is = new ByteArrayInputStream(decode);
		BufferedImage bi = ImageIO.read(is);
		ImageIO.write(bi, "jpg", new File("C:\\Users\\guilh\\Downloads\\ashley_3.jpg"));

	}

}

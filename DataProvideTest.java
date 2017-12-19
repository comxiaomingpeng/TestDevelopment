package com.pxm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * ʹ��TestNG������������
 */
public class DataProvideTest {
	private static WebDriver driver;

	@DataProvider(name = "searchWords")
	public static Object[][] words() {
		return new Object[][] { { "������", "����", "���˶�" }, { "����", "����", "����" },
				{ "����Σ��", "���", "����ɭ" } };
	}

	@Test(dataProvider = "searchWords")
	public void test(String searchWord1, String searchWord2, String SearchResult) {
		driver = new FirefoxDriver();
		// �趨�ȴ�10����
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw"))
				.sendKeys(searchWord1 + "" + searchWord2);
		driver.findElement(By.id("su")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.getPageSource().contains(SearchResult));

		driver.quit();

	}
}
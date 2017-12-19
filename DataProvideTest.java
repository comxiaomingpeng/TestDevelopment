package com.pxm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * 使用TestNG进行数据驱动
 */
public class DataProvideTest {
	private static WebDriver driver;

	@DataProvider(name = "searchWords")
	public static Object[][] words() {
		return new Object[][] { { "蝙蝠侠", "主演", "迈克尔" }, { "超人", "导演", "唐纳" },
				{ "生化危机", "编剧", "安德森" } };
	}

	@Test(dataProvider = "searchWords")
	public void test(String searchWord1, String searchWord2, String SearchResult) {
		driver = new FirefoxDriver();
		// 设定等待10秒钟
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

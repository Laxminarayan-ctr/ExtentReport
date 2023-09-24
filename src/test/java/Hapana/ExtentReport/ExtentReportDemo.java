package Hapana.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;

	@BeforeTest

	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Result");
		report.config().setDocumentTitle("Test Result");

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("TesterName", "LaxmiNarayan");
		extent.setSystemInfo("Environment", "QA");

	}

	@Test

	public void initialDemo() {

		ExtentTest test = extent.createTest("initial Demo");
		System.setProperty("Webdriver.driver.chrome",
				"C://Users//ofsin//OneDrive//Desktop//Automation//chromedriver_win32.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://core.hapana.com/");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("result do not match");
		extent.flush();

	}
}

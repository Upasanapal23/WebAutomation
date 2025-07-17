package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ScreenshotUtil;
import java.nio.file.Files; // Added
import java.nio.file.Path;  // Added

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver(result.getTestContext().getCurrentXmlTest().getParameter("browser"));
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        attachScreenshot(screenshotPath);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
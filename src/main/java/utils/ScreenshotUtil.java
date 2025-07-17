package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "target/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            Files.createDirectories(Path.of("target/screenshots"));
            Files.copy(screenshot.toPath(), new FileOutputStream(path));
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
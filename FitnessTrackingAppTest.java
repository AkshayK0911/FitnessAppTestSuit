package practice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class FitnessTrackingAppTest {

    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() {
        try {
            // Set the desired capabilities for the Appium session
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "device_name");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "path_to_app_file.apk");
            // Add other desired capabilities as needed

            // Initialize the Appium driver
            URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void logWorkoutTest() {
        // Locate and interact with elements on the app screen
        MobileElement workoutButton = driver.findElementById("workout_button");
        workoutButton.click();

        MobileElement exerciseInput = driver.findElementById("exercise_input");
        exerciseInput.sendKeys("Push-ups");

        MobileElement setsInput = driver.findElementById("sets_input");
        setsInput.sendKeys("3");

        MobileElement repsInput = driver.findElementById("reps_input");
        repsInput.sendKeys("10");

        MobileElement saveButton = driver.findElementById("save_button");
        saveButton.click();

        // Add assertions or verifications to validate the expected behavior after logging a workout
        // For example, check if the logged workout is displayed correctly on the screen
    }

    @AfterTest
    public void tearDown() {
        // Quit the driver and close the session
        driver.quit();
    }
}

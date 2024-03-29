package google.form;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    WebDriver driver;

    // ChromeDriver driver;
    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        System.out.println("end Test case: testCase01");
    }

    public void testcase02() {
        System.out.println("Start Test case: testCase02");
        System.out.println("Enter the Name:");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement namefield = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd']//input[@type='text']")));

        namefield.clear();
        namefield.sendKeys("Hello World");
        boolean istext = wait.until(ExpectedConditions.textToBePresentInElementValue(namefield, "Hello World"));
        if (istext) {
            System.out.println("Text Hello World is entered successfully");
        } else {
            System.out.println("Text is not successfully sent");
        }
        System.out.println("End Test case: testCase02");
    }

    public void testcase03() {
        System.out.println("Start Test case: testCase03");
        System.out.println("Why are you practicing Automation?");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement practice = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@class='KHxj8b tL9Q4c']")));
        practice.clear();
        long epoch = System.currentTimeMillis() / 1000;
        System.out.println("current time :" + epoch);
        String text = "I want to be the best QA Engineer! " + epoch;
        practice.sendKeys(text);
        boolean practicetext = wait.until(ExpectedConditions.textToBePresentInElementValue(practice,
                "I want to be the best QA Engineer! " + epoch));
        if (practicetext) {
            System.out.println("Perfect text sent");
        } else {
            System.out.println("Invalid text sent");
        }
        System.out.println("End Test case: testCase03");
    }

    public void testcase04() {
        System.out.println("Start Test case: testCase04");
        System.out.println("Select the Experience");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Expradiobutton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.xpath("//span[text()='3 - 5']/ancestor::div[@class='YEVVod']/preceding-sibling::div/div")));
        Expradiobutton.click();
        // span[text()='3 - 5']/ancestor::div[@class='YEVVod']/preceding-sibling::div
        String selected = Expradiobutton.getAttribute("aria-checked");
        if (selected.equalsIgnoreCase("true")) {
            System.out.println("Radio button is clicked");
        } else {
            System.out.println("Radio button not clicked");
        }
        System.out.println("End Test case: testCase04");
    }

    public void testcase05() throws InterruptedException {
        System.out.println("Start Test case: testCase05");
        System.out.println("Select the multiple courses in crio : ");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> courses = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//label[@class='docssharedWizToggleLabeledContainer Yri8Nb']/div")));

        for (WebElement course : courses) {
            if (!course.getText().contains("Springboot")) {
                course.click();
                Thread.sleep(3000);
                boolean isselect = driver
                        .findElement(By.xpath("//div[@class='uVccjd aiSeRd FXLARc wGQFbe BJHAP oLlshd i9xfbb N2RpBe']"))
                        .getAttribute("aria-checked").equals("true");
                if (isselect) {
                    System.out.println(course.getText() + " is Selected");
                } else {
                    System.out.println(course.getText() + " is not Selected");
                }
            }
        }
        System.out.println("End Test case: testCase05");
    }

    public void testcase06() throws InterruptedException {
        System.out.println("Start Test case: testCase06");
        System.out.println("Choose what to be Addressed?");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addressed = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Choose']")));
        addressed.click();
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.xpath(
                "//div[@class='OA0qNb ncFHed QXL7Te']/div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb')]"));
        for (WebElement opt : options) {
            if (opt.getText().equals("Mr")) {
                opt.click();
                System.out.println(opt.getText() + " Should be addressed");
            }
            break;
        }
        System.out.println("End Test case: testCase06");
    }

    public void testcase07() {
        System.out.println("Start Test case: testCase07");
        System.out.println("Provide the current date minus 7 days in the next date field");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement datepick = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='date']")));
        // Set the date format
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate now = LocalDate.now();
        System.out.println("Current Date : "+now);
        System.out.println("Date 7 days ago :" + dtf.format(now.minusDays(7)));
        datepick.sendKeys(dtf.format(now.minusDays(7)));
        System.out.println("End Test case: testCase07");
    }

    public void testcase08() {
        System.out.println("Start Test case: testCase08");
        System.out.println("Provide the current time");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hourfield = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Hour']")));
        hourfield.clear();
        SimpleDateFormat formatHours = new SimpleDateFormat("HH");
        String getHours = formatHours.format(new Date());
        System.out.println(getHours);
        hourfield.sendKeys(getHours);
        WebElement minutefield = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Minute']")));
        minutefield.clear();
        SimpleDateFormat formatminute = new SimpleDateFormat("mm");
        String getminutes = formatminute.format(new Date());
        System.out.println(getminutes);
        minutefield.sendKeys(getminutes);
        System.out.println("End Test case: testCase08");
    }

    public void testcase09() throws InterruptedException {
        System.out.println("Start Test case: testCase09");
        System.out.println("Change the URL of the tab (amazon.in)");
        driver.get("https://amazon.in");
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();
        System.out.println("End Test case: testCase09");
    }

    public void testcase10() throws InterruptedException {
        System.out.println("Start Test case: testCase10");
        System.out.println("Submit the form");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitbutton = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Submit']")));
        if (submitbutton.isEnabled()) {
            submitbutton.click();
        }
        Thread.sleep(3000);
        System.out.println("Form is submitted");
        System.out.println("Print the success message in console");
        By msg = By.xpath("//div[@class='vHW8K']");
        WebElement successmessage = driver.findElement(msg);
        boolean ismessage = wait.until(ExpectedConditions.textToBePresentInElementLocated(msg,
                "Thanks for your response, Automation Wizard!"));
        if (ismessage) {
            System.out.println(successmessage.getText());
        } else {
            System.out.println("No message");
        }
        System.out.println("End Test case: testCase10");
    }

}

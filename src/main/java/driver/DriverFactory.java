package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import java.util.Collections;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            try {
                webDriver.set(createDriver());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return webDriver.get();
    }


    private static WebDriver createDriver() throws IOException {
        WebDriver driver = null;

        switch (getBrowserType()) {
            /*case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }*/

            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                // Установка пользовательского User Agent
                String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (HTML, like Gecko) Chrome/124.0.0.0 Safari/537.36";
                chromeOptions.addArguments("--user-agent=" + userAgent);
                // Отключение автоматической загрузки
                chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                // Установка языковых параметров
                chromeOptions.addArguments("--lang=en-US");
                // Отключение расширений
                chromeOptions.addArguments("--disable-extensions");
                // Максимизация окна браузера
                chromeOptions.addArguments("--start-maximized");
                // Отключение использования sandbox
                chromeOptions.addArguments("--no-sandbox");
                // Отключение программного рендеринга
                chromeOptions.addArguments("--disable-software-rasterizer");
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                //chromeOptions.setBinary("C:/tmp1/chrome-win64/chrome.exe");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }


            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case "edge" -> {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new EdgeDriver(edgeOptions);
                break;
            }
            case "iexplorer" -> { //does not work
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/IEDriverServer.exe");
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;
        String browserTypeRemoteValue = System.getProperty("browserType");
        try {
            if (browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()) {
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
            } else {
                browserType = browserTypeRemoteValue;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    public static void cleanupDriver() throws InterruptedException {
        //Thread.sleep(2000);
        webDriver.get().quit();
        webDriver.remove();
    }

}

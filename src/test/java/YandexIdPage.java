import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexIdPage {
    private WebDriver driver;
    @FindBy(xpath = "//div[@class='UserID-Badge ']")
    private WebElement navbar;
    @FindBy(xpath = "//div[contains(@class, 'Logout')]")
    private WebElement logoutButton;
    @FindBy(xpath = "//iframe[@class='UserWidget-Iframe']")
    private WebElement iframeElement;
    private static final String PAGE_TITLE = "Яндекс ID";

    public YandexIdPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //--------------------------------------------
    //ГЕТТЕРЫ
    public WebElement getNavbar() {
        return navbar;
    }

    //----------------------------------------------
    //ЛОГИКА СТРАНИЦЫ
    public Boolean atPage() {
        return driver.getTitle().equals(PAGE_TITLE);
    }

    public void navbarClick() {
        navbar.click();
    }

    public void logoutButtonClick() {
        driver.switchTo().frame(iframeElement);
        logoutButton.click();
        driver.switchTo().defaultContent();
    }
}

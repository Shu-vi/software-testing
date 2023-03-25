import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexAuthPage {
    private WebDriver driver;
    @FindBy(id = "passp-field-login")
    private WebElement loginField;
    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;
    @FindBy(id = "passp:sign-in")
    private WebElement signInButton;
    @FindBy(xpath = "//button[@data-type='login']")
    private WebElement mailButton;
    private static final String PAGE_TITLE = "Авторизация";

    public YandexAuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //---------------------------------------------------------
    //ГЕТТЕРЫ
    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getMailButton() {
        return mailButton;
    }

    //---------------------------------------------------
    //ЛОГИКА СТРАНИЦЫ
    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public Boolean atPage() {
        return driver.getTitle().equals(PAGE_TITLE);
    }

    public void mailButtonClick() {
        mailButton.click();
    }
}
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Double.parseDouble;
import static java.lang.Double.sum;

public class CheckoutStepTwo extends BasePage{
    public CheckoutStepTwo(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "summary_subtotal_label")
    private WebElement totalPrice;

    @FindBy(className = "summary_tax_label")
    private WebElement tax;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalWithTaxFromStepTwo;


    public double totalPriceFromStepTwo(){
        //return parseDouble(totalPrice.getText().substring(totalPrice.getText().indexOf("$")));
        return parseDouble(totalPrice.getText().replace("Item total: $", ""));
    }

    public double taxPrice(){
        return parseDouble(tax.getText().replace("Tax: $", ""));
    }

    public double totalPriceAnTheEnd(){
        return parseDouble(totalWithTaxFromStepTwo.getText().replace("Total: $", ""));
    }

    public double totalWithTaxSum(){
        return sum(totalPriceFromStepTwo(), taxPrice());
    }


}

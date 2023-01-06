package featurefile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.PageObjects.AddToCart;
import org.PageObjects.FilterPage;
import org.PageObjects.HomePageHeader;
import org.SeleniumCommands.SeleniumCommands;

import java.util.List;
import java.util.Map;

public class Stepdefination extends SeleniumCommands{
    SeleniumCommands selenium=new SeleniumCommands();
    HomePageHeader homepage=new HomePageHeader();
    FilterPage filterPage=new FilterPage();
    AddToCart addToCart=new AddToCart();
    @Given("The User has launched Leanskart Application")
    public void the_user_has_launched_leanskart_application() {
      selenium.initDriver();


    }

    @When("The User select the product {string} from {string} from {string}")
    public void the_user_select_the_product_from_from(String category, String subCategory, String mainCategory) {
        this.delayScript(2000);
        homepage.select(mainCategory, subCategory, category);
        this.delayScript(2000);

    }

    @When("The User applies the filters")
    public void the_user_applies_the_filters(io.cucumber.datatable.DataTable filterTable) {
        List<Map<String, String>> filterList = filterTable.asMaps(String.class, String.class);
        for (int i = 0; i < filterList.size(); i++) {
            String filter = filterList.get(i).get("Filter");
            String filterValue = filterList.get(i).get("Filtervalue");
            this.Scroll(filter);
            this.ScrollUp(filter);
            filterPage.selectFilter(filter, filterValue);
            this.delayScript(2000);
        }

    }

    @When("Select item {string} and click on Add to Cart")
    public void select_item_and_click_on_add_to_cart(String Product) {
        this.delayScript(2000);
        addToCart.selectItem(Product);
        addToCart.windowHandle();
        this.delayScript(2000);
        addToCart.add();
        throw new io.cucumber.java.PendingException();
    }

    @Then("User verifies the cart using {string} text")
    public void user_verifies_the_cart_using_text(String string) {

           }
}

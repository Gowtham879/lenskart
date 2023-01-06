package org.PageObjects;

import org.SeleniumCommands.SeleniumCommands;

public class AddToCart extends SeleniumCommands {
    private void item(String Product)
    {
        String xpath="//a[text()='"+Product+"']";
        this.click(xpath);
    }
    public void selectItem(String Product)
    {
        this.item(Product);
    }
    public void add()
    {
        String xpath="//button[text()='BUY NOW']";
        this.click(xpath);
    }
}

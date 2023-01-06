package org.PageObjects;

import org.SeleniumCommands.SeleniumCommands;

public class HomePageHeader extends SeleniumCommands {
    private void mainMenu(String mainCategory) {
        String mainMenu = "//a[text()='"+mainCategory+"']";
        this.hoverOnElement(mainMenu);
    }
    private void subCategory(String subCategory, String mainCategory ) {
        String xpath = "//a[text()='"+mainCategory+"']/following-sibling::div//span[text()='"+subCategory+"']";
        this.hoverOnElement(xpath);
    }
    private void category(String category,String mainCategory,String subCategory) {
        String xpath = "//a[text()='"+mainCategory+"']/following-sibling::div//span[text()='"+subCategory+"']/../following-sibling::div//span[text()='"+category+"']";
        this.click(xpath);
    }
    public void select(String mainCategory,String subCategory,String category)
    {
        this.mainMenu(mainCategory);
        this.subCategory(subCategory,mainCategory);
        this.category(category,subCategory,mainCategory);
    }

}

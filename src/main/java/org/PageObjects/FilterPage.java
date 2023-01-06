package org.PageObjects;

import org.SeleniumCommands.SeleniumCommands;

public class FilterPage extends SeleniumCommands {
    private void filtertype(String Filter)
    {
        String xpath="//div[text()='"+Filter+"']";
        this.click(xpath);
    }
    private void filtervalue(String Filtervalue)
    {
        String xpath="//span[text()='"+Filtervalue+"']";
        this.click(xpath);
    }
    public void selectFilter(String Filter,String Filtervalue)
    {
        this.filtertype(Filter);
        this.filtervalue(Filtervalue);
    }
}

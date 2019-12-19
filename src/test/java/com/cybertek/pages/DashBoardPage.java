package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BasePage{

   /*
  - we dont need constructor below, because it will use parents constructor
  - kalsa da olur because it will override */

    public DashBoardPage(){
        PageFactory.initElements(Driver.get(),this);
    }



}

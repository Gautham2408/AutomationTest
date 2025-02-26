package TestRunner;		

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="features",glue={"com.vyg.Sales.Enquiry","com.vyg.Sales.Quotation","com.vyg.Sales.Order"})						
public class Runner				
{		

}

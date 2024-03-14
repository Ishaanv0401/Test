package Formy_Test;
import org.testng.annotations.Test;

import com.Formy.pages.AutocompletePage;

public class AutocompletePage_Test extends BaseTest
{

	AutocompletePage autoform=new AutocompletePage();
	
	@Test 
	public void testautocompleteform() throws InterruptedException
	{
		homepage.clickautocompletebtn();
		autoform.Autocomplete_details();
	}

}

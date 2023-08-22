package api.utilities;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
    @Test
	@DataProvider(name = "data")
    public String [][] testData() throws Exception {
        String path = System.getProperty("user.dir") + "//Testdata//Userdata.xlsx";
    	XLUtils xl = new XLUtils(path);
      
        
    	int rowCount = xl.getRowCount("sheet1");
        int colCount = xl.getCellCount("sheet1", 1);

      String  testData[][] = new String[rowCount][colCount];

       for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                testData[i - 1][j] = xl.getCellData("sheet1", i, j);
            }
        }

        return testData;
    }




	
	@DataProvider (name = "Username")
	public String[] getUsername() throws IOException {
		
		String path = System.getProperty("user.dir")+"//Testdata//Userdata.xlsx";
		XLUtils xl = new XLUtils(path);
		 
		int rownum = xl.getRowCount("sheet1");
		
		String apidata[] = new String[rownum];
		
		for (int i=1; i<=rownum; i++) {
			
			apidata[i-1]= xl.getCellData("sheet1",  i, 1); 
			
		}
		
		return apidata;
	}
}
	
	
	



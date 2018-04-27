package testingProject.testingProjectArtifact;

import org.junit.Test;

public class ExcelIO {
	
	@Test
	public void method() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		
		System.out.println(ExcelUtils.getCellData(0, 3)); 
		System.out.println(ExcelUtils.getCellData(1, 3)); 
		System.out.println(ExcelUtils.getCellData(2, 0)); 
		
		ExcelUtils.setCellData("Bish", 0, 2);
		ExcelUtils.setCellData("Bish", 1, 2);
		ExcelUtils.setCellData("Bish", 2, 2);
	}
}

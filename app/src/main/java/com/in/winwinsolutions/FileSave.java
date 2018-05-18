package com.in.winwinsolutions;

import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class FileSave 
{
	@SuppressWarnings("resource")
	public void XLS(File directory,String file_name) {
		// TODO Auto-generated method stub
		try
		{

			Workbook wb = null;
//			System.out.print("Type i.e 2007+ if u wan2 create xlsx file (default xls) => ");
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int sdkVersion = android.os.Build.VERSION.SDK_INT; // e.g. sdkVersion := 8; 
			if(sdkVersion>=21)
			{
				wb = new XSSFWorkbook();
			}
			else
			{
				wb = new HSSFWorkbook();
			}
			
			

			Sheet sheet = wb.createSheet("MY_SHEET");

			// row numbering starts from 0
			Row row = sheet.createRow( 0);
			Cell cell0 =  row.createCell(0);
			Cell cell1 =  row.createCell(1);
			Cell cell2 =  row.createCell(2);
			Cell cell3 =  row.createCell(3);
			Cell cell4 =  row.createCell(4);
			Cell cell5 =  row.createCell(5);
			Cell cell6 = row.createCell(6);
			Cell cell7 =  row.createCell(7);
			Cell cell8 =  row.createCell(8);
			Cell cell9 =  row.createCell(9);
			Cell cell10 =  row.createCell(10);
			Cell cell11 =  row.createCell(11);
			Cell cell12 =  row.createCell(12);
			Cell cell13 =  row.createCell(13);
			Cell cell14 =  row.createCell(14);
			Cell cell15 = row.createCell(15);
			Cell cell16 =  row.createCell(16);
			Cell cell17 =  row.createCell(17);
			Cell cell18 =  row.createCell(18);
			Cell cell19 =  row.createCell(19);
			Cell cell20 =  row.createCell(20);
			Cell cell21 =  row.createCell(21);
			Cell cell22 =  row.createCell(22);
			Cell cell23 =  row.createCell(23);
			Cell cell24 = row.createCell(24);
			Cell cell25 =  row.createCell(25);
			Cell cell26 =  row.createCell(26);
			Cell cell27 =  row.createCell(27);
			Cell cell28 =  row.createCell(28);
			Cell cell29 =  row.createCell(29);
			Cell cell30 =  row.createCell(30);
			Cell cell31 =  row.createCell(31);
			Cell cell32 =  row.createCell(32);
			Cell cell33 = row.createCell(33);
			Cell cell34 =  row.createCell(34);
//			Cell cell35 =  row.createCell(35);



			cell0.setCellValue("Title");
			cell1.setCellValue("Owner");
			cell2.setCellValue("Story");
			cell3.setCellValue("Objective A");
			cell4.setCellValue("Need B");
			cell5.setCellValue("Need C");
			cell6.setCellValue("Want D");
			cell7.setCellValue("Want D'");
			cell8.setCellValue("Why A?");
			cell9.setCellValue("In order to have A-B is needed because");
			cell10.setCellValue("In order to have A-C is needed because");
			cell11.setCellValue("In order to have B-D is needed because");
			cell12.setCellValue("In order to have C-D' is needed because");
			cell13.setCellValue("D is in conflict with D' because");
			cell14.setCellValue("Assumption A?");
			cell15.setCellValue("Assumption AB?");
			cell16.setCellValue("Assumption AC?");
			cell17.setCellValue("Assumption BD?");
			cell18.setCellValue("Assumption CD'?");
			cell19.setCellValue("Assumption DD'?");
			cell20.setCellValue("Idea A?");
			cell21.setCellValue("Idea AB?");
			cell22.setCellValue("Idea AC?");
			cell23.setCellValue("Idea BD?");
			cell24.setCellValue("Idea CD'?");
			cell25.setCellValue("Idea DD'?");
			cell26.setCellValue("Injection/Solution");
			cell27.setCellValue("Objective A");
			cell28.setCellValue("Need B");
			cell29.setCellValue("Need C");
			cell30.setCellValue("Injection I");
			cell31.setCellValue("In Order to have A, B is needed because");
			cell32.setCellValue("In Order to have A, C is needed because");
			cell33.setCellValue("If I exist B also exists because");
			cell34.setCellValue("If I exist C also exists because");
//			cell35.setCellValue("Conflict_Solved");

			Row row1 = sheet.createRow( 1);

			Cell cell_0 =  row1.createCell(0);
			Cell cell_1 =  row1.createCell(1);
			Cell cell_2 =  row1.createCell(2);
			Cell cell_3 =  row1.createCell(3);
			Cell cell_4 =  row1.createCell(4);
			Cell cell_5 =  row1.createCell(5);
			Cell cell_6 = row1.createCell(6);
			Cell cell_7 =  row1.createCell(7);
			Cell cell_8 =  row1.createCell(8);
			Cell cell_9 =  row1.createCell(9);
			Cell cell_10 =  row1.createCell(10);
			Cell cell_11 =  row1.createCell(11);
			Cell cell_12 =  row1.createCell(12);
			Cell cell_13 =  row1.createCell(13);
			Cell cell_14 =  row1.createCell(14);
			Cell cell_15 = row1.createCell(15);
			Cell cell_16 =  row1.createCell(16);
			Cell cell_17 =  row1.createCell(17);
			Cell cell_18 =  row1.createCell(18);
			Cell cell_19 =  row1.createCell(19);
			Cell cell_20 =  row1.createCell(20);
			Cell cell_21 =  row1.createCell(21);
			Cell cell_22 =  row1.createCell(22);
			Cell cell_23 =  row1.createCell(23);
			Cell cell_24 = row1.createCell(24);
			Cell cell_25 =  row1.createCell(25);
			Cell cell_26 =  row1.createCell(26);
			Cell cell_27 =  row1.createCell(27);
			Cell cell_28 =  row1.createCell(28);
			Cell cell_29 =  row1.createCell(29);
			Cell cell_30 =  row1.createCell(30);
			Cell cell_31 =  row1.createCell(31);
			Cell cell_32 =  row1.createCell(32);
			Cell cell_33 = row1.createCell(33);
			Cell cell_34 =  row1.createCell(34);
//			Cell cell_35 =  row1.createCell(35);



			cell_0.setCellValue(HomeActivity.Title);
			cell_1.setCellValue(HomeActivity.Owner);
			cell_2.setCellValue(HomeActivity.Story);
			cell_3.setCellValue(HomeActivity.Objective_A);
			cell_4.setCellValue(HomeActivity.Need_B);
			cell_5.setCellValue(HomeActivity.Need_C);
			cell_6.setCellValue(HomeActivity.Want_D1);
			cell_7.setCellValue(HomeActivity.Want_D2);
			cell_8.setCellValue(HomeActivity.Why_A);
			cell_9.setCellValue(HomeActivity.A_B_Needed);
			cell_10.setCellValue(HomeActivity.A_C_Needed);
			cell_11.setCellValue(HomeActivity.B_D1_Needed);
			cell_12.setCellValue(HomeActivity.C_D2_Needed);
			cell_13.setCellValue(HomeActivity.D1_conflict_D2);
			cell_14.setCellValue(HomeActivity.Why_A);
			cell_15.setCellValue(HomeActivity.A_B_Needed);
			cell_16.setCellValue(HomeActivity.A_C_Needed);
			cell_17.setCellValue(HomeActivity.B_D1_Needed);
			cell_18.setCellValue(HomeActivity.C_D2_Needed);
			cell_19.setCellValue(HomeActivity.D1_conflict_D2);
			cell_20.setCellValue(HomeActivity.Ideas_A);
			cell_21.setCellValue(HomeActivity.Ideas_AB);
			cell_22.setCellValue(HomeActivity.Ideas_AC);
			cell_23.setCellValue(HomeActivity.Ideas_BD1);
			cell_24.setCellValue(HomeActivity.Ideas_CD2);
			cell_25.setCellValue(HomeActivity.Ideas_D1D2);
			cell_26.setCellValue(HomeActivity.Injection);
			cell_27.setCellValue(HomeActivity.Objective_A2);
			cell_28.setCellValue(HomeActivity.Need_B2);
			cell_29.setCellValue(HomeActivity.Need_C2);
			cell_30.setCellValue(HomeActivity.Injection1);
			cell_31.setCellValue(HomeActivity.A2_B2_Needed);
			cell_32.setCellValue(HomeActivity.A2_C2_Needed);
			cell_33.setCellValue(HomeActivity.I_Exist_B_alsoExist);
			cell_34.setCellValue(HomeActivity.I_Exist_C_alsoexist);
//			cell_35.setCellValue(HomeActivity.conflictsolved);

			//		String excelFileName = "AKSINGHhhhh.xlsx";

			FileOutputStream fos = new FileOutputStream(""+directory+"/"+file_name);
			wb.write(fos);
			fos.flush();
			fos.close();
//			br.close();
		}
		catch(Exception e)
		{
			Log.e("gfd","sdgds");
		}		

		//		WorkbookSettings wbSettings = new WorkbookSettings();
		//
		//		wbSettings.setLocale(new Locale("en", "EN"));
		//
		//		WritableWorkbook workbook;
		//		try {
		//			int a = 1;
		//			workbook = Workbook.createWorkbook(file, wbSettings);
		//			WritableSheet sheet = workbook.createSheet("First Sheet", 0);
		//			//-----------------------heading--------------
		//			Label label0 = new Label(0, 0, "Title");
		//			Label label1 = new Label(1, 0, "Owner");
		//			Label label2 = new Label(2, 0, "Story");
		//			Label label3 = new Label(3, 0, "Objective A");
		//			Label label4 = new Label(4, 0, "Need B");
		//			Label label5 = new Label(5, 0, "Need C");
		//			Label label6 = new Label(6, 0, "Want D");
		//			Label label7 = new Label(7, 0, "Want D'");
		//			Label label8 = new Label(8, 0, "Why A?");
		//			Label label9 = new Label(9, 0, "In order to have A-B is needed because");
		//			Label label10 = new Label(10, 0, "In order to have A-C is needed because");
		//			Label label11 = new Label(11, 0, "In order to have B-D is needed because");
		//			Label label12 = new Label(12, 0, "In order to have C-D' is needed because");
		//			Label label13 = new Label(13, 0, "D is in conflict with D' because");
		//			Label label14 = new Label(14, 0, "Assumption A?");
		//			Label label15 = new Label(15, 0, "Assumption AB?");
		//			Label label16 = new Label(16, 0, "Assumption AC?");
		//			Label label17 = new Label(17, 0, "Assumption BD?");
		//			Label label18 = new Label(18, 0, "Assumption CD'?");
		//			Label label19 = new Label(19, 0, "Assumption DD'?");
		//			Label label20 = new Label(20, 0, "Idea A?");
		//			Label label21 = new Label(21, 0, "Idea AB?");
		//			Label label22= new Label(22, 0, "Idea AC?");
		//			Label label23= new Label(23, 0, "Idea BD?");
		//			Label label24 = new Label(24, 0, "Idea CD'?");
		//			Label label25 = new Label(25, 0, "Idea DD'?");
		//			Label label26 = new Label(26, 0, "Injection/Solution");
		//			Label label27 = new Label(27, 0, "Objective A");
		//			Label label28 = new Label(28, 0, "Need B");
		//			Label label29 = new Label(29, 0, "Need C");
		//			Label label30 = new Label(30, 0, "Injection I");
		//			Label label31 = new Label(31, 0, "In Order to have A, B is needed because");
		//			Label label32 = new Label(32, 0, "In Order to have A, C is needed because");
		//			Label label33 = new Label(33, 0, "If I exist B also exists because");
		//			Label label34 = new Label(34, 0, "If I exist C also exists because");
		//			Label label35 = new Label(35, 0, "progress");
		//
		//
		//			//---------------------values------------
		//			Label label_0 = new Label(0, 1,HomeActivity.Title);
		//			Label label_1 = new Label(1, 1, HomeActivity.Owner);
		//			Label label_2 = new Label(2, 1,HomeActivity.Story);
		//			Label label_3 = new Label(3, 1, HomeActivity.Objective_A);
		//			Label label_4 = new Label(4, 1, HomeActivity.Need_B);
		//			Label label_5 = new Label(5, 1, HomeActivity.Need_C);
		//			Label label_6 = new Label(6, 1,HomeActivity.Want_D1);
		//			Label label_7= new Label(7, 1, HomeActivity.Want_D2);
		//			Label label_8= new Label(8, 1, HomeActivity.Why_A);
		//			Label label_9= new Label(9, 1, HomeActivity.A_B_Needed);
		//			Label label_10= new Label(10,1,HomeActivity.A_C_Needed);
		//			Label label_11= new Label(11, 1,HomeActivity.B_D1_Needed);
		//			Label label_12=new Label(12, 1, HomeActivity.C_D2_Needed);
		//			Label label_13= new Label(13, 1,HomeActivity.D1_conflict_D2);
		//			Label label_14= new Label(14, 1, HomeActivity.Why_A);
		//			Label label_15= new Label(15, 1, HomeActivity.A_B_Needed);
		//			Label label_16= new Label(16, 1, HomeActivity.A_C_Needed);
		//			Label label_17= new Label(17, 1, HomeActivity.B_D1_Needed);
		//			Label label_18= new Label(18, 1, HomeActivity.C_D2_Needed);
		//			Label label_19= new Label(19, 1, HomeActivity.D1_conflict_D2);
		//			Label label_20= new Label(20, 1, HomeActivity.Ideas_A);
		//			Label label_21= new Label(21, 1, HomeActivity.Ideas_AB);
		//			Label label_22= new Label(22, 1, HomeActivity.Ideas_AC);
		//			Label label_23= new Label(23, 1, HomeActivity.Ideas_BD1);
		//			Label label_24= new Label(24, 1, HomeActivity.Ideas_CD2);
		//			Label label_25= new Label(25, 1, HomeActivity.Ideas_D1D2);
		//			Label label_26= new Label(26, 1, HomeActivity.Injection);
		//
		//			Label label_27= new Label(27, 1, HomeActivity.Objective_A2);
		//			Label label_28= new Label(28, 1, HomeActivity.Need_B2);
		//			Label label_29= new Label(29, 1, HomeActivity.Need_C2);
		//			Label label_30= new Label(30, 1, HomeActivity.Injection1);
		//			Label label_31= new Label(31, 1, HomeActivity.A2_B2_Needed);
		//			Label label_32= new Label(32, 1, HomeActivity.A2_C2_Needed);
		//			Label label_33= new Label(33, 1, HomeActivity.I_Exist_B_alsoExist);
		//			Label label_34= new Label(34, 1, HomeActivity.I_Exist_C_alsoexist);
		//			Label label_35= new Label(35, 1,String.valueOf(HomeActivity.seekbarvalue));
		//
		//
		//			try {				//				sheet.addCell(label);
		//				//------------------set heading on sheet----------------
		//				sheet.addCell(label0);
		//				sheet.addCell(label1);
		//				sheet.addCell(label2);
		//				sheet.addCell(label3);
		//				sheet.addCell(label4);
		//				sheet.addCell(label5);
		//				sheet.addCell(label6);
		//				sheet.addCell(label7);
		//				sheet.addCell(label8);
		//				sheet.addCell(label9);
		//				sheet.addCell(label10);
		//				sheet.addCell(label11);
		//				sheet.addCell(label12);
		//				sheet.addCell(label13);
		//				sheet.addCell(label14);
		//				sheet.addCell(label15);
		//				sheet.addCell(label16);
		//				sheet.addCell(label17);
		//				sheet.addCell(label18);
		//				sheet.addCell(label19);
		//				sheet.addCell(label20);
		//				sheet.addCell(label21);
		//				sheet.addCell(label22);
		//				sheet.addCell(label23);
		//				sheet.addCell(label24);
		//				sheet.addCell(label25);
		//				sheet.addCell(label26);
		//				sheet.addCell(label27);
		//				sheet.addCell(label28);
		//				sheet.addCell(label29);
		//				sheet.addCell(label30);
		//				sheet.addCell(label31);
		//				sheet.addCell(label32);
		//				sheet.addCell(label33);
		//				sheet.addCell(label34);
		//				sheet.addCell(label35);
		//				
		//				//----------------------set value of heading on sheet-----------------------
		//				sheet.addCell(label_0);
		//				sheet.addCell(label_1);
		//				sheet.addCell(label_2);
		//				sheet.addCell(label_3);
		//				sheet.addCell(label_4);
		//				sheet.addCell(label_5);
		//				sheet.addCell(label_6);
		//				sheet.addCell(label_7);
		//				sheet.addCell(label_8);
		//				sheet.addCell(label_9);
		//				sheet.addCell(label_10);
		//				sheet.addCell(label_11);
		//				sheet.addCell(label_12);
		//				sheet.addCell(label_13);
		//				sheet.addCell(label_14);
		//				sheet.addCell(label_15);
		//				sheet.addCell(label_16);
		//				sheet.addCell(label_17);
		//				sheet.addCell(label_18);
		//				sheet.addCell(label_19);
		//				sheet.addCell(label_20);
		//				sheet.addCell(label_21);
		//				sheet.addCell(label_22);
		//				sheet.addCell(label_23);
		//				sheet.addCell(label_24);
		//				sheet.addCell(label_25);
		//				sheet.addCell(label_26);
		//				sheet.addCell(label_27);
		//				sheet.addCell(label_28);
		//				sheet.addCell(label_29);
		//				sheet.addCell(label_30);
		//				sheet.addCell(label_31);
		//				sheet.addCell(label_32);
		//				sheet.addCell(label_33);
		//				sheet.addCell(label_34);
		//				sheet.addCell(label_35);
		//
		//
		//			} catch (RowsExceededException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			} catch (WriteException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//
		//
		//			workbook.write();
		//			try {
		//				workbook.close();
		//			} catch (WriteException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//			//createExcel(excelSheet);
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

	}
}

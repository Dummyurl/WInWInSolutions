package com.in.winwinsolutions;

import java.util.Stack;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.Window;

@SuppressWarnings("deprecation")
public class TabStack extends ActivityGroup {
	public static  Stack<String> stack;
	public static int a=1;
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (stack == null)
			stack = new Stack<String>();
		// start default activity
		push("FirstStackActivity", new Intent(this, HomeActivity.class));
	}

	@Override
	public void finishFromChild(Activity child) {
//		Log.e("hello","chieldback");
//		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//		int page=sharedpreferences.getInt("page", 0);

//		if(page==11)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.A2_B2_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.A2_C2_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}	
//				if(HomeActivity.I_Exist_B_alsoExist.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+5;
//				}
//				if(HomeActivity.I_Exist_C_alsoexist.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+5;
//				}
//				if(HomeActivity.Injection1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}	
//			}
//
//		}
//		else if(page==10)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Injection.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==9)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Ideas_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_AB.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_AC.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_BD1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_CD2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_D1D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//			}
//		}
//		else if(page==8)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.D1_conflict_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==7)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.C_D2_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==6)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.B_D1_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}	
//			}
//		}
//		else if(page==5)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.A_C_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==4)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.A_B_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}	
//			}
//		}
//		else if(page==3)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Why_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==2)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//			}
//		}
//		else if(page==1)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Owner.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//				if(HomeActivity.Story.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//			}
//		}
//		else if(page==12)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.B_D1_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.A_B_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.Why_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==13)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.C_D2_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.D1_conflict_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.A_C_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
		pop();
	}

	@Override
	public void onBackPressed() {

//		Log.e("hello","back");
//		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//		int page=sharedpreferences.getInt("page", 0);
//
//		if(page==11)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.A2_B2_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.A2_C2_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}	
//				if(HomeActivity.I_Exist_B_alsoExist.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+5;
//				}
//				if(HomeActivity.I_Exist_C_alsoexist.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+5;
//				}
//				if(HomeActivity.Injection1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}	
//			}
//		}
//		else if(page==10)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Injection.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==9)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Ideas_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_AB.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_AC.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_BD1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_CD2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//				if(HomeActivity.Ideas_D1D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.5;
//				}
//			}
//		}
//		else if(page==8)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.D1_conflict_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==7)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.C_D2_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==6)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.B_D1_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}	
//			}
//		}
//		else if(page==5)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.A_C_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==4)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.A_B_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}	
//			}
//		}
//		else if(page==3)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Why_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==2)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}	
//			}
//		}
//		else if(page==1)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//
//
//				if(HomeActivity.Owner.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//				if(HomeActivity.Story.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}	
//			}
//		}
//		else if(page==12)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.B_D1_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.A_B_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.Why_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
//		else if(page==13)
//		{
//			if((int)HomeActivity.seekbarvalue==100)
//			{
//
//			}
//			else
//			{
//				if(HomeActivity.Title.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;
//				}
//				if(HomeActivity.Objective_A.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_B.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Need_C.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D1.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.Want_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+1.8;
//				}
//				if(HomeActivity.C_D2_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.D1_conflict_D2.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//				if(HomeActivity.A_C_Needed.length()!=0)
//				{
//					HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;
//				}
//			}
//		}
		pop();
	}

	public void push(String id, Intent intent) {
		Window window = getLocalActivityManager().startActivity(id,
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

		if (window != null) {
			stack.push(id);
			a++;
			setContentView(window.getDecorView());
		}
	}


	public void pop() {
		if (stack.size() == 1)
		{//adb.setMessage(Html.fromHtml("<font color='#FF0000'><b>John:</b></font>"+"How are you?"))
			AlertDialog alertDialog = new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_LIGHT).create();

			alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Exit</b></font>"));
			alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Do you really want to exit?</b></font>"));
			alertDialog.setIcon(R.drawable.launchicon);
			alertDialog.setButton("Yes", new  DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					stack = new Stack<String>();
					TabStack.this.finish();
				}
			});
			alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {

				}
			});


			alertDialog.show();
			//finish();
		}
		else
		{
			LocalActivityManager manager = getLocalActivityManager();
			manager.destroyActivity(stack.pop(), true);
			if (stack.size() > 0) {
				Intent lastIntent = manager.getActivity(stack.peek()).getIntent();
				Window newWindow = manager.startActivity(stack.peek(), lastIntent);
				setContentView(newWindow.getDecorView());
			}
		}
	}
}

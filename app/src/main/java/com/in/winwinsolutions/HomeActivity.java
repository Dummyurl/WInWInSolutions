package com.in.winwinsolutions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;

public class HomeActivity extends Activity implements OnClickListener {
	Button btn_new_conflict,btn_open_conflict;
	RelativeLayout Rl_open,Rl_new;
	TextView txtnew,txtopen,txtnewconflict,txtopenconflict;
	Intent in=new Intent();
	TabStack home_services;
	int stack_size;
	File directory;
	public static String Title="",Owner="",Story="",Objective_A="",Objective_A2="",Need_B="",Need_B2="",Need_C="",Need_C2="",Want_D1="",Want_D2="",Why_A="",A_B_Needed="",A2_B2_Needed="",A_C_Needed="",A2_C2_Needed="",B_D1_Needed="",C_D2_Needed="",D1_conflict_D2="",Injection="",I_Exist_B_alsoExist="",I_Exist_C_alsoexist="";
	public static String Ideas_A="",Ideas_AB="",Ideas_AC="",Ideas_BD1="",Ideas_CD2="",Ideas_D1D2="",Injection1="",conflictsolved="no";
	public static String Temp_Objective_A="",Temp_Need_B="",Temp_Need_C="",Temp_A_B_Needed="",Temp_A_C_Needed="",Temp_Injection="";
	public static Boolean Check_conflictsolved=false;
	public static double seekbarvalue=0.0;
	public static double seekbar=0.0;
	public static double pageseekbar=0.0;
	public static Boolean back=false;
	public static Boolean btnback=false;
	public static Boolean btnnext=false;
	public static Boolean jump=false;

	@SuppressLint("ResourceAsColor")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		btn_new_conflict=(Button)findViewById(R.id.btn_new); 
		btn_open_conflict=(Button)findViewById(R.id.btn_open); 
		Rl_new=(RelativeLayout)findViewById(R.id.rlnew);
		Rl_open=(RelativeLayout)findViewById(R.id.rlopen);
		txtnew=(TextView)findViewById(R.id.txtnew);
		txtopen=(TextView)findViewById(R.id.txtopen);
		
		txtnew.setTextColor(getResources().getColor(R.color.btncolor));
		txtopen.setTextColor(getResources().getColor(R.color.btncolor));
		SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putBoolean("dropbox_file",false);
		editor.commit();

		
		Check_conflictsolved=false;	
		seekbarvalue=0.0;
		seekbar=0.0;
		boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
		if (tabletSize) {

			
		} 
		else
		{

			txtnewconflict=(TextView)findViewById(R.id.txtnewconflict);
			txtopenconflict=(TextView)findViewById(R.id.txtopenconflict);
			txtnewconflict.setTextColor(getResources().getColor(R.color.btncolor));
			txtopenconflict.setTextColor(getResources().getColor(R.color.btncolor));
		}
		
		
		btn_new_conflict.setOnClickListener(this); 
		btn_open_conflict.setOnClickListener(this);
		Rl_open.setOnClickListener(this); 
		Rl_new.setOnClickListener(this); 
		home_services=(TabStack)getParent();
		File sdCard = Environment.getExternalStorageDirectory();
		directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
		directory.mkdirs();

		File sdCard1 = Environment.getExternalStorageDirectory();
		directory = new File (sdCard1.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
		directory.mkdirs();
		Tabs.btn_exit_app.setText("Exit App");
		Tabs.btn_line2.setText("|");
		Tabs.btn_faq.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				stack_size=TabStack.stack.size();
				for(int i=1;i<stack_size;i++)
				{
					home_services.pop();	
				}
				in.setClass(getParent(),FAQ.class);
				home_services.push("faq",in);

			}
		});
		Tabs.btn_home.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});

		Tabs.btn_exit_app.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for(int i=0;i<stack_size;i++)
				{
					home_services.pop();	
				}
				finish();
			}
		});
		Tabs.btn_home.setTextColor(getResources().getColor(R.color.color_name1));
		Tabs.btn_faq.setTextColor(getResources().getColor(R.color.color_name2));
		Tabs.btn_exit_app.setTextColor(getResources().getColor(R.color.color_name2));
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.btn_new:
		case R.id.rlnew:
			SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
			SharedPreferences.Editor editor = sp.edit();
			editor.putInt("file_open", 0);
			editor.commit();
			Method m=new Method();
			m.run();

			Tabs.btn_home.setTextColor(getResources().getColor(R.color.color_name2));
			Tabs.btn_faq.setTextColor(getResources().getColor(R.color.color_name2));

			boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
			if (tabletSize) {

				in.setClass(getParent(),TabPage1.class);
				home_services.push("page1",in);
			} 
			else
			{

				in.setClass(getParent(),Page1.class);
				home_services.push("page1",in);
			}


			break;
		case R.id.btn_open:
		case R.id.rlopen:
			Tabs.btn_home.setTextColor(getResources().getColor(R.color.color_name2));
			Tabs.btn_faq.setTextColor(getResources().getColor(R.color.color_name2));
			in.setClass(getParent(),DeviceFileList.class);
			home_services.push("conflict",in);
			break;
		case R.id.btn_close:
		case R.id.rlclose:
			break;
		}
	}
}

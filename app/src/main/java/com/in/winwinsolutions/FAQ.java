package com.in.winwinsolutions;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FAQ extends Activity implements OnClickListener {
	TextView textview1,link;
	Button btn_new_conflict,btn_open_conflict;
	RelativeLayout Rl_open,Rl_new;
	TextView txtnew,txtopen,txtnewconflict,txtopenconflict;
	Intent in=new Intent();
	TabStack home_services;
	int stack_size;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.faqq);
		//		textview1=(TextView)findViewById(R.id.textView1);
		//		textview1.setText("Q&A:");
		btn_new_conflict=(Button)findViewById(R.id.btn_new); 
		btn_open_conflict=(Button)findViewById(R.id.btn_open);
		Rl_new=(RelativeLayout)findViewById(R.id.rlnew);
		Rl_open=(RelativeLayout)findViewById(R.id.rlopen);
		txtnew=(TextView)findViewById(R.id.txtnew);
		txtopen=(TextView)findViewById(R.id.txtopen);

		link=(TextView) findViewById(R.id.link);
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
		txtnew.setTextColor(getResources().getColor(R.color.btncolor));
		txtopen.setTextColor(getResources().getColor(R.color.btncolor));
		home_services=(TabStack)getParent();
		SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putInt("file_open", 0);
		editor.putBoolean("dropbox_file",false);
		editor.commit();
		
		
		Tabs.btn_exit_app.setText("");
		Tabs.btn_line2.setText("");
		Tabs.btn_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stack_size=TabStack.stack.size();
				for(int i=1;i<stack_size;i++)
				{
					home_services.pop();	
				}
				in.setClass(getParent(),HomeActivity.class);
				home_services.push("home",in);
			}
		});

		link.setMovementMethod(LinkMovementMethod.getInstance());
		Tabs.btn_faq.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		Tabs.btn_home.setTextColor(getResources().getColor(R.color.color_name2));

		Tabs.btn_faq.setTextColor(getResources().getColor(R.color.color_name1));}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.btn_new:
		case R.id.rlnew:
			//			Tabs.btn_home.setTextColor(getResources().getColor(R.color.color_name2));
			//			Tabs.btn_faq.setTextColor(getResources().getColor(R.color.color_name2));
			//			in.setClass(getParent(),Page1.class);
			//			home_services.push("page1",in);


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

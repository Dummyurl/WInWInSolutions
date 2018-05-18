package com.in.winwinsolutions;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tabs extends TabActivity {
	public static Tabs myTabLayoutDemo;
	private static final String Email = "Email";

	public static TabHost tabHost;

	public static Button btn_home,btn_faq,btn_exit_app,btn_line2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_tabs);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
		btn_home=(Button) findViewById(R.id.btn_home);
		btn_faq=(Button) findViewById(R.id.btn_faq);
		btn_exit_app=(Button)findViewById(R.id.btnexit);
		btn_line2=(Button)findViewById(R.id.btnline2);
		tabHost = getTabHost();
		tabHost.getTabWidget().setStripEnabled(false);
		boolean result = Utility.checkPermission(Tabs.this);
		TabSpec email = tabHost.newTabSpec(Email);
		email.setIndicator(prepareTabView(Email,R.drawable.ic_launcher));
		Intent emailIntent = new Intent(this, TabStack.class);
		emailIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		email.setContent(emailIntent);




		tabHost.addTab(email);
	}
	private View prepareTabView(String text, int resId) {
		View view = LayoutInflater.from(this).inflate(R.layout.tabss, null);
		ImageView iv = (ImageView) view.findViewById(R.id.TabImageView);
		iv.setBackgroundResource(resId);
		return view;
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();

	}
}

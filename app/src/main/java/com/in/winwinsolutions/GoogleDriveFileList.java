package com.in.winwinsolutions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GoogleDriveFileList extends Activity implements OnClickListener{
	Button btn_new_conflict,btn_open_conflict,btn_close_conflict,btn_Drop,btn_drive,btn_device;
	Intent in=new Intent();
	TabStack home_services;
	int stack_size;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.google_drive_file_list);
		btn_Drop=(Button)findViewById(R.id.btn_drop);
		btn_device=(Button)findViewById(R.id.btn_device);
		btn_drive=(Button)findViewById(R.id.btn_drive);
		btn_new_conflict=(Button)findViewById(R.id.btn_new); 
		btn_close_conflict=(Button)findViewById(R.id.btn_close); 
		btn_open_conflict=(Button)findViewById(R.id.btn_open); 
		btn_drive.setSelected(true);
		btn_device.setSelected(false);
		btn_Drop.setSelected(false);
		btn_new_conflict.setOnClickListener(this); 
		btn_open_conflict.setOnClickListener(this); 
		btn_close_conflict.setOnClickListener(this); 
		btn_Drop.setOnClickListener(this);
		btn_drive.setOnClickListener(this);
		btn_device.setOnClickListener(this);
		home_services=(TabStack)getParent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.google_drive_file, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_new:
			SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
			SharedPreferences.Editor editor = sp.edit();
			editor.putInt("file_open", 0);
			editor.commit();
			Method m=new Method();
			m.run();
			int stack_sizee=TabStack.stack.size();
			for(int i=1;i<stack_sizee;i++)
			{
				home_services.pop();	
			}
			in.setClass(getParent(),Page1.class);
			home_services.push("n_page1",in);
			break;
		case R.id.btn_open:
			break;
		case R.id.btn_close:
			int stack_size=TabStack.stack.size();
			for(int i=1;i<stack_size;i++)
			{
				home_services.pop();	
			}
			break;
		case R.id.btn_drop:
			ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
			if (!cd.isConnectingToInternet()) {
				AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
				alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Internet Connection Error</b></font>"));
				alertDialog.setMessage("Please connect to working Internet connection");
				alertDialog.setIcon(R.drawable.launchicon);
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				alertDialog.show();
				return;
			}
			in.setClass(getParent(),DropBoxFileList.class);
			home_services.push("dropbox",in);

			break;
		case R.id.btn_drive:
			

			break;
		case R.id.btn_device:
			in.setClass(getParent(),DeviceFileList.class);
			home_services.push("device",in);
			break;

		}
	}
}

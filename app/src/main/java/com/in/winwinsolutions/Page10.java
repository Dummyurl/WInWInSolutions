package com.in.winwinsolutions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Page10 extends Activity implements OnClickListener,OnTouchListener{
	Button btn_new_conflict,btn_open_conflict,btn_close_conflict,btn_next,btn_back,btnreset;
	TextView Text_A,Text_AB,Text_AC,Text_BD1,Text_CD2,Text_D1D2;
	EditText edt_title,edt_injections;
	Intent in=new Intent();
	TabStack home_services;
	int stack_size;
	int myIntValue;
	String file_name;
	File directory;
	TextView error,tvcompleted;
	RelativeLayout toplayout;
	Button btnsave,btncancel;
	EditText edtfilename;
	TextView empty;
	ScrollView sc;
	Button btnWhya, btnWhyb,btnWhyc, btnWhyd1, btnWhyd2, btnconflict,btnstory,btndiagrom,btnidea,btnsolution,btncheck;
	ImageView imgtitlehint;
	LinearLayout firstscrolllayout;
	int a=0;
	Boolean ConflictSolve;
	int k,textlength,j,l;
	SeekBar seekbarCompleted;
	RelativeLayout Rl_open,Rl_new,Rl_close,seek,seekcompleted;;
	TextView txtnew,txtopen,txtclose,txtnewconflict,txtopenconflict,txtcloseconflict;
	double seekvalue;
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	PopupWindow popupWindow ;
	Boolean dropbox_file;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page10);
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedpreferences.edit();
		editor.putInt("page",10);
		//		editor.commit();




		btn_new_conflict=(Button)findViewById(R.id.btn_new); 
		btn_close_conflict=(Button)findViewById(R.id.btn_close); 
		btn_open_conflict=(Button)findViewById(R.id.btn_open); 

		btn_next=(Button)findViewById(R.id.btn_next); 
		btn_back=(Button)findViewById(R.id.btn_back); 
		btnreset=(Button)findViewById(R.id.btnreset);
		toplayout=(RelativeLayout) findViewById(R.id.toplayout);
		Text_A=(TextView)findViewById(R.id.txt_a);
		Text_AB=(TextView)findViewById(R.id.txt_ab);
		Text_AC=(TextView)findViewById(R.id.txt_ac);
		Text_BD1=(TextView)findViewById(R.id.txt_bd1);
		Text_CD2=(TextView)findViewById(R.id.txt_cd2);
		Text_D1D2=(TextView)findViewById(R.id.txt_d1d2);

		Text_A.setMovementMethod(new ScrollingMovementMethod());
		Text_A.setOnTouchListener(this);
		Text_AB.setMovementMethod(new ScrollingMovementMethod());
		Text_AB.setOnTouchListener(this);
		Text_AC.setMovementMethod(new ScrollingMovementMethod());
		Text_AC.setOnTouchListener(this);
		Text_BD1.setMovementMethod(new ScrollingMovementMethod());
		Text_BD1.setOnTouchListener(this);
		Text_CD2.setMovementMethod(new ScrollingMovementMethod());
		Text_CD2.setOnTouchListener(this);
		Text_D1D2.setMovementMethod(new ScrollingMovementMethod());
		Text_D1D2.setOnTouchListener(this);
		imgtitlehint=(ImageView)findViewById(R.id.imghint);
		firstscrolllayout=(LinearLayout)findViewById(R.id.firstscrolllayout);

		error=(TextView) findViewById(R.id.error);

		Rl_new=(RelativeLayout)findViewById(R.id.rlnew);
		Rl_open=(RelativeLayout)findViewById(R.id.rlopen);
		Rl_close=(RelativeLayout)findViewById(R.id.rlclose);
		seek=(RelativeLayout)findViewById(R.id.seek);
		seekcompleted=(RelativeLayout)findViewById(R.id.seekcompleted);
		txtnew=(TextView)findViewById(R.id.txtnew);
		txtopen=(TextView)findViewById(R.id.txtopen);
		txtclose=(TextView)findViewById(R.id.txtclose);
		txtnewconflict=(TextView)findViewById(R.id.txtnewconflict);
		txtopenconflict=(TextView)findViewById(R.id.txtopenconflict);
		txtcloseconflict=(TextView)findViewById(R.id.txtcloseconflict);

		edt_injections=(EditText)findViewById(R.id.injections);
		edt_title=(EditText)findViewById(R.id.title);

		btnWhya=(Button)findViewById(R.id.btnwhya); 
		btnWhyb=(Button)findViewById(R.id.btnwhyb);
		btnWhyc=(Button)findViewById(R.id.btnwhyc);
		btnWhyd1=(Button)findViewById(R.id.btnwhyd);
		btnWhyd2=(Button)findViewById(R.id.btnwhyd2);
		btnconflict=(Button)findViewById(R.id.btnconflict);
		btnstory=(Button)findViewById(R.id.btnstory);
		btndiagrom=(Button)findViewById(R.id.btndiagrom);
		btnidea=(Button)findViewById(R.id.btnidea);
		btnsolution=(Button)findViewById(R.id.btnsolution);
		btncheck=(Button)findViewById(R.id.btncheck);

		btnWhya.setOnClickListener(this);
		btnWhyb.setOnClickListener(this);
		btnWhyc.setOnClickListener(this);
		btnWhyd1.setOnClickListener(this);
		btnWhyd2.setOnClickListener(this);
		btnconflict.setOnClickListener(this);
		btnstory.setOnClickListener(this);
		btndiagrom.setOnClickListener(this);
		btnidea.setOnClickListener(this);
		btnsolution.setOnClickListener(this);
		btncheck.setOnClickListener(this);
		btnreset.setOnClickListener(this);
		edt_title.setEnabled(false);

		btnWhya.setTextColor(getResources().getColor(R.color.color_name3));
		btnWhyb.setTextColor(getResources().getColor(R.color.color_name3));
		btnWhyc.setTextColor(getResources().getColor(R.color.color_name3));
		btnWhyd1.setTextColor(getResources().getColor(R.color.color_name3));
		btnWhyd2.setTextColor(getResources().getColor(R.color.color_name3));
		btnconflict.setTextColor(getResources().getColor(R.color.color_name3));
		btnstory.setTextColor(getResources().getColor(R.color.color_name3));
		btndiagrom.setTextColor(getResources().getColor(R.color.color_name3));
		btnidea.setTextColor(getResources().getColor(R.color.color_name3));
		btnsolution.setTextColor(getResources().getColor(R.color.color_name1));
		btncheck.setTextColor(getResources().getColor(R.color.color_name3));
		edt_injections.setMovementMethod(new ScrollingMovementMethod());
		edt_injections.setOnTouchListener(this);
		LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
		View popupView = layoutInflater.inflate(R.layout.textview_hint, null);  
		popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
		TextView text=(TextView)popupView.findViewById(R.id.popuptext);
		text.setText("Should you need to make further changes to 'Title' and 'Ideas' please go back to previous screens.");

		imgtitlehint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(a==0)
				{

					popupWindow.showAsDropDown(edt_title, 0, 0);
					a=1;
				}
				else
				{
					popupWindow.dismiss();
					a=0;
				}


			}
		});
		firstscrolllayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//				edt_title.setError(null);
				popupWindow.dismiss();
				a=0;
			}
		});

		NumberKeyListener PwdkeyListener = new NumberKeyListener() {

			public int getInputType() {
				return InputType.TYPE_MASK_VARIATION;
			}

			@Override
			protected char[] getAcceptedChars() {
				return new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
						'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
						'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '@', '.', '_', '#', '$', '%', '&', '*', '-', '+', '(', ')', '!', '"', '\'', ':', 
						';', '/', '?', ',', '~', '`', '|', '\\', '^', '<', '>', '{', '}', '[', ']', '=', '.', '�','\n',' ','�', '�', '�', '�'};
			}
		};

		edt_title.setKeyListener(PwdkeyListener);
		edt_injections.setKeyListener(PwdkeyListener);

		btn_new_conflict.setOnClickListener(this); 
		btn_open_conflict.setOnClickListener(this); 
		btn_close_conflict.setOnClickListener(this); 
		Rl_open.setOnClickListener(this); 
		Rl_new.setOnClickListener(this); 
		Rl_close.setOnClickListener(this); 
		btn_back.setOnClickListener(this); 

		home_services=(TabStack)getParent();


		seekbarCompleted = (SeekBar)findViewById(R.id.sBcompleted);
		tvcompleted = (TextView)findViewById(R.id.tvcompleted);
		if(HomeActivity.Injection.length()==0)
		{
			editor.putInt("injection",-1);

		}

		editor.commit();
		HomeActivity.seekbarvalue=round(HomeActivity.seekbarvalue, 2);
		tvcompleted.setText(HomeActivity.seekbarvalue+"%");
		seekbarCompleted.setProgress((int)HomeActivity.seekbarvalue);
		seekbarCompleted.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

				tvcompleted.setText(HomeActivity.seekbarvalue+"%");
				seekBar.setProgress((int)HomeActivity.seekbarvalue);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}

		});
		edt_injections.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				reset();
				// put the code of save Database here 
				popupWindow.dismiss();
				if(edt_injections.getText().toString().length()>=1)
				{
					btnreset.setSelected(false);
				}
				sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
				int check_injection = sharedpreferences.getInt("injection", 0);
				if(edt_injections.getText().toString().length()>0)
				{


					if(check_injection==0)
					{
						HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+9;	
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("injection",1);
						editor.commit();
						HomeActivity.seekbarvalue=round(HomeActivity.seekbarvalue, 2);
						tvcompleted.setText(HomeActivity.seekbarvalue+"%");
						seekbarCompleted.setProgress((int)HomeActivity.seekbarvalue);
					}
				}
				else
				{
					if(check_injection==-1)
					{
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("injection",0);
						editor.commit();
					}
					else
					{
						HomeActivity.seekbarvalue=HomeActivity.seekbarvalue-9;	
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("injection",0);
						editor.commit();
						HomeActivity.seekbarvalue=round(HomeActivity.seekbarvalue, 2);
						tvcompleted.setText(HomeActivity.seekbarvalue+"%");
						seekbarCompleted.setProgress((int)HomeActivity.seekbarvalue);
					}

				}	

			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}
		});
		SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
		myIntValue = sp.getInt("file_open", 0);
		dropbox_file = sp.getBoolean("dropbox_file", false);
		ConflictSolve=sp.getBoolean("ConflictSolve", false);
		if(myIntValue==0)
		{
			btn_new_conflict.setSelected(true);
			txtnew.setTextColor(getResources().getColor(R.color.btncolorhover));
			txtopen.setTextColor(getResources().getColor(R.color.btncolor));
			txtclose.setTextColor(getResources().getColor(R.color.btncolor));
			txtnewconflict.setTextColor(getResources().getColor(R.color.btncolorhover));
			txtopenconflict.setTextColor(getResources().getColor(R.color.btncolor));
			txtcloseconflict.setTextColor(getResources().getColor(R.color.btncolor));
			Text_A.setText(HomeActivity.Ideas_A);
			Text_AB.setText(HomeActivity.Ideas_AB);
			Text_AC.setText(HomeActivity.Ideas_AC);
			Text_BD1.setText(HomeActivity.Ideas_BD1);
			Text_CD2.setText(HomeActivity.Ideas_CD2);
			Text_D1D2.setText(HomeActivity.Ideas_D1D2);

			edt_title.setText(HomeActivity.Title);
			edt_injections.setText(HomeActivity.Injection);
		}
		else
		{
			if(ConflictSolve)
			{
				btn_new_conflict.setSelected(false);
				Text_A.setText(HomeActivity.Ideas_A);
				Text_AB.setText(HomeActivity.Ideas_AB);
				Text_AC.setText(HomeActivity.Ideas_AC);
				Text_BD1.setText(HomeActivity.Ideas_BD1);
				Text_CD2.setText(HomeActivity.Ideas_CD2);
				Text_D1D2.setText(HomeActivity.Ideas_D1D2);

				edt_title.setText(HomeActivity.Title);
				edt_injections.setText(HomeActivity.Injection);
				btn_open_conflict.setSelected(true);

				txtnew.setTextColor(getResources().getColor(R.color.btncolor));
				txtopen.setTextColor(getResources().getColor(R.color.btncolorhover));
				txtclose.setTextColor(getResources().getColor(R.color.btncolor));
				txtnewconflict.setTextColor(getResources().getColor(R.color.btncolor));
				txtopenconflict.setTextColor(getResources().getColor(R.color.btncolorhover));
				txtcloseconflict.setTextColor(getResources().getColor(R.color.btncolor));


				edt_title.setKeyListener(null);
				Text_A.setKeyListener(null);
				Text_AB.setKeyListener(null);
				Text_AC.setKeyListener(null);
				Text_BD1.setKeyListener(null);
				Text_CD2.setKeyListener(null);
				Text_D1D2.setKeyListener(null);
				edt_injections.setKeyListener(null);
				edt_title.setBackgroundColor(getResources().getColor(R.color.gray));
				Text_A.setBackgroundColor(getResources().getColor(R.color.gray));
				Text_AB.setBackgroundColor(getResources().getColor(R.color.gray));
				Text_AC.setBackgroundColor(getResources().getColor(R.color.gray));
				Text_BD1.setBackgroundColor(getResources().getColor(R.color.gray));
				Text_CD2.setBackgroundColor(getResources().getColor(R.color.gray));
				Text_D1D2.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_injections.setBackgroundColor(getResources().getColor(R.color.gray));
				imgtitlehint.setVisibility(View.GONE);
				seekbarCompleted.setVisibility(View.GONE);
				tvcompleted.setVisibility(View.GONE);
				btnreset.setVisibility(View.GONE);
				seek.setVisibility(View.GONE);
				seekcompleted.setVisibility(View.GONE);
			}
			else
			{
				if(HomeActivity.Injection.length()>0)
				{
					editor.putInt("injection",1);

				}

				editor.commit();
				btn_new_conflict.setSelected(false);
				Text_A.setText(HomeActivity.Ideas_A);
				Text_AB.setText(HomeActivity.Ideas_AB);
				Text_AC.setText(HomeActivity.Ideas_AC);
				Text_BD1.setText(HomeActivity.Ideas_BD1);
				Text_CD2.setText(HomeActivity.Ideas_CD2);
				Text_D1D2.setText(HomeActivity.Ideas_D1D2);

				edt_title.setText(HomeActivity.Title);
				edt_injections.setText(HomeActivity.Injection);
				btn_open_conflict.setSelected(true);
				txtnew.setTextColor(getResources().getColor(R.color.btncolor));
				txtopen.setTextColor(getResources().getColor(R.color.btncolorhover));
				txtclose.setTextColor(getResources().getColor(R.color.btncolor));
				txtnewconflict.setTextColor(getResources().getColor(R.color.btncolor));
				txtopenconflict.setTextColor(getResources().getColor(R.color.btncolorhover));
				txtcloseconflict.setTextColor(getResources().getColor(R.color.btncolor));
			}
		}

		Tabs.btn_home.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HomeActivity.Title=edt_title.getText().toString();
				HomeActivity.Injection=edt_injections.getText().toString();
				popupWindow.dismiss();
				if(myIntValue==1)
				{
					if((HomeActivity.Title.equalsIgnoreCase(""))&&(HomeActivity.Owner.equalsIgnoreCase(""))&&(HomeActivity.Story.equalsIgnoreCase(""))&&(HomeActivity.Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Objective_A2.equalsIgnoreCase(""))&&(HomeActivity.Need_B.equalsIgnoreCase(""))&&(HomeActivity.Need_B2.equalsIgnoreCase(""))&&(HomeActivity.Need_C.equalsIgnoreCase(""))&&(HomeActivity.Need_C2.equalsIgnoreCase(""))&&(HomeActivity.Want_D1.equalsIgnoreCase(""))&&(HomeActivity.Want_D2.equalsIgnoreCase(""))&&(HomeActivity.Why_A.equalsIgnoreCase(""))&&(HomeActivity.A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_B2_Needed.equalsIgnoreCase(""))&&(HomeActivity.A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_C2_Needed.equalsIgnoreCase(""))&&(HomeActivity.B_D1_Needed.equalsIgnoreCase(""))&&(HomeActivity.C_D2_Needed.equalsIgnoreCase(""))&&(HomeActivity.D1_conflict_D2.equalsIgnoreCase(""))&&(HomeActivity.Injection.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_B_alsoExist.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_C_alsoexist.equalsIgnoreCase(""))&&(HomeActivity.Ideas_A.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AB.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AC.equalsIgnoreCase(""))&&(HomeActivity.Ideas_BD1.equalsIgnoreCase(""))&&(HomeActivity.Ideas_CD2.equalsIgnoreCase(""))&&(HomeActivity.Ideas_D1D2.equalsIgnoreCase(""))&&(HomeActivity.Injection1.equalsIgnoreCase("")))
					{
						stack_size=TabStack.stack.size();
						for(int i=1;i<stack_size;i++)
						{
							home_services.pop();	
						}
					}
					else
					{
						if(dropbox_file)
						{
							AlertDialog.Builder builder = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);
							builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Save Conflict</b></font>"));
							builder.setMessage(Html.fromHtml("<font color='#00478f'><b>Where would you like to save the conflict file?</b></font>"));
							builder.setIcon(R.drawable.launchicon);
							builder.setPositiveButton("Device", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
									alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>File saved</b></font>"));
									alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Your file has been saved and can be accessed via the Device tab</b></font>"));
									alertDialog.setIcon(R.drawable.launchicon);
									alertDialog.setCancelable(false);
									alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog, int which) {
											file_name=DeviceFileList.File_name;

											//						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
											//						boolean deleted = file.delete();

											if(HomeActivity.Check_conflictsolved)
											{
												//							file_name=DeviceFileList.File_name;
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);

											}	
											else
											{
												//							file_name=DeviceFileList.File_name;
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

											}

											FileSave fs=new FileSave();
											fs.XLS(directory, file_name);
											stack_size=TabStack.stack.size();
											Method m=new Method();
											m.run();
											for(int i=1;i<stack_size;i++)
											{
												home_services.pop();	
											}in.setClass(getParent(),HomeActivity.class);
											home_services.push("home"+TabStack.a,in);
											SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
											SharedPreferences.Editor editor = sp.edit();
											editor.putInt("file_open", 0);
											editor.commit();//com.dropbox.android
										}
									});
									alertDialog.show();
									
									
								}
							})
							.setNeutralButton("Dropbox", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {


									file_name=DeviceFileList.File_name;

									//						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox", file_name);
									//						boolean deleted = file.delete();

									File sdCard = Environment.getExternalStorageDirectory();
									directory = new File (sdCard.getAbsolutePath() + "/Conflict_Dropbox");
									File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Dropbox/"+file_name);

									FileSave fs=new FileSave();
									fs.XLS(directory, file_name);
									stack_size=TabStack.stack.size();
									Method m=new Method();
									m.run();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}in.setClass(getParent(),HomeActivity.class);
									home_services.push("home"+TabStack.a,in);
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();//com.dropbox.android


									List<Intent> targetedShareIntents = new ArrayList<Intent>();

									Intent shareIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
									shareIntent.setType("text/*");
									List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(shareIntent, 0);

									if (!resInfo.isEmpty())
									{

										for (ResolveInfo resolveInfo : resInfo) {

											String packageName = resolveInfo.activityInfo.packageName;
											String Name = resolveInfo.activityInfo.name;
											Log.v("hari", "packageName:"+packageName) ;



											if ((resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.dropbox.android"))) {
												Intent targetedShareIntent = new Intent(Intent.ACTION_SEND);
												targetedShareIntent.
												putExtra(Intent.EXTRA_STREAM,
														Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox",file_name)));

												targetedShareIntent.setType("text/xml");
												targetedShareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
												//											targetedShareIntent.
												//											putExtra(android.content.Intent.EXTRA_SUBJECT,str);
												//											
												targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT,"Please find the attached conflict file");
												targetedShareIntent.setPackage(packageName);
												targetedShareIntents.add(targetedShareIntent);
											}  
										}
										Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0),
												"Select app to share");
										chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.
												toArray(new Parcelable[]{}));
										Log.v("hari", "chooserIntent:"+chooserIntent) ;
										startActivity(chooserIntent);
									}


								}
							});
							builder.setNegativeButton("Close without saving", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();

									Method m=new Method();
									m.run();
									stack_size=TabStack.stack.size();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}
									in.setClass(getParent(),HomeActivity.class);
									home_services.push("home"+TabStack.a,in);
								}
							});
							AlertDialog alert = builder.create();
							alert.show();
							//	((Button)alert.findViewById(android.R.id.button1)).setBackgroundResource(R.drawable.button_border);
						}
						else
						{

							AlertDialog.Builder builder = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);
							builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Close conflict</b></font>"));
							builder.setMessage(Html.fromHtml("<font color='#00478f'><b>All data will be lost which you changed.Do you want to save or exit without saving?</b></font>"));
							builder.setIcon(R.drawable.launchicon);
							builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									file_name=DeviceFileList.File_name;

									File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
									boolean deleted = file.delete();

									if(HomeActivity.Check_conflictsolved)
									{
										//							file_name=DeviceFileList.File_name;
										File sdCard = Environment.getExternalStorageDirectory();
										directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
										File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);

									}	
									else
									{
										//							file_name=DeviceFileList.File_name;
										File sdCard = Environment.getExternalStorageDirectory();
										directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
										File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

									}

									FileSave fs=new FileSave();
									fs.XLS(directory, file_name);
									stack_size=TabStack.stack.size();
									Method m=new Method();
									m.run();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}
									setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
									toplayout.setAlpha(1F);
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();

									in.setClass(getParent(),HomeActivity.class);
									home_services.push("home"+TabStack.a,in);
								}
							});

							builder.setNeutralButton("Save As", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

									if(getResources().getConfiguration().orientation==1)
									{

									}
									else
									{
										setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
									}
									LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
									View popupView = layoutInflater.inflate(R.layout.popup, null);  
									final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

									btncancel = (Button)popupView.findViewById(R.id.btncancel);
									btnsave = (Button)popupView.findViewById(R.id.btnsave);
									edtfilename=(EditText)popupView.findViewById(R.id.edtfilename);
									empty=(TextView)popupView.findViewById(R.id.error);
									btncancel.setOnClickListener(new OnClickListener(){

										@Override
										public void onClick(View v) {
											// TODO Auto-generated method stub
											setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
											toplayout.setAlpha(1F);
											popupWindow.dismiss();
										}});
									btnsave.setOnClickListener(new OnClickListener(){

										@Override
										public void onClick(View v) {
											// TODO Auto-generated method stub
											file_name=edtfilename.getText().toString();
											if(HomeActivity.Check_conflictsolved)
											{
												if(file_name.trim().length()<1)
												{
													empty.setVisibility(View.VISIBLE);
													empty.setText("Please enter file name");

												}
												else
												{

													file_name=file_name+"_conflict.xlsx";
													File sdCard = Environment.getExternalStorageDirectory();
													directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
													File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
													if(myFile.exists())
													{
														Log.e("File exist","exist");
														empty.setVisibility(View.VISIBLE);
														empty.setText("File name already exists");

													}
													else
													{
														popupWindow.dismiss();
														FileSave fs=new FileSave();
														fs.XLS(directory, file_name);
														stack_size=TabStack.stack.size();
														Method m=new Method();
														m.run();
														for(int i=1;i<stack_size;i++)
														{
															home_services.pop();	
														}
														SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
														SharedPreferences.Editor editor = sp.edit();
														editor.putInt("file_open", 0);
														editor.commit();
														setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
														in.setClass(getParent(),HomeActivity.class);
														home_services.push("home"+TabStack.a,in);
														toplayout.setAlpha(1F);
													}	
												}
											}
											else
											{

												if(file_name.trim().length()<1)
												{
													empty.setVisibility(View.VISIBLE);
													empty.setText("Please enter file name");

												}
												else
												{
													file_name=file_name+"_conflict.xlsx";
													File sdCard = Environment.getExternalStorageDirectory();
													directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
													File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
													if(myFile.exists()){
														Log.e("File exist","exist");
														empty.setVisibility(View.VISIBLE);
														empty.setText("File name already exists");

													}
													else
													{
														popupWindow.dismiss();
														FileSave fs=new FileSave();
														fs.XLS(directory, file_name);
														SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
														SharedPreferences.Editor editor = sp.edit();
														editor.putInt("file_open", 0);
														editor.commit();

														Method m=new Method();
														m.run();
														stack_size=TabStack.stack.size();
														for(int i=1;i<stack_size;i++)
														{
															home_services.pop();	
														}
														toplayout.setAlpha(1F);
														setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
														in.setClass(getParent(),HomeActivity.class);
														home_services.push("home"+TabStack.a,in);
													}
												}
											}
										}});
									popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,200);
									popupWindow.setFocusable(true);
									popupWindow.update();
									toplayout.setAlpha(0.7F);
								}
							});
							builder.setNegativeButton("Close without saving", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) {
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();

									Method m=new Method();
									m.run();
									stack_size=TabStack.stack.size();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}
									in.setClass(getParent(),HomeActivity.class);
									home_services.push("home"+TabStack.a,in);
								}
							});
							if(ConflictSolve)
							{

								stack_size=TabStack.stack.size();
								for(int i=1;i<stack_size;i++)
								{
									home_services.pop();	
								}
								Method m=new Method();
								m.run();
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();

								editor.putBoolean("ConflictSolve", false);
								editor.putInt("file_open", 0);
								editor.commit();

								in.setClass(getParent(),HomeActivity.class);
								home_services.push("home"+TabStack.a,in);
							}
							else
							{
								AlertDialog alert = builder.create();
								alert.show();
							}

						}
					}
				}
				else
				{
					if((HomeActivity.Title.equalsIgnoreCase(""))&&(HomeActivity.Owner.equalsIgnoreCase(""))&&(HomeActivity.Story.equalsIgnoreCase(""))&&(HomeActivity.Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Objective_A2.equalsIgnoreCase(""))&&(HomeActivity.Need_B.equalsIgnoreCase(""))&&(HomeActivity.Need_B2.equalsIgnoreCase(""))&&(HomeActivity.Need_C.equalsIgnoreCase(""))&&(HomeActivity.Need_C2.equalsIgnoreCase(""))&&(HomeActivity.Want_D1.equalsIgnoreCase(""))&&(HomeActivity.Want_D2.equalsIgnoreCase(""))&&(HomeActivity.Why_A.equalsIgnoreCase(""))&&(HomeActivity.A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_B2_Needed.equalsIgnoreCase(""))&&(HomeActivity.A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_C2_Needed.equalsIgnoreCase(""))&&(HomeActivity.B_D1_Needed.equalsIgnoreCase(""))&&(HomeActivity.C_D2_Needed.equalsIgnoreCase(""))&&(HomeActivity.D1_conflict_D2.equalsIgnoreCase(""))&&(HomeActivity.Injection.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_B_alsoExist.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_C_alsoexist.equalsIgnoreCase(""))&&(HomeActivity.Ideas_A.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AB.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AC.equalsIgnoreCase(""))&&(HomeActivity.Ideas_BD1.equalsIgnoreCase(""))&&(HomeActivity.Ideas_CD2.equalsIgnoreCase(""))&&(HomeActivity.Ideas_D1D2.equalsIgnoreCase(""))&&(HomeActivity.Injection1.equalsIgnoreCase("")))
					{
						stack_size=TabStack.stack.size();
						for(int i=1;i<stack_size;i++)
						{
							home_services.pop();	
						}
					}
					else
					{
						AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

						alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Close conflict</b></font>"));
						alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>All data will be lost.Do you want to save or exit without saving?</b></font>"));
						alertDialog.setIcon(R.drawable.launchicon);
						alertDialog.setButton("Save", new  DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								if(getResources().getConfiguration().orientation==1)
								{

								}
								else
								{
									setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
								}
								LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
								View popupView = layoutInflater.inflate(R.layout.popup, null);  
								final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

								btncancel = (Button)popupView.findViewById(R.id.btncancel);
								btnsave = (Button)popupView.findViewById(R.id.btnsave);
								edtfilename=(EditText)popupView.findViewById(R.id.edtfilename);
								empty=(TextView)popupView.findViewById(R.id.error);
								btncancel.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
										toplayout.setAlpha(1F);
										popupWindow.dismiss();
									}});
								btnsave.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										file_name=edtfilename.getText().toString();
										if(file_name.trim().length()<1)
										{
											empty.setVisibility(View.VISIBLE);
											empty.setText("Please enter file name");

										}
										else
										{
											if(HomeActivity.Check_conflictsolved)
											{
												file_name=file_name+"_conflict.xlsx";
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
												if(myFile.exists())
												{
													Log.e("File exist","exist");
													empty.setVisibility(View.VISIBLE);
													empty.setText("File name already exists");

												}
												else
												{
													popupWindow.dismiss();
													FileSave fs=new FileSave();
													fs.XLS(directory, file_name);
													stack_size=TabStack.stack.size();
													Method m=new Method();
													m.run();
													for(int i=1;i<stack_size;i++)
													{
														home_services.pop();	
													}
													setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
													in.setClass(getParent(),HomeActivity.class);
													home_services.push("home"+TabStack.a,in);
													toplayout.setAlpha(1F);
												}	
											}
											else
											{


												file_name=file_name+"_conflict.xlsx";
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
												if(myFile.exists()){
													Log.e("File exist","exist");
													empty.setVisibility(View.VISIBLE);
													empty.setText("File name already exists");

												}
												else
												{
													popupWindow.dismiss();
													FileSave fs=new FileSave();
													fs.XLS(directory, file_name);
													stack_size=TabStack.stack.size();
													Method m=new Method();
													m.run();
													for(int i=1;i<stack_size;i++)
													{
														home_services.pop();	
													}
													toplayout.setAlpha(1F);
													setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
													in.setClass(getParent(),HomeActivity.class);
													home_services.push("home"+TabStack.a,in);
												}
											}
										}
									}});
								popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,200);
								popupWindow.setFocusable(true);
								popupWindow.update();
								toplayout.setAlpha(0.7F);
							}
						});
						alertDialog.setButton2("Close without saving", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								Method m=new Method();
								m.run();
								stack_size=TabStack.stack.size();
								for(int i=1;i<stack_size;i++)
								{
									home_services.pop();	
								}
							}
						});
						alertDialog.show();
					}
				}
			}
		});
		Tabs.btn_faq.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HomeActivity.Title=edt_title.getText().toString();
				HomeActivity.Injection=edt_injections.getText().toString();
				popupWindow.dismiss();
				if(myIntValue==1)
				{
					if((HomeActivity.Title.equalsIgnoreCase(""))&&(HomeActivity.Owner.equalsIgnoreCase(""))&&(HomeActivity.Story.equalsIgnoreCase(""))&&(HomeActivity.Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Objective_A2.equalsIgnoreCase(""))&&(HomeActivity.Need_B.equalsIgnoreCase(""))&&(HomeActivity.Need_B2.equalsIgnoreCase(""))&&(HomeActivity.Need_C.equalsIgnoreCase(""))&&(HomeActivity.Need_C2.equalsIgnoreCase(""))&&(HomeActivity.Want_D1.equalsIgnoreCase(""))&&(HomeActivity.Want_D2.equalsIgnoreCase(""))&&(HomeActivity.Why_A.equalsIgnoreCase(""))&&(HomeActivity.A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_B2_Needed.equalsIgnoreCase(""))&&(HomeActivity.A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_C2_Needed.equalsIgnoreCase(""))&&(HomeActivity.B_D1_Needed.equalsIgnoreCase(""))&&(HomeActivity.C_D2_Needed.equalsIgnoreCase(""))&&(HomeActivity.D1_conflict_D2.equalsIgnoreCase(""))&&(HomeActivity.Injection.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_B_alsoExist.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_C_alsoexist.equalsIgnoreCase(""))&&(HomeActivity.Ideas_A.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AB.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AC.equalsIgnoreCase(""))&&(HomeActivity.Ideas_BD1.equalsIgnoreCase(""))&&(HomeActivity.Ideas_CD2.equalsIgnoreCase(""))&&(HomeActivity.Ideas_D1D2.equalsIgnoreCase(""))&&(HomeActivity.Injection1.equalsIgnoreCase("")))
					{
						stack_size=TabStack.stack.size();
						for(int i=1;i<stack_size;i++)
						{
							home_services.pop();	
						}
						in.setClass(getParent(),FAQ.class);
						home_services.push("faq"+TabStack.a,in);
					}
					else
					{
						if(dropbox_file)
						{
							AlertDialog.Builder builder = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);
							builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Save Conflict</b></font>"));
							builder.setMessage(Html.fromHtml("<font color='#00478f'><b>Where would you like to save the conflict file?</b></font>"));
							builder.setIcon(R.drawable.launchicon);
							builder.setPositiveButton("Device", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
									alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>File saved</b></font>"));
									alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Your file has been saved and can be accessed via the Device tab</b></font>"));
									alertDialog.setIcon(R.drawable.launchicon);
									alertDialog.setCancelable(false);
									alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog, int which) {
											file_name=DeviceFileList.File_name;

											//						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
											//						boolean deleted = file.delete();

											if(HomeActivity.Check_conflictsolved)
											{
												//							file_name=DeviceFileList.File_name;
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);

											}	
											else
											{
												//							file_name=DeviceFileList.File_name;
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

											}

											FileSave fs=new FileSave();
											fs.XLS(directory, file_name);
											stack_size=TabStack.stack.size();
											Method m=new Method();
											m.run();
											for(int i=1;i<stack_size;i++)
											{
												home_services.pop();	
											}
											
											in.setClass(getParent(),FAQ.class);
											home_services.push("faq"+TabStack.a,in);
											SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
											SharedPreferences.Editor editor = sp.edit();
											editor.putInt("file_open", 0);
											editor.commit();//com.dropbox.android
										}
									});
									alertDialog.show();
									
									
								}
							})
							.setNeutralButton("Dropbox", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {


									file_name=DeviceFileList.File_name;

									//						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox", file_name);
									//						boolean deleted = file.delete();

									File sdCard = Environment.getExternalStorageDirectory();
									directory = new File (sdCard.getAbsolutePath() + "/Conflict_Dropbox");
									File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Dropbox/"+file_name);

									FileSave fs=new FileSave();
									fs.XLS(directory, file_name);
									stack_size=TabStack.stack.size();
									Method m=new Method();
									m.run();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}
									in.setClass(getParent(),FAQ.class);
									home_services.push("faq"+TabStack.a,in);
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();//com.dropbox.android


									List<Intent> targetedShareIntents = new ArrayList<Intent>();

									Intent shareIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
									shareIntent.setType("text/*");
									List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(shareIntent, 0);

									if (!resInfo.isEmpty())
									{

										for (ResolveInfo resolveInfo : resInfo) {

											String packageName = resolveInfo.activityInfo.packageName;
											String Name = resolveInfo.activityInfo.name;
											Log.v("hari", "packageName:"+packageName) ;



											if ((resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.dropbox.android"))) {
												Intent targetedShareIntent = new Intent(Intent.ACTION_SEND);
												targetedShareIntent.
												putExtra(Intent.EXTRA_STREAM,
														Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox",file_name)));

												targetedShareIntent.setType("text/xml");
												targetedShareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
												//											targetedShareIntent.
												//											putExtra(android.content.Intent.EXTRA_SUBJECT,str);
												//											
												targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT,"Please find the attached conflict file");
												targetedShareIntent.setPackage(packageName);
												targetedShareIntents.add(targetedShareIntent);
											}  
										}
										Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0),
												"Select app to share");
										chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.
												toArray(new Parcelable[]{}));
										Log.v("hari", "chooserIntent:"+chooserIntent) ;
										startActivity(chooserIntent);
									}


								}
							});

							builder.setNegativeButton("Close without saving", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();

									Method m=new Method();
									m.run();
									stack_size=TabStack.stack.size();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}
									in.setClass(getParent(),FAQ.class);
									home_services.push("faq"+TabStack.a,in);
								}
							});
							AlertDialog alert = builder.create();
							alert.show();
							//	((Button)alert.findViewById(android.R.id.button1)).setBackgroundResource(R.drawable.button_border);
						}
						else
						{

							AlertDialog.Builder builder = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);
							builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Close conflict</b></font>"));
							builder.setMessage(Html.fromHtml("<font color='#00478f'><b>All data will be lost which you changed.Do you want to save or exit without saving?</b></font>"));
							builder.setIcon(R.drawable.launchicon);
							builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									file_name=DeviceFileList.File_name;

									File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
									boolean deleted = file.delete();

									if(HomeActivity.Check_conflictsolved)
									{
										//							file_name=DeviceFileList.File_name;
										File sdCard = Environment.getExternalStorageDirectory();
										directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
										File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);

									}	
									else
									{
										//							file_name=DeviceFileList.File_name;
										File sdCard = Environment.getExternalStorageDirectory();
										directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
										File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

									}

									FileSave fs=new FileSave();
									fs.XLS(directory, file_name);
									stack_size=TabStack.stack.size();
									Method m=new Method();
									m.run();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}
									setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
									toplayout.setAlpha(1F);
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();

									in.setClass(getParent(),FAQ.class);
									home_services.push("n_home"+TabStack.a,in);
								}
							});

							builder.setNeutralButton("Save As", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

									if(getResources().getConfiguration().orientation==1)
									{

									}
									else
									{
										setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
									}
									LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
									View popupView = layoutInflater.inflate(R.layout.popup, null);  
									final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

									btncancel = (Button)popupView.findViewById(R.id.btncancel);
									btnsave = (Button)popupView.findViewById(R.id.btnsave);
									edtfilename=(EditText)popupView.findViewById(R.id.edtfilename);
									empty=(TextView)popupView.findViewById(R.id.error);
									btncancel.setOnClickListener(new OnClickListener(){

										@Override
										public void onClick(View v) {
											// TODO Auto-generated method stub
											setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
											toplayout.setAlpha(1F);
											popupWindow.dismiss();
										}});
									btnsave.setOnClickListener(new OnClickListener(){

										@Override
										public void onClick(View v) {
											// TODO Auto-generated method stub
											file_name=edtfilename.getText().toString();
											if(HomeActivity.Check_conflictsolved)
											{
												if(file_name.trim().length()<1)
												{
													empty.setVisibility(View.VISIBLE);
													empty.setText("Please enter file name");

												}
												else
												{

													file_name=file_name+"_conflict.xlsx";
													File sdCard = Environment.getExternalStorageDirectory();
													directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
													File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
													if(myFile.exists())
													{
														Log.e("File exist","exist");
														empty.setVisibility(View.VISIBLE);
														empty.setText("File name already exists");

													}
													else
													{
														popupWindow.dismiss();
														FileSave fs=new FileSave();
														fs.XLS(directory, file_name);
														stack_size=TabStack.stack.size();
														Method m=new Method();
														m.run();
														for(int i=1;i<stack_size;i++)
														{
															home_services.pop();	
														}
														SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
														SharedPreferences.Editor editor = sp.edit();
														editor.putInt("file_open", 0);
														editor.commit();
														setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
														in.setClass(getParent(),FAQ.class);
														home_services.push("n_home"+TabStack.a,in);
														toplayout.setAlpha(1F);
													}	
												}
											}
											else
											{

												if(file_name.trim().length()<1)
												{
													empty.setVisibility(View.VISIBLE);
													empty.setText("Please enter file name");

												}
												else
												{
													file_name=file_name+"_conflict.xlsx";
													File sdCard = Environment.getExternalStorageDirectory();
													directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
													File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
													if(myFile.exists()){
														Log.e("File exist","exist");
														empty.setVisibility(View.VISIBLE);
														empty.setText("File name already exists");

													}
													else
													{
														popupWindow.dismiss();
														FileSave fs=new FileSave();
														fs.XLS(directory, file_name);
														SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
														SharedPreferences.Editor editor = sp.edit();
														editor.putInt("file_open", 0);
														editor.commit();

														Method m=new Method();
														m.run();
														stack_size=TabStack.stack.size();
														for(int i=1;i<stack_size;i++)
														{
															home_services.pop();	
														}
														toplayout.setAlpha(1F);
														setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
														in.setClass(getParent(),FAQ.class);
														home_services.push("n_home"+TabStack.a,in);
													}
												}
											}
										}});
									popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,200);
									popupWindow.setFocusable(true);
									popupWindow.update();
									toplayout.setAlpha(0.7F);
								}
							});
							builder.setNegativeButton("Close without saving", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) {
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();

									Method m=new Method();
									m.run();
									stack_size=TabStack.stack.size();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}
									in.setClass(getParent(),FAQ.class);
									home_services.push("n_home"+TabStack.a,in);
								}
							});
							if(ConflictSolve)
							{

								stack_size=TabStack.stack.size();
								for(int i=1;i<stack_size;i++)
								{
									home_services.pop();	
								}
								Method m=new Method();
								m.run();
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();

								editor.putBoolean("ConflictSolve", false);
								editor.putInt("file_open", 0);
								editor.commit();

								in.setClass(getParent(),FAQ.class);
								home_services.push("n_home"+TabStack.a,in);
							}
							else
							{
								AlertDialog alert = builder.create();
								alert.show();
							}

						}
					}
				}
				else
				{
					if((HomeActivity.Title.equalsIgnoreCase(""))&&(HomeActivity.Owner.equalsIgnoreCase(""))&&(HomeActivity.Story.equalsIgnoreCase(""))&&(HomeActivity.Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Objective_A2.equalsIgnoreCase(""))&&(HomeActivity.Need_B.equalsIgnoreCase(""))&&(HomeActivity.Need_B2.equalsIgnoreCase(""))&&(HomeActivity.Need_C.equalsIgnoreCase(""))&&(HomeActivity.Need_C2.equalsIgnoreCase(""))&&(HomeActivity.Want_D1.equalsIgnoreCase(""))&&(HomeActivity.Want_D2.equalsIgnoreCase(""))&&(HomeActivity.Why_A.equalsIgnoreCase(""))&&(HomeActivity.A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_B2_Needed.equalsIgnoreCase(""))&&(HomeActivity.A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_C2_Needed.equalsIgnoreCase(""))&&(HomeActivity.B_D1_Needed.equalsIgnoreCase(""))&&(HomeActivity.C_D2_Needed.equalsIgnoreCase(""))&&(HomeActivity.D1_conflict_D2.equalsIgnoreCase(""))&&(HomeActivity.Injection.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_B_alsoExist.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_C_alsoexist.equalsIgnoreCase(""))&&(HomeActivity.Ideas_A.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AB.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AC.equalsIgnoreCase(""))&&(HomeActivity.Ideas_BD1.equalsIgnoreCase(""))&&(HomeActivity.Ideas_CD2.equalsIgnoreCase(""))&&(HomeActivity.Ideas_D1D2.equalsIgnoreCase(""))&&(HomeActivity.Injection1.equalsIgnoreCase("")))
					{
						stack_size=TabStack.stack.size();
						for(int i=1;i<stack_size;i++)
						{
							home_services.pop();	
						}
						in.setClass(getParent(),FAQ.class);
						home_services.push("faq"+TabStack.a,in);
					}
					else
					{
						AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

						alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Close conflict</b></font>"));
						alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>All data will be lost.Do you want to save or exit without saving?</b></font>"));
						alertDialog.setIcon(R.drawable.launchicon);
						alertDialog.setButton("Save", new  DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								if(getResources().getConfiguration().orientation==1)
								{

								}
								else
								{
									setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
								}
								LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
								View popupView = layoutInflater.inflate(R.layout.popup, null);  
								final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

								btncancel = (Button)popupView.findViewById(R.id.btncancel);
								btnsave = (Button)popupView.findViewById(R.id.btnsave);
								edtfilename=(EditText)popupView.findViewById(R.id.edtfilename);
								empty=(TextView)popupView.findViewById(R.id.error);
								btncancel.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
										toplayout.setAlpha(1F);
										popupWindow.dismiss();
									}});
								btnsave.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										file_name=edtfilename.getText().toString();
										if(file_name.trim().length()<1)
										{
											empty.setVisibility(View.VISIBLE);
											empty.setText("Please enter file name");

										}
										else
										{
											if(HomeActivity.Check_conflictsolved)
											{
												file_name=file_name+"_conflict.xlsx";
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
												if(myFile.exists())
												{
													Log.e("File exist","exist");
													empty.setVisibility(View.VISIBLE);
													empty.setText("File name already exists");

												}
												else
												{
													popupWindow.dismiss();
													FileSave fs=new FileSave();
													fs.XLS(directory, file_name);
													stack_size=TabStack.stack.size();
													Method m=new Method();
													m.run();
													for(int i=1;i<stack_size;i++)
													{
														home_services.pop();	
													}
													setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
													in.setClass(getParent(),FAQ.class);
													home_services.push("n_home"+TabStack.a,in);
													toplayout.setAlpha(1F);
												}	
											}
											else
											{


												file_name=file_name+"_conflict.xlsx";
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
												if(myFile.exists()){
													Log.e("File exist","exist");
													empty.setVisibility(View.VISIBLE);
													empty.setText("File name already exists");

												}
												else
												{
													popupWindow.dismiss();
													FileSave fs=new FileSave();
													fs.XLS(directory, file_name);
													stack_size=TabStack.stack.size();
													Method m=new Method();
													m.run();
													for(int i=1;i<stack_size;i++)
													{
														home_services.pop();	
													}
													toplayout.setAlpha(1F);
													setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
													in.setClass(getParent(),FAQ.class);
													home_services.push("n_home"+TabStack.a,in);
												}
											}
										}
									}});
								popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,200);
								popupWindow.setFocusable(true);
								popupWindow.update();
								toplayout.setAlpha(0.7F);
							}
						});
						alertDialog.setButton2("Close without saving", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								Method m=new Method();
								m.run();
								stack_size=TabStack.stack.size();
								for(int i=1;i<stack_size;i++)
								{
									home_services.pop();	
								}
								in.setClass(getParent(),FAQ.class);
								home_services.push("n_home"+TabStack.a,in);
							}
						});
						alertDialog.show();
					}
				}
			}
		});
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				HomeActivity.Title=edt_title.getText().toString();
				HomeActivity.Injection=edt_injections.getText().toString();
				popupWindow.dismiss();
				HomeActivity.btnback=false;
				HomeActivity.back=false;
				HomeActivity.jump=false;
				HomeActivity.btnnext=true;

				in.setClass(getParent(),Page11.class);
				home_services.push("n_page11"+TabStack.a,in);
			}
		}); 

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.btn_new:
		case R.id.rlnew:
			HomeActivity.Title=edt_title.getText().toString();
			HomeActivity.Injection=edt_injections.getText().toString();
			popupWindow.dismiss();
			if(btn_new_conflict.isSelected())
			{

			}
			else
			{
				if(dropbox_file)
				{
					AlertDialog.Builder builder = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Save Conflict</b></font>"));
					builder.setMessage(Html.fromHtml("<font color='#00478f'><b>Where would you like to save the conflict file?</b></font>"));
					builder.setIcon(R.drawable.launchicon);
					builder.setPositiveButton("Device", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
							alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>File saved</b></font>"));
							alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Your file has been saved and can be accessed via the Device tab</b></font>"));
							alertDialog.setIcon(R.drawable.launchicon);
							alertDialog.setCancelable(false);
							alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) {
									file_name=DeviceFileList.File_name;

									//						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
									//						boolean deleted = file.delete();

									if(HomeActivity.Check_conflictsolved)
									{
										//							file_name=DeviceFileList.File_name;
										File sdCard = Environment.getExternalStorageDirectory();
										directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
										File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);

									}	
									else
									{
										//							file_name=DeviceFileList.File_name;
										File sdCard = Environment.getExternalStorageDirectory();
										directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
										File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

									}

									FileSave fs=new FileSave();
									fs.XLS(directory, file_name);
									stack_size=TabStack.stack.size();
									Method m=new Method();
									m.run();
									for(int i=1;i<stack_size;i++)
									{
										home_services.pop();	
									}
									in.setClass(getParent(),Page1.class);
									home_services.push("page1"+TabStack.a,in);
									SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
									SharedPreferences.Editor editor = sp.edit();
									editor.putInt("file_open", 0);
									editor.commit();//com.dropbox.android
								}
							});
							alertDialog.show();
							
							
						}
					})
					.setNeutralButton("Dropbox", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {


							file_name=DeviceFileList.File_name;

							//						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox", file_name);
							//						boolean deleted = file.delete();

							File sdCard = Environment.getExternalStorageDirectory();
							directory = new File (sdCard.getAbsolutePath() + "/Conflict_Dropbox");
							File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Dropbox/"+file_name);

							FileSave fs=new FileSave();
							fs.XLS(directory, file_name);
							stack_size=TabStack.stack.size();
							Method m=new Method();
							m.run();
							for(int i=1;i<stack_size;i++)
							{
								home_services.pop();	
							}
							in.setClass(getParent(),Page1.class);
							home_services.push("page1"+TabStack.a,in);
							SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
							SharedPreferences.Editor editor = sp.edit();
							editor.putInt("file_open", 0);
							editor.commit();//com.dropbox.android


							List<Intent> targetedShareIntents = new ArrayList<Intent>();

							Intent shareIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
							shareIntent.setType("text/*");
							List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(shareIntent, 0);

							if (!resInfo.isEmpty())
							{

								for (ResolveInfo resolveInfo : resInfo) {

									String packageName = resolveInfo.activityInfo.packageName;
									String Name = resolveInfo.activityInfo.name;
									Log.v("hari", "packageName:"+packageName) ;



									if ((resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.dropbox.android"))) {
										Intent targetedShareIntent = new Intent(Intent.ACTION_SEND);
										targetedShareIntent.
										putExtra(Intent.EXTRA_STREAM,
												Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox",file_name)));

										targetedShareIntent.setType("text/xml");
										targetedShareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
										//											targetedShareIntent.
										//											putExtra(android.content.Intent.EXTRA_SUBJECT,str);
										//											
										targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT,"Please find the attached conflict file");
										targetedShareIntent.setPackage(packageName);
										targetedShareIntents.add(targetedShareIntent);
									}  
								}
								Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0),
										"Select app to share");
								chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.
										toArray(new Parcelable[]{}));
								Log.v("hari", "chooserIntent:"+chooserIntent) ;
								startActivity(chooserIntent);
							}


						}
					});
					builder.setNegativeButton("Close without saving", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
							SharedPreferences.Editor editor = sp.edit();
							editor.putInt("file_open", 0);
							editor.commit();

							Method m=new Method();
							m.run();
							stack_size=TabStack.stack.size();
							for(int i=1;i<stack_size;i++)
							{
								home_services.pop();	
							}
							in.setClass(getParent(),Page1.class);
							home_services.push("page1"+TabStack.a,in);
						}
					});
					AlertDialog alert = builder.create();
					alert.show();
					//	((Button)alert.findViewById(android.R.id.button1)).setBackgroundResource(R.drawable.button_border);
				}
				else
				{

					AlertDialog.Builder alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);

					alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Close the open conflict</b></font>"));
					alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>All data will be lost which you changed.Do you want to save or exit without saving?</b></font>"));
					alertDialog.setIcon(R.drawable.launchicon);
					alertDialog.setPositiveButton("Save", new  DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							file_name=DeviceFileList.File_name;

							File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
							boolean deleted = file.delete();

							if(HomeActivity.Check_conflictsolved)
							{
								//							file_name=DeviceFileList.File_name;
								File sdCard = Environment.getExternalStorageDirectory();
								directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
								File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);

							}	
							else
							{
								//							file_name=DeviceFileList.File_name;
								File sdCard = Environment.getExternalStorageDirectory();
								directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
								File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

							}

							FileSave fs=new FileSave();
							fs.XLS(directory, file_name);
							stack_size=TabStack.stack.size();
							Method m=new Method();
							m.run();
							for(int i=1;i<stack_size;i++)
							{
								home_services.pop();	
							}
							setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
							toplayout.setAlpha(1F);
							SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
							SharedPreferences.Editor editor = sp.edit();
							editor.putInt("file_open", 0);
							editor.commit();

							in.setClass(getParent(),Page1.class);
							home_services.push("page1"+TabStack.a,in);

						}
					});

					alertDialog.setNeutralButton("Save As", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {

							if(getResources().getConfiguration().orientation==1)
							{

							}
							else
							{
								setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
							}
							LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
							View popupView = layoutInflater.inflate(R.layout.popup, null);  
							final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

							btncancel = (Button)popupView.findViewById(R.id.btncancel);
							btnsave = (Button)popupView.findViewById(R.id.btnsave);
							edtfilename=(EditText)popupView.findViewById(R.id.edtfilename);
							empty=(TextView)popupView.findViewById(R.id.error);
							btncancel.setOnClickListener(new OnClickListener(){

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
									toplayout.setAlpha(1F);
									popupWindow.dismiss();
								}});
							btnsave.setOnClickListener(new OnClickListener(){

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									file_name=edtfilename.getText().toString();
									if(HomeActivity.Check_conflictsolved)
									{
										if(file_name.trim().length()<1)
										{
											empty.setVisibility(View.VISIBLE);
											empty.setText("Please enter file name");

										}
										else
										{

											file_name=file_name+"_conflict.xlsx";
											File sdCard = Environment.getExternalStorageDirectory();
											directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
											File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
											if(myFile.exists())
											{
												Log.e("File exist","exist");
												empty.setVisibility(View.VISIBLE);
												empty.setText("File name already exists");

											}
											else
											{
												popupWindow.dismiss();
												FileSave fs=new FileSave();
												fs.XLS(directory, file_name);
												stack_size=TabStack.stack.size();
												Method m=new Method();
												m.run();
												for(int i=1;i<stack_size;i++)
												{
													home_services.pop();	
												}
												SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
												SharedPreferences.Editor editor = sp.edit();
												editor.putInt("file_open", 0);
												editor.commit();
												setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
												in.setClass(getParent(),Page1.class);
												home_services.push("page1"+TabStack.a,in);
												toplayout.setAlpha(1F);
											}	
										}
									}
									else
									{

										if(file_name.trim().length()<1)
										{
											empty.setVisibility(View.VISIBLE);
											empty.setText("Please enter file name");

										}
										else
										{
											file_name=file_name+"_conflict.xlsx";
											File sdCard = Environment.getExternalStorageDirectory();
											directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
											File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
											if(myFile.exists()){
												Log.e("File exist","exist");
												empty.setVisibility(View.VISIBLE);
												empty.setText("File name already exists");

											}
											else
											{
												popupWindow.dismiss();
												FileSave fs=new FileSave();
												fs.XLS(directory, file_name);
												SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
												SharedPreferences.Editor editor = sp.edit();
												editor.putInt("file_open", 0);
												editor.commit();

												Method m=new Method();
												m.run();
												stack_size=TabStack.stack.size();
												for(int i=1;i<stack_size;i++)
												{
													home_services.pop();	
												}
												toplayout.setAlpha(1F);
												setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
												in.setClass(getParent(),Page1.class);
												home_services.push("page1"+TabStack.a,in);
											}
										}
									}
								}});
							popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,200);
							popupWindow.setFocusable(true);
							popupWindow.update();
							toplayout.setAlpha(0.7F);
						}
					});

					alertDialog.setNegativeButton("Close without saving", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
							SharedPreferences.Editor editor = sp.edit();
							editor.putInt("file_open", 0);
							editor.commit();

							Method m=new Method();
							m.run();
							stack_size=TabStack.stack.size();
							for(int i=1;i<stack_size;i++)
							{
								home_services.pop();	
							}
							in.setClass(getParent(),Page1.class);
							home_services.push("page1"+TabStack.a,in);
						}
					});
					//				AlertDialog alert = alertDialog.create();
					//				alert.show();
					if(ConflictSolve)
					{

						stack_size=TabStack.stack.size();
						for(int i=1;i<stack_size;i++)
						{
							home_services.pop();	
						}
						Method m=new Method();
						m.run();
						SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
						SharedPreferences.Editor editor = sp.edit();

						editor.putBoolean("ConflictSolve", false);
						editor.putInt("file_open", 0);
						editor.commit();

						in.setClass(getParent(),Page1.class);
						home_services.push("page1"+TabStack.a,in);
					}
					else
					{
						AlertDialog alert = alertDialog.create();
						alert.show();
					}


				}
			}
			break;
		case R.id.btn_open:
		case R.id.rlopen:
			HomeActivity.Title=edt_title.getText().toString();
			HomeActivity.Injection=edt_injections.getText().toString();
			popupWindow.dismiss();
			if(myIntValue==1)
			{

			}
			else
			{
				if((HomeActivity.Title.equalsIgnoreCase(""))&&(HomeActivity.Owner.equalsIgnoreCase(""))&&(HomeActivity.Story.equalsIgnoreCase(""))&&(HomeActivity.Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Objective_A2.equalsIgnoreCase(""))&&(HomeActivity.Need_B.equalsIgnoreCase(""))&&(HomeActivity.Need_B2.equalsIgnoreCase(""))&&(HomeActivity.Need_C.equalsIgnoreCase(""))&&(HomeActivity.Need_C2.equalsIgnoreCase(""))&&(HomeActivity.Want_D1.equalsIgnoreCase(""))&&(HomeActivity.Want_D2.equalsIgnoreCase(""))&&(HomeActivity.Why_A.equalsIgnoreCase(""))&&(HomeActivity.A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_B2_Needed.equalsIgnoreCase(""))&&(HomeActivity.A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_C2_Needed.equalsIgnoreCase(""))&&(HomeActivity.B_D1_Needed.equalsIgnoreCase(""))&&(HomeActivity.C_D2_Needed.equalsIgnoreCase(""))&&(HomeActivity.D1_conflict_D2.equalsIgnoreCase(""))&&(HomeActivity.Injection.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_B_alsoExist.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_C_alsoexist.equalsIgnoreCase(""))&&(HomeActivity.Ideas_A.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AB.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AC.equalsIgnoreCase(""))&&(HomeActivity.Ideas_BD1.equalsIgnoreCase(""))&&(HomeActivity.Ideas_CD2.equalsIgnoreCase(""))&&(HomeActivity.Ideas_D1D2.equalsIgnoreCase(""))&&(HomeActivity.Injection1.equalsIgnoreCase("")))
				{
					stack_size=TabStack.stack.size();
					for(int i=1;i<stack_size;i++)
					{
						home_services.pop();	
					}
					Method m=new Method();
					m.run();
					in.setClass(getParent(),DeviceFileList.class);
					home_services.push("conflict"+TabStack.a,in);
				}
				else
				{
					AlertDialog alertDialogg = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

					alertDialogg.setTitle(Html.fromHtml("<font color='#00478f'><b>Are you sure you want to close the current conflict</b></font>"));
					alertDialogg.setMessage(Html.fromHtml("<font color='#00478f'><b>All data will be lost.Do you want to save or exit without saving?</b></font>"));
					alertDialogg.setIcon(R.drawable.launchicon);
					alertDialogg.setButton("Save", new  DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							if(getResources().getConfiguration().orientation==1)
							{

							}
							else
							{
								setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
							}
							LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
							View popupView = layoutInflater.inflate(R.layout.popup, null);  
							final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

							btncancel = (Button)popupView.findViewById(R.id.btncancel);
							btnsave = (Button)popupView.findViewById(R.id.btnsave);
							edtfilename=(EditText)popupView.findViewById(R.id.edtfilename);
							empty=(TextView)popupView.findViewById(R.id.error);
							btncancel.setOnClickListener(new OnClickListener(){

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
									toplayout.setAlpha(1F);
									popupWindow.dismiss();
								}});
							btnsave.setOnClickListener(new OnClickListener(){

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									file_name=edtfilename.getText().toString();
									if(file_name.trim().length()<1)
									{
										empty.setVisibility(View.VISIBLE);
										empty.setText("Please enter file name");

									}
									else
									{
										if(HomeActivity.Check_conflictsolved)
										{
											solved();
										}
										else
										{
											file_name=file_name+"_conflict.xlsx";
											File sdCard = Environment.getExternalStorageDirectory();
											directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
											File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
											if(myFile.exists()){
												Log.e("File exist","exist");
												empty.setVisibility(View.VISIBLE);
												empty.setText("File name already exists");

											}
											else
											{
												popupWindow.dismiss();
												FileSave fs=new FileSave();
												fs.XLS(directory, file_name);
												stack_size=TabStack.stack.size();
												Method m=new Method();
												m.run();
												for(int i=1;i<stack_size;i++)
												{
													home_services.pop();	
												}
												toplayout.setAlpha(1F);
												setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
												in.setClass(getParent(),DeviceFileList.class);
												home_services.push("conflict"+TabStack.a,in);
											}
										}
									}
								}});
							popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,200);
							popupWindow.setFocusable(true);
							popupWindow.update();
							toplayout.setAlpha(0.7F);
						}
					});
					alertDialogg.setButton2("Close without saving", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Method m=new Method();
							m.run();
							stack_size=TabStack.stack.size();
							for(int i=1;i<stack_size;i++)
							{
								home_services.pop();	
							}
							in.setClass(getParent(),DeviceFileList.class);
							home_services.push("conflict"+TabStack.a,in);
						}
					});
					alertDialogg.show();	
				}
			}
			break;
		case R.id.btn_close:
		case R.id.rlclose:

			HomeActivity.Title=edt_title.getText().toString();
			HomeActivity.Injection=edt_injections.getText().toString();
			popupWindow.dismiss();
			if(myIntValue==1)
			{
				if((HomeActivity.Title.equalsIgnoreCase(""))&&(HomeActivity.Owner.equalsIgnoreCase(""))&&(HomeActivity.Story.equalsIgnoreCase(""))&&(HomeActivity.Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Objective_A2.equalsIgnoreCase(""))&&(HomeActivity.Need_B.equalsIgnoreCase(""))&&(HomeActivity.Need_B2.equalsIgnoreCase(""))&&(HomeActivity.Need_C.equalsIgnoreCase(""))&&(HomeActivity.Need_C2.equalsIgnoreCase(""))&&(HomeActivity.Want_D1.equalsIgnoreCase(""))&&(HomeActivity.Want_D2.equalsIgnoreCase(""))&&(HomeActivity.Why_A.equalsIgnoreCase(""))&&(HomeActivity.A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_B2_Needed.equalsIgnoreCase(""))&&(HomeActivity.A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_C2_Needed.equalsIgnoreCase(""))&&(HomeActivity.B_D1_Needed.equalsIgnoreCase(""))&&(HomeActivity.C_D2_Needed.equalsIgnoreCase(""))&&(HomeActivity.D1_conflict_D2.equalsIgnoreCase(""))&&(HomeActivity.Injection.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_B_alsoExist.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_C_alsoexist.equalsIgnoreCase(""))&&(HomeActivity.Ideas_A.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AB.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AC.equalsIgnoreCase(""))&&(HomeActivity.Ideas_BD1.equalsIgnoreCase(""))&&(HomeActivity.Ideas_CD2.equalsIgnoreCase(""))&&(HomeActivity.Ideas_D1D2.equalsIgnoreCase(""))&&(HomeActivity.Injection1.equalsIgnoreCase("")))
				{
					stack_size=TabStack.stack.size();
					for(int i=1;i<stack_size;i++)
					{
						home_services.pop();	
					}
				}
				else
				{
					if(dropbox_file)
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);
						builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Save Conflict</b></font>"));
						builder.setMessage(Html.fromHtml("<font color='#00478f'><b>Where would you like to save the conflict file?</b></font>"));
						builder.setIcon(R.drawable.launchicon);
						builder.setPositiveButton("Device", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
								alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>File saved</b></font>"));
								alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Your file has been saved and can be accessed via the Device tab</b></font>"));
								alertDialog.setIcon(R.drawable.launchicon);
								alertDialog.setCancelable(false);
								alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int which) {
										file_name=DeviceFileList.File_name;

										//							File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
										//							boolean deleted = file.delete();

										if(HomeActivity.Check_conflictsolved)
										{
											//							file_name=DeviceFileList.File_name;
											File sdCard = Environment.getExternalStorageDirectory();
											directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
											File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);

										}	
										else
										{
											//							file_name=DeviceFileList.File_name;
											File sdCard = Environment.getExternalStorageDirectory();
											directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
											File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

										}

										FileSave fs=new FileSave();
										fs.XLS(directory, file_name);
										stack_size=TabStack.stack.size();
										Method m=new Method();
										m.run();
										for(int i=1;i<stack_size;i++)
										{
											home_services.pop();	
										}
										SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
										SharedPreferences.Editor editor = sp.edit();
										editor.putInt("file_open", 0);
										editor.commit();//com.dropbox.android
									}
								});
								alertDialog.show();
								
								
							}
						})
						.setNeutralButton("Dropbox", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {


								file_name=DeviceFileList.File_name;

								//							File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox", file_name);
								//							boolean deleted = file.delete();

								File sdCard = Environment.getExternalStorageDirectory();
								directory = new File (sdCard.getAbsolutePath() + "/Conflict_Dropbox");
								File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Dropbox/"+file_name);

								FileSave fs=new FileSave();
								fs.XLS(directory, file_name);
								stack_size=TabStack.stack.size();
								Method m=new Method();
								m.run();
								for(int i=1;i<stack_size;i++)
								{
									home_services.pop();	
								}
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putInt("file_open", 0);
								editor.commit();//com.dropbox.android


								List<Intent> targetedShareIntents = new ArrayList<Intent>();

								Intent shareIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
								shareIntent.setType("text/*");
								List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(shareIntent, 0);

								if (!resInfo.isEmpty())
								{

									for (ResolveInfo resolveInfo : resInfo) {

										String packageName = resolveInfo.activityInfo.packageName;
										String Name = resolveInfo.activityInfo.name;
										Log.v("hari", "packageName:"+packageName) ;



										if ((resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.dropbox.android"))) {
											Intent targetedShareIntent = new Intent(Intent.ACTION_SEND);
											targetedShareIntent.
											putExtra(Intent.EXTRA_STREAM,
													Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox",file_name)));

											targetedShareIntent.setType("text/xml");
											targetedShareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
											//											targetedShareIntent.
											//											putExtra(android.content.Intent.EXTRA_SUBJECT,str);
											//											
											targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT,"Please find the attached conflict file");
											targetedShareIntent.setPackage(packageName);
											targetedShareIntents.add(targetedShareIntent);
										}  
									}
									Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0),
											"Select app to share");
									chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.
											toArray(new Parcelable[]{}));
									Log.v("hari", "chooserIntent:"+chooserIntent) ;
									startActivity(chooserIntent);
								}


							}
						});
						builder.setNegativeButton("Close without saving", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putInt("file_open", 0);
								editor.commit();

								Method m=new Method();
								m.run();
								stack_size=TabStack.stack.size();
								for(int i=1;i<stack_size;i++)
								{
									home_services.pop();	
								}
							}
						});
						AlertDialog alert = builder.create();
						alert.show();
						//	((Button)alert.findViewById(android.R.id.button1)).setBackgroundResource(R.drawable.button_border);
					}
					else
					{

						AlertDialog.Builder builder = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);
						builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Close conflict</b></font>"));
						builder.setMessage(Html.fromHtml("<font color='#00478f'><b>All data will be lost which you changed.Do you want to save or exit without saving?</b></font>"));
						builder.setIcon(R.drawable.launchicon);
						builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								file_name=DeviceFileList.File_name;

								File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
								boolean deleted = file.delete();

								if(HomeActivity.Check_conflictsolved)
								{
									//							file_name=DeviceFileList.File_name;
									File sdCard = Environment.getExternalStorageDirectory();
									directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
									File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);

								}	
								else
								{
									//							file_name=DeviceFileList.File_name;
									File sdCard = Environment.getExternalStorageDirectory();
									directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
									File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

								}

								FileSave fs=new FileSave();
								fs.XLS(directory, file_name);
								stack_size=TabStack.stack.size();
								Method m=new Method();
								m.run();
								for(int i=1;i<stack_size;i++)
								{
									home_services.pop();	
								}
								setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
								toplayout.setAlpha(1F);
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putInt("file_open", 0);
								editor.commit();

								in.setClass(getParent(),HomeActivity.class);
								home_services.push("home"+TabStack.a,in);
							}
						});

						builder.setNeutralButton("Save As", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								if(getResources().getConfiguration().orientation==1)
								{

								}
								else
								{
									setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
								}
								LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
								View popupView = layoutInflater.inflate(R.layout.popup, null);  
								final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

								btncancel = (Button)popupView.findViewById(R.id.btncancel);
								btnsave = (Button)popupView.findViewById(R.id.btnsave);
								edtfilename=(EditText)popupView.findViewById(R.id.edtfilename);
								empty=(TextView)popupView.findViewById(R.id.error);
								btncancel.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
										toplayout.setAlpha(1F);
										popupWindow.dismiss();
									}});
								btnsave.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										file_name=edtfilename.getText().toString();
										if(HomeActivity.Check_conflictsolved)
										{
											if(file_name.trim().length()<1)
											{
												empty.setVisibility(View.VISIBLE);
												empty.setText("Please enter file name");

											}
											else
											{

												file_name=file_name+"_conflict.xlsx";
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
												if(myFile.exists())
												{
													Log.e("File exist","exist");
													empty.setVisibility(View.VISIBLE);
													empty.setText("File name already exists");

												}
												else
												{
													popupWindow.dismiss();
													FileSave fs=new FileSave();
													fs.XLS(directory, file_name);
													stack_size=TabStack.stack.size();
													Method m=new Method();
													m.run();
													for(int i=1;i<stack_size;i++)
													{
														home_services.pop();	
													}
													SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
													SharedPreferences.Editor editor = sp.edit();
													editor.putInt("file_open", 0);
													editor.commit();
													setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
													in.setClass(getParent(),HomeActivity.class);
													home_services.push("home"+TabStack.a,in);
													toplayout.setAlpha(1F);
												}	
											}
										}
										else
										{

											if(file_name.trim().length()<1)
											{
												empty.setVisibility(View.VISIBLE);
												empty.setText("Please enter file name");

											}
											else
											{
												file_name=file_name+"_conflict.xlsx";
												File sdCard = Environment.getExternalStorageDirectory();
												directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
												File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
												if(myFile.exists()){
													Log.e("File exist","exist");
													empty.setVisibility(View.VISIBLE);
													empty.setText("File name already exists");

												}
												else
												{
													popupWindow.dismiss();
													FileSave fs=new FileSave();
													fs.XLS(directory, file_name);
													SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
													SharedPreferences.Editor editor = sp.edit();
													editor.putInt("file_open", 0);
													editor.commit();

													Method m=new Method();
													m.run();
													stack_size=TabStack.stack.size();
													for(int i=1;i<stack_size;i++)
													{
														home_services.pop();	
													}
													toplayout.setAlpha(1F);
													setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
													in.setClass(getParent(),HomeActivity.class);
													home_services.push("home"+TabStack.a,in);
												}
											}
										}
									}});
								popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,200);
								popupWindow.setFocusable(true);
								popupWindow.update();
								toplayout.setAlpha(0.7F);
							}
						});
						builder.setNegativeButton("Close without saving", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putInt("file_open", 0);
								editor.commit();

								Method m=new Method();
								m.run();
								stack_size=TabStack.stack.size();
								for(int i=1;i<stack_size;i++)
								{
									home_services.pop();	
								}
								in.setClass(getParent(),HomeActivity.class);
								home_services.push("home"+TabStack.a,in);
							}
						});
						//					AlertDialog alertDialog = builder.create();
						//					alertDialog.show();
						if(ConflictSolve)
						{

							stack_size=TabStack.stack.size();
							for(int i=1;i<stack_size;i++)
							{
								home_services.pop();	
							}
							Method m=new Method();
							m.run();
							SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
							SharedPreferences.Editor editor = sp.edit();

							editor.putBoolean("ConflictSolve", false);
							editor.putInt("file_open", 0);
							editor.commit();

							in.setClass(getParent(),HomeActivity.class);
							home_services.push("home"+TabStack.a,in);
						}
						else
						{
							AlertDialog alert = builder.create();
							alert.show();
						}

					}
				}
			}
			else
			{
				if((HomeActivity.Title.equalsIgnoreCase(""))&&(HomeActivity.Owner.equalsIgnoreCase(""))&&(HomeActivity.Story.equalsIgnoreCase(""))&&(HomeActivity.Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Objective_A2.equalsIgnoreCase(""))&&(HomeActivity.Need_B.equalsIgnoreCase(""))&&(HomeActivity.Need_B2.equalsIgnoreCase(""))&&(HomeActivity.Need_C.equalsIgnoreCase(""))&&(HomeActivity.Need_C2.equalsIgnoreCase(""))&&(HomeActivity.Want_D1.equalsIgnoreCase(""))&&(HomeActivity.Want_D2.equalsIgnoreCase(""))&&(HomeActivity.Why_A.equalsIgnoreCase(""))&&(HomeActivity.A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_B2_Needed.equalsIgnoreCase(""))&&(HomeActivity.A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.A2_C2_Needed.equalsIgnoreCase(""))&&(HomeActivity.B_D1_Needed.equalsIgnoreCase(""))&&(HomeActivity.C_D2_Needed.equalsIgnoreCase(""))&&(HomeActivity.D1_conflict_D2.equalsIgnoreCase(""))&&(HomeActivity.Injection.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_B_alsoExist.equalsIgnoreCase(""))&&(HomeActivity.I_Exist_C_alsoexist.equalsIgnoreCase(""))&&(HomeActivity.Ideas_A.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AB.equalsIgnoreCase(""))&&(HomeActivity.Ideas_AC.equalsIgnoreCase(""))&&(HomeActivity.Ideas_BD1.equalsIgnoreCase(""))&&(HomeActivity.Ideas_CD2.equalsIgnoreCase(""))&&(HomeActivity.Ideas_D1D2.equalsIgnoreCase(""))&&(HomeActivity.Injection1.equalsIgnoreCase("")))
				{
					stack_size=TabStack.stack.size();
					for(int i=1;i<stack_size;i++)
					{
						home_services.pop();	
					}
				}
				else
				{
					AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

					alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Close conflict</b></font>"));
					alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>All data will be lost.Do you want to save or exit without saving?</b></font>"));
					alertDialog.setIcon(R.drawable.launchicon);
					alertDialog.setButton("Save", new  DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							if(getResources().getConfiguration().orientation==1)
							{

							}
							else
							{
								setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
							}
							LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
							View popupView = layoutInflater.inflate(R.layout.popup, null);  
							final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

							btncancel = (Button)popupView.findViewById(R.id.btncancel);
							btnsave = (Button)popupView.findViewById(R.id.btnsave);
							edtfilename=(EditText)popupView.findViewById(R.id.edtfilename);
							empty=(TextView)popupView.findViewById(R.id.error);
							btncancel.setOnClickListener(new OnClickListener(){

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
									toplayout.setAlpha(1F);
									popupWindow.dismiss();
								}});
							btnsave.setOnClickListener(new OnClickListener(){

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									file_name=edtfilename.getText().toString();
									if(file_name.trim().length()<1)
									{
										empty.setVisibility(View.VISIBLE);
										empty.setText("Please enter file name");

									}
									else
									{
										if(HomeActivity.Check_conflictsolved)
										{
											file_name=file_name+"_conflict.xlsx";
											File sdCard = Environment.getExternalStorageDirectory();
											directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
											File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
											if(myFile.exists())
											{
												Log.e("File exist","exist");
												empty.setVisibility(View.VISIBLE);
												empty.setText("File name already exists");

											}
											else
											{
												popupWindow.dismiss();
												FileSave fs=new FileSave();
												fs.XLS(directory, file_name);
												stack_size=TabStack.stack.size();
												Method m=new Method();
												m.run();
												for(int i=1;i<stack_size;i++)
												{
													home_services.pop();	
												}
												setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
												in.setClass(getParent(),HomeActivity.class);
												home_services.push("home"+TabStack.a,in);
												toplayout.setAlpha(1F);
											}	
										}
										else
										{


											file_name=file_name+"_conflict.xlsx";
											File sdCard = Environment.getExternalStorageDirectory();
											directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
											File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
											if(myFile.exists()){
												Log.e("File exist","exist");
												empty.setVisibility(View.VISIBLE);
												empty.setText("File name already exists");

											}
											else
											{
												popupWindow.dismiss();
												FileSave fs=new FileSave();
												fs.XLS(directory, file_name);
												stack_size=TabStack.stack.size();
												Method m=new Method();
												m.run();
												for(int i=1;i<stack_size;i++)
												{
													home_services.pop();	
												}
												toplayout.setAlpha(1F);
												setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
												in.setClass(getParent(),HomeActivity.class);
												home_services.push("home"+TabStack.a,in);
											}
										}
									}
								}});
							popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,200);
							popupWindow.setFocusable(true);
							popupWindow.update();
							toplayout.setAlpha(0.7F);
						}
					});
					alertDialog.setButton2("Close without saving", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Method m=new Method();
							m.run();
							stack_size=TabStack.stack.size();
							for(int i=1;i<stack_size;i++)
							{
								home_services.pop();	
							}
						}
					});
					alertDialog.show();
				}
			}
			break;
		case R.id.btn_back:
			HomeActivity.Title=edt_title.getText().toString();
			HomeActivity.Injection=edt_injections.getText().toString();
			popupWindow.dismiss();
			HomeActivity.btnback=true;
			//			home_services.pop();
			in.setClass(getParent(),Page9.class);
			home_services.push("pn_page9"+TabStack.a,in);
			break;
		case R.id.btnwhya:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page3.class);
			home_services.push("pn_page3"+TabStack.a,in);
			break;
		case R.id.btnwhyb:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page4.class);
			home_services.push("pn_page4"+TabStack.a,in);
			break;
		case R.id.btnwhyc:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page5.class);
			home_services.push("pn_page5"+TabStack.a,in);
			break;
		case R.id.btnwhyd:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page6.class);
			home_services.push("pn_page6"+TabStack.a,in);
			break;
		case R.id.btnwhyd2:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page7.class);
			home_services.push("pn_page7"+TabStack.a,in);
			break;
		case R.id.btnconflict:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page8.class);
			home_services.push("pn_page8"+TabStack.a,in);
			break;
		case R.id.btnstory:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page1.class);
			home_services.push("pn_page1"+TabStack.a,in);
			break;
		case R.id.btndiagrom:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page2.class);
			home_services.push("pn_page2"+TabStack.a,in);
			break;
		case R.id.btnidea:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page9.class);
			home_services.push("pn_page9"+TabStack.a,in);
			break;
		case R.id.btnsolution:
			break;
		case R.id.btncheck:
			getdata();
			popupWindow.dismiss();
			HomeActivity.jump=true;
			in.setClass(getParent(),Page11.class);
			home_services.push("pn_page11"+TabStack.a,in);
			break;
		case R.id.btnreset:
			popupWindow.dismiss();
			if(btnreset.isSelected())
			{

			}
			else
			{
				AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

				alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Reset content</b></font>"));
				alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Delete field content of this screen in order to re-enter?</b></font>"));
				alertDialog.setIcon(R.drawable.launchicon);
				alertDialog.setButton("Yes", new  DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						btnreset.setSelected(true);
						resetdata();
					}
				});
				alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

					}
				});


				alertDialog.show();	
			}
			break;
		}
	}
	public void getdata()
	{
		HomeActivity.Title=edt_title.getText().toString();
		HomeActivity.Injection=edt_injections.getText().toString();
	}
	public void resetdata()
	{
		//		edt_title.setText("");
		if(edt_injections.getText().toString().length()>0)
		{
			edt_injections.setText("");
		}

	}
	public void solved()
	{

		file_name=file_name+"_conflict.xlsx";
		File sdCard = Environment.getExternalStorageDirectory();
		directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
		File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
		if(myFile.exists())
		{
			Log.e("File exist","exist");
			empty.setVisibility(View.VISIBLE);
			empty.setText("File name already exists");

		}
		else
		{
			FileSave fs=new FileSave();
			fs.XLS(directory, file_name);
			stack_size=TabStack.stack.size();
			Method m=new Method();
			m.run();
			for(int i=1;i<stack_size;i++)
			{
				home_services.pop();	
			}
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
			in.setClass(getParent(),HomeActivity.class);
			home_services.push("home"+TabStack.a,in);
			toplayout.setAlpha(1F);
		}	

	}
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		view.getParent().requestDisallowInterceptTouchEvent(true);
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_UP:
			view.getParent().requestDisallowInterceptTouchEvent(false);
			break;
		}

		return false;
	}
	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
	
	
	public void reset()
	{
		if((edt_injections.getText().toString().length()==0))
		{
			btnreset.setSelected(true);
		}
		else
		{
			btnreset.setSelected(false);
		}
	}
}

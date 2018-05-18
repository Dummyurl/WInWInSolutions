package com.in.winwinsolutions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.os.StrictMode;
import android.provider.Settings.Secure;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TabPage11 extends Activity implements OnClickListener,OnTouchListener{
	Button btn_new_conflict,btn_open_conflict,btn_close_conflict,btn_save,btn_back,btnreset;
	EditText edt_title,edt_a_b_needed,edt_i_exist_b_alsoexist,edt_objective_a,edt_need_b,edt_need_c,edt_injections,edt_a_c_needed,edt_i_exist_c_alsoexist;
	Intent in=new Intent();
	TabStack home_services;
	String file_name;
	File directory;
	String android_id;
	int stack_size;
	RelativeLayout toplayout;
	//String ashok="test";
	int myIntValue;
	TextView error,tvcompleted;
	Button btnsave,btncancel;
	EditText edtfilename;
	TextView empty;
	Button btnstory,btndiagrom,btnidea,btnsolution,btncheck ,btnassumptions1,btnassumptions2;
	CheckBox check_conflictsolved;
	TextView txtcheck;
	Boolean ConflictSolve;
	LinearLayout firstscrolllayout;
	Button btnverifytitle,btnedittitle,btnverifyobjective,btneditobjective,btnverifyneedb,btneditneedb,btnverifyneedc,btneditneedc,btnverifyinjection,btneditinjection,btneditabneeded,btneditacneeded;
	int a=0;
	ImageView imgtitlehint;
	PopupWindow popupWindow ;
	NumberKeyListener PwdkeyListener;
	Drawable originalDrawabletitle,originalDrawableobjective,originalDrawableneedb,originalDrawableneedc,originalDrawableinjection,originalDrawableabneeded,originalDrawableacneeded;
	int k,textlength,j,l,m,n,o,p,q,r,t,u;
	SeekBar seekbarCompleted;
	RelativeLayout Rl_open,Rl_new,Rl_close,seek,seekcompleted;
	//	TextView txtnew,txtopen,txtclose,txtnewconflict,txtopenconflict,txtcloseconflict,textView133;
	TextView txtnew,txtopen,txtclose;
	double seekvalue;
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	RelativeLayout rlseek,rlseekcompleted;
	Boolean dropbox_file;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page11);
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedpreferences.edit();
		editor.putInt("page",11);
		//		editor.commit();
		btn_new_conflict=(Button)findViewById(R.id.btn_new); 
		btn_close_conflict=(Button)findViewById(R.id.btn_close); 
		btn_open_conflict=(Button)findViewById(R.id.btn_open); 
		btn_save=(Button)findViewById(R.id.btn_save); 
		btn_back=(Button)findViewById(R.id.btn_back); 
		btnreset=(Button)findViewById(R.id.btnreset);
		toplayout=(RelativeLayout) findViewById(R.id.toplayout);
		edt_title=(EditText)findViewById(R.id.title);
		edt_a_b_needed=(EditText)findViewById(R.id.a_b_needed);
		edt_i_exist_b_alsoexist=(EditText)findViewById(R.id.i_exist_b_alsoExist);
		edt_objective_a=(EditText)findViewById(R.id.objective_a);
		edt_need_b=(EditText)findViewById(R.id.need_b);
		edt_need_c=(EditText)findViewById(R.id.need_c);
		edt_injections=(EditText)findViewById(R.id.injection);
		edt_a_c_needed=(EditText)findViewById(R.id.a_c_needed);
		edt_i_exist_c_alsoexist=(EditText)findViewById(R.id.i_exist_c_alsoexist);
		check_conflictsolved=(CheckBox)findViewById(R.id.check_conflictsolved);
		firstscrolllayout=(LinearLayout)findViewById(R.id.firstscrolllayout);
		txtcheck=(TextView)findViewById(R.id.txtcheckbox);

		btnverifytitle=(Button)findViewById(R.id.btnverifytitle);
		btnedittitle=(Button)findViewById(R.id.btnedittitle);
		btnverifyobjective=(Button)findViewById(R.id.btnverifyobjective);
		btneditobjective=(Button)findViewById(R.id.btneditobjective);
		btnverifyneedb=(Button)findViewById(R.id.btnverifyneedb);
		btneditneedb=(Button)findViewById(R.id.btneditneedb);
		btnverifyneedc=(Button)findViewById(R.id.btnverifyneedc);
		btneditneedc=(Button)findViewById(R.id.btneditneedc);
		btnverifyinjection=(Button)findViewById(R.id.btnverifyinjection);
		btneditinjection=(Button)findViewById(R.id.btneditinjection);
		btneditabneeded=(Button)findViewById(R.id.btneditabneeded);
		btneditacneeded=(Button)findViewById(R.id.btneditacneeded);
		rlseek=(RelativeLayout)findViewById(R.id.seek);
		rlseekcompleted=(RelativeLayout)findViewById(R.id.seekcompleted);
		imgtitlehint=(ImageView)findViewById(R.id.imghint);
		
		edt_need_b.setMovementMethod(new ScrollingMovementMethod());
		edt_need_b.setOnTouchListener(this);
		edt_need_c.setMovementMethod(new ScrollingMovementMethod());
		edt_need_c.setOnTouchListener(this);
		edt_a_b_needed.setMovementMethod(new ScrollingMovementMethod());
		edt_a_b_needed.setOnTouchListener(this);
		edt_a_c_needed.setMovementMethod(new ScrollingMovementMethod());
		edt_a_c_needed.setOnTouchListener(this);
		edt_i_exist_b_alsoexist.setMovementMethod(new ScrollingMovementMethod());
		edt_i_exist_b_alsoexist.setOnTouchListener(this);
		edt_i_exist_c_alsoexist.setMovementMethod(new ScrollingMovementMethod());
		edt_i_exist_c_alsoexist.setOnTouchListener(this);



		error=(TextView) findViewById(R.id.error);
		Rl_new=(RelativeLayout)findViewById(R.id.rlnew);
		Rl_open=(RelativeLayout)findViewById(R.id.rlopen);
		Rl_close=(RelativeLayout)findViewById(R.id.rlclose);
		seek=(RelativeLayout)findViewById(R.id.seek);
		seekcompleted=(RelativeLayout)findViewById(R.id.seekcompleted);
		txtnew=(TextView)findViewById(R.id.txtnew);
		txtopen=(TextView)findViewById(R.id.txtopen);
		txtclose=(TextView)findViewById(R.id.txtclose);
		//		txtnewconflict=(TextView)findViewById(R.id.txtnewconflict);
		//		txtopenconflict=(TextView)findViewById(R.id.txtopenconflict);
		//		txtcloseconflict=(TextView)findViewById(R.id.txtcloseconflict);
//		textView133=(TextView)findViewById(R.id.textView133);
		//		btnWhya=(Button)findViewById(R.id.btnwhya); 
		//		btnWhyb=(Button)findViewById(R.id.btnwhyb);
		//		btnWhyc=(Button)findViewById(R.id.btnwhyc);
		//		btnWhyd1=(Button)findViewById(R.id.btnwhyd);
		//		btnWhyd2=(Button)findViewById(R.id.btnwhyd2);
		//		btnconflict=(Button)findViewById(R.id.btnconflict);
		btnassumptions1=(Button)findViewById(R.id.assumptions1); 
		btnassumptions2=(Button)findViewById(R.id.assumptions2);
		btnstory=(Button)findViewById(R.id.btnstory);
		btndiagrom=(Button)findViewById(R.id.btndiagrom);
		btnidea=(Button)findViewById(R.id.btnidea);
		btnsolution=(Button)findViewById(R.id.btnsolution);
		btncheck=(Button)findViewById(R.id.btncheck);

		//		btnWhya.setOnClickListener(this);
		//		btnWhyb.setOnClickListener(this);
		//		btnWhyc.setOnClickListener(this);
		//		btnWhyd1.setOnClickListener(this);
		//		btnWhyd2.setOnClickListener(this);
		//		btnconflict.setOnClickListener(this);
		//		edt_title.setEnabled(false);
		btnassumptions1.setOnClickListener(this);
		btnassumptions2.setOnClickListener(this);
		btnstory.setOnClickListener(this);
		btndiagrom.setOnClickListener(this);
		btnidea.setOnClickListener(this);
		btnsolution.setOnClickListener(this);
		btncheck.setOnClickListener(this);
		btnreset.setOnClickListener(this);

		btnverifytitle.setOnClickListener(this);
		btnedittitle.setOnClickListener(this);
		btnverifyobjective.setOnClickListener(this);
		btneditobjective.setOnClickListener(this);
		btnverifyneedb.setOnClickListener(this);
		btneditneedb.setOnClickListener(this);
		btnverifyneedc.setOnClickListener(this);
		btneditneedc.setOnClickListener(this);
		btnverifyinjection.setOnClickListener(this);
		btneditinjection.setOnClickListener(this);
		btneditabneeded.setOnClickListener(this);
		btneditacneeded.setOnClickListener(this);

		//		btnWhya.setTextColor(getResources().getColor(R.color.color_name3));
		//		btnWhyb.setTextColor(getResources().getColor(R.color.color_name3));
		//		btnWhyc.setTextColor(getResources().getColor(R.color.color_name3));
		//		btnWhyd1.setTextColor(getResources().getColor(R.color.color_name3));
		//		btnWhyd2.setTextColor(getResources().getColor(R.color.color_name3));
		//		btnconflict.setTextColor(getResources().getColor(R.color.color_name3));
		btnassumptions1.setTextColor(getResources().getColor(R.color.color_name3));
		btnassumptions1.setTextColor(getResources().getColor(R.color.color_name3));
		btnstory.setTextColor(getResources().getColor(R.color.color_name3));
		btndiagrom.setTextColor(getResources().getColor(R.color.color_name3));
		btnidea.setTextColor(getResources().getColor(R.color.color_name3));
		btnsolution.setTextColor(getResources().getColor(R.color.color_name3));
		btncheck.setTextColor(getResources().getColor(R.color.color_name1));

		LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
		View popupView = layoutInflater.inflate(R.layout.textview_hint, null);  
		popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
		TextView text=(TextView)popupView.findViewById(R.id.popuptext);
		text.setText(getResources().getString(R.string.checkinstruction));

		imgtitlehint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(a==0)
				{

					popupWindow.showAsDropDown(btnreset, 0, 0);
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
		
		seekbarCompleted = (SeekBar)findViewById(R.id.sBcompleted);
		tvcompleted = (TextView)findViewById(R.id.tvcompleted);

		if(HomeActivity.Title.length()==0)
		{
			editor.putInt("title",-1);

		}
		if(HomeActivity.I_Exist_B_alsoExist.length()==0)
		{
			editor.putInt("bexist",-1);

		}
		if(HomeActivity.I_Exist_C_alsoexist.length()==0)
		{
			editor.putInt("cexist",-1);

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


		edt_title.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				// put the code of save Database here 
				reset();
				sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
				int check_title = sharedpreferences.getInt("title", 0);
				if(edt_title.getText().toString().length()>0)
				{


					if(check_title==0)
					{
						HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+3;	
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("title",1);
						editor.commit();
						HomeActivity.seekbarvalue=round(HomeActivity.seekbarvalue, 2);
						tvcompleted.setText(HomeActivity.seekbarvalue+"%");
						seekbarCompleted.setProgress((int)HomeActivity.seekbarvalue);
					}
				}
				else
				{
					if(check_title==-1)
					{
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("title",0);
						editor.commit();
					}
					else
					{
						HomeActivity.seekbarvalue=HomeActivity.seekbarvalue-3;	
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("title",0);
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
		edt_objective_a.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				reset();
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}
		});
		edt_need_b.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				reset();
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}
		});
		edt_need_c.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				reset();
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}
		});
		edt_injections.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				reset();
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}
		});
		edt_a_b_needed.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				reset();
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}
		});
		edt_a_c_needed.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				reset();
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {


			}
		});
		edt_i_exist_b_alsoexist.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				reset();

				sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
				int check_bexist = sharedpreferences.getInt("bexist", 0);
				if(edt_i_exist_b_alsoexist.getText().toString().length()>0)
				{


					if(check_bexist==0)
					{
						HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+5;	
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("bexist",1);
						editor.commit();
						HomeActivity.seekbarvalue=round(HomeActivity.seekbarvalue, 2);
						tvcompleted.setText(HomeActivity.seekbarvalue+"%");
						seekbarCompleted.setProgress((int)HomeActivity.seekbarvalue);
					}
				}
				else
				{
					if(check_bexist==-1)
					{
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("bexist",0);
						editor.commit();
					}
					else
					{
						HomeActivity.seekbarvalue=HomeActivity.seekbarvalue-5;	
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("bexist",0);
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
		edt_i_exist_c_alsoexist.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				popupWindow.dismiss();
				reset();
				sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
				int check_cexist = sharedpreferences.getInt("cexist", 0);
				if(edt_i_exist_c_alsoexist.getText().toString().length()>0)
				{


					if(check_cexist==0)
					{
						HomeActivity.seekbarvalue=HomeActivity.seekbarvalue+5;	
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("cexist",1);
						editor.commit();
						HomeActivity.seekbarvalue=round(HomeActivity.seekbarvalue, 2);
						tvcompleted.setText(HomeActivity.seekbarvalue+"%");
						seekbarCompleted.setProgress((int)HomeActivity.seekbarvalue);
					}
				}
				else
				{
					if(check_cexist==-1)
					{
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("cexist",0);
						editor.commit();
					}
					else
					{
						HomeActivity.seekbarvalue=HomeActivity.seekbarvalue-5;	
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putInt("cexist",0);
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
		if(HomeActivity.Check_conflictsolved)
		{
			check_conflictsolved.setChecked(true);
		}
		else
		{
			check_conflictsolved.setChecked(false);	
		}




		check_conflictsolved.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				HomeActivity.Check_conflictsolved=isChecked;
			}
		});



		PwdkeyListener = new NumberKeyListener() {

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


		edt_title.setKeyListener(null);
		edt_a_b_needed.setKeyListener(null);
		edt_objective_a.setKeyListener(null);
		edt_need_b.setKeyListener(null);
		edt_need_c.setKeyListener(null);
		edt_injections.setKeyListener(null);
		edt_a_c_needed.setKeyListener(null);

		originalDrawabletitle = edt_title.getBackground();
		originalDrawableobjective = edt_objective_a.getBackground();
		originalDrawableneedb = edt_need_b.getBackground();
		originalDrawableneedc = edt_need_c.getBackground();
		originalDrawableinjection = edt_injections.getBackground();
		originalDrawableabneeded = edt_a_b_needed.getBackground();
		originalDrawableacneeded = edt_a_c_needed.getBackground();

		edt_title.setBackgroundColor(getResources().getColor(R.color.gray));
		edt_objective_a.setBackgroundColor(getResources().getColor(R.color.gray));
		edt_need_b.setBackgroundColor(getResources().getColor(R.color.gray));
		edt_need_c.setBackgroundColor(getResources().getColor(R.color.gray));
		edt_injections.setBackgroundColor(getResources().getColor(R.color.gray));
		edt_a_b_needed.setBackgroundColor(getResources().getColor(R.color.gray));
		edt_a_c_needed.setBackgroundColor(getResources().getColor(R.color.gray));

		error=(TextView)findViewById(R.id.error);

		android_id = Secure.getString(TabPage11.this.getContentResolver(),
				Secure.ANDROID_ID); 




		btn_new_conflict.setOnClickListener(this); 
		btn_open_conflict.setOnClickListener(this); 
		btn_close_conflict.setOnClickListener(this); 
		Rl_open.setOnClickListener(this); 
		Rl_new.setOnClickListener(this); 
		Rl_close.setOnClickListener(this); 
		btn_back.setOnClickListener(this); 
		home_services=(TabStack)getParent();

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
			
			edt_title.setText(HomeActivity.Title);
			edt_i_exist_b_alsoexist.setText(HomeActivity.I_Exist_B_alsoExist);
			edt_i_exist_c_alsoexist.setText(HomeActivity.I_Exist_C_alsoexist);
			if((!HomeActivity.Temp_Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Temp_Objective_A.equalsIgnoreCase(HomeActivity.Objective_A)))
			{
				edt_objective_a.setText(HomeActivity.Objective_A2);
			}
			else if(!HomeActivity.Temp_Objective_A.equalsIgnoreCase(""))
			{
				edt_objective_a.setText(HomeActivity.Temp_Objective_A);

			}
			else
			{
				edt_objective_a.setText(HomeActivity.Objective_A);
				HomeActivity.Temp_Objective_A=HomeActivity.Objective_A;
			}
			
			if((!HomeActivity.Temp_Need_B.equalsIgnoreCase(""))&&(HomeActivity.Temp_Need_B.equalsIgnoreCase(HomeActivity.Need_B)))
			{
				edt_need_b.setText(HomeActivity.Need_B2);
			}
			else if(!HomeActivity.Temp_Need_B.equalsIgnoreCase(""))
			{
				edt_need_b.setText(HomeActivity.Temp_Need_B);

			}
			else
			{
				edt_need_b.setText(HomeActivity.Need_B);
				HomeActivity.Temp_Need_B=HomeActivity.Need_B;
			}

			if((!HomeActivity.Temp_Need_C.equalsIgnoreCase(""))&&(HomeActivity.Temp_Need_C.equalsIgnoreCase(HomeActivity.Need_C)))
			{
				edt_need_c.setText(HomeActivity.Need_C2);
			}
			else if(!HomeActivity.Temp_Need_C.equalsIgnoreCase(""))
			{
				edt_need_c.setText(HomeActivity.Temp_Need_C);

			}
			else
			{
				edt_need_c.setText(HomeActivity.Need_C);
				HomeActivity.Temp_Need_C=HomeActivity.Need_C;
			}
			if((!HomeActivity.Temp_Injection.equalsIgnoreCase(""))&&(HomeActivity.Temp_Injection.equalsIgnoreCase(HomeActivity.Injection)))
			{
				edt_injections.setText(HomeActivity.Injection1);
			}
			else if(!HomeActivity.Temp_Injection.equalsIgnoreCase(""))
			{
				edt_injections.setText(HomeActivity.Temp_Injection);

			}
			else
			{
				edt_injections.setText(HomeActivity.Injection);
				HomeActivity.Temp_Injection=HomeActivity.Injection;
			}
			if((!HomeActivity.Temp_A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.Temp_A_B_Needed.equalsIgnoreCase(HomeActivity.A_B_Needed)))
			{
				edt_a_b_needed.setText(HomeActivity.A2_B2_Needed);
			}
			else if(!HomeActivity.Temp_A_B_Needed.equalsIgnoreCase(""))
			{
				edt_a_b_needed.setText(HomeActivity.Temp_A_B_Needed);

			}
			else
			{
				edt_a_b_needed.setText(HomeActivity.A_B_Needed);
				HomeActivity.Temp_A_B_Needed=HomeActivity.A_B_Needed;
			}
			if((!HomeActivity.Temp_A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.Temp_A_C_Needed.equalsIgnoreCase(HomeActivity.A_C_Needed)))
			{
			edt_a_c_needed.setText(HomeActivity.A2_C2_Needed);
			}
			else if(!HomeActivity.Temp_A_C_Needed.equalsIgnoreCase(""))
			{
				edt_a_c_needed.setText(HomeActivity.Temp_A_C_Needed);

			}
			else
			{
				edt_a_c_needed.setText(HomeActivity.A_C_Needed);
				HomeActivity.Temp_A_C_Needed=HomeActivity.A_C_Needed;
			}
		}
		else
		{

			if(ConflictSolve)
			{
				btn_new_conflict.setSelected(false);
				edt_title.setText(HomeActivity.Title);
				edt_a_b_needed.setText(HomeActivity.A2_B2_Needed);
				edt_i_exist_b_alsoexist.setText(HomeActivity.I_Exist_B_alsoExist);
				edt_objective_a.setText(HomeActivity.Objective_A2);
				edt_need_b.setText(HomeActivity.Need_B2);
				edt_need_c.setText(HomeActivity.Need_C2);
				edt_injections.setText(HomeActivity.Injection1);
				edt_a_c_needed.setText(HomeActivity.A2_C2_Needed);
				edt_i_exist_c_alsoexist.setText(HomeActivity.I_Exist_C_alsoexist);
				btn_open_conflict.setSelected(true);
				txtnew.setTextColor(getResources().getColor(R.color.btncolor));
				txtopen.setTextColor(getResources().getColor(R.color.btncolorhover));
				txtclose.setTextColor(getResources().getColor(R.color.btncolor));
				//				txtnewconflict.setTextColor(getResources().getColor(R.color.btncolor));
				//				txtopenconflict.setTextColor(getResources().getColor(R.color.btncolorhover));
				//				txtcloseconflict.setTextColor(getResources().getColor(R.color.btncolor));
				edt_title.setKeyListener(null);
				edt_a_b_needed.setKeyListener(null);
				edt_i_exist_b_alsoexist.setKeyListener(null);
				edt_objective_a.setKeyListener(null);
				edt_need_b.setKeyListener(null);
				edt_need_c.setKeyListener(null);
				edt_injections.setKeyListener(null);
				edt_a_c_needed.setKeyListener(null);
				edt_i_exist_c_alsoexist.setKeyListener(null);

				edt_title.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_a_b_needed.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_i_exist_b_alsoexist.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_objective_a.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_need_b.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_need_c.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_injections.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_a_c_needed.setBackgroundColor(getResources().getColor(R.color.gray));
				edt_i_exist_c_alsoexist.setBackgroundColor(getResources().getColor(R.color.gray));
				check_conflictsolved.setVisibility(View.GONE);
				txtcheck.setVisibility(View.GONE);
				btn_save.setVisibility(View.GONE);
				btnreset.setVisibility(View.GONE);
				seekbarCompleted.setVisibility(View.GONE);
				tvcompleted.setVisibility(View.GONE);
				btnreset.setVisibility(View.GONE);
				btnverifytitle.setVisibility(View.GONE);
				btnedittitle.setVisibility(View.GONE);
				btnverifyobjective.setVisibility(View.GONE);
				btneditobjective.setVisibility(View.GONE);
				btnverifyneedb.setVisibility(View.GONE);
				btneditneedb.setVisibility(View.GONE);
				btnverifyneedc.setVisibility(View.GONE);
				btneditneedc.setVisibility(View.GONE);
				btnverifyinjection.setVisibility(View.GONE);
				btneditinjection.setVisibility(View.GONE);
				btneditabneeded.setVisibility(View.GONE);
				btneditacneeded.setVisibility(View.GONE);
//				textView133.setVisibility(View.GONE);
				seek.setVisibility(View.GONE);
				seekcompleted.setVisibility(View.GONE);
				rlseek.setVisibility(View.GONE);
				rlseekcompleted.setVisibility(View.GONE);
			}
			else
			{
				if(HomeActivity.Title.length()>0)
				{
					editor.putInt("title",1);

				}
				
				if(HomeActivity.I_Exist_B_alsoExist.length()>0)
				{
					editor.putInt("bexist",1);

				}
				if(HomeActivity.I_Exist_C_alsoexist.length()>0)
				{
					editor.putInt("cexist",1);

				}

				editor.commit();
				btn_new_conflict.setSelected(false);
				edt_title.setText(HomeActivity.Title);
//				edt_a_b_needed.setText(HomeActivity.A2_B2_Needed);
				edt_i_exist_b_alsoexist.setText(HomeActivity.I_Exist_B_alsoExist);
//				edt_objective_a.setText(HomeActivity.Objective_A2);
//				edt_need_b.setText(HomeActivity.Need_B2);
//				edt_need_c.setText(HomeActivity.Need_C2);
//				edt_injections.setText(HomeActivity.Injection1);
//				edt_a_c_needed.setText(HomeActivity.A2_C2_Needed);
				edt_i_exist_c_alsoexist.setText(HomeActivity.I_Exist_C_alsoexist);
				
				if((!HomeActivity.Temp_Objective_A.equalsIgnoreCase(""))&&(HomeActivity.Temp_Objective_A.equalsIgnoreCase(HomeActivity.Objective_A)))
				{
					edt_objective_a.setText(HomeActivity.Objective_A2);
				}
				else
				{
					edt_objective_a.setText(HomeActivity.Objective_A);
					HomeActivity.Temp_Objective_A=HomeActivity.Objective_A;
				}
				
				if((!HomeActivity.Temp_Need_B.equalsIgnoreCase(""))&&(HomeActivity.Temp_Need_B.equalsIgnoreCase(HomeActivity.Need_B)))
				{
					edt_need_b.setText(HomeActivity.Need_B2);
				}
				else
				{
					edt_need_b.setText(HomeActivity.Need_B);
					HomeActivity.Temp_Need_B=HomeActivity.Need_B;
				}

				if((!HomeActivity.Temp_Need_C.equalsIgnoreCase(""))&&(HomeActivity.Temp_Need_C.equalsIgnoreCase(HomeActivity.Need_C)))
				{
					edt_need_c.setText(HomeActivity.Need_C2);
				}
				else
				{
					edt_need_c.setText(HomeActivity.Need_C);
					HomeActivity.Temp_Need_C=HomeActivity.Need_C;
				}
				if((!HomeActivity.Temp_Injection.equalsIgnoreCase(""))&&(HomeActivity.Temp_Injection.equalsIgnoreCase(HomeActivity.Injection)))
				{
					edt_injections.setText(HomeActivity.Injection1);
				}
				else
				{
					edt_injections.setText(HomeActivity.Injection);
					HomeActivity.Temp_Injection=HomeActivity.Injection;
				}
				if((!HomeActivity.Temp_A_B_Needed.equalsIgnoreCase(""))&&(HomeActivity.Temp_A_B_Needed.equalsIgnoreCase(HomeActivity.A_B_Needed)))
				{
					edt_a_b_needed.setText(HomeActivity.A2_B2_Needed);
				}
				else
				{
					edt_a_b_needed.setText(HomeActivity.A_B_Needed);
					HomeActivity.Temp_A_B_Needed=HomeActivity.A_B_Needed;
				}
				if((!HomeActivity.Temp_A_C_Needed.equalsIgnoreCase(""))&&(HomeActivity.Temp_A_C_Needed.equalsIgnoreCase(HomeActivity.A_C_Needed)))
				{
				edt_a_c_needed.setText(HomeActivity.A2_C2_Needed);
				}
				else
				{
					edt_a_c_needed.setText(HomeActivity.A_C_Needed);
					HomeActivity.Temp_A_C_Needed=HomeActivity.A_C_Needed;
				}
				
				btn_open_conflict.setSelected(true);
				txtnew.setTextColor(getResources().getColor(R.color.btncolor));
				txtopen.setTextColor(getResources().getColor(R.color.btncolorhover));
				txtclose.setTextColor(getResources().getColor(R.color.btncolor));
				//				txtnewconflict.setTextColor(getResources().getColor(R.color.btncolor));
				//				txtopenconflict.setTextColor(getResources().getColor(R.color.btncolorhover));
				//				txtcloseconflict.setTextColor(getResources().getColor(R.color.btncolor));
			}
		}
		Tabs.btn_home.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popupWindow.dismiss();
				HomeActivity.Title=edt_title.getText().toString();
				HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
				HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
				HomeActivity.Objective_A2=edt_objective_a.getText().toString();
				HomeActivity.Need_B2=edt_need_b.getText().toString();
				HomeActivity.Need_C2=edt_need_c.getText().toString();
				HomeActivity.Injection1=edt_injections.getText().toString();
				HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
				HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();
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
											}
											in.setClass(getParent(),HomeActivity.class);
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
									}
									in.setClass(getParent(),HomeActivity.class);
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
									popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
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
								popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
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
				popupWindow.dismiss();
				// TODO Auto-generated method stub
				HomeActivity.Title=edt_title.getText().toString();
				HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
				HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
				HomeActivity.Objective_A2=edt_objective_a.getText().toString();
				HomeActivity.Need_B2=edt_need_b.getText().toString();
				HomeActivity.Need_C2=edt_need_c.getText().toString();
				HomeActivity.Injection1=edt_injections.getText().toString();
				HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
				HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();
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
									popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
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
								popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
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
		edt_need_c.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (v.getId() == R.id.need_c) {
					v.getParent().requestDisallowInterceptTouchEvent(true);
					switch (event.getAction() & MotionEvent.ACTION_MASK) {
					case MotionEvent.ACTION_UP:
						v.getParent().requestDisallowInterceptTouchEvent(false);
						break;
					}
				}
				return false;
			}
		});
		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				popupWindow.dismiss();
				// TODO Auto-generated method stub
				HomeActivity.Title=edt_title.getText().toString();
				HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
				HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
				HomeActivity.Objective_A2=edt_objective_a.getText().toString();
				HomeActivity.Need_B2=edt_need_b.getText().toString();
				HomeActivity.Need_C2=edt_need_c.getText().toString();
				HomeActivity.Injection1=edt_injections.getText().toString();
				HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
				HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();
				int SDK_INT = android.os.Build.VERSION.SDK_INT;
				if (SDK_INT>8)
				{
					StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
					StrictMode.setThreadPolicy(policy);
				}
				if(myIntValue==1)
				{
					if(dropbox_file)
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT);
						builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Save Conflict</b></font>"));
						builder.setMessage(Html.fromHtml("<font color='#00478f'><b>Where would you like to save the conflict file?</b></font>"));
						builder.setIcon(R.drawable.launchicon);
						builder.setPositiveButton("Device", new DialogInterface.OnClickListener() {
							@SuppressWarnings("deprecation")
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
						builder.setTitle(Html.fromHtml("<font color='#00478f'><b>Do you want to</b></font>"));
						builder.setIcon(R.drawable.launchicon);
						builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								if(DeviceFileList.File_name.equalsIgnoreCase(""))
								{
									file_name=DropBoxFileList.File_name;
								}
								else
								{
									file_name=DeviceFileList.File_name;
								}

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
										toplayout.setAlpha(01F);
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
								popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
								popupWindow.setFocusable(true);
								popupWindow.update();
								toplayout.setAlpha(0.7F);
							}
						});

						builder.setNegativeButton("Close without saving",new DialogInterface.OnClickListener() {
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
				else
				{

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
							popupWindow.dismiss();
							toplayout.setAlpha(1F);
						}});
					btnsave.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							file_name=edtfilename.getText().toString();
							File myFile;
							if(file_name.trim().length()<1)
							{
								empty.setVisibility(View.VISIBLE);
								empty.setText("Please enter file name");

							}
							else
							{
								file_name=file_name+"_conflict.xlsx";
								if(HomeActivity.Check_conflictsolved)
								{

									File sdCard = Environment.getExternalStorageDirectory();
									directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
									myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
								}
								else
								{
									File sdCard = Environment.getExternalStorageDirectory();
									directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
									myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);

								}
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




						}});
					popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
					popupWindow.setFocusable(true);
					popupWindow.update();	
					toplayout.setAlpha(0.7F);
				}
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
			popupWindow.dismiss();
			HomeActivity.Title=edt_title.getText().toString();
			HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
			HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
			HomeActivity.Objective_A2=edt_objective_a.getText().toString();
			HomeActivity.Need_B2=edt_need_b.getText().toString();
			HomeActivity.Need_C2=edt_need_c.getText().toString();
			HomeActivity.Injection1=edt_injections.getText().toString();
			HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
			HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();
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
									in.setClass(getParent(),TabPage1.class);
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
							in.setClass(getParent(),TabPage1.class);
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
							in.setClass(getParent(),TabPage1.class);
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

							in.setClass(getParent(),TabPage1.class);
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
												in.setClass(getParent(),TabPage1.class);
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
												in.setClass(getParent(),TabPage1.class);
												home_services.push("page1"+TabStack.a,in);
											}
										}
									}
								}});
							popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
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
							in.setClass(getParent(),TabPage1.class);
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

						in.setClass(getParent(),TabPage1.class);
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
			popupWindow.dismiss();
			HomeActivity.Title=edt_title.getText().toString();
			HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
			HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
			HomeActivity.Objective_A2=edt_objective_a.getText().toString();
			HomeActivity.Need_B2=edt_need_b.getText().toString();
			HomeActivity.Need_C2=edt_need_c.getText().toString();
			HomeActivity.Injection1=edt_injections.getText().toString();
			HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
			HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();
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
											in.setClass(getParent(),DeviceFileList.class);
											home_services.push("conflict"+TabStack.a,in);
											toplayout.setAlpha(1F);
										}	
									}
									else
									{

										file_name=edtfilename.getText().toString();
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
							popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
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
			popupWindow.dismiss();
			HomeActivity.Title=edt_title.getText().toString();
			HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
			HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
			HomeActivity.Objective_A2=edt_objective_a.getText().toString();
			HomeActivity.Need_B2=edt_need_b.getText().toString();
			HomeActivity.Need_C2=edt_need_c.getText().toString();
			HomeActivity.Injection1=edt_injections.getText().toString();
			HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
			HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();
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
								popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
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
							popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
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
			popupWindow.dismiss();
//			HomeActivity.Title=edt_title.getText().toString();
//			HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
//			HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
//			HomeActivity.Objective_A2=edt_objective_a.getText().toString();
//			HomeActivity.Need_B2=edt_need_b.getText().toString();
//			HomeActivity.Need_C2=edt_need_c.getText().toString();
//			HomeActivity.Injection1=edt_injections.getText().toString();
//			HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
//			HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();
			getdata();
				//			if((int)HomeActivity.seekbarvalue==100)
			//			{
			//
			//			}
			//			else
			//			{
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			int progress=sharedpreferences.getInt("progressupdate", 0);
			if(progress==0)
			{
			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = sharedpreferences.edit();
			editor.putInt("progressupdate",0);
			editor.commit();				
			//			Checkallfield();
			//			}
			HomeActivity.btnback=true;
			//			home_services.pop();
			in.setClass(getParent(),TabPage10.class);
			home_services.push("page10"+TabStack.a,in);
			break;

		case R.id.assumptions1:
			popupWindow.dismiss();
			getdata();
			//			if((int)HomeActivity.seekbarvalue==100)
			//			{
			//
			//			}
			//			else
			//			{
			//				progress();
			//			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			int progress2=sharedpreferences.getInt("progressupdate", 0);
			if(progress2==0)
			{
			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor2 = sharedpreferences.edit();
			editor2.putInt("progressupdate",0);
			editor2.commit();
			HomeActivity.jump=true;
			in.setClass(getParent(),Assumptions1.class);
			home_services.push("page3"+TabStack.a,in);
			break;

		case R.id.assumptions2:
			popupWindow.dismiss();
			getdata();
			//			if((int)HomeActivity.seekbarvalue==100)
			//			{
			//
			//			}
			//			else
			//			{
			//				progress();
			//			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			int progress3=sharedpreferences.getInt("progressupdate", 0);
			if(progress3==0)
			{
			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor3 = sharedpreferences.edit();
			editor3.putInt("progressupdate",0);
			editor3.commit();
			HomeActivity.jump=true;
			in.setClass(getParent(),Assumptions2.class);
			home_services.push("page4"+TabStack.a,in);
			break;
		case R.id.btnstory:
			popupWindow.dismiss();
			getdata();
			//			if((int)HomeActivity.seekbarvalue==100)
			//			{
			//
			//			}
			//			else
			//			{
			//				progress();
			//			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			int progress4=sharedpreferences.getInt("progressupdate", 0);
			if(progress4==0)
			{
			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor4 = sharedpreferences.edit();
			editor4.putInt("progressupdate",0);
			editor4.commit();
			HomeActivity.jump=true;
			in.setClass(getParent(),TabPage1.class);
			home_services.push("page1"+TabStack.a,in);
			break;
		case R.id.btndiagrom:
			popupWindow.dismiss();
			getdata();
			//			if((int)HomeActivity.seekbarvalue==100)
			//			{
			//
			//			}
			//			else
			//			{
			//				progress();
			//			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			int progress5=sharedpreferences.getInt("progressupdate", 0);
			if(progress5==0)
			{
			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor5 = sharedpreferences.edit();
			editor5.putInt("progressupdate",0);
			editor5.commit();
			HomeActivity.jump=true;
			in.setClass(getParent(),TabPage2.class);
			home_services.push("page2"+TabStack.a,in);
			break;
		case R.id.btnidea:
			popupWindow.dismiss();
			getdata();
			//			if((int)HomeActivity.seekbarvalue==100)
			//			{
			//
			//			}
			//			else
			//			{
			//				progress();
			//			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			int progress6=sharedpreferences.getInt("progressupdate", 0);
			if(progress6==0)
			{
			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor6 = sharedpreferences.edit();
			editor6.putInt("progressupdate",0);
			editor6.commit();
			HomeActivity.jump=true;
			in.setClass(getParent(),TabPage9.class);
			home_services.push("page9"+TabStack.a,in);
			break;
		case R.id.btnsolution:
			popupWindow.dismiss();
			getdata();
			//			if((int)HomeActivity.seekbarvalue==100)
			//			{
			//
			//			}
			//			else
			//			{
			//				progress();
			//			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			int progress7=sharedpreferences.getInt("progressupdate", 0);
			if(progress7==0)
			{
			}
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor7 = sharedpreferences.edit();
			editor7.putInt("progressupdate",0);
			editor7.commit();
			HomeActivity.jump=true;
			in.setClass(getParent(),TabPage10.class);
			home_services.push("page10"+TabStack.a,in);
			break;
		case R.id.btncheck:
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
						u=0;
						t=0;
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
		case R.id.btnverifytitle:
			popupWindow.dismiss();
			if((edt_i_exist_b_alsoexist.getText().toString().length()==0)||(edt_i_exist_c_alsoexist.getText().toString().length()==0))
			{
				check2();
			}
			else
			{
				edt_title.setKeyListener(null);
				edt_title.setBackgroundColor(getResources().getColor(R.color.gray));
				btnverifytitle.setSelected(true);
				btnedittitle.setSelected(false);
				check();
			}
			break;

		case R.id.btnedittitle:
			popupWindow.dismiss();
			edt_title.setKeyListener(PwdkeyListener);
			edt_title.setBackground(originalDrawabletitle);
			btnverifytitle.setSelected(false);
			btnedittitle.setSelected(true);
			break;

		case R.id.btnverifyobjective:
			popupWindow.dismiss();
			if((edt_i_exist_b_alsoexist.getText().toString().length()==0)||(edt_i_exist_c_alsoexist.getText().toString().length()==0))
			{
				check2();
			}
			else
			{
				edt_objective_a.setKeyListener(null);
				edt_objective_a.setBackgroundColor(getResources().getColor(R.color.gray));
				btnverifyobjective.setSelected(true);
				btneditobjective.setSelected(false);
				check();
			}

			break;

		case R.id.btneditobjective:
			popupWindow.dismiss();
			edt_objective_a.setKeyListener(PwdkeyListener);
			edt_objective_a.setBackground(originalDrawableobjective);
			btnverifyobjective.setSelected(false);
			btneditobjective.setSelected(true);
			break;

		case R.id.btnverifyneedb:
			popupWindow.dismiss();
			if((edt_i_exist_b_alsoexist.getText().toString().length()==0)||(edt_i_exist_c_alsoexist.getText().toString().length()==0))
			{
				check2();
			}
			else
			{
				edt_need_b.setKeyListener(null);
				edt_need_b.setBackgroundColor(getResources().getColor(R.color.gray));
				btnverifyneedb.setSelected(true);
				btneditneedb.setSelected(false);
				check();
			}

			break;

		case R.id.btneditneedb:
			popupWindow.dismiss();
			edt_need_b.setKeyListener(PwdkeyListener);
			edt_need_b.setBackground(originalDrawableneedb);
			btnverifyneedb.setSelected(false);
			btneditneedb.setSelected(true);
			break;

		case R.id.btnverifyneedc:
			popupWindow.dismiss();
			if((edt_i_exist_b_alsoexist.getText().toString().length()==0)||(edt_i_exist_c_alsoexist.getText().toString().length()==0))
			{
				check2();
			}
			else
			{
				edt_need_c.setKeyListener(null);
				edt_need_c.setBackgroundColor(getResources().getColor(R.color.gray));
				btnverifyneedc.setSelected(true);
				btneditneedc.setSelected(false);
				check();
			}

			break;

		case R.id.btneditneedc:
			popupWindow.dismiss();
			edt_need_c.setKeyListener(PwdkeyListener);
			edt_need_c.setBackground(originalDrawableneedc);
			btnverifyneedc.setSelected(false);
			btneditneedc.setSelected(true);
			break;

		case R.id.btnverifyinjection:
			popupWindow.dismiss();
			if((edt_i_exist_b_alsoexist.getText().toString().length()==0)||(edt_i_exist_c_alsoexist.getText().toString().length()==0))
			{
				check2();
			}
			else
			{
				edt_injections.setKeyListener(null);
				edt_injections.setBackgroundColor(getResources().getColor(R.color.gray));
				btnverifyinjection.setSelected(true);
				btneditinjection.setSelected(false);
				check();
			}

			break;

		case R.id.btneditinjection:
			popupWindow.dismiss();
			edt_injections.setKeyListener(PwdkeyListener);
			edt_injections.setBackground(originalDrawableinjection);
			btnverifyinjection.setSelected(false);
			btneditinjection.setSelected(true);
			break;

		case R.id.btnverifyabneeded:
			popupWindow.dismiss();
			if((edt_i_exist_b_alsoexist.getText().toString().length()==0)||(edt_i_exist_c_alsoexist.getText().toString().length()==0))
			{
				check2();
			}
			else
			{
				edt_a_b_needed.setKeyListener(null);
				edt_a_b_needed.setBackgroundColor(getResources().getColor(R.color.gray));
				btneditabneeded.setSelected(false);
				check();
			}

			break;

		case R.id.btneditabneeded:
			popupWindow.dismiss();
			edt_a_b_needed.setKeyListener(PwdkeyListener);
			edt_a_b_needed.setBackground(originalDrawableabneeded);
			btneditabneeded.setSelected(true);
			break;

		case R.id.btnverifyacneeded:
			popupWindow.dismiss();
			if((edt_i_exist_b_alsoexist.getText().toString().length()==0)||(edt_i_exist_c_alsoexist.getText().toString().length()==0))
			{
				check2();
			}
			else
			{
				edt_a_c_needed.setKeyListener(null);
				edt_a_c_needed.setBackgroundColor(getResources().getColor(R.color.gray));
				btneditacneeded.setSelected(false);
				check();
			}

			break;

		case R.id.btneditacneeded:
			popupWindow.dismiss();
			edt_a_c_needed.setKeyListener(PwdkeyListener);
			edt_a_c_needed.setBackground(originalDrawableacneeded);
			btneditacneeded.setSelected(true);
			break;
		}
	}
	public void getdata()
	{
		HomeActivity.Title=edt_title.getText().toString();
		HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
		HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
		HomeActivity.Objective_A2=edt_objective_a.getText().toString();
		HomeActivity.Need_B2=edt_need_b.getText().toString();
		HomeActivity.Need_C2=edt_need_c.getText().toString();
		HomeActivity.Injection1=edt_injections.getText().toString();
		HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
		HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();

		HomeActivity.Temp_Objective_A=HomeActivity.Objective_A2;
		HomeActivity.Temp_Need_B=HomeActivity.Need_B2;
		HomeActivity.Temp_Need_C=HomeActivity.Need_C2;
		HomeActivity.Temp_Injection=HomeActivity.Injection1;
		HomeActivity.Temp_A_B_Needed=HomeActivity.A2_B2_Needed;
		HomeActivity.Temp_A_C_Needed=HomeActivity.A2_C2_Needed;
	}
	public void resetdata()
	{
		if(btnedittitle.isSelected())
		{
			if(edt_title.getText().toString().length()>0)
			{
				edt_title.setText("");	
			}

		}
		if(btneditobjective.isSelected())
		{
			if(edt_objective_a.getText().toString().length()>0)
			{
				edt_objective_a.setText("");
			}

		}
		if(btneditneedb.isSelected())
		{
			if(edt_need_b.getText().toString().length()>0)
			{
				edt_need_b.setText("");
			}

		}
		if(btneditneedc.isSelected())
		{
			if(edt_need_c.getText().toString().length()>0)
			{
				edt_need_c.setText("");
			}

		}
		if(btneditinjection.isSelected())
		{
			if(edt_injections.getText().toString().length()>0)
			{
				edt_injections.setText("");
			}

		}
		if(btneditabneeded.isSelected())
		{
			if(edt_a_b_needed.getText().toString().length()>0)
			{
				edt_a_b_needed.setText("");
			}

		}
		if(btneditacneeded.isSelected())
		{
			if(edt_a_c_needed.getText().toString().length()>0)
			{
				edt_a_c_needed.setText("");
			}

		}
		if(edt_i_exist_b_alsoexist.getText().toString().length()>0)
		{
			edt_i_exist_b_alsoexist.setText("");
		}
		if(edt_i_exist_c_alsoexist.getText().toString().length()>0)
		{
			edt_i_exist_c_alsoexist.setText("");
		}




		btnverifytitle.setSelected(false);
		btnverifyobjective.setSelected(false);
		btnverifyneedb.setSelected(false);
		btnverifyneedc.setSelected(false);
		btnverifyinjection.setSelected(false);
	}
	@SuppressWarnings("deprecation")
	public void check()
	{
		if((btnverifytitle.isSelected())&&(btnverifyobjective.isSelected())&&(btnverifyneedb.isSelected())&&(btnverifyneedc.isSelected())&&(btnverifyinjection.isSelected()))
		{
			HomeActivity.Title=edt_title.getText().toString();
			HomeActivity.A2_B2_Needed=edt_a_b_needed.getText().toString();
			HomeActivity.I_Exist_B_alsoExist=edt_i_exist_b_alsoexist.getText().toString();
			HomeActivity.Objective_A2=edt_objective_a.getText().toString();
			HomeActivity.Need_B2=edt_need_b.getText().toString();
			HomeActivity.Need_C2=edt_need_c.getText().toString();
			HomeActivity.Injection1=edt_injections.getText().toString();
			HomeActivity.A2_C2_Needed=edt_a_c_needed.getText().toString();
			HomeActivity.I_Exist_C_alsoexist=edt_i_exist_c_alsoexist.getText().toString();
			AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

			alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Conflict solved.</b></font>"));
//			alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>You have now verified all fields. Congratulations you have found a solution to your problem.\nMark conflict as solved?</b></font>"));
			alertDialog.setMessage(Html.fromHtml(getResources().getString(R.string.message)));
			alertDialog.setIcon(R.drawable.launchicon);
			alertDialog.setCancelable(false);
			alertDialog.setButton("YES", new  DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
					SharedPreferences.Editor editor = sharedpreferences.edit();
					editor.putInt("progressupdate",1);
					editor.commit();
					if(myIntValue==1)
					{
						file_name=DeviceFileList.File_name;

						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", file_name);
						boolean deleted = file.delete();

						File sdCard = Environment.getExternalStorageDirectory();
						directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
						File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);


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
						SharedPreferences.Editor editorr = sp.edit();
						editorr.putInt("file_open", 0);
						editorr.commit();

						in.setClass(getParent(),HomeActivity.class);
						home_services.push("home"+TabStack.a,in);
					}
					else
					{
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
								popupWindow.dismiss();
								toplayout.setAlpha(1F);
							}});
						btnsave.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								file_name=edtfilename.getText().toString();
								File myFile;
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
										myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/Close_Conflict/"+file_name);
									
									if(myFile.exists())
									{
										Log.e("File exist","exist");
										empty.setVisibility(View.VISIBLE);
										empty.setText("File name already exists");

									}
									else
									{
										popupWindow.dismiss();
										HomeActivity.conflictsolved="yes";
										FileSave fs=new FileSave();
										fs.XLS(directory, file_name);
										stack_size=TabStack.stack.size();
										HomeActivity.conflictsolved="no";
										Method m=new Method();
										m.run();
										
										setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
										
										toplayout.setAlpha(1F);
										
										AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
                                        alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Message</b></font>"));
										alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Conflict marked as solved.</b></font>"));
										alertDialog.setIcon(R.drawable.launchicon);
										alertDialog.setButton("OK", new  DialogInterface.OnClickListener() {

											@Override
											public void onClick(DialogInterface dialog, int which) {
												// TODO Auto-generated method stub

												for(int i=1;i<stack_size;i++)
												{
													home_services.pop();	
												}
												in.setClass(getParent(),HomeActivity.class);
												home_services.push("home"+TabStack.a,in);
											}
										});
										alertDialog.show();
									}	
								}




							}});
						popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
						popupWindow.setFocusable(true);
						popupWindow.update();	
						toplayout.setAlpha(0.7F);
						
					}
					

				}
			});
			alertDialog.setButton2("NO", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					//					file_name=DeviceFileList.File_name;
					
					if(myIntValue==1)
					{
						file_name=DeviceFileList.File_name;


						File sdCard = Environment.getExternalStorageDirectory();
						directory = new File (sdCard.getAbsolutePath() + "/Conflict_Files");
						File myFile = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);


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
						SharedPreferences.Editor editorr = sp.edit();
						editorr.putInt("file_open", 0);
						editorr.commit();

						in.setClass(getParent(),HomeActivity.class);
						home_services.push("home"+TabStack.a,in);
					}
					else
					{
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
								popupWindow.dismiss();
								toplayout.setAlpha(1F);
							}});
						btnsave.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								file_name=edtfilename.getText().toString();
								File myFile;
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
									File myFilee = new File(sdCard.getAbsolutePath()+"/Conflict_Files/"+file_name);
									
									if(myFilee.exists())
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
										
										setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
										
										toplayout.setAlpha(1F);
										
										AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

										alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Message</b></font>"));
										alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Conflict not marked as solved. Edit if necessary.</b></font>"));
										alertDialog.setIcon(R.drawable.launchicon);
										alertDialog.setButton("OK", new  DialogInterface.OnClickListener() {

											@Override
											public void onClick(DialogInterface dialog, int which) {
												// TODO Auto-generated method stub

												for(int i=1;i<stack_size;i++)
												{
													home_services.pop();	
												}
												in.setClass(getParent(),HomeActivity.class);
												home_services.push("home"+TabStack.a,in);
											}
										});
										alertDialog.show();
									}	
								}




							}});
						popupWindow.showAtLocation(popupView, LayoutParams.WRAP_CONTENT,10,300);
						popupWindow.setFocusable(true);
						popupWindow.update();	
						toplayout.setAlpha(0.7F);
					}
				
					
				}
			});

			alertDialog.show();
		}
	}
	@SuppressWarnings("deprecation")
	public void check2()
	{

		AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

				alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Warning</b></font>"));
		alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>Before content of this field can be verified, last two fields need to be filled.</font>"));
				alertDialog.setIcon(R.drawable.launchicon);
		alertDialog.setButton("Ok", new  DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		});


		alertDialog.show();

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
		if((edt_title.getText().toString().length()==0)&&(edt_objective_a.getText().toString().length()==0)&&(edt_need_b.getText().toString().length()==0)&&(edt_need_c.getText().toString().length()==0)&&(edt_injections.getText().toString().length()==0)&&(edt_a_b_needed.getText().toString().length()==0)&&(edt_a_c_needed.getText().toString().length()==0)&&(edt_i_exist_b_alsoexist.getText().toString().length()==0)&&(edt_i_exist_c_alsoexist.getText().toString().length()==0))
		{
			btnreset.setSelected(true);
		}
		else
		{
			btnreset.setSelected(false);
		}
	}
}

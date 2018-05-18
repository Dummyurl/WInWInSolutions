package com.in.winwinsolutions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class DeviceFileList extends Activity implements OnClickListener {
	Button btn_new_conflict,btn_open_conflict,btn_close_conflict,btn_Drop,btn_drive,btn_device;
	RelativeLayout Rl_open,Rl_new,Rl_close;
	//	TextView txtnew,txtopen,txtclose;
	TextView txtnew,txtopen,txtclose,txtnewconflict,txtopenconflict,txtcloseconflict;
	//ListView listview;
	ArrayAdapter<String> arr_adapter;
	String F_name ;
	Intent in=new Intent();
	TabStack home_services;
	TextView empty_list;
	int stack_size;
	int del_pos;
	public static String File_name="";
	public static ArrayList<String> Heading=new ArrayList<String>();
	public static ArrayList<String> Value=new ArrayList<String>();

	List<Item> items1, items2;//, items3;
	ListView listView1, listView2;//, listView3;
	ItemsListAdapter myItemsListAdapter1;//, myItemsListAdapter3;
	ItemsListAdapter2 myItemsListAdapter2;
	LinearLayoutListView area1, area2;//, area3;
	TextView prompt;
	String area="outofrange";
	public int listposition=3;
	ImageView imgtitlehint,imgtitlehint2,devicefilehint,dropboxfilehint;
	PopupWindow popupWindow ;
	int a=0;
	TextView text,txtopenconflicts,txtcloseconflicts;
	Boolean conflictfile=false;
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.device_file_list);
		//listview=(ListView)findViewById(R.id.device_file_list);
		btn_new_conflict=(Button)findViewById(R.id.btn_new); 
		btn_close_conflict=(Button)findViewById(R.id.btn_close); 
		btn_open_conflict=(Button)findViewById(R.id.btn_open); 
		Rl_new=(RelativeLayout)findViewById(R.id.rlnew);
		Rl_open=(RelativeLayout)findViewById(R.id.rlopen);
		Rl_close=(RelativeLayout)findViewById(R.id.rlclose);


		imgtitlehint=(ImageView)findViewById(R.id.imghint);
		imgtitlehint2=(ImageView)findViewById(R.id.imghint2);
		devicefilehint=(ImageView)findViewById(R.id.devicefilehint);
		dropboxfilehint=(ImageView)findViewById(R.id.dropboxfilehint);

		btn_Drop=(Button)findViewById(R.id.btn_drop);
		btn_device=(Button)findViewById(R.id.btn_device);
		btn_drive=(Button)findViewById(R.id.btn_drive);
		btn_new_conflict.setOnClickListener(this); 
		btn_open_conflict.setOnClickListener(this); 
		btn_close_conflict.setOnClickListener(this); 
		Rl_open.setOnClickListener(this); 
		Rl_new.setOnClickListener(this); 
		Rl_close.setOnClickListener(this); 
		btn_Drop.setOnClickListener(this);
		btn_drive.setOnClickListener(this);
		btn_device.setOnClickListener(this);
		empty_list=(TextView)findViewById(R.id.empty_list);
		txtopenconflicts=(TextView)findViewById(R.id.txtopenconflicts);
		txtcloseconflicts=(TextView)findViewById(R.id.txtcloseconflicts);
		Tabs.btn_exit_app.setText("");
		Tabs.btn_line2.setText("");

		home_services=(TabStack)getParent();
		btn_open_conflict.setSelected(true);
		btn_device.setSelected(true);
		btn_drive.setSelected(false);
		btn_Drop.setSelected(false);
		boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
		if (tabletSize) {

			txtnew=(TextView)findViewById(R.id.txtnew);
			txtopen=(TextView)findViewById(R.id.txtopen);
			txtclose=(TextView)findViewById(R.id.txtclose);


			txtnew.setTextColor(getResources().getColor(R.color.btncolor));
			txtopen.setTextColor(getResources().getColor(R.color.btncolorhover));
			txtclose.setTextColor(getResources().getColor(R.color.btncolor));	
		} 
		else
		{
			txtnew=(TextView)findViewById(R.id.txtnew);
			txtopen=(TextView)findViewById(R.id.txtopen);
			txtclose=(TextView)findViewById(R.id.txtclose);
			txtnewconflict=(TextView)findViewById(R.id.txtnewconflict);
			txtopenconflict=(TextView)findViewById(R.id.txtopenconflict);
			txtcloseconflict=(TextView)findViewById(R.id.txtcloseconflict);

			txtnew.setTextColor(getResources().getColor(R.color.btncolor));
			txtopen.setTextColor(getResources().getColor(R.color.btncolorhover));
			txtclose.setTextColor(getResources().getColor(R.color.btncolor));
			txtnewconflict.setTextColor(getResources().getColor(R.color.btncolor));
			txtopenconflict.setTextColor(getResources().getColor(R.color.btncolorhover));
			txtcloseconflict.setTextColor(getResources().getColor(R.color.btncolor));
		}
		listView1 = (ListView)findViewById(R.id.listview1);
		listView2 = (ListView)findViewById(R.id.listview2);
		//  listView3 = (ListView)findViewById(R.id.listview3);

		LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
		View popupView = layoutInflater.inflate(R.layout.textview_hint, null);  
		popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
		text=(TextView)popupView.findViewById(R.id.popuptext);


		imgtitlehint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(a==0)
				{
					String str="Drag and Drop conflict to \"Solved conflicts\" to mark as solved.";
					text.setText(str);
					popupWindow.showAsDropDown(txtopenconflicts, 0, 0);
					a=1;
				}
				else
				{
					//					edt_title.setError(null);	
					popupWindow.dismiss();
					a=0;
				}


			}
		});
		imgtitlehint2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(a==0)
				{
					String str="Drag and Drop conflict to \"Open conflicts\" to allow editing.";
					text.setText(str);
					popupWindow.showAsDropDown(txtcloseconflicts, 0, 0);
					a=1;
				}
				else
				{
					//					edt_title.setError(null);	
					popupWindow.dismiss();
					a=0;
				}


			}
		});
		devicefilehint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(a==0)
				{
					String str="1.Conflict files will be saved by default on your device with the file suffix _conflict in the folder <b>Conflict_files.</b><br/>2.The App is able to read .xls and .xlsx file format.<br/>3.If you receive a shared file with the suffix _conflict, the App will pick it up from the Download folder, and load it into the App.<br/>4.If you want to share a file, go to <b>Open Conflict</b> and click on the <b>Send</b> button to share it via Google Drive Google Mail or Dropbox.";
					
					text.setText(Html.fromHtml(str));
					popupWindow.showAsDropDown(btn_device, 0, 0);
					a=1;
				}
				else
				{
					//					edt_title.setError(null);	
					popupWindow.dismiss();
					a=0;
				}


			}
		});
		dropboxfilehint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(a==0)
				{
					String str="1.Sign into your dropbox account and link it to the App.<br/>2.Only _conflict files .xls or .xlsx format which are saved in your  linked dropbox will be shown.<br/>3.If you make changes to the file, it will be saved in the folder Conflict_files on your device  or in the Dropbox under the App folder DropBox_Conflict.<br/>4.Open your changed file using the <b>Device / Dropbox</b> tab respectively.";
					
					text.setText(Html.fromHtml(str));
					popupWindow.showAsDropDown(btn_Drop, 0, 0);
					a=1;
				}
				else
				{
					//					edt_title.setError(null);	
					popupWindow.dismiss();
					a=0;
				}


			}
		});

		listView1.setOnTouchListener(new ListView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					// Disallow ScrollView to intercept touch events.
					v.getParent().requestDisallowInterceptTouchEvent(true);
					break;

				case MotionEvent.ACTION_UP:
					// Allow ScrollView to intercept touch events.
					v.getParent().requestDisallowInterceptTouchEvent(false);
					break;
				}

				// Handle ListView touch events.
				v.onTouchEvent(event);
				return true;
			}
		});

		listView2.setOnTouchListener(new ListView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					// Disallow ScrollView to intercept touch events.
					v.getParent().requestDisallowInterceptTouchEvent(true);
					break;

				case MotionEvent.ACTION_UP:
					// Allow ScrollView to intercept touch events.
					v.getParent().requestDisallowInterceptTouchEvent(false);
					break;
				}

				// Handle ListView touch events.
				v.onTouchEvent(event);
				return true;
			}
		});

		area1 = (LinearLayoutListView)findViewById(R.id.pane1);
		area2 = (LinearLayoutListView)findViewById(R.id.pane2);
		//  area3 = (LinearLayoutListView)findViewById(R.id.pane3);
		area1.setOnDragListener(myOnDragListener);
		area2.setOnDragListener(myOnDragListener2);
		//  area3.setOnDragListener(myOnDragListener);
		area1.setListView(listView1);
		area2.setListView(listView2);
		//  area3.setListView(listView3);

		initItems();
		myItemsListAdapter1 = new ItemsListAdapter(this, items1);
		myItemsListAdapter2 = new ItemsListAdapter2(this, items2);
		//  myItemsListAdapter3 = new ItemsListAdapter(this, items3);
		listView1.setAdapter(myItemsListAdapter1);
		listView2.setAdapter(myItemsListAdapter2);
		//  listView3.setAdapter(myItemsListAdapter3);

		//Auto scroll to end of ListView
		listView1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		listView2.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		//  listView3.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

		listView1.setOnItemClickListener(listOnItemClickListener);
		listView2.setOnItemClickListener(listOnItemClickListener);
		//  listView3.setOnItemClickListener(listOnItemClickListener);

		listView1.setOnItemLongClickListener(myOnItemLongClickListener);
		listView2.setOnItemLongClickListener(myOnItemLongClickListener2);
		//  listView3.setOnItemLongClickListener(myOnItemLongClickListener);

		prompt = (TextView) findViewById(R.id.prompt);
		// make TextView scrollable
		prompt.setMovementMethod(new ScrollingMovementMethod());
		//clear prompt area if LongClick
		prompt.setOnLongClickListener(new OnLongClickListener(){

			@Override
			public boolean onLongClick(View v) {
				prompt.setText("");
				return true; 
			}});




		Tabs.btn_home.setTextColor(getResources().getColor(R.color.color_name2));
		Tabs.btn_faq.setTextColor(getResources().getColor(R.color.color_name2));
		//		listview.setAdapter(new MycustomAdapter(DeviceFileList.this,theNamesOfFiles));


		Tabs.btn_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popupWindow.dismiss();
				stack_size=TabStack.stack.size();
				for(int i=1;i<stack_size;i++)
				{
					home_services.pop();	
				}
				in.setClass(getParent(),HomeActivity.class);
				home_services.push("conhome1"+TabStack.a,in);
			}
		});
		Tabs.btn_faq.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popupWindow.dismiss();
				stack_size=TabStack.stack.size();
				for(int i=1;i<stack_size;i++)
				{
					home_services.pop();	
				}
				in.setClass(getParent(),FAQ.class);
				home_services.push("faqhome1"+TabStack.a,in);
			}
		});
	}
	



	OnItemLongClickListener myOnItemLongClickListener = new OnItemLongClickListener(){

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			listposition=1;
			Item selectedItem = (Item)(parent.getItemAtPosition(position));

			ItemsListAdapter associatedAdapter = (ItemsListAdapter)(parent.getAdapter());
			List<Item> associatedList = associatedAdapter.getList();

			PassObject passObj = new PassObject(view, selectedItem, associatedList);


			ClipData data = ClipData.newPlainText("", "");
			DragShadowBuilder shadowBuilder = new DragShadowBuilder(view);
			view.startDrag(data, shadowBuilder, passObj, 0);

			return true;
		}

	};
	OnItemLongClickListener myOnItemLongClickListener2 = new OnItemLongClickListener(){

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			listposition=2;
			Item selectedItem = (Item)(parent.getItemAtPosition(position));

			ItemsListAdapter2 associatedAdapter = (ItemsListAdapter2)(parent.getAdapter());
			List<Item> associatedList = associatedAdapter.getList();

			PassObject passObj = new PassObject(view, selectedItem, associatedList);


			ClipData data = ClipData.newPlainText("", "");
			DragShadowBuilder shadowBuilder = new DragShadowBuilder(view);
			view.startDrag(data, shadowBuilder, passObj, 0);


			return true;
		}

	};

	OnDragListener myOnDragListener = new OnDragListener() {

		@SuppressWarnings("deprecation")
		@Override
		public boolean onDrag(final View v, DragEvent event) {

			popupWindow.dismiss();
			if(v == area1){
				area = "area1"; 
			}else if(v == area2){
				area = "area2"; 
			}
			//   else if(v == area3){
			//    area = "area3"; 
			//   }
			else{
				area = "unknown"; 
			}

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				prompt.append("ACTION_DRAG_STARTED: " + area  + "\n");
				break; 
			case DragEvent.ACTION_DRAG_ENTERED:
				prompt.append("ACTION_DRAG_ENTERED: " + area  + "\n");
				break; 
			case DragEvent.ACTION_DRAG_EXITED:
				prompt.append("ACTION_DRAG_EXITED: " + area  + "\n");
				break; 
			case DragEvent.ACTION_DROP:
				prompt.append("ACTION_DROP: " + area  + "\n");

				PassObject passObj = (PassObject)event.getLocalState();
				View view = passObj.view;
				final Item passedItem = passObj.item;
				final List<Item> srcList = passObj.srcList;

				final ListView oldParent = (ListView)view.getParent();

				if(listposition==1)
				{
					if(area.equalsIgnoreCase("area1"))
					{
					}
					else
					{
						ItemsListAdapter srcAdapter = (ItemsListAdapter)(oldParent.getAdapter());

						LinearLayoutListView newParent = (LinearLayoutListView)v;
						ItemsListAdapter2 destAdapter = (ItemsListAdapter2)(newParent.listView.getAdapter()); 
						List<Item> destList = destAdapter.getList();

						if(removeItemToList(srcList, passedItem)){
							addItemToList(destList, passedItem);
						}

						srcAdapter.notifyDataSetChanged();
						destAdapter.notifyDataSetChanged();	


					}

				}
				else
				{


					AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
					alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Message</b></font>"));
					alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>Your conflict has been moved to open conflicts. You are able to view/edit the conflict.</font>"));
						alertDialog.setIcon(R.drawable.launchicon);
					alertDialog.setCancelable(false);	
					alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							final File sdCard = Environment.getExternalStorageDirectory();
							File from = new File(sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict/"+passedItem.ItemString);
							File to = new File(sdCard.getAbsolutePath() + "/Conflict_Files/"+passedItem.ItemString);

							if(to.exists())
							{

								AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
								alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Message</b></font>"));
								alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>File already exist.</font>"));
									alertDialog.setIcon(R.drawable.launchicon);
								alertDialog.setCancelable(false);	
								alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int which) {

									}
								});
								alertDialog.show();
							}
							else
							{
								ItemsListAdapter2 srcAdapter = (ItemsListAdapter2)(oldParent.getAdapter());

								LinearLayoutListView newParent = (LinearLayoutListView)v;
								ItemsListAdapter destAdapter = (ItemsListAdapter)(newParent.listView.getAdapter()); 
								List<Item> destList = destAdapter.getList();

								if(removeItemToList(srcList, passedItem)){
									addItemToList(destList, passedItem);
								}
								//------new add
								from.renameTo(to);
								srcAdapter.notifyDataSetChanged();
								destAdapter.notifyDataSetChanged(); 

								initItems();
								myItemsListAdapter1 = new ItemsListAdapter(DeviceFileList.this, items1);
								myItemsListAdapter2 = new ItemsListAdapter2(DeviceFileList.this, items2);

								//  myItemsListAdapter3 = new ItemsListAdapter(this, items3);
								listView1.setAdapter(myItemsListAdapter1);
								listView2.setAdapter(myItemsListAdapter2);
							}
						}
					});
					alertDialog.show();
				}

				break;
			case DragEvent.ACTION_DRAG_ENDED:
				prompt.append("ACTION_DRAG_ENDED: " + area  + "\n");   
			default:
				break;    
			}

			return true;
		}

	};
	OnDragListener myOnDragListener2 = new OnDragListener() {

		@SuppressWarnings("deprecation")
		@Override
		public boolean onDrag(final View v, DragEvent event) {

			popupWindow.dismiss();
			if(v == area1){
				area = "area1"; 
			}else if(v == area2){
				area = "area2"; 
			}
			else{
				area = "unknown"; 
			}

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				prompt.append("ACTION_DRAG_STARTED: " + area  + "\n");
				break; 
			case DragEvent.ACTION_DRAG_ENTERED:
				prompt.append("ACTION_DRAG_ENTERED: " + area  + "\n");
				break; 
			case DragEvent.ACTION_DRAG_EXITED:
				prompt.append("ACTION_DRAG_EXITED: " + area  + "\n");
				break; 
			case DragEvent.ACTION_DROP:
				prompt.append("ACTION_DROP: " + area  + "\n");

				PassObject passObj = (PassObject)event.getLocalState();
				final View view = passObj.view;
				final Item passedItem = passObj.item;
				final List<Item> srcList = passObj.srcList;

				if(listposition==2)
				{
					if(area.equalsIgnoreCase("area1"))
					{
						ListView oldParent = (ListView)view.getParent();
						ItemsListAdapter2 srcAdapter = (ItemsListAdapter2)(oldParent.getAdapter());

						LinearLayoutListView newParent = (LinearLayoutListView)v;
						ItemsListAdapter destAdapter = (ItemsListAdapter)(newParent.listView.getAdapter());
						List<Item> destList = destAdapter.getList();

						if(removeItemToList(srcList, passedItem)){
							addItemToList(destList, passedItem);
						}

						srcAdapter.notifyDataSetChanged();
						destAdapter.notifyDataSetChanged();

					}
					else
					{
					}

				}
				else
				{

					AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
					alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Message</b></font>"));
					//					alertDialog.setMessage("Your conflict has been moved to solved conflicts. You are able to view the conflict.");
					alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>Your conflict has been moved to solved conflicts. You are able to view the conflict.</font>"));
						alertDialog.setIcon(R.drawable.launchicon);
					alertDialog.setCancelable(false);	
					alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							File sdCard = Environment.getExternalStorageDirectory();
							File from = new File(sdCard.getAbsolutePath() + "/Conflict_Files/"+passedItem.ItemString);
							File to = new File(sdCard.getAbsolutePath() + "/Conflict_Files/Close_Conflict/"+passedItem.ItemString);

							if(to.exists())
							{
								AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
								alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Message</b></font>"));
								alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>File already exist.</font>"));
									alertDialog.setIcon(R.drawable.launchicon);
								alertDialog.setCancelable(false);	
								alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int which) {

									}
								});
								alertDialog.show();
							}
							else
							{
								ListView oldParent = (ListView)view.getParent();
								ItemsListAdapter srcAdapter = (ItemsListAdapter)(oldParent.getAdapter());

								LinearLayoutListView newParent = (LinearLayoutListView)v;
								ItemsListAdapter2 destAdapter = (ItemsListAdapter2)(newParent.listView.getAdapter()); 
								List<Item> destList = destAdapter.getList();

								if(removeItemToList(srcList, passedItem)){
									addItemToList(destList, passedItem);
								}
								//------new add
								from.renameTo(to);
								srcAdapter.notifyDataSetChanged();
								destAdapter.notifyDataSetChanged(); 
								initItems();
								myItemsListAdapter1 = new ItemsListAdapter(DeviceFileList.this, items1);
								myItemsListAdapter2 = new ItemsListAdapter2(DeviceFileList.this, items2);

								//  myItemsListAdapter3 = new ItemsListAdapter(this, items3);
								listView1.setAdapter(myItemsListAdapter1);
								listView2.setAdapter(myItemsListAdapter2);
							}


						}
					});
					alertDialog.show();

				}
				break;
			case DragEvent.ACTION_DRAG_ENDED:
				prompt.append("ACTION_DRAG_ENDED: " + area  + "\n");   
			default:
				break;    
			}

			return true;
		}

	};
	OnItemClickListener listOnItemClickListener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
		}

	};
	private void initItems(){
		items1 = new ArrayList<Item>();
		items2 = new ArrayList<Item>();

		final File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File(sdCard.getAbsolutePath() + "/Conflict_Files");


		File download = new File(sdCard.getAbsolutePath() + "/Download");
		File[] downloadfilelist=download.listFiles();
		for(int j=0;j<downloadfilelist.length;j++)
		{

			String s = downloadfilelist[j].getName();

			if((s.contains("_conflict"))||(s.contains("_Conflict")))
			{
				//File a=downloadfilelist[j];

				if(s.contains(".xls"))
				{
					copyFile( download.toString(),  s,  dir.toString());

					File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download", s);
					boolean deleted = file.delete();
				}

			}
		}

		File[] filelist = dir.listFiles();
		Arrays.sort(filelist, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		System.out.println("\nLast Modified Descending Order (LASTMODIFIED_COMPARATOR)");
		displayFiles(filelist);

		for(int i=0; i<filelist.length; i++){
			//		   Drawable d = arrayDrawable.getDrawable(i);
			Drawable d =getResources().getDrawable( R.drawable.delete );
			Drawable d1 =getResources().getDrawable( R.drawable.view );
			Drawable d2 =getResources().getDrawable( R.drawable.send );
			String s = filelist[i].getName();

			if(s.contains(".xls"))
			{



				Item item = new Item(d,d1,d2,s);
				items1.add(item);
			}



		}

		final File sdCard1 = Environment.getExternalStorageDirectory();
		File dir1 = new File(sdCard1.getAbsolutePath() + "/Conflict_Files/Close_Conflict");
		File[] filelist1 = dir1.listFiles();

		Arrays.sort(filelist1, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		System.out.println("\nLast Modified Descending Order (LASTMODIFIED_REVERSE)");
		displayFiles(filelist1);

		for(int i=0; i<filelist1.length; i++){
			//		   Drawable d = arrayDrawable.getDrawable(i);
			Drawable d =getResources().getDrawable( R.drawable.delete );
			Drawable d1 =getResources().getDrawable( R.drawable.view );
			Drawable d2 =getResources().getDrawable( R.drawable.send );
			String s = filelist1[i].getName();

			if(s.contains(".xls"))
			{
				Item item = new Item(d,d1,d2,s);
				items2.add(item);
			}



		}
	}

	private void copyFile(String inputPath, String inputFile, String outputPath) {

		InputStream in = null;
		OutputStream out = null;
		try {

			//create output directory if it doesn't exist
			File dir = new File (outputPath); 
			if (!dir.exists())
			{
				dir.mkdirs();
			}


			in = new FileInputStream(inputPath +"/"+ inputFile);        
			out = new FileOutputStream(outputPath +"/"+ inputFile);

			byte[] buffer = new byte[1024];
			int read;
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
			in.close();
			in = null;

			// write the output file (You have now copied the file)
			out.flush();
			out.close();
			out = null;        

		}  catch (FileNotFoundException fnfe1) {
			Log.e("tag", fnfe1.getMessage());
		}
		catch (Exception e) {
			Log.e("tag", e.getMessage());
		}

	}


	private boolean removeItemToList(List<Item> l, Item it){
		boolean result = l.remove(it);
		return result;
	}

	private boolean addItemToList(List<Item> l, Item it){
		boolean result = l.add(it);
		return result;
	}
	public static void displayFiles(File[] files) {
		for (File file : files) {
			System.out.printf("File: %-20s Last Modified:" + new Date(file.lastModified()) + "\n", file.getName());
		}
	}

	//items stored in ListView
	public class Item {
		Drawable ItemDrawable,ItemDrawable1,itemDrawable2;
		String ItemString;
		Item(Drawable drawable,Drawable d1,Drawable d2, String t){
			ItemDrawable = drawable;
			ItemDrawable1 =d1;
			itemDrawable2=d2;
			ItemString = t;
		}
	}

	//objects passed in Drag and Drop operation
	class PassObject{
		View view;
		Item item;
		List<Item> srcList;

		PassObject(View v, Item i, List<Item> s){
			view = v;
			item = i;
			srcList = s;
		}
	}
	
	static class ViewHolder {
		ImageView Share,View,Delete;
		TextView text; 
	}

	public class ItemsListAdapter extends BaseAdapter {

		private Context context;
		private List<Item> list;

		ItemsListAdapter(Context c, List<Item> l){
			context = c;
			list = l;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int paramInt, View convertView, ViewGroup parent) {
			View rowView = convertView;

			// reuse views
			if (rowView == null) {
				LayoutInflater inflater = ((Activity) context).getLayoutInflater();
				rowView = inflater.inflate(R.layout.device_file_list_item, null);

				ViewHolder viewHolder = new ViewHolder();
				//  viewHolder.icon = (ImageView) rowView.findViewById(R.id.rowImageView);
				viewHolder.View = (ImageView) rowView.findViewById(R.id.view);
				viewHolder.Delete = (ImageView) rowView.findViewById(R.id.delete);
				viewHolder.Share = (ImageView) rowView.findViewById(R.id.share);
				viewHolder.text = (TextView) rowView.findViewById(R.id.file_name);
				rowView.setTag(viewHolder); 
			}

			ViewHolder holder = (ViewHolder) rowView.getTag();
			// holder.icon.setImageDrawable(list.get(position).ItemDrawable);
			//				holder.view.setBackgroundDrawable(list.get(position).ItemDrawable2);
			holder.text.setText(list.get(paramInt).ItemString);

			holder.View.setTag(paramInt);
			holder.View.setOnClickListener(new OnClickListener() {

				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View vv) {
					// TODO Auto-generated method stub
					Heading.clear();
					Value.clear();
					popupWindow.dismiss();
					int pos1 = (Integer) vv.getTag();
					//					Holder h1 = (Holder) list.get(pos1);
					File_name=list.get(pos1).ItemString;

					if(File_name.contains(".xlsx"))
					{
						List<String> resultSet = new ArrayList<String>();
						File inputWorkbook = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", File_name);

						if(inputWorkbook.exists()){

							try 
							{

								// Get the workbook instance for XLSX file
								HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(inputWorkbook));

								// Get first sheet from the workbook
								HSSFSheet sheet = wb.getSheetAt(0);

								Row row;
								Cell cell;

								// Iterate through each rows from first sheet
								Iterator<Row> rowIterator = sheet.iterator();
								int j=0;
								int k=0;
								while (rowIterator.hasNext()) 
								{
									j++;
									row = rowIterator.next();

									// For each row, iterate through each columns
									Iterator<Cell> cellIterator = row.cellIterator();

									while (cellIterator.hasNext()) 
									{

										cell = cellIterator.next();
										if(k==0)
										{
											String str=cell.getStringCellValue();
											if(!str.equalsIgnoreCase("Title")||(str.equalsIgnoreCase("")))
											{
												Toast.makeText(getParent(), "It's not a conflict file" , Toast.LENGTH_LONG).show();
												conflictfile=false;
												break;
											}
											else
											{
												conflictfile=true;
												k++;
											}
										}
										if(j==1)
										{
											Heading.add(cell.getStringCellValue());
										}
										else if(j==2)
										{
											switch (cell.getCellType()) 
											{


											case Cell.CELL_TYPE_NUMERIC:
												System.out.println(cell.getNumericCellValue());
												Value.add(""+cell.getNumericCellValue());
												break;

											case Cell.CELL_TYPE_STRING:
												System.out.println(cell.getStringCellValue());
												Value.add(cell.getStringCellValue());
												break;
											}

										}
									}
								}
							}
							catch (Exception e) 
							{
								try
								{
									XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(inputWorkbook));
									// Get first sheet from the workbook
									XSSFSheet sheet = workbook.getSheetAt(0);
									Cell cell;
									Row row;

									// Iterate through each rows from first sheet
									Iterator<Row> rowIterator = sheet.iterator();
									int j=0;
									int k=0;
									while (rowIterator.hasNext()) 
									{
										j++;
										row = rowIterator.next();

										// For each row, iterate through each columns
										Iterator<Cell> cellIterator = row.cellIterator();

										while (cellIterator.hasNext()) 
										{
											cell = cellIterator.next();
											if(k==0)
											{
												String str=cell.getStringCellValue();
												if(!str.equalsIgnoreCase("Title")||(str.equalsIgnoreCase("")))
												{
													Toast.makeText(getParent(), "It's not a conflict file" , Toast.LENGTH_LONG).show();
													conflictfile=false;
													break;
												}
												else
												{
													conflictfile=true;
													k++;
												}
											}

											if(j==1)
											{
												Heading.add(cell.getStringCellValue());

											}
											else if(j==2)
											{
												switch (cell.getCellType()) 
												{


												case Cell.CELL_TYPE_NUMERIC:
													System.out.println(cell.getNumericCellValue());
													Value.add(""+cell.getNumericCellValue());
													break;

												case Cell.CELL_TYPE_STRING:
													System.out.println(cell.getStringCellValue());
													Value.add(cell.getStringCellValue());
													break;
												}
											}
										}
									}
								}
								catch(Exception e90)
								{
									System.err.println("Exception" + e.getMessage());
									//									File file = new File(Environment.getExternalStorageDirectory()+ "/filepath/" + filename);
									Intent intent = new Intent(Intent.ACTION_VIEW);
									intent.setDataAndType(Uri.fromFile(inputWorkbook),"application/vnd.ms-excel");
									startActivity(intent);
								}

								System.err.println("Exception :" + e.getMessage());
							}
							if(conflictfile)
							{
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putInt("file_open", 1);
								editor.putBoolean("ConflictSolve", false);
								editor.commit();
								HomeActivity.Title=DeviceFileList.Value.get(0);
								HomeActivity.Owner=DeviceFileList.Value.get(1);
								HomeActivity.Story=DeviceFileList.Value.get(2);
								HomeActivity.Objective_A=DeviceFileList.Value.get(3);
								HomeActivity.Need_B=DeviceFileList.Value.get(4);
								HomeActivity.Need_C=DeviceFileList.Value.get(5);
								HomeActivity.Want_D1=DeviceFileList.Value.get(6);
								HomeActivity.Want_D2=DeviceFileList.Value.get(7);
								HomeActivity.Why_A=DeviceFileList.Value.get(8);
								HomeActivity.A_B_Needed=DeviceFileList.Value.get(9);
								HomeActivity.A_C_Needed=DeviceFileList.Value.get(10);
								HomeActivity.B_D1_Needed=DeviceFileList.Value.get(11);
								HomeActivity.C_D2_Needed=DeviceFileList.Value.get(12);
								HomeActivity.D1_conflict_D2=DeviceFileList.Value.get(13);
								HomeActivity.Ideas_A=DeviceFileList.Value.get(20);
								HomeActivity.Ideas_AB=DeviceFileList.Value.get(21);
								HomeActivity.Ideas_AC=DeviceFileList.Value.get(22);
								HomeActivity.Ideas_BD1=DeviceFileList.Value.get(23);
								HomeActivity.Ideas_CD2=DeviceFileList.Value.get(24);
								HomeActivity.Ideas_D1D2=DeviceFileList.Value.get(25);
								HomeActivity.Injection=DeviceFileList.Value.get(26);

								HomeActivity.Objective_A2=DeviceFileList.Value.get(27);
								HomeActivity.Need_B2=DeviceFileList.Value.get(28);
								HomeActivity.Need_C2=DeviceFileList.Value.get(29);
								HomeActivity.Injection1=DeviceFileList.Value.get(30);
								HomeActivity.A2_B2_Needed=DeviceFileList.Value.get(31);
								HomeActivity.A2_C2_Needed=DeviceFileList.Value.get(32);
								HomeActivity.I_Exist_B_alsoExist=DeviceFileList.Value.get(33);
								HomeActivity.I_Exist_C_alsoexist=DeviceFileList.Value.get(34);
									boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
									if (tabletSize) {




										in.setClass(getParent(),TabPage1.class);
										home_services.push("page1",in);
									} 
									else
									{

										in.setClass(getParent(),Page1.class);
										home_services.push("page1"+TabStack.a,in);
									}

							}
						}
						else
						{
							AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

							alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>File not found..!</b></font>"));
							//							alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>File not found..!</font>"));
							alertDialog.setIcon(R.drawable.launchicon);
							alertDialog.setButton("Ok", new  DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
								}
							});


							alertDialog.show();

							resultSet.add("File not found..!");
						}
					}
					else
					{
						List<String> resultSet = new ArrayList<String>();
						File inputWorkbook = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files/"+File_name);
						if(inputWorkbook.exists()){
							try 
							{
								// Get the workbook instance for XLS file
								HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputWorkbook));
								// Get first sheet from the workbook
								HSSFSheet sheet = workbook.getSheetAt(0);
								Cell cell;
								Row row;

								// Iterate through each rows from first sheet
								Iterator<Row> rowIterator = sheet.iterator();
								int j=0;
								int k=0;
								while (rowIterator.hasNext()) 
								{
									j++;

									row = rowIterator.next();

									// For each row, iterate through each columns
									Iterator<Cell> cellIterator = row.cellIterator();

									while (cellIterator.hasNext()) 
									{
										cell = cellIterator.next();
										if(k==0)
										{
											String str=cell.getStringCellValue();
											if(!str.equalsIgnoreCase("Title")||(str.equalsIgnoreCase("")))
											{
												Toast.makeText(getParent(), "It's not a conflict file" , Toast.LENGTH_LONG).show();
												conflictfile=false;
												break;
											}
											else
											{
												conflictfile=true;
												k++;
											}
										}
										if(j==1)
										{
											Heading.add(cell.getStringCellValue());
										}
										else if(j==2)
										{
											switch (cell.getCellType()) 
											{


											case Cell.CELL_TYPE_NUMERIC:
												System.out.println(cell.getNumericCellValue());
												Value.add(""+cell.getNumericCellValue());
												break;

											case Cell.CELL_TYPE_STRING:
												System.out.println(cell.getStringCellValue());
												Value.add(cell.getStringCellValue());
												break;
											}

										}

									}
								}

							} 

							catch (FileNotFoundException e) 
							{

								System.err.println("Exception" + e.getMessage());
							}
							catch (IOException e) 
							{

								System.err.println("Exception" + e.getMessage());
							}


							if(conflictfile)
							{
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putInt("file_open", 1);
								editor.putBoolean("ConflictSolve", false);
								editor.commit();
								HomeActivity.Title=DeviceFileList.Value.get(0);
								HomeActivity.Owner=DeviceFileList.Value.get(1);
								HomeActivity.Story=DeviceFileList.Value.get(2);
								HomeActivity.Objective_A=DeviceFileList.Value.get(3);
								HomeActivity.Need_B=DeviceFileList.Value.get(4);
								HomeActivity.Need_C=DeviceFileList.Value.get(5);
								HomeActivity.Want_D1=DeviceFileList.Value.get(6);
								HomeActivity.Want_D2=DeviceFileList.Value.get(7);
								HomeActivity.Why_A=DeviceFileList.Value.get(8);
								HomeActivity.A_B_Needed=DeviceFileList.Value.get(9);
								HomeActivity.A_C_Needed=DeviceFileList.Value.get(10);
								HomeActivity.B_D1_Needed=DeviceFileList.Value.get(11);
								HomeActivity.C_D2_Needed=DeviceFileList.Value.get(12);
								HomeActivity.D1_conflict_D2=DeviceFileList.Value.get(13);
								HomeActivity.Ideas_A=DeviceFileList.Value.get(20);
								HomeActivity.Ideas_AB=DeviceFileList.Value.get(21);
								HomeActivity.Ideas_AC=DeviceFileList.Value.get(22);
								HomeActivity.Ideas_BD1=DeviceFileList.Value.get(23);
								HomeActivity.Ideas_CD2=DeviceFileList.Value.get(24);
								HomeActivity.Ideas_D1D2=DeviceFileList.Value.get(25);
								HomeActivity.Injection=DeviceFileList.Value.get(26);

								HomeActivity.Objective_A2=DeviceFileList.Value.get(27);
								HomeActivity.Need_B2=DeviceFileList.Value.get(28);
								HomeActivity.Need_C2=DeviceFileList.Value.get(29);
								HomeActivity.Injection1=DeviceFileList.Value.get(30);
								HomeActivity.A2_B2_Needed=DeviceFileList.Value.get(31);
								HomeActivity.A2_C2_Needed=DeviceFileList.Value.get(32);
								HomeActivity.I_Exist_B_alsoExist=DeviceFileList.Value.get(33);
								HomeActivity.I_Exist_C_alsoexist=DeviceFileList.Value.get(34);

									boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
									if (tabletSize) {

										in.setClass(getParent(),TabPage1.class);
										home_services.push("page1",in);
									} 
									else
									{

										in.setClass(getParent(),Page1.class);
										home_services.push("page1"+TabStack.a,in);
									}
							}
						}
						else
						{
							AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

							alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>File not found..!</b></font>"));
							//							alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>File not found..!</font>"));
							alertDialog.setIcon(R.drawable.launchicon);
							alertDialog.setButton("Ok", new  DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
								}
							});


							alertDialog.show();

							resultSet.add("File not found..!");
						}
						if(resultSet.size()==0){
							resultSet.add("Data not found..!");
						}
					}

				}
			});
			holder.Delete.setTag(paramInt);
			holder.Delete.setOnClickListener(new OnClickListener() {

				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View vv) {
					// TODO Auto-generated method stub

					popupWindow.dismiss();
					del_pos = (Integer) vv.getTag();
					AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
					alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Delete the file</b></font>"));
					alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Are you sure you want to delete the conflict file?</b></font>"));
					alertDialog.setIcon(R.drawable.launchicon);
					alertDialog.setButton("Yes", new  DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub

							//					Holder h1 = (Holder) list.get(pos1);
							String str=list.get(del_pos).ItemString;
							File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files", str);
							boolean deleted = file.delete();

							final File sdCard = Environment.getExternalStorageDirectory();
							File dir = new File(sdCard.getAbsolutePath() + "/Conflict_Files");
							File[] filelist = dir.listFiles();
							String[] theNamesOfFiles = new String[filelist.length];
							for (int i = 0; i < theNamesOfFiles.length; i++) {
								theNamesOfFiles[i] = filelist[i].getName();
							}
							//listview.setAdapter(new MycustomAdapter(DeviceFileList.this,theNamesOfFiles));
							initItems();
							myItemsListAdapter1 = new ItemsListAdapter(DeviceFileList.this, items1);

							//  myItemsListAdapter3 = new ItemsListAdapter(this, items3);
							listView1.setAdapter(myItemsListAdapter1);


						}
					});
					alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					});
					alertDialog.show();


				}
			});

			holder.Share.setTag(paramInt);
			holder.Share.setOnClickListener(new OnClickListener() {

				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					popupWindow.dismiss();
					int pos1 = (Integer) v.getTag();
					//					Holder h1 = (Holder) list.get(pos1);
					String str=list.get(pos1).ItemString;
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
							


							if (resolveInfo.activityInfo.name.toLowerCase().equalsIgnoreCase("com.google.android.apps.docs.shareitem.UploadSharedItemActivity")||(resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.dropbox.android"))||(resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.android.email"))||(resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.google.android.gm"))) {
								Intent targetedShareIntent = new Intent(Intent.ACTION_SEND);
								targetedShareIntent.
								putExtra(Intent.EXTRA_STREAM,
										Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files",str)));

								targetedShareIntent.setType("text/xml");
								targetedShareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//								
								targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT,
										"Please find the attached conflict file");
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


			return rowView;
		}

		public List<Item> getList(){
			return list;
		}
	}

	public class ItemsListAdapter2 extends BaseAdapter {

		private Context context;
		private List<Item> list;

		ItemsListAdapter2(Context c, List<Item> l){
			context = c;
			list = l;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int paramInt, View convertView, ViewGroup parent) {
			View rowView = convertView;

			// reuse views
			if (rowView == null) {
				LayoutInflater inflater = ((Activity) context).getLayoutInflater();
				rowView = inflater.inflate(R.layout.device_file_list_item, null);

				ViewHolder viewHolder = new ViewHolder();
				//  viewHolder.icon = (ImageView) rowView.findViewById(R.id.rowImageView);
				viewHolder.View = (ImageView) rowView.findViewById(R.id.view);
				viewHolder.Delete = (ImageView) rowView.findViewById(R.id.delete);
				viewHolder.Share = (ImageView) rowView.findViewById(R.id.share);
				viewHolder.text = (TextView) rowView.findViewById(R.id.file_name);
				rowView.setTag(viewHolder); 
			}

			ViewHolder holder = (ViewHolder) rowView.getTag();
			holder.text.setText(list.get(paramInt).ItemString);
			holder.text.setTextColor(getResources().getColor(R.color.green));


			holder.View.setVisibility(View.VISIBLE);
			holder.View.setBackgroundResource(R.drawable.view);
			holder.View.setTag(paramInt);
			holder.View.setOnClickListener(new OnClickListener() {

				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View vv) {
					// TODO Auto-generated method stub
					popupWindow.dismiss();
					Heading.clear();
					Value.clear();
					int pos1 = (Integer) vv.getTag();
					//					Holder h1 = (Holder) list.get(pos1);
					File_name=list.get(pos1).ItemString;
					if(File_name.contains(".xlsx"))
					{
						List<String> resultSet = new ArrayList<String>();
						File inputWorkbook = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files/Close_Conflict", File_name);
						if(inputWorkbook.exists()){
							try 
							{

								// Get the workbook instance for XLSX file
								HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(inputWorkbook));

								// Get first sheet from the workbook
								HSSFSheet sheet = wb.getSheetAt(0);

								Row row;
								Cell cell;

								// Iterate through each rows from first sheet
								Iterator<Row> rowIterator = sheet.iterator();
								int j=0;
								int k=0;
								while (rowIterator.hasNext()) 
								{
									j++;
									row = rowIterator.next();

									// For each row, iterate through each columns
									Iterator<Cell> cellIterator = row.cellIterator();

									while (cellIterator.hasNext()) 
									{

										cell = cellIterator.next();
										if(k==0)
										{
											String str=cell.getStringCellValue();
											if(!str.equalsIgnoreCase("Title")||(str.equalsIgnoreCase("")))
											{
												Toast.makeText(getParent(), "It's not conflict file" , Toast.LENGTH_LONG).show();
												conflictfile=false;
												break;
											}
											else
											{
												conflictfile=true;
												k++;
											}
										}
										if(j==1)
										{
											Heading.add(cell.getStringCellValue());
										}
										else if(j==2)
										{
											switch (cell.getCellType()) 
											{


											case Cell.CELL_TYPE_NUMERIC:
												System.out.println(cell.getNumericCellValue());
												Value.add(""+cell.getNumericCellValue());
												break;

											case Cell.CELL_TYPE_STRING:
												System.out.println(cell.getStringCellValue());
												Value.add(cell.getStringCellValue());
												break;
											}
										}
									}
								}
							}
							catch (Exception e) 
							{
								try
								{
									XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(inputWorkbook));
									// Get first sheet from the workbook
									XSSFSheet sheet = workbook.getSheetAt(0);
									Cell cell;
									Row row;

									// Iterate through each rows from first sheet
									Iterator<Row> rowIterator = sheet.iterator();
									int j=0;
									int k=0;
									while (rowIterator.hasNext()) 
									{
										j++;
										row = rowIterator.next();

										// For each row, iterate through each columns
										Iterator<Cell> cellIterator = row.cellIterator();

										while (cellIterator.hasNext()) 
										{
											cell = cellIterator.next();

											if(k==0)
											{
												String str=cell.getStringCellValue();
												if(!str.equalsIgnoreCase("Title")||(str.equalsIgnoreCase("")))
												{
													Toast.makeText(getParent(), "It's not conflict file" , Toast.LENGTH_LONG).show();
													conflictfile=false;
													break;
												}
												else
												{
													conflictfile=true;
													k++;
												}
											}
											if(j==1)
											{
												Heading.add(cell.getStringCellValue());
											}
											else if(j==2)
											{
												switch (cell.getCellType()) 
												{


												case Cell.CELL_TYPE_NUMERIC:
													System.out.println(cell.getNumericCellValue());
													Value.add(""+cell.getNumericCellValue());
													break;

												case Cell.CELL_TYPE_STRING:
													System.out.println(cell.getStringCellValue());
													Value.add(cell.getStringCellValue());
													break;
												}
											}
										}
									}
								}
								catch(Exception e90)
								{
									System.err.println("Exception" + e.getMessage());
								}
								System.err.println("Exception :" + e.getMessage());
							}
							if(conflictfile)
							{
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putInt("file_open", 1);
								editor.putBoolean("ConflictSolve", true);
								editor.commit();
								HomeActivity.Title=DeviceFileList.Value.get(0);
								HomeActivity.Owner=DeviceFileList.Value.get(1);
								HomeActivity.Story=DeviceFileList.Value.get(2);
								HomeActivity.Objective_A=DeviceFileList.Value.get(3);
								HomeActivity.Need_B=DeviceFileList.Value.get(4);
								HomeActivity.Need_C=DeviceFileList.Value.get(5);
								HomeActivity.Want_D1=DeviceFileList.Value.get(6);
								HomeActivity.Want_D2=DeviceFileList.Value.get(7);
								HomeActivity.Why_A=DeviceFileList.Value.get(8);
								HomeActivity.A_B_Needed=DeviceFileList.Value.get(9);
								HomeActivity.A_C_Needed=DeviceFileList.Value.get(10);
								HomeActivity.B_D1_Needed=DeviceFileList.Value.get(11);
								HomeActivity.C_D2_Needed=DeviceFileList.Value.get(12);
								HomeActivity.D1_conflict_D2=DeviceFileList.Value.get(13);
								HomeActivity.Ideas_A=DeviceFileList.Value.get(20);
								HomeActivity.Ideas_AB=DeviceFileList.Value.get(21);
								HomeActivity.Ideas_AC=DeviceFileList.Value.get(22);
								HomeActivity.Ideas_BD1=DeviceFileList.Value.get(23);
								HomeActivity.Ideas_CD2=DeviceFileList.Value.get(24);
								HomeActivity.Ideas_D1D2=DeviceFileList.Value.get(25);
								HomeActivity.Injection=DeviceFileList.Value.get(26);

								HomeActivity.Objective_A2=DeviceFileList.Value.get(27);
								HomeActivity.Need_B2=DeviceFileList.Value.get(28);
								HomeActivity.Need_C2=DeviceFileList.Value.get(29);
								HomeActivity.Injection1=DeviceFileList.Value.get(30);
								HomeActivity.A2_B2_Needed=DeviceFileList.Value.get(31);
								HomeActivity.A2_C2_Needed=DeviceFileList.Value.get(32);
								HomeActivity.I_Exist_B_alsoExist=DeviceFileList.Value.get(33);
								HomeActivity.I_Exist_C_alsoexist=DeviceFileList.Value.get(34);

								boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
								if (tabletSize) {

									in.setClass(getParent(),TabPage1.class);
									home_services.push("page1",in);
								} 
								else
								{

									in.setClass(getParent(),Page1.class);
									home_services.push("page1"+TabStack.a,in);
								}
							}
						}
						else
						{
							AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

							alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>File not found..!</b></font>"));
							//							alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>File not found..!</font>"));
							alertDialog.setIcon(R.drawable.launchicon);
							alertDialog.setButton("Ok", new  DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
								}
							});


							alertDialog.show();


							resultSet.add("File not found..!");
						}
					}
					else
					{
						List<String> resultSet = new ArrayList<String>();
						File inputWorkbook = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files/Close_Conflict", File_name);
						if(inputWorkbook.exists()){
							try 
							{
								// Get the workbook instance for XLS file
								HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputWorkbook));
								// Get first sheet from the workbook
								HSSFSheet sheet = workbook.getSheetAt(0);
								Cell cell;
								Row row;

								// Iterate through each rows from first sheet
								Iterator<Row> rowIterator = sheet.iterator();
								int j=0;
								int k=0;
								while (rowIterator.hasNext()) 
								{
									j++;
									row = rowIterator.next();

									// For each row, iterate through each columns
									Iterator<Cell> cellIterator = row.cellIterator();

									while (cellIterator.hasNext()) 
									{
										cell = cellIterator.next();
										if(k==0)
										{
											String str=cell.getStringCellValue();
											if(!str.equalsIgnoreCase("Title"))
											{
												Toast.makeText(getParent(), "It's not conflict file" , Toast.LENGTH_LONG).show();
												conflictfile=false;
												break;
											}
											else
											{
												conflictfile=true;
												k++;
											}
										}
										if(j==1)
										{
											Heading.add(cell.getStringCellValue());
										}
										else if(j==2)
										{
											Value.add(cell.getStringCellValue());
										}

									}
								}

							} 

							catch (FileNotFoundException e) 
							{

								System.err.println("Exception" + e.getMessage());
							}
							catch (IOException e) 
							{

								System.err.println("Exception" + e.getMessage());
							}


							if(conflictfile)
							{
								SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putInt("file_open", 1);
								editor.putBoolean("ConflictSolve", true);
								editor.commit();
								HomeActivity.Title=DeviceFileList.Value.get(0);
								HomeActivity.Owner=DeviceFileList.Value.get(1);
								HomeActivity.Story=DeviceFileList.Value.get(2);
								HomeActivity.Objective_A=DeviceFileList.Value.get(3);
								HomeActivity.Need_B=DeviceFileList.Value.get(4);
								HomeActivity.Need_C=DeviceFileList.Value.get(5);
								HomeActivity.Want_D1=DeviceFileList.Value.get(6);
								HomeActivity.Want_D2=DeviceFileList.Value.get(7);
								HomeActivity.Why_A=DeviceFileList.Value.get(8);
								HomeActivity.A_B_Needed=DeviceFileList.Value.get(9);
								HomeActivity.A_C_Needed=DeviceFileList.Value.get(10);
								HomeActivity.B_D1_Needed=DeviceFileList.Value.get(11);
								HomeActivity.C_D2_Needed=DeviceFileList.Value.get(12);
								HomeActivity.D1_conflict_D2=DeviceFileList.Value.get(13);
								HomeActivity.Ideas_A=DeviceFileList.Value.get(20);
								HomeActivity.Ideas_AB=DeviceFileList.Value.get(21);
								HomeActivity.Ideas_AC=DeviceFileList.Value.get(22);
								HomeActivity.Ideas_BD1=DeviceFileList.Value.get(23);
								HomeActivity.Ideas_CD2=DeviceFileList.Value.get(24);
								HomeActivity.Ideas_D1D2=DeviceFileList.Value.get(25);
								HomeActivity.Injection=DeviceFileList.Value.get(26);

								HomeActivity.Objective_A2=DeviceFileList.Value.get(27);
								HomeActivity.Need_B2=DeviceFileList.Value.get(28);
								HomeActivity.Need_C2=DeviceFileList.Value.get(29);
								HomeActivity.Injection1=DeviceFileList.Value.get(30);
								HomeActivity.A2_B2_Needed=DeviceFileList.Value.get(31);
								HomeActivity.A2_C2_Needed=DeviceFileList.Value.get(32);
								HomeActivity.I_Exist_B_alsoExist=DeviceFileList.Value.get(33);
								HomeActivity.I_Exist_C_alsoexist=DeviceFileList.Value.get(34);

								boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
								if (tabletSize) {

									in.setClass(getParent(),TabPage1.class);
									home_services.push("page1",in);
								} 
								else
								{

									in.setClass(getParent(),Page1.class);
									home_services.push("page1"+TabStack.a,in);
								}
							}

						}
						else
						{
							AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();

							alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>File not found..!</b></font>"));
							//							alertDialog.setMessage(Html.fromHtml("<font color='#00478f'>File not found..!</font>"));
							alertDialog.setIcon(R.drawable.launchicon);
							alertDialog.setButton("Ok", new  DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
								}
							});


							alertDialog.show();

							resultSet.add("File not found..!");
						}
						if(resultSet.size()==0){
							resultSet.add("Data not found..!");
						}
					}
				}
			});
			holder.Delete.setTag(paramInt);
			holder.Delete.setOnClickListener(new OnClickListener() {

				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View vv) {
					// TODO Auto-generated method stub

					popupWindow.dismiss();
					del_pos = (Integer) vv.getTag();
					AlertDialog alertDialog = new AlertDialog.Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
					alertDialog.setTitle(Html.fromHtml("<font color='#00478f'><b>Delete the file</b></font>"));
					alertDialog.setMessage(Html.fromHtml("<font color='#00478f'><b>Are you sure you want to delete the conflict file?</b></font>"));
					alertDialog.setIcon(R.drawable.launchicon);
					alertDialog.setButton("Yes", new  DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub

							//					Holder h1 = (Holder) list.get(pos1);
							String str=list.get(del_pos).ItemString;
							File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files/Close_Conflict", str);
							boolean deleted = file.delete();

							final File sdCard = Environment.getExternalStorageDirectory();
							File dir = new File(sdCard.getAbsolutePath() + "/Conflict_Files");
							File[] filelist = dir.listFiles();
							String[] theNamesOfFiles = new String[filelist.length];
							for (int i = 0; i < theNamesOfFiles.length; i++) {
								theNamesOfFiles[i] = filelist[i].getName();
							}
							//listview.setAdapter(new MycustomAdapter(DeviceFileList.this,theNamesOfFiles));
							initItems();
							myItemsListAdapter2 = new ItemsListAdapter2(DeviceFileList.this, items2);

							//  myItemsListAdapter3 = new ItemsListAdapter(this, items3);
							listView2.setAdapter(myItemsListAdapter2);


						}
					});
					alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					});
					alertDialog.show();


				}
			});

			holder.Share.setTag(paramInt);
			holder.Share.setOnClickListener(new OnClickListener() {

				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					popupWindow.dismiss();
					int pos1 = (Integer) v.getTag();
					//					Holder h1 = (Holder) list.get(pos1);
					String str=list.get(pos1).ItemString;
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
							


							if (resolveInfo.activityInfo.name.toLowerCase().equalsIgnoreCase("com.google.android.apps.docs.shareitem.UploadSharedItemActivity")||(resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.dropbox.android"))||(resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.android.email"))||(resolveInfo.activityInfo.packageName.equalsIgnoreCase("com.google.android.gm"))) {
								Intent targetedShareIntent = new Intent(Intent.ACTION_SEND);
								targetedShareIntent.
								putExtra(Intent.EXTRA_STREAM,
										Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Files/Close_Conflict",str)));

								targetedShareIntent.setType("text/xml");
								targetedShareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
								targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT,
										"Please find the attached conflict file");
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



			return rowView;
		}

		public List<Item> getList(){
			return list;
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.btn_new:
		case R.id.rlnew:
			popupWindow.dismiss();
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
			boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
			if (tabletSize) {

				in.setClass(getParent(),TabPage1.class);
				home_services.push("n_page1"+TabStack.a,in);
			} 
			else
			{

				in.setClass(getParent(),Page1.class);
				home_services.push("n_page1"+TabStack.a,in);
			}

			break;
		case R.id.btn_open:
		case R.id.rlopen:
			break;
		case R.id.btn_close:
		case R.id.rlclose:
			popupWindow.dismiss();
			int stack_size=TabStack.stack.size();
			for(int i=1;i<stack_size;i++)
			{
				home_services.pop();	
			}
			break;
		case R.id.btn_drop:
			popupWindow.dismiss();
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
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			 editor = sharedpreferences.edit();
			editor.putInt("dropbox",1);
			editor.commit();
			in.setClass(getParent(),DropBoxFileList.class);
			home_services.push("dropbox"+TabStack.a,in);

			break;
		case R.id.btn_drive:
			popupWindow.dismiss();
			ConnectionDetector cd1 = new ConnectionDetector(getApplicationContext());
			if (!cd1.isConnectingToInternet()) {
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

			in.setClass(getParent(),GoogleDriveFileList.class);
			home_services.push("drive"+TabStack.a,in);

			break;
		case R.id.btn_device:

			break;

		}
	}
}

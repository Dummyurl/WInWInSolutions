package com.in.winwinsolutions;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxInputStream;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.android.AuthActivity;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.TokenPair;

public class DropBoxFileList extends Activity implements OnClickListener {
	Button btn_new_conflict,btn_open_conflict,btn_close_conflict,btn_Drop,btn_drive,btn_device;
	RelativeLayout Rl_open,Rl_new,Rl_close;
	//	TextView txtnew,txtopen,txtclose;
	TextView txtnew,txtopen,txtclose,txtnewconflict,txtopenconflict,txtcloseconflict;
	public static String File_name="";
	Intent in=new Intent();
	TabStack home_services;
	int stack_size;
	private DropboxAPI<AndroidAuthSession> mApi;
	private String DIR = "/";
	private ArrayList<Entry> files;
	private ArrayList<String> dir_path;
	private boolean isItemClicked = false;
	private ListView dropbox_list;
	private ProgressDialog pd;
	File inputWorkbook;
	List<String> resultSet;
	ImageView imgtitlehint,imgtitlehint2,devicefilehint,dropboxfilehint;
	PopupWindow popupWindow ;
	int a=0;
	TextView text;
	Boolean conflictfile;
	SharedPreferences sharedpreferences;
	Editor editor;
	int dropbox;
	TextView empty_message;
	public static final String MyPREFERENCES = "MyPrefs" ;
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				dropbox_list.setAdapter(new ProgressBar(getParent(),files));
				if(files.size()>0)
				{
					dropbox_list.setVisibility(View.VISIBLE);
					empty_message.setVisibility(View.GONE);
				}
				else
				{
					dropbox_list.setVisibility(View.GONE);
					empty_message.setVisibility(View.VISIBLE);
				}
				pd.dismiss();
			} else if (msg.what == 1) {
				fileread();
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drop_box_file_list);
		dropbox_list = (ListView) findViewById(R.id.dropbox_list);
		btn_Drop=(Button)findViewById(R.id.btn_drop);
		btn_device=(Button)findViewById(R.id.btn_device);
		btn_drive=(Button)findViewById(R.id.btn_drive);
		btn_new_conflict=(Button)findViewById(R.id.btn_new); 
		btn_close_conflict=(Button)findViewById(R.id.btn_close); 
		btn_open_conflict=(Button)findViewById(R.id.btn_open); 
		empty_message=(TextView)findViewById(R.id.empty_message);
		Rl_new=(RelativeLayout)findViewById(R.id.rlnew);
		Rl_open=(RelativeLayout)findViewById(R.id.rlopen);
		Rl_close=(RelativeLayout)findViewById(R.id.rlclose);

		devicefilehint=(ImageView)findViewById(R.id.devicefilehint);
		dropboxfilehint=(ImageView)findViewById(R.id.dropboxfilehint);
		AndroidAuthSession session = buildSession();
		mApi = new DropboxAPI<AndroidAuthSession>(session);

		checkAppKeySetup();
		// setLoggedIn(false);
		if (!Constants.mLoggedIn)
			mApi.getSession().startAuthentication(getParent());
		home_services=(TabStack)getParent();
		btn_open_conflict.setSelected(true);
		btn_Drop.setSelected(true);
		btn_device.setSelected(false);
		btn_drive.setSelected(false);
		
		Tabs.btn_home.setTextColor(getResources().getColor(R.color.color_name2));
		Tabs.btn_faq.setTextColor(getResources().getColor(R.color.color_name2));
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


		btn_new_conflict.setOnClickListener(this); 
		btn_open_conflict.setOnClickListener(this); 
		btn_close_conflict.setOnClickListener(this); 
		Rl_open.setOnClickListener(this); 
		Rl_new.setOnClickListener(this); 
		Rl_close.setOnClickListener(this); 

		btn_Drop.setOnClickListener(this);
		btn_drive.setOnClickListener(this);
		btn_device.setOnClickListener(this);
		LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
		View popupView = layoutInflater.inflate(R.layout.textview_hint, null);  
		popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
		text=(TextView)popupView.findViewById(R.id.popuptext);
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
	}


	private void checkAppKeySetup() {
		if (Constants.DROPBOX_APP_KEY.startsWith("CHANGE")
				|| Constants.DROPBOX_APP_SECRET.startsWith("CHANGE")) {
			showToast("You must apply for an app key and secret from developers.dropbox.com, and add them to the DBRoulette ap before trying it.");
			finish();
			return;
		}
		Intent testIntent = new Intent(Intent.ACTION_VIEW);
		String scheme = "db-" + Constants.DROPBOX_APP_KEY;
		String uri = scheme + "://" + AuthActivity.AUTH_VERSION + "/test";
		testIntent.setData(Uri.parse(uri));
		PackageManager pm = getPackageManager();
		if (0 == pm.queryIntentActivities(testIntent, 0).size()) {
			showToast("URL scheme in your app's "
					+ "manifest is not set up correctly. You should have a "
					+ "com.dropbox.client2.android.AuthActivity with the "
					+ "scheme: " + scheme);
			finish();
		}
	}

	private void showToast(String msg) {
		Toast error = Toast.makeText(getParent(), msg, Toast.LENGTH_LONG);
		error.show();
	}

	private AndroidAuthSession buildSession() {
		AppKeyPair appKeyPair = new AppKeyPair(Constants.DROPBOX_APP_KEY,
				Constants.DROPBOX_APP_SECRET);
		AndroidAuthSession session;

		String[] stored = getKeys();
		if (stored != null) {
			AccessTokenPair accessToken = new AccessTokenPair(stored[0],
					stored[1]);
			session = new AndroidAuthSession(appKeyPair, Constants.ACCESS_TYPE,
					accessToken);
		} else {
			session = new AndroidAuthSession(appKeyPair, Constants.ACCESS_TYPE);
		}

		return session;
	}

	public void setLoggedIn(final boolean loggedIn) {
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		dropbox = sharedpreferences.getInt("dropbox", 0);


		if(dropbox==1)
		{
			pd = ProgressDialog.show(getParent(), null,
					"Retrieving data...");
			new Thread(new Runnable() {

				@Override
				public void run() {
					Constants.mLoggedIn = loggedIn;
					if (loggedIn) {
						int i = 0;
						com.dropbox.client2.DropboxAPI.Entry dirent;


						try {
							dirent = mApi.metadata(DIR, 1000, null, true, null);
							
							files = new ArrayList<com.dropbox.client2.DropboxAPI.Entry>();
							dir_path = new ArrayList<String>();
						
							for (com.dropbox.client2.DropboxAPI.Entry ent : dirent.contents) {

								String str=ent.path;
								if((str.contains("_conflict"))||(str.contains("_Conflict")))
								{
									if(str.contains(".xls"))
									{
										files.add(ent);
										dir_path.add(new String(files.get(i++).path));	
									}

								}

							}
							i = 0;
							mHandler.sendEmptyMessage(0);
						} catch (DropboxException e) {
							e.printStackTrace();
						}

					}
				}
			}).start();	
		}
		else
		{

		}
	}

	@Override
	protected void onResume() {

		super.onResume();
		AndroidAuthSession session = mApi.getSession();

		if (session.authenticationSuccessful()) {
			try {
				session.finishAuthentication();



				TokenPair tokens = session.getAccessTokenPair();
				storeKeys(tokens.key, tokens.secret);
				setLoggedIn(true);
			} catch (IllegalStateException e) {
				showToast("Couldn't authenticate with Dropbox:"
						+ e.getLocalizedMessage());
			}
		}
	}

	private void storeKeys(String key, String secret) {
		SharedPreferences prefs = getSharedPreferences(
				Constants.ACCOUNT_PREFS_NAME, 0);
		Editor edit = prefs.edit();
		edit.putString(Constants.ACCESS_KEY_NAME, key);
		edit.putString(Constants.ACCESS_SECRET_NAME, secret);
		edit.commit();
	}


	private String[] getKeys() {
		SharedPreferences prefs = getSharedPreferences(
				Constants.ACCOUNT_PREFS_NAME, 0);
		String key = prefs.getString(Constants.ACCESS_KEY_NAME, null);
		String secret = prefs.getString(Constants.ACCESS_SECRET_NAME, null);
		if (key != null && secret != null) {
			String[] ret = new String[2];
			ret[0] = key;
			ret[1] = secret;
			return ret;
		} else {
			return null;
		}
	}

	private boolean downloadDropboxFile(Entry fileSelected) {// , String
		// localFilePath)
		// {
		File dir = new File(Utils.getPath());
		if (!dir.exists())
			dir.mkdirs();
		try {
			File localFile = new File(dir + "/" + fileSelected.fileName());
			if (!localFile.exists()) {
				localFile.createNewFile();
				copy(fileSelected, localFile);

			} else {
				showFileExitsDialog(fileSelected, localFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}



	private void copy(final Entry fileSelected, final File localFile) {
		final ProgressDialog pd = ProgressDialog.show(getParent(),
				"Downloading...", "Please wait...");
		new Thread(new Runnable() {

			@Override
			public void run() {
				BufferedInputStream br = null;
				BufferedOutputStream bw = null;
				DropboxInputStream fd;
				try {
					fd = mApi.getFileStream(fileSelected.path,
							localFile.getPath());
					br = new BufferedInputStream(fd);
					bw = new BufferedOutputStream(new FileOutputStream(
							localFile));

					byte[] buffer = new byte[4096];
					int read;
					while (true) {
						read = br.read(buffer);
						if (read <= 0) {
							break;
						}
						bw.write(buffer, 0, read);
					}
					pd.dismiss();

					Message message = new Message();
					message.obj = localFile.getAbsolutePath();
					message.what = 1;
					mHandler.sendMessage(message);

				} catch (DropboxException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (bw != null) {
						try {
							bw.close();
							if (br != null) {
								br.close();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}

			}
		}).start();

	}

	private void showFileExitsDialog(final Entry fileSelected,
			final File localFile) {
		Builder alertBuilder = new Builder(getParent());
		alertBuilder.setMessage(Constants.OVERRIDEMSG);
		alertBuilder.setPositiveButton("Ok",
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				copy(fileSelected, localFile);
			}
		});
		alertBuilder.setNegativeButton("Cancel", null);
		alertBuilder.create().show();

	}

	@Override
	public void onBackPressed() {
		popupWindow.dismiss();
		if (isItemClicked) {
			if (DIR.length() == 0) {
				// logOut();
				setResult(RESULT_OK);
				super.onBackPressed();
			} else {
				DIR = DIR.substring(0, DIR.lastIndexOf('/'));
				setLoggedIn(true);

			}
		} else {
			setResult(RESULT_OK);
			super.onBackPressed();
		}

	}
	public class ProgressBar extends BaseAdapter {

		// private Context context;
		private ArrayList<Entry> files;
		private View view;
		private LayoutInflater lInflater;

		public ProgressBar(Context context, ArrayList<Entry> files) {
			// this.context = context;
			this.files = files;
			lInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return files.size();
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		private class Holder {
			ImageView ivImageFolderOrFile, ivImageDownloadOrBrowableDir;
			TextView tvDownloadFileOrFolderName;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final Holder holder;
			view = convertView;
			if (view == null) {
				holder = new Holder();
				view = lInflater.inflate(R.layout.drop_box_file_list_item, null);
				holder.ivImageDownloadOrBrowableDir = (ImageView) view
						.findViewById(R.id.ivImageDownloadOrBrowableDir);
				holder.ivImageFolderOrFile = (ImageView) view
						.findViewById(R.id.ivImageFolderOrFile);
				holder.tvDownloadFileOrFolderName = (TextView) view
						.findViewById(R.id.tvDownloadFileFileName);
				view.setTag(holder);
			} else {
				holder = (Holder) view.getTag();
			}
			final Entry file = files.get(position);
			if (!file.isDir) {
				holder.ivImageDownloadOrBrowableDir
				.setImageResource(R.drawable.viewandedit);
				holder.ivImageFolderOrFile.setImageResource(R.drawable.fileicon);
			} else {
				holder.ivImageDownloadOrBrowableDir
				.setImageResource(R.drawable.browsedirectoryicon);
				holder.ivImageFolderOrFile
				.setImageResource(R.drawable.dropboxdiricon);
			}
			holder.tvDownloadFileOrFolderName.setText(file.fileName());

			holder.ivImageDownloadOrBrowableDir.setTag(position);
			holder.ivImageDownloadOrBrowableDir.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View vv) {
					// TODO Auto-generated method stub
					popupWindow.dismiss();
					DeviceFileList.Heading.clear();
					DeviceFileList.Value.clear();
					int pos1 = (Integer) vv.getTag();
					//					Holder h1 = (Holder) list.get(pos1);
					File dir = new File(Utils.getPath());
					if (!dir.exists())
						dir.mkdirs();

					inputWorkbook = new File(dir + "/" + file.fileName());
					File_name=file.fileName();
					DeviceFileList.File_name=File_name;

					//					Entry str=files.get(pos1);
					//					//File_name=str;
					resultSet=new ArrayList<String>();

					Entry fileSelected = files.get(pos1);
					if (fileSelected.isDir) {
						isItemClicked = true;
						DIR = dir_path.get(pos1);
						setLoggedIn(true);
					} else {
						if(inputWorkbook.toString().contains(".xls"))
						{
							//							String str=list[del_pos];
							File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox", File_name);
							boolean deleted = file.delete();






							downloadDropboxFile(fileSelected);
						}
					}
					if(resultSet.size()==0){
						resultSet.add("Data not found..!");
					}
				}
			});



			return view;
		}

	}
	@SuppressWarnings("deprecation")
	public void fileread()
	{
		editor = sharedpreferences.edit();
		editor.putInt("dropbox",0);
		editor.commit();
				if(File_name.contains(".xlsx"))
				{
					List<String> resultSet = new ArrayList<String>();
					File inputWorkbook = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox", File_name);

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
									if(!str.equalsIgnoreCase("Title"))
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
									DeviceFileList.Heading.add(cell.getStringCellValue());
								}
								else if(j==2)
								{
									switch (cell.getCellType()) 
									{


									case Cell.CELL_TYPE_NUMERIC:
										System.out.println(cell.getNumericCellValue());
										DeviceFileList.Value.add(""+cell.getNumericCellValue());
										break;

									case Cell.CELL_TYPE_STRING:
										System.out.println(cell.getStringCellValue());
										DeviceFileList.Value.add(cell.getStringCellValue());
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
										DeviceFileList.Heading.add(cell.getStringCellValue());
									}
									else if(j==2)
									{
										switch (cell.getCellType()) 
										{


										case Cell.CELL_TYPE_NUMERIC:
											System.out.println(cell.getNumericCellValue());
											DeviceFileList.Value.add(""+cell.getNumericCellValue());
											break;

										case Cell.CELL_TYPE_STRING:
											System.out.println(cell.getStringCellValue());
											DeviceFileList.Value.add(cell.getStringCellValue());
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
						Editor editor = sp.edit();
						editor.putInt("file_open", 1);
						editor.putBoolean("ConflictSolve", false);
						editor.putBoolean("dropbox_file",true);
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
						HomeActivity.Why_A=DeviceFileList.Value.get(14);
						HomeActivity.A_B_Needed=DeviceFileList.Value.get(15);
						HomeActivity.A_C_Needed=DeviceFileList.Value.get(16);
						HomeActivity.B_D1_Needed=DeviceFileList.Value.get(17);
						HomeActivity.C_D2_Needed=DeviceFileList.Value.get(18);
						HomeActivity.D1_conflict_D2=DeviceFileList.Value.get(19);
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
//						HomeActivity.conflictsolved=DeviceFileList.Value.get(35);
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
					List<String> resultSet = new ArrayList<String>();
					File inputWorkbook = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Conflict_Dropbox", File_name);
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
										DeviceFileList.Heading.add(cell.getStringCellValue());
									}
									else if(j==2)
									{
										switch (cell.getCellType()) 
										{


										case Cell.CELL_TYPE_NUMERIC:
											System.out.println(cell.getNumericCellValue());
											DeviceFileList.Value.add(""+cell.getNumericCellValue());
											break;

										case Cell.CELL_TYPE_STRING:
											System.out.println(cell.getStringCellValue());
											DeviceFileList.Value.add(cell.getStringCellValue());
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
							Editor editor = sp.edit();
							editor.putInt("file_open", 1);
							editor.putBoolean("ConflictSolve", false);
							editor.putBoolean("dropbox_file",true);
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
							HomeActivity.Why_A=DeviceFileList.Value.get(14);
							HomeActivity.A_B_Needed=DeviceFileList.Value.get(15);
							HomeActivity.A_C_Needed=DeviceFileList.Value.get(16);
							HomeActivity.B_D1_Needed=DeviceFileList.Value.get(17);
							HomeActivity.C_D2_Needed=DeviceFileList.Value.get(18);
							HomeActivity.D1_conflict_D2=DeviceFileList.Value.get(19);
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
//							HomeActivity.conflictsolved=DeviceFileList.Value.get(35);
							
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
						resultSet.add("File not found..!");
					}
					if(resultSet.size()==0){
						resultSet.add("Data not found..!");
					}
				}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_new:
		case R.id.rlnew:
			popupWindow.dismiss();
			SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
			Editor editor = sp.edit();
			editor.putInt("file_open", 0);
			editor.putInt("dropbox",0);
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
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			editor = sharedpreferences.edit();
			editor.putInt("dropbox",0);
			editor.commit();
			int stack_size=TabStack.stack.size();
			for(int i=1;i<stack_size;i++)
			{
				home_services.pop();	
			}
			break;
		case R.id.btn_drop:


			break;
		case R.id.btn_drive:
			popupWindow.dismiss();
			ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
			if (!cd.isConnectingToInternet()) {
				AlertDialog alertDialog = new Builder(getParent(),AlertDialog.THEME_HOLO_LIGHT).create();
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
			popupWindow.dismiss();
			sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			editor = sharedpreferences.edit();
			editor.putInt("dropbox",0);
			editor.commit();
			in.setClass(getParent(),DeviceFileList.class);
			home_services.push("device"+TabStack.a,in);
			break;

		}
	}
}

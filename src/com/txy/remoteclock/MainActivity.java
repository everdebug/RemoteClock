package com.txy.remoteclock;

import com.txy.remoteclock_setting.SettingMain;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView tv_info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_info = (TextView) findViewById(R.id.tv_info);
		setTextInfo();

	}

	private void setTextInfo() {
		SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
		String number = sp.getString("number", "");
		String code = sp.getString("bindingcode", "");
		String toTAtext = sp.getString("toTAtext", "");
		if (!TextUtils.isEmpty(number) && !TextUtils.isEmpty(code)&&!TextUtils.isEmpty(toTAtext)) {
			tv_info.setText("number��" + number + "\r\ncode��" + code
					+ "\r\n��TA������:" + toTAtext);
		} else {
			tv_info.setText("��Щ����û������Ŷ~��ȥ���������ð�~");
		}
	}

	public void startService(View view) {
		Toast.makeText(this, "��������", 0).show();
	}

	// ��ת�����ý���
	public void goSetting(View view) {
		Intent intent = new Intent(this, SettingMain.class);
		startActivity(intent);
	}

	@Override
	protected void onResume() {
		setTextInfo();
		super.onResume();
	}
}

package com.txy.remoteclock_setting;

import com.txy.remoteclock.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//手机号和绑定码的设置界面
public class NumberSetting extends Activity {
	private EditText et_setting_number, et_setting_code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.number_setting);

		ActionBar actionBar = this.getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP,
				ActionBar.DISPLAY_HOME_AS_UP);

		et_setting_number = (EditText) findViewById(R.id.et_setting_number);
		et_setting_code = (EditText) findViewById(R.id.et_setting_code);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// 当ActionBar图标被点击时调用
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// 点击即返回上层并返回设置的数据
	public void returndata(View view) {
		String number = et_setting_number.getText().toString();
		String code = et_setting_code.getText().toString();
		if (!TextUtils.isEmpty(number) && !TextUtils.isEmpty(code)) {
			String smsinfo = "123654789+aas1sa";
			Intent data = new Intent();
			data.putExtra("number", number);
			data.putExtra("code", code);
			// 设置数据
			setResult(0, data);// 设置返回码及返回的意图（意图用来传送数据）
			finish();
		} else {
			Toast.makeText(NumberSetting.this, "请输入正确的手机号和绑定码", 0).show();
			return;
		}
	}
}

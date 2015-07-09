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

//�ֻ��źͰ�������ý���
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
			// ��ActionBarͼ�걻���ʱ����
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// ����������ϲ㲢�������õ�����
	public void returndata(View view) {
		String number = et_setting_number.getText().toString();
		String code = et_setting_code.getText().toString();
		if (!TextUtils.isEmpty(number) && !TextUtils.isEmpty(code)) {
			String smsinfo = "123654789+aas1sa";
			Intent data = new Intent();
			data.putExtra("number", number);
			data.putExtra("code", code);
			// ��������
			setResult(0, data);// ���÷����뼰���ص���ͼ����ͼ�����������ݣ�
			finish();
		} else {
			Toast.makeText(NumberSetting.this, "��������ȷ���ֻ��źͰ���", 0).show();
			return;
		}
	}
}

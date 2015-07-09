package com.txy.remoteclock_setting;

import com.txy.remoteclock.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TextSetting extends Activity {

	private EditText et_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_setting);

		et_text = (EditText) findViewById(R.id.tv_clock_txet_to_other);
	}

	public void returnText(View view) {
		String text = et_text.getText().toString();
		if (!TextUtils.isEmpty(text)) {
			Intent data = new Intent();
			data.putExtra("text", text);
			// 设置数据
			setResult(1, data);// 设置返回码及返回的意图（意图用来传送数据）
			finish();
		} else {
			Toast.makeText(TextSetting.this, "请输入提醒文本", 0).show();
			return;
		}
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
}

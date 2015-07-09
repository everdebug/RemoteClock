package com.txy.remoteclock_setting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.txy.remoteclock.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class SettingMain extends Activity {

	private ListView lv_setting;
	// 设置选项的集合
	private List<Map<String, Object>> settings;

	// 不同设置返回的requestcode
	private final static int NUMBERANDCODE = 0;
	private final static int TEXT = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		// 在actionbar上面添加返回上级箭头
		ActionBar actionBar = this.getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP,
				ActionBar.DISPLAY_HOME_AS_UP);
		// listview中添加数据 （适配器后期会改成MyAdpter）
		adddate();
		lv_setting = (ListView) findViewById(R.id.lv_setting);
		lv_setting.setAdapter(new SimpleAdapter(this, settings,
				R.layout.setting_item, new String[] { "name", "image" },
				new int[] { R.id.tv_setting_name, R.id.iv_setting_icon }));
		// 每一个选项添加监听器
		lv_setting.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String name = (String) settings.get(position).get("name");
				if (name.equals("手机号绑定")) {
					// 设置手机号和绑定码
					Toast.makeText(SettingMain.this, "手机号绑定", 0).show();
					Intent intent = new Intent(SettingMain.this,
							NumberSetting.class);
					startActivityForResult(intent, NUMBERANDCODE);
				} else if (name.equals("设置叫醒铃声")) {
					// 设置铃声
					Toast.makeText(SettingMain.this, "设置叫醒铃声", 0).show();
				} else if (name.equals("设置叫醒文字")) {
					// 设置文字
					Toast.makeText(SettingMain.this, "设置叫醒文字", 0).show();
					Intent intent = new Intent(SettingMain.this,
							TextSetting.class);
					startActivityForResult(intent, TEXT);
				}

			}
		});

	}

	// 当actionbar的返回键被点击结束此activity
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

	// 得到返回的各个设置参数
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data != null) {
			switch (requestCode) {
			case NUMBERANDCODE:
				String number = data.getStringExtra("number");
				String code = data.getStringExtra("code");
				// 写入sp中
				SettingUtils.saveNumber(this, number, code);
				Toast.makeText(SettingMain.this,
						"手机号:" + number + "    绑定码:" + code, 0).show();
				break;
			case TEXT:
				String text = data.getStringExtra("text");
				// 写入sp中
				SettingUtils.saveText(this, text);
				Toast.makeText(SettingMain.this, "提醒信息:" + text, 0).show();
				break;

			default:
				break;
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	// 添加数据（后期写到信息配置中）
	private void adddate() {
		settings = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "手机号绑定");
		map1.put("image", R.drawable.phonebind);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "设置叫醒铃声");
		map3.put("image", R.drawable.custommusic);

		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("name", "设置叫醒文字");
		map4.put("image", R.drawable.customtext);

		settings.add(map1);
		settings.add(map3);
		settings.add(map4);
	}

}

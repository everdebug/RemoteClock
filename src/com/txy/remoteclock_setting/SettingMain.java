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
	// ����ѡ��ļ���
	private List<Map<String, Object>> settings;

	// ��ͬ���÷��ص�requestcode
	private final static int NUMBERANDCODE = 0;
	private final static int TEXT = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		// ��actionbar������ӷ����ϼ���ͷ
		ActionBar actionBar = this.getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP,
				ActionBar.DISPLAY_HOME_AS_UP);
		// listview��������� �����������ڻ�ĳ�MyAdpter��
		adddate();
		lv_setting = (ListView) findViewById(R.id.lv_setting);
		lv_setting.setAdapter(new SimpleAdapter(this, settings,
				R.layout.setting_item, new String[] { "name", "image" },
				new int[] { R.id.tv_setting_name, R.id.iv_setting_icon }));
		// ÿһ��ѡ����Ӽ�����
		lv_setting.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String name = (String) settings.get(position).get("name");
				if (name.equals("�ֻ��Ű�")) {
					// �����ֻ��źͰ���
					Toast.makeText(SettingMain.this, "�ֻ��Ű�", 0).show();
					Intent intent = new Intent(SettingMain.this,
							NumberSetting.class);
					startActivityForResult(intent, NUMBERANDCODE);
				} else if (name.equals("���ý�������")) {
					// ��������
					Toast.makeText(SettingMain.this, "���ý�������", 0).show();
				} else if (name.equals("���ý�������")) {
					// ��������
					Toast.makeText(SettingMain.this, "���ý�������", 0).show();
					Intent intent = new Intent(SettingMain.this,
							TextSetting.class);
					startActivityForResult(intent, TEXT);
				}

			}
		});

	}

	// ��actionbar�ķ��ؼ������������activity
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

	// �õ����صĸ������ò���
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data != null) {
			switch (requestCode) {
			case NUMBERANDCODE:
				String number = data.getStringExtra("number");
				String code = data.getStringExtra("code");
				// д��sp��
				SettingUtils.saveNumber(this, number, code);
				Toast.makeText(SettingMain.this,
						"�ֻ���:" + number + "    ����:" + code, 0).show();
				break;
			case TEXT:
				String text = data.getStringExtra("text");
				// д��sp��
				SettingUtils.saveText(this, text);
				Toast.makeText(SettingMain.this, "������Ϣ:" + text, 0).show();
				break;

			default:
				break;
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	// ������ݣ�����д����Ϣ�����У�
	private void adddate() {
		settings = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "�ֻ��Ű�");
		map1.put("image", R.drawable.phonebind);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "���ý�������");
		map3.put("image", R.drawable.custommusic);

		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("name", "���ý�������");
		map4.put("image", R.drawable.customtext);

		settings.add(map1);
		settings.add(map3);
		settings.add(map4);
	}

}

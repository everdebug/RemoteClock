package com.txy.remoteclock_setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
/**
 * @ 存储各种设置数据
 * */
public class SettingUtils {
	
	/**
	 * @ 保存number和code
	 * */
	public static boolean saveNumber(Context context,String number,String bindingcode) {
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);
		// 得到一个sp的编辑器
				Editor editor = sp.edit();
				editor.putString("number", number);
				editor.putString("bindingcode", bindingcode);
				// 使用edit，必须使用commit进行提交，文件才能保存。
				// 类似数据库的事务，保证数据同时提交成功
				editor.commit();
		return true;
	}
	/**
	 * @ 保存text
	 * */
	public static boolean saveText(Context context,String text) {
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);
		// 得到一个sp的编辑器
		Editor editor = sp.edit();
		editor.putString("toTAtext", text);
		// 使用edit，必须使用commit进行提交，文件才能保存。
		// 类似数据库的事务，保证数据同时提交成功
		editor.commit();
		return true;
	}
}

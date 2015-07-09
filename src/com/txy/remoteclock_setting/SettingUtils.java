package com.txy.remoteclock_setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
/**
 * @ �洢������������
 * */
public class SettingUtils {
	
	/**
	 * @ ����number��code
	 * */
	public static boolean saveNumber(Context context,String number,String bindingcode) {
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);
		// �õ�һ��sp�ı༭��
				Editor editor = sp.edit();
				editor.putString("number", number);
				editor.putString("bindingcode", bindingcode);
				// ʹ��edit������ʹ��commit�����ύ���ļ����ܱ��档
				// �������ݿ�����񣬱�֤����ͬʱ�ύ�ɹ�
				editor.commit();
		return true;
	}
	/**
	 * @ ����text
	 * */
	public static boolean saveText(Context context,String text) {
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);
		// �õ�һ��sp�ı༭��
		Editor editor = sp.edit();
		editor.putString("toTAtext", text);
		// ʹ��edit������ʹ��commit�����ύ���ļ����ܱ��档
		// �������ݿ�����񣬱�֤����ͬʱ�ύ�ɹ�
		editor.commit();
		return true;
	}
}

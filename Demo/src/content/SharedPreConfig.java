package content;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreConfig {
	/**
	 * SharedPreferences ���ݻ�ȡ.
	 */
	public static SharedPreConfig sharedPreConfig;
	SharedPreferences sp;

	public static SharedPreConfig getInstance() {
		if (sharedPreConfig == null) {
			sharedPreConfig = new SharedPreConfig();
		}
		return sharedPreConfig;
	}

	/**
	 * ��ȡ��Ӧ������ by key.
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public String getValueByKey(Context context, String key) {
		String value = "";
		sp = context.getSharedPreferences(IContent.FILE_SHAREPRE,
				context.MODE_PRIVATE);
		value = sp.getString(key, "");
		return value;
	}

	public void setValueByKey(Context context, String key, String value,
			String fileName) {
		sp = context.getSharedPreferences(fileName, context.MODE_PRIVATE);
		SharedPreferences.Editor ed = sp.edit();
		ed.putString(key, value);
		ed.commit();
	}

	// ����洢��Ϣ
	public void clear(Context context, String fileName) {
		sp = context.getSharedPreferences(fileName, context.MODE_PRIVATE);
		SharedPreferences.Editor ed = sp.edit();
		ed.clear();
		ed.commit();
	}
}

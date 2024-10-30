package busiframe.system.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 情報配列汎用クラス<br>
 * @since 2024/10/24
 * @version 1.00 新規作成
 */
public class DataCollection {

	/** 項目名リスト */
	private List<Map<String, String>> nameList = new ArrayList<>();
	/** データリスト */
	private List<List<Object>> dataList = new ArrayList<>();
	
	/**
	 * 項目名と属性をリスト化する<br>
	 * @since 2024/10/25
	 * @param names 項目名+":"+属性
	 */
	public void setItemInfomation(String...names ) {
		nameList.clear();
		dataList.clear();
		for(int ix = 0; ix < names.length; ix++) {
			String data = names[ix];
			Map<String, String> map = new HashMap<>();
			map.put("name", data.split(":")[0]);
			map.put("type", data.split(":")[1]);
			nameList.add(map);
		}
	}

	/**
	 * 情報をリストに追加する。<br>
	 * @param objects データ
	 */
	public void addData(Object...objects) {
		List<Object> data = new ArrayList<>();
		for(int ix = 0; ix < objects.length; ix++) {
			data.add(objects[ix]);
		}
		dataList.add(data);
	}

	/**
	 * 指定されたリスト番号に対する項目の属性を取得する。<br>
	 * @since 2024/10/25
	 * @param ix 項目位置
	 * @return 項目属性
	 */
	public String getitemType(int ix) {
		Map<String, String> item = nameList.get(ix);
		return item.get("type");
	}

	public List<List<Object>> getDataList() {
		return dataList;
	}

}

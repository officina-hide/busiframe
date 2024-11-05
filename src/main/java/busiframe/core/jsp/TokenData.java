package busiframe.core.jsp;

import java.util.HashMap;
import java.util.Map;

/**
 * HTML・JSPトークンクラス<br>
 * name - トークン名
 * param - トークン内のパラメータ  - Key : Value (複数件あり、Valueが無い場合もある。)
 * TODO 本クラスは試行レベルの為、変更等が行われる可能性があります。 2024/11/05
 * @since 2024/11/05
 * @version 1.00 新規作成
 */
public class TokenData implements I_BaseCharacter {

	/** トークン名 */
	private String name;
	/** パラメータリスト */
	private Map<String, Object> plist = new HashMap<String,Object>();
	
	/**
	 * パラメーター追加
	 * @param key Key
	 * @param value 文字列情報
	 */
	protected void addParameter(String key, Object value) {
		plist.put(key, value);
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Object> getPlist() {
		if(plist == null) {
			plist = new HashMap<String, Object>();
		}
		return plist;
	}
	
}

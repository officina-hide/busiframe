package busiframe.core.dao;

/**
 * 参照用インターフェースクラス<br>
 * 参照情報に関連する各種定数当の定義を行う。<br>
 * @since 2025/01/15
 * @version 1.00 新規作成
 */
public interface I_BaseReference {

	/** 項目属性 */
	public final String R_STRING = "string";
	public final String R_TEXT = "test";	//複数行 Addition 2025/02/03
	public final String R_DATE = "date";		//日付 Addition 2025/03/24
	public final String R_INT = "int";		//整数 Addition 2025/03/26
	public final String R_NUMBER = "number";	//数値 Addition 2025/03/28
}

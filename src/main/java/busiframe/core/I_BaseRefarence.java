package busiframe.core;

/**
 * 参照情報インターフェースクラス<br>
 * @since 2024/11/12
 * @version 1.00 新規作成
 */
public interface I_BaseRefarence {

	// 属性定数
	/** 数値 : INT */
	public final String R_INT = "int";
	/** 文字列 : STRING */
	public final String R_VARCHAR = "varchar";
	
	// SQL
	/** Primary Key */
	public final String S_PRIMARY_KEY = "PRIMARY KEY";
	/** Not Null */
	public final String R_NOT_NULL = "NOT NULL";
	/** コメント */
	public final String S_COMMENT = "COMMENT";
}

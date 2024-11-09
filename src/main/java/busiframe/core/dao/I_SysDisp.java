package busiframe.core.dao;

/**
 * 表示情報インターフェースクラス<br>
 * @since 2024/11/07
 * @version 1.00 新規作成
 */
public interface I_SysDisp {

	// 基本情報
	/** テーブル名 */
	public final String TABLE_NAME = "sys_disp";
	
	// テーブル項目
	/** 表示情報ID */
	public final String COLUMN_NAME_DISP_ID = "disp_id";
	/** 表示識別コード */
	public final String COLUMN_NAME_DISP_CD = "disp_cd";
	
	// SQL関連
	/** 抽出 : 表示識別コード */
	public final String SQL_LOAD_BY_CODE = 
			"SELECT * FROM " + TABLE_NAME + " "
			+ "WHERE " + COLUMN_NAME_DISP_CD + " = ? ";
}

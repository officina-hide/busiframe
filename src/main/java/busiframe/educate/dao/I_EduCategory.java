package busiframe.educate.dao;

import busiframe.core.tools.BaseCharacter;

/**
 * 教育カテゴリー情報インターフェースクラス<br>
 * @since 2024/12/14
 * @version 1.00 新規作成
 */
public interface I_EduCategory extends BaseCharacter {
	
	// テーブル関連
	public final String TABLE_NAME_EDU_CATEGORY = "edu_category";
	public final String TABLE_COMMENT_EDU_CATEGORY = "教育カテゴリー情報 Lv.01";

	// テーブル項目
	/** 教育カテゴリー情報ID */
	public final String COL_NAME_CATEGORY_ID = "category_id";
	public final String COL_COMMENT_CATEGORY_ID = "教育カテゴリー情報ID";
	/** 教育カテゴリー識別コード */
	public final String COL_NAME_CATEGORY_CD = "category_cd";
	public final String COL_COMMENT_CATEGORY_CD = "教育カテゴリー識別コード";
	public final String COL_DESCRIPTION_CATEGORY_CD = "教育用システムのカテゴリーを一意で識別する為のコード。";
	public final String COL_ALTER_CATEGORY_CD = "ALTER TABLE" + SP + TABLE_NAME_EDU_CATEGORY + SP
			+ "ADD" + SP + COL_NAME_CATEGORY_CD + SP + "VARCHAR(100) NOT NULL UNIQUE" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_CATEGORY_CD + SQ + SP;
	/** 教育カテゴリー名 */
	public final String COL_NAME_CATEGORY_NAME = "category_name";
	public final String COL_COMMENT_CATEGORY_NAME = "教育カテゴリー名";
	public final String COL_DESCRIPTION_CATEGORY_NAME = "教育システムのカテゴリーの名称";
	public final String COL_ALTER_CATEGORY_NAME = "ALTER TABLE" + SP + TABLE_NAME_EDU_CATEGORY + SP
			+ "ADD" + SP + COL_NAME_CATEGORY_NAME + SP + "VARCHAR(200)" +  SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_CATEGORY_NAME + SQ + SP;
	
	// 初期登録時の教育カテゴリー情報ID
	/** ID : Java基礎 */
	public final int CATEGORY_ID_JAVA_BASIC = 1001;
	/** ID : SQL */
	public final int CATEGORY_ID_SQL = 1002;
	
	// SQL関連
	/** 新規登録 */
	public final String SQL_INSERT_CATEGORY = "INSERT INTO" + SP + TABLE_NAME_EDU_CATEGORY + SP + "("
			+ COL_NAME_CATEGORY_ID + CM + COL_NAME_CATEGORY_CD
			+ CM + COL_NAME_CATEGORY_NAME + ") VALUES (?,?,?)" + SP;
	/** 教育カテゴリー情報一覧取得用 : ALL */
	public final String SQL_LIST_ALL = "SELECT * FROM" + SP + TABLE_NAME_EDU_CATEGORY + SP;
}

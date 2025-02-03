package busiframe.product.dao;

import busiframe.core.dao.I_BaseDAO;

/**
 * 商品情報インターフェースクラス<br>
 * @since 2024/12/31
 * @version 1.00 新規作成
 */
public interface I_Product extends I_BaseDAO {

	// テーブル関連
	public final String TABLE_NAME_PRODUCT = "prd_product";
	public final String TABLE_COMMENT_PRODUCT = "商品情報 Lv.01";

	// テーブル項目
	/** 商品情報ID */
	public final String COL_NAME_PRODUCT_ID = "product_id";
	public final String COL_COMMENT_PRODUCT_ID = "商品情報ID";
	/** 商品識別コード */
	public final String COL_NAME_PRODUCT_CD = "product_cd";
	public final String COL_COMMENT_PRODUCT_CD = "商品コード";
	public final String COL_DESCRIPTION_PRODUCT_CD = "商品のマスター情報";
	public final String COL_ALTER_PRODUCT_CD = "ALTER TABLE" + SP + TABLE_NAME_PRODUCT + SP
			+ "ADD" + SP + COL_NAME_PRODUCT_CD + SP + "VARCHAR(100) NOT NULL UNIQUE" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_PRODUCT_CD + SQ + SP;
	/** 名前 */
	public final String COL_ALTER_NAME = "ALTER TABLE" + SP + TABLE_NAME_PRODUCT + SP
			+ "ADD" + SP + COL_NAME_NAME + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_NAME + SQ + SP;
	/** 解説 */
	public final String COL_ALTER_DESCRIPTION = "ALTER TABLE" + SP + TABLE_NAME_PRODUCT + SP
			+ "ADD" + SP + COL_NAME_DESCRIPTION + SP + "VARCHAR(3000)"
			+ "COMMENT" + SP + SQ + COL_COMMENT_DESCRIPTION + SQ + SP;
	
	// SQL関連
	/** SQL : 新規登録 */
	public final String SQL_INSERT = "INSERT INTO" + SP + TABLE_NAME_PRODUCT + SP
			+ "(" + COL_NAME_PRODUCT_ID + CM + COL_NAME_PRODUCT_CD + CM
			+ COL_NAME_NAME + CM + COL_NAME_DESCRIPTION + ") VALUES (?,?,?,?)";
	/** SQL : 商品情報一覧取得 */
	public final String SQL_GET_LIST = "SELECT * FROM" + SP + TABLE_NAME_PRODUCT + SP;
}

package busiframe.order.dao;

import busiframe.core.dao.I_BaseDAO;

/**
 * 受注情報 Lv.01 インターフェースクラス<br>
 * @since 2024/11/21
 * @version 1.00 新規作成
 */
public interface I_Order01 extends I_BaseDAO {

	// テーブル関連
	public final String TABLE_NAME_ORDER = "ord_order";
	
	// テーブル項目関連
	// 受注情報ID
	public final String COL_NAME_ORDER_ID = "order_id";
	public final String COL_COMMENT_ORDER_ID = "受注情報ID";
	// 受注日
	public final String COL_NAME_ORDER_DATE = "order_date";
	public final String COL_COMMENT_ORDER_DATE = "受注日";
	public final String COL_DESCRIPTION_ORDER_DATE = "営業が受注を最初に確定した日（注意：最初に注文を受けた日ではない）";
	public final String COL_ALTER_ORDER_DATE = "ALTER TABLE" + SP + TABLE_NAME_ORDER + SP
			+ "add  order_date DATE COMMENT" + SP
			+ SQ + COL_COMMENT_ORDER_DATE + SQ + SP;
	
	// SQL関係
	/** SQL : 追加用 */
	public final String SQL_INSERT_ORDER = "INSERT INTO" + SP + TABLE_NAME_ORDER + " ("
			+ COL_NAME_ORDER_ID + CM + COL_NAME_ORDER_DATE
			+ ") VALUES (?,?)" + SP;
	
}

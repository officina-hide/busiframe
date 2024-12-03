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
	public final String TABLE_COMMENT_ORDER = "受注情報 Lv.01";
	public final int TABLE_ID_ORDER = 1101;	// TODO 受注情報のテーブル情報IDは固定 2024/11/22
	
	// テーブル項目関連
	// 受注情報ID
	public final String COL_NAME_ORDER_ID = "order_id";
	public final String COL_COMMENT_ORDER_ID = "受注情報ID";
	public final int COL_ID_ORDER_ID = 1101001;
	// 受注日
	public final String COL_NAME_ORDER_DATE = "order_date";
	public final String COL_COMMENT_ORDER_DATE = "受注日";
	public final String COL_DESCRIPTION_ORDER_DATE = "営業が受注を最初に確定した日（注意：最初に注文を受けた日ではない）";
	public final String COL_ALTER_ORDER_DATE = "ALTER TABLE" + SP + TABLE_NAME_ORDER + SP
			+ "add  order_date DATE COMMENT" + SP
			+ SQ + COL_COMMENT_ORDER_DATE + SQ + SP;
	// 相手先名 addition 2024/11/25
	public final String COL_NAME_PARTNER_NAME = "partner_name";
	public final String COL_COMMENT_PARTNER_NAME = "相手先名";
	public final String COL_DESCRIPTION_PARTNER_NAME = "商品を受注した相手先の名称"
			+ "<br>Lv.01では受注・納品・請求の全てがこの相手先ととなる。マスター管理もしない。";
	public final String COL_ALTER_PARTNER_NAME = "ALTER TABLE" + SP + TABLE_NAME_ORDER + SP
			+ "ADD" + SP + COL_NAME_PARTNER_NAME + SP + "VARCHAR(100)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_PARTNER_NAME + SQ + SP;
	// 商品名 Addition 2024/11/28
	public final String COL_NAME_PRODUCT_NAME = "product_name";
	public final String COL_COMMENT_PRODUCT_NAME = "商品名";
	public final String COL_DESCRIPTION_PRODUCT_NAME = "受注した商品の名前<br>"
			+ "Lv.01では実際に相手先に販売する商品の会社側で命名した名前を扱う。";
	public final String COL_ALTER_PRODUCT_NAME = "ALTER TABLE" + SP + TABLE_NAME_ORDER + SP
			+ "ADD" + SP + COL_NAME_PRODUCT_NAME + SP + "VARCHAR(200)" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_PRODUCT_NAME + SQ + SP;
	// 受注数 Addition 2024/11/30
	public final String COL_NAME_ORDER_NUMBER = "order_number";
	public final String COL_COMMENT_ORDER_NUMBER = "受注数";
	public final String COL_DESCRIPTION_ORDER_NUMBER = "受注した商品の数量（Lv.01では単位は未実装）";
	public final String COL_ALTER_ORDER_NUMBER = "ALTER TABLE" + SP + TABLE_NAME_ORDER + SP
			+ "ADD" + SP + COL_NAME_ORDER_NUMBER + SP + "DECIMAL(10,0) DEFAULT 0" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ORDER_NUMBER + SQ + SP;
	// 受注金額 Addition 2024/11/30
	public final String COL_NAME_ORDER_AMOUNT = "order_amount";
	public final String COL_COMMENT_ORDER_AMOUNT = "受注金額";
	public final String COL_DESCRIPTION_ORDER_AMOUNT = "受注した商品の金額";
	public final String COL_ALTER_ORDER_AMOUNT = "ALTER TABLE" + SP + TABLE_NAME_ORDER + SP
			+ "ADD" + SP + COL_NAME_ORDER_AMOUNT + SP + "DECIMAL(20,0) DEFAULT 0" + SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ORDER_AMOUNT + SQ + SP;
	
	// SQL関係
	/** SQL : 追加用 */
	public final String SQL_INSERT_ORDER = "INSERT INTO" + SP + TABLE_NAME_ORDER + " ("
			+ COL_NAME_ORDER_ID + CM + COL_NAME_ORDER_DATE + CM + COL_NAME_PARTNER_NAME + CM
			+ COL_NAME_PRODUCT_NAME + CM + COL_NAME_ORDER_NUMBER
			+ CM + COL_NAME_ORDER_AMOUNT
			+ ") VALUES (?,?,?,?,?,?)" + SP;
	/** SQL : 全件取得用 */
	public final String SQL_LOAD_ALL = "SELECT * FROM" + SP + TABLE_NAME_ORDER + SP;
}

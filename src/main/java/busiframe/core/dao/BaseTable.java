package busiframe.core.dao;

/**
 * テーブル関連インターフェースクラス<br>
 * 本クラスは、テーブルに関連する定数当の管理を行う。<br>
 * @since 2024/11/28
 * @version 1.00 新規作成
 */
public interface BaseTable {

	// 固定テーブルID
	public final int TABLE_ID_SYS_DISPDETAIL = 10102;	//表示詳細情報
	public final int TABLE_ID_SYS_DISPMENU = 10103;		//表示メニュー情報
	
	// 表示処理情報 Addition 2025/01/16
	public final int TABLE_ID_SYS_DISPPROCESS = 10104;	//表示処理情報
	public final int COL_ID_DISPPROCESS_ID = 1104001;		//表示処理情報ID
	public final int COL_ID_DISPPROCEDD_CD = 1104002;	//表示処理識別コード
	public final int COL_ID_PROCESS_TITLE = 1104003;		//処理タイトル
	public final int COL_ID_PROCESS_ACTION_URL = 1104004;			//処理アクションURL
	
	//教育カテゴリー情報
	public final int TABLE_ID_EDU_CATEGORY = 10201;
	public final int COL_ID_CATEGORY_ID = 11020001;
	public final int COL_ID_CATEGORY_CD = 11020002;
	public final int COL_ID_CATEGORY_NAME = 11020002;

	// 商品情報
	public final int TABLE_ID_PRD_PRODUCT = 10301;

	// テーブル情報　Addition 2025/03/14
	public final int TABLE_ID_SYS_TABLE = 90101;
}

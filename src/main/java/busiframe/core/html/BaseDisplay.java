package busiframe.core.html;

/**
 * 表示共通インターフェースクラス<br>
 * @since 2024/11/30
 * @version 1.00 新規作成
 */
public interface BaseDisplay {

	// 表示画面固定ID
	/** 受注登録 Lv.01 */
	public final int DISPLAY_ID_ORDER_ENTRY_01 = 10001;
	public final String DISPLAY_CD_ORDER_ENTRY_01 = "OrderEntry01";
	/** 受注一覧 Lv.01 */
	public final int DISPLAY_ID_ORDER_LIST_01 = 10002;
	public final String DISPLAY_CD_ORDER_LIST_01 = "orderList01";
	/** 教育メニュー Lv.01 */
	public final int DISPLAY_ID_EDUCATE_MENU_01 = 10201;
	public final String DISPLAY_CD_EDUCATE_MENU_01 = "educateMenu01";
	public final String ACTION_URI_EDUCATE_MENU_01 = "./educate01";
}

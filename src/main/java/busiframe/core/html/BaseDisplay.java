package busiframe.core.html;

/**
 * 表示共通インターフェースクラス<br>
 * @since 2024/11/30
 * @version 1.00 新規作成
 */
public interface BaseDisplay {

	// 表示画面固定ID
	// メインメニュー Addition 2025/02/10
	public final int DISPLAY_ID_MAIN_MENU = 10001;
	public final String DISPLAY_CD_MAIN_MENU = "mainMenu";
	public final String DISPLAY_TITLE_MAIN_MENU = "メインメニュー";
	public final String ACTION_URI_MAIN_MENU = "./action01";
	
	// 受注メニュー Lv.01 Addition 2025/03/04
	public final int DISPLAY_ID_ORDER_MENU_01 = 10101;
	public final String DISPLAY_CD_ORDER_MENU_01 = "orderMenu01";
	public final String DISPLAY_TITLE_ORDER_MENU_01 = "受注メニュー　Lv.01";
	
	/** 受注登録 Lv.01 */
	public final int DISPLAY_ID_ORDER_ENTRY_01 = 10102;
	public final String DISPLAY_CD_ORDER_ENTRY_01 = "OrderEntry01";
	/** 受注一覧 Lv.01 */
	public final int DISPLAY_ID_ORDER_LIST_01 = 10103;
	public final String DISPLAY_CD_ORDER_LIST_01 = "orderList01";
	public final String DISPLAY_TITLE_ORDER_LIST_01 = "受注一覧 Lv.01";

	/** 教育メニュー Lv.01 */
	public final int DISPLAY_ID_EDUCATE_MENU_01 = 10201;
	public final String DISPLAY_CD_EDUCATE_MENU_01 = "educateMenu01";
	public final String ACTION_URI_EDUCATE_MENU_01 = "./educate01";
	public final String DISPLAY_TITLE_EDUCATE_MENU_01 = "教育メニュー Lv.01";	//　Addition 2024/02/25
	/** 教育カテゴリー一覧 Lv.01 */
	public final int DISPLAY_ID_EDUCATE_CATEGORY_01 = 10202;
	public final String DISPLAY_CD_EDUCATE_CATEGORY_01 = "eduCategoryList01";
	public final String DISPLAY_TITLE_EDUCATE_CATEGORY_01 = "教育カテゴリー一覧 Lv.01";
	/** 問題一覧 Lv.01 */
	public final int DISPLAY_ID_QUESTION_LIST_01 = 10203;
	public final String DISPLAY_CD_QUESTION_LIST_01 = "eduQuestionList01";
	public final String DISPLAY_TITLE_QUESTION_LIST_01 = "教育問題一覧 Lv01";
	
	// 生産メニュー Lv.01関連
	/** 生産メニュー Lv,01 */
	public final int DISPLAY_ID_PRODUCT_MENU_01 = 10301;
	public final String DISPLAY_CD_PRODUCT_MENU_01 = "productMenu01";
	public final String DISPLAY_TITLE_PRODUCT_MENU_01 = "生産メニュー Lv.01";
	/** メニュー情報 :  */
	public final String MENU_CD_PRODUCT_LIST = "productList01";
	public final String MENU_TITLE_PRODUCT_LIST = "商品一覧 Lv.01";
	public final String MENU_ACTION_PRODUCT_LIST = "./productAction01";
	// 商品一覧 Lv.01 Addition 2025/01/09
	public final int DISPLAY_ID_PRODUCT_LIST_01 = 10302;
	public final String DISPLAY_CD_PRODUCT_LIST_01 = "productList01";
	public final String DISPLAY_TITLE_PRODUCT_LIST_01 = "商品一覧 Lv.01";
	// 商品照会 Lv.01 Addition 2025/02/03
	public final int DISPLAY_ID_PRODUCT_DATA_01 = 10303;
	public final String DISPLAY_CD_PRODUCT_DATA_01 = "productData01";
	public final String DISPLAY_TITLE_PRODUCT_DATA_01 = "商品照会 Lv.01";
	// 商品編集 Lv.01 Addition 2025/02/18
	public final int DISPLAY_ID_PRODUCT_ENTRY_01 = 10304;
	public final String DISPLAY_CD_PRODUCT_ENTRY_01 = "productEntry01";
	public final String DISPLAY_TITLE_PRODUCT_ENTRY_01 = "商品編集 Lv.01";
	
	// プロジェクト管理メニュー Lv.01
	public final int DISPLAY_ID_PROJECT_MENU_01 = 10401;
	public final String DISPLAY_CD_PROJECT_MENU_01 = "projectMenu01";
	public final String DISPLAY_TITLE_PROJECT_MENU_01 = "プロジェクト管理メニュー Lv.01";
	public final String ACTION_URI_PROJECT_MENU_01 = "./projectAction01";
	// プロジェクト一覧
	public final int DISPLAY_ID_PROJECT_LIST_01 = 10402;
	public final String DISPLAY_CD_PROJECT_LIST_01 = "projectList01";
	public final String DISPLAY_TITLE_PROJECT_LIST_01 = "プロジェクト一覧";
	
	// システム管理メニュー Lv.01 Addition 2025/03/06
	public final int DISPLAY_ID_SYSTEM_MENU_01 = 90101;
	public final String DISPLAY_CD_SYSTEM_MENU_01 = "systemMenu01";
	public final String DISPLAY_TITLE_SYSTEM_MENU_01 = "システム管理メニュー Lv.01";
	public final String ACTION_URI_SYSTEM_MENU_01 = "./systemAction01";
}

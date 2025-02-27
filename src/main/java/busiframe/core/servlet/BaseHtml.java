package busiframe.core.servlet;

/**
 * HTMLインターフェースクラス<br>
 * 本クラスでは、HTMLを生成する際に共通して使われる情報を扱います。<br>
 * @since 2024/11/18
 * @version 1.00 新規作成
 */
public interface BaseHtml {
	// actionName
	/** 生産メニュー */
	public static final String MENU_PRODUCT01 = "product01";

	/** POST */
	public final String H_POST = "post";

	// 画面名称 TODO データベース化 2024/11/19
	public final String EDUCATE_MENU_01_TITLE = "教育メニュー Lv.01";
	public final String ORDER_MENU_01_TITLE = "受注メニュー Lv.01";
	public final String PRODUCT_MENU_01_TITLE = "生産メニュー Lv.01";	// addition 2024/11/25
	public final String ORDER_ENTRY_01_TITLE = "受注登録 Lv.01";
	
	public final String SCRIPT_START = "<script>";
	public final String SCRIPT_END = "</script>";
	
	public final String HTML_START = "<html>";
	public final String HTML_END = "</html>";

	public final String HEAD_START = "<head>";
	public final String HEAD_END = "</head>";

	public final String BODY_START = "<body>";
	public final String BODY_END = "</body>";
	
	public final String HEADER_START = "<header>";
	public final String HEADER_END = "</header>";

	
	/** DOCTYPE */
	public static final String DOCTYPE_HTML = "<!DOCTYPE html>";

}

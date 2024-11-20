package busiframe.core.servlet;

/**
 * HTMLインターフェースクラス<br>
 * 本クラスでは、HTMLを生成する際に共通して使われる情報を扱います。<br>
 * @since 2024/11/18
 * @version 1.00 新規作成
 */
public interface BaseHtml {

	// 画面名称 TODO データベース化 2024/11/19
	public static final String EDUCATE_MENU_01_TITLE = "教育メニュー Lv.01";
	public static final String ORDER_MENU_01_TITLE = "受注メニュー Lv.01";
	public static final String ORDER_ENTRY_01_TITLE = "受注登録 Lv.01";
	
	public static final String HTML_START = "<html>";
	public static final String HTML_END = "</html>";

	public static final String HEAD_START = "<head>";
	public static final String HEAD_END = "</head>";

	
	
	/** DOCTYPE */
	public static final String DOCTYPE_HTML = "<!DOCTYPE html>";

}

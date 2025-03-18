package busiframe.system.generate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import busiframe.core.dao.Environment;
import busiframe.core.dao.I_BaseReference;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;
import busiframe.system.dao.I_Table;
import busiframe.system.dao.M_Table;

/**
 * システム管理生成クラス<br>
 * @since 2025/03/13
 * @version 1.00 新規作成
 */
public class CreateSystemMnagement01 implements BaseDisplay, I_BaseReference {
	
	/** 表示日付書式 */
	protected DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	public void execute(Environment env) {
		// 開始メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : システム管理に関する機能の生成を開始します。");
		
		// テーブル情報構築 Addition 2025/03/14
		M_Table table = new M_Table();
		table.dropTable(env);
		table.createTable(env);
		
		M_Display disp = new M_Display();
		// 表示情報 : システム管理メニュー情報 Addition 2025/03/10
		disp.addDispData(env, DISPLAY_ID_SYSTEM_MENU_01, DISPLAY_CD_SYSTEM_MENU_01, 
				DISPLAY_TITLE_SYSTEM_MENU_01);
		// 表示メニュー情報 : システム管理メニュー情報 Addition 2025/03/10
		disp.addMenuData(env, DISPLAY_ID_SYSTEM_MENU_01, DISPLAY_CD_TABLE_LIST_01,
				DISPLAY_TITLE_TABLE_LIST_01, ACTION_URI_SYSTEM_ACTION_01, 1);
		disp.addMenuData(env, DISPLAY_ID_SYSTEM_MENU_01, DISPLAY_CD_ENTITY_LIST_01,
				DISPLAY_TITLE_ENTITY_LIST_01, ACTION_URI_SYSTEM_ACTION_01, 1);
		disp.addMenuData(env, DISPLAY_ID_SYSTEM_MENU_01, DISPLAY_CD_DISPLAY_LIST_01,
				DISPLAY_TITLE_DISPLAY_LIST_01, ACTION_URI_SYSTEM_ACTION_01, 1);
		// 表示情報 : テーブル一覧 Addition 2025/03/18
		disp.addDispData(env, DISPLAY_ID_TABLE_LIST_01, DISPLAY_CD_TABLE_LIST_01, DISPLAY_TITLE_TABLE_LIST_01);
		disp.addDispDetailData(env, DISPLAY_ID_TABLE_LIST_01, I_Table.COL_NAME_TABLE_ID,
				1, I_Table.COL_COMMENT_TABLE_ID, R_STRING);
		
		// 完了メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : システム管理に関する機能の生成を完了しました。");
	}

}

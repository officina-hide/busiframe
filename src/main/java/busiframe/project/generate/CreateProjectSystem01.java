package busiframe.project.generate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;

/**
 * プロジェクト管理関係 : 初期設定クラス<br>
 * @since 2025/03/01
 * @version 1.00 新規作成
 */
public class CreateProjectSystem01 implements BaseDisplay {
	
	/** 表示日付書式 */
	protected DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	/**
	 * 生成処理実行<br>
	 * @param env 環境情報
	 * @since 2025/03/01
	 */
	public void execute(Environment env) {
		// 開始メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : プロジェクト管理に関する機能の生成を開始します。");
		// 表示情報登録 : プロジェクト管理メニュー
		M_Display disp = new M_Display();
		disp.addDispData(env, DISPLAY_ID_PROJECT_MENU_01, DISPLAY_CD_PROJECT_MENU_01,
				DISPLAY_TITLE_PROJECT_MENU_01);
		// 表示メニュー登録 : プロジェクト管理メニュー : プロジェクト一覧
		disp.addMenuData(env, DISPLAY_ID_PROJECT_MENU_01, DISPLAY_CD_PROJECT_LIST_01, DISPLAY_TITLE_PROJECT_LIST_01,
				ACTION_URI_PROJECT_MENU_01, 1);

		// 完了メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : プロジェクト管理に関する機能の生成を完了しました。");
	}

}

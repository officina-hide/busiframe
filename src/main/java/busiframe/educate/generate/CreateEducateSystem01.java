package busiframe.educate.generate;

import busiframe.core.dao.I_BaseTable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Display;
import busiframe.core.html.BaseDisplay;
import busiframe.educate.dao.I_EduCategory;
import busiframe.educate.dao.M_EduCategory;
import busiframe.educate.dao.M_EduIssue;

/**
 * 教育関連システム初期生成クラス<br>
 * @since 2024/12/04
 * @version 1.00 新規作成
 */
public class CreateEducateSystem01 implements BaseDisplay, I_BaseTable {
	/** 表示日付書式 */
	protected DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	/**
	 * 生成実行<br>
	 * @since 2024/12/04
	 * @param env 環境情報
	 */
	public void execute(Environment env) {
		// 開始メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : 教育システムの生成を開始します。");
		
		// 表示情報に教育メニュー Lv.01を登録する。
		M_Display disp = new M_Display();
		disp.addDispData(env, DISPLAY_ID_EDUCATE_MENU_01, DISPLAY_CD_EDUCATE_MENU_01, "教育メニュー");
		/*
		 *  表示情報にメニュー情報を登録する。<br> Addition 2023/12/05
		 *  メニュー : カテゴリー一覧
		 */
		disp.addMenuData(env, disp.getDispData().getDispId(), "educateMenu01", "カテゴリー一覧", "./educate01", 1);
		// 教育カテゴリー情報を構築する。
		M_EduCategory ecat = new M_EduCategory();
		ecat.dropTable(env);
		ecat.createTable(env);
		// 教育カテゴリー一覧を表示情報に登録する。
		disp.addDispData(env, DISPLAY_ID_EDUCATE_CATEGORY_01, DISPLAY_CD_EDUCATE_CATEGORY_01,
				DISPLAY_TITLE_EDUCATE_CATEGORY_01);
		disp.addDispDetailData(env, DISPLAY_ID_EDUCATE_CATEGORY_01, I_EduCategory.COL_NAME_CATEGORY_NAME,	1,
				"カテゴリー名", "String", 0);
		// 教育カテゴリー情報の初期登録を行う。
		ecat.addData(env, I_EduCategory.CATEGORY_ID_JAVA_BASIC, "javaBasic", "Java基礎");
		ecat.addData(env, I_EduCategory.CATEGORY_ID_SQL, "sql", "SQL");
		
		// 問題情報を構築する。
		M_EduIssue issue = new M_EduIssue();
		issue.dropTable(env);
		issue.createTable(env);
		// 問題情報を表示情報に登録する。
		disp.addDispData(env, DISPLAY_ID_ISSUE_ENTRY_01, DISPLAY_CD_ISSUE_ENTRY_01,	
				DISPLAY_TITLE_ISSUE_ENTRY_01, TABLE_ID_EDU_ISSUE);

		// 開始メッセージ
		System.out.println(LocalDateTime.now().format(fomat) + " : 教育システムの生成を完了しました。");
	}

}

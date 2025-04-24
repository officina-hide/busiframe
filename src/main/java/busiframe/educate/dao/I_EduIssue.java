package busiframe.educate.dao;

import busiframe.core.tools.BaseCharacter;

/**
 * 問題情報インターフェース<br>
 * 	@since 2025/04/23
 * @version 1.00 新規作成
 */
public interface I_EduIssue extends BaseCharacter {
	
	// テーブル関連
	public final String TABLE_NAME_EDU_ISSUE = "edu_issue";
	public final String TABLE_COMMENT_EDU_ISSUE = "問題情報 Lv.01";

	// テーブル項目
	// 問題情報ID
	public final String COL_NAME_ISSUE_ID = "issue_id";
	public final String COL_COMMENT_ISSUE_ID = "問題情報ID";
	public final String COL_DESCRIPTION_ISSUE_ID = "問題情報を一意で識別する為のID。";
	// カテゴリー情報ID
	public final String ALTER_CATEGORY_ID = "ALTER TABLE" + SP + TABLE_NAME_EDU_ISSUE + SP
			+ "ADD" + SP + I_EduCategory.COL_NAME_CATEGORY_ID + SP + "INT NOT NULL" + SP
			+ "COMMENT" + SP + SQ + I_EduCategory.COL_COMMENT_CATEGORY_ID + SQ + SP;
	// 問題タイトル
	public final String COL_NAME_ISSUE_TITLE = "issue_title";
	public final String COL_COMMENT_ISSUE_TITLE = "問題タイトル";
	public final String COL_DESCRIPTION_ISSUE_TITLE = "問題一覧等で識別する為のタイトル。";
	public final String COL_ALTER_ISSUE_TITLE = "ALTER TABLE" + SP + TABLE_NAME_EDU_ISSUE + SP
			+ "ADD" + SP + COL_NAME_ISSUE_TITLE + SP + "VARCHAR(200)" +  SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ISSUE_TITLE + SQ + SP;
	// 問題内容
	public final String COL_NAME_ISSUE_CONTENT = "issue_content";
	public final String COL_COMMENT_ISSUE_CONTENT = "問題内容";
	public final String COL_DESCRIPTION_ISSUE_CONTENT = "単純な選択肢解答要の問題文";
	public final String COL_ALTER_ISSUE_CONTENT = "ALTER TABLE" + SP + TABLE_NAME_EDU_ISSUE + SP
			+ "ADD" + SP + COL_NAME_ISSUE_CONTENT + SP + "VARCHAR(2000)" +  SP
			+ "COMMENT" + SP + SQ + COL_COMMENT_ISSUE_CONTENT + SQ + SP;
}

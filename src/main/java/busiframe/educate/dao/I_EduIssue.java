package busiframe.educate.dao;

/**
 * 問題情報インターフェース<br>
 * 	@since 2025/04/23
 * @version 1.00 新規作成
 */
public interface I_EduIssue {
	
	// テーブル関連
	public final String TABLE_NAME_EDU_ISSUE = "edu_issue";
	public final String TABLE_COMMENT_EDU_ISSUE = "問題情報 Lv.01";

	// テーブル項目
	// 問題情報ID
	public final String COL_NAME_ISSUE_ID = "issue_id";
	public final String COL_COMMENT_ISSUE_ID = "問題情報ID";
	public final String COL_DESCRIPTION_ISSUE_ID = "問題情報を一意で識別する為のID。";
}

package busiframe.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 表示処理情報クラス<br>
 * @since 2025/01/22
 * @version 1.00 新規作成
 */
public class X_sysDispProcess implements I_SysDIspProcess {

	/** 表示処理情報ID */
	private int dispProcessId;
	/** 表示情報ID */
	private int dispId;
	/** ボタンタイトル */
	private String buttonTitle;
	/** アクションURL */
	private String actionURL;
	/** アクション名 */
	private String actionName;
	
	/**
	 * 項目セットll
	 * [o@:p;cx
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	public void setItems(ResultSet rs) throws SQLException {
		setDispProcessId(rs.getInt(COL_NAME_DISP_PROCESS_ID));
		setDispId(rs.getInt(I_SysDisp.COL_NAME_DISP_ID));
		setButtonTitle(rs.getString(COL_NAME_BUTTON_TITLE));
		setActionURL(rs.getString(COL_NAME_ACTION_URL));
		setActionName(rs.getString(COL_NAME_ACTION_NAME));
	}
	
	public int getDispProcessId() {
		return dispProcessId;
	}
	public void setDispProcessId(int dispProcessId) {
		this.dispProcessId = dispProcessId;
	}
	public int getDispId() {
		return dispId;
	}
	public void setDispId(int dispId) {
		this.dispId = dispId;
	}
	public String getButtonTitle() {
		return buttonTitle;
	}
	public void setButtonTitle(String buttonTitle) {
		this.buttonTitle = buttonTitle;
	}
	public String getActionURL() {
		return actionURL;
	}
	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
}

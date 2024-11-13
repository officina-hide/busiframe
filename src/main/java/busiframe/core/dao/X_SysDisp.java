package busiframe.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 表示情報DAOクラス<br>
 * @since 2024/11/06
 */
public class X_SysDisp extends BaseDAO implements I_SysDisp {

	/** 表示情報ID */
	private int dispId;
	/** 表示識別コード */
	private String dispCd;
	/** タブタイトル */
	private String tabTitle;

	/**
	 * 項目セット<Br>
	 * @since 2024/11/07
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	public void itemSet(ResultSet rs) throws SQLException {
		setDispId(rs.getInt(COLUMN_NAME_DISP_ID));
		setDispCd(rs.getString(COLUMN_NAME_DISP_CD));
		setTabTitle(rs.getString(COLUMN_NAME_TAB_TITLE));
	}

	public int getDispId() {
		return dispId;
	}
	public void setDispId(int dispId) {
		this.dispId = dispId;
	}
	public String getDispCd() {
		return dispCd;
	}
	public void setDispCd(String dispCd) {
		this.dispCd = dispCd;
	}
	public String getTabTitle() {
		return tabTitle;
	}
	public void setTabTitle(String tabTitle) {
		this.tabTitle = tabTitle;
	}
}

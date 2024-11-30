package busiframe.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 表示情報クラス<br>
 * @since 2024/11/30
 * @version 1.00 新規作成
 */
public class X_SysDisp implements I_SysDisp {

	/** 表示情報ID */
	private int dispId;
	/** 表示識別コード */
	private String dispCd;
	
	/**
	 * 検索結果からの項目セット<br>
	 * @since 2024/11/30
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	public void setItems(ResultSet rs) throws SQLException {
		dispId = rs.getInt(COL_NAME_DISP_ID);
		dispCd = rs.getString(COL_NAME_DISP_CD);
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
}

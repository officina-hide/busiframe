package busiframe.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import busiframe.system.dao.I_SysTable;
import busiframe.system.dao.X_SysTable;

/**
 * 表示情報クラス<br>
 * @since 2024/11/30
 * @version 1.00 新規作成
 * @version 1.01 テーブル情報の項目と情報取得を追加
 */
public class X_SysDisp implements I_SysDisp {

	/** 表示情報ID */
	private int dispId;
	/** 表示識別コード */
	private String dispCd;
	/** 表示タイトル Addition 2024/12/04 */
	private String dispTitle;
	/** テーブル情報ID Addition 2025/03/24 */
	private int tableId;
	/** テーブル情報 Addition 2025/03/24 */
	private X_SysTable table = new X_SysTable();
	
	/**
	 * 検索結果からの項目セット<br>
	 * @since 2024/11/30
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	public void setItems(ResultSet rs) throws SQLException {
		dispId = rs.getInt(COL_NAME_DISP_ID);
		dispCd = rs.getString(COL_NAME_DISP_CD);
		dispTitle = rs.getString(COL_NAME_DISP_TITLE);		// Addition 2024/12/05
		tableId = rs.getInt(I_SysTable.COL_NAME_TABLE_ID);		// Addition 2025/03/24
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
	public String getDispTitle() {
		return dispTitle;
	}
	public void setDispTitle(String dispTitle) {
		this.dispTitle = dispTitle;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public X_SysTable getTable() {
		if(table == null) {
			table = new X_SysTable();
		}
		return table;
	}
}

package busiframe.system.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * テーブル情報クラス
 * @since 2025/03/24
 * @version 1.00 新規作成
 */
public class X_SysTable implements I_SysTable {

	/** テーブル情報ID */
	private int tableId;
	/** テーブル識別コード */
	private String tableCd;
	/** 名前 */
	private String name;
	/** 説明 */
	private String description;
	/** テーブル項目情報リスト Addition 2025/03/29 */
	private List<X_SysColumn> columns = new ArrayList<>();
	
	/**
	 * 項目セット<br>
	 * @param rs 検索結果
	 * @throws SQLException SQLエラーを返す
	 */
	public void setItems(ResultSet rs) throws SQLException {
		setTableId(rs.getInt(COL_NAME_TABLE_ID));
		setTableCd(rs.getString(COL_NAME_TABLE_CD));
		setName(rs.getString(COL_NAME_NAME));
		setDescription(rs.getString(COL_NAME_DESCRIPTION));
	}

	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTableCd() {
		return tableCd;
	}
	public void setTableCd(String tableCd) {
		this.tableCd = tableCd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<X_SysColumn> getColumns() {
		return columns;
	}

}

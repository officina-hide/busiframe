package busiframe.system.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * テーブル項目情報クラス<br>
 * @since 2025/03/29
 * @version 1.00 新規作成
 */
public class X_SysColumn implements I_SysColumn {
	
	/** テーブル項目情報ID */
	private int columnId;
	/** 項目識別コード */
	private String columnCd;
	/** テーブル情報ID */
	private int tableId;
	/** 項目型 */
	private String columnType;
	/** 項目名 */
	private String name;
	/** 項目説明 */
	private String description;
	
	/**
	 * 検索結果から項目情報を取得する<br>
	 * @param rs　検索結果
	 * @throws SQLException　SQL例外
	 */
	public void setItems(ResultSet rs) throws SQLException {
		this.columnId = rs.getInt(COL_NAME_COLUMN_ID);
		this.columnCd = rs.getString(COL_NAME_COLUMN_CD);
		this.tableId = rs.getInt(I_SysTable.COL_NAME_TABLE_ID);
		this.columnType = rs.getString(COL_NAME_COLUMN_TYPE);
		this.name = rs.getString(COL_NAME_NAME);
		this.description = rs.getString(COL_NAME_DESCRIPTION);
	}

	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public String getColumnCd() {
		return columnCd;
	}
	public void setColumnCd(String columnCd) {
		this.columnCd = columnCd;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
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
}

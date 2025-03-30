package busiframe.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import busiframe.system.dao.I_SysColumn;
import busiframe.system.dao.X_SysColumn;

/**
 * 表示詳細情報クラス<br>
 * @since 2024/11/30
 * @version 1.00 新規作成
 * @version 1.01 テーブル項目情報IDを追加 2025/03/30
 */
public class X_sysDispDetail implements I_SysDispDetail {

	/** 表示詳細情報ID */
	private int dispdetailId;
	/** 表示情報ID */
	private int dispId;
	/** 項目識別コード */
	private String itemCd;
	/** 表示順 */
	private int itemSeq;
	/** ラベル */
	private String itemLabel;
	/** 属性名 */
	private String itemType;
	/** テーブル項目情報ID  Addition  2025/03/30 */
	private int columnId;
	/** テーブル項目情報  Addition  2025/03/30 */
	private X_SysColumn column;
	
	/**
	 * 検索結果から項目セット<br>
	 * @since 2024/11/30
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	public void setItems(ResultSet rs) throws SQLException {
		setDispdetailId(rs.getInt(COL_NAME_DISP_DETAIL_ID));
		setDispId(rs.getInt(I_SysDisp.COL_NAME_DISP_ID));
		setItemCd(rs.getString(COL_NAME_ITEM_CD));
		setItemSeq(rs.getInt(COL_NAME_ITEM_SEQ));
		setItemLabel(rs.getString(COL_NAME_ITEM_LABEL));
		setItemType(rs.getString(COL_NAME_ITEM_TYPE));
		setColumnId(rs.getInt(I_SysColumn.COL_NAME_COLUMN_ID));
	}
	
	public int getDispdetailId() {
		return dispdetailId;
	}
	public void setDispdetailId(int dispdetailId) {
		this.dispdetailId = dispdetailId;
	}
	public int getDispId() {
		return dispId;
	}
	public void setDispId(int dispId) {
		this.dispId = dispId;
	}
	public String getItemCd() {
		return itemCd;
	}
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}
	public int getItemSeq() {
		return itemSeq;
	}
	public void setItemSeq(int itemSeq) {
		this.itemSeq = itemSeq;
	}
	public String getItemLabel() {
		return itemLabel;
	}
	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getColumnId() {
		return columnId;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public X_SysColumn getColumn() {
		return column;
	}
	public void setColumn(X_SysColumn column) {
		this.column = column;
	}
}

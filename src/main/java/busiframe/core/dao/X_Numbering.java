package busiframe.core.dao;

/**
 * 採番情報DAOクラス<br>
 * @since 2024/11/22
 * @version 1.00 新規作成
 */
public class X_Numbering {
	
	/** 採番情報ID */
	private int numberingId;
	/** 現在値 */
	private int currentNumber;
	/** テーブル情報ID */
	private int tableId;
	
	public int getNumberingId() {
		return numberingId;
	}
	public void setNumberingId(int numberingId) {
		this.numberingId = numberingId;
	}
	public int getCurrentNumber() {
		return currentNumber;
	}
	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
}

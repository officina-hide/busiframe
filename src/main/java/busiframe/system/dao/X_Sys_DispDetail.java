package busiframe.system.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import busiframe.system.Environment;

/**
 * 表示詳細情報DAOクラス<br>
 * TODO 本クラスは自動生成では無いが、個別のカスタマイズは行わない事 2024/10/25<br>
 * @since 2024/10/25
 * @version 1.00 新規作成
 */
public class X_Sys_DispDetail extends BaseDAO implements I_Sys_DispDetail {

	// テーブル項目
	/** 表示詳細情報ID */
	private int dispdetailId;
	/** 表示情報ID */
	private int dispId;
	/** 表示順序 */
	private int dispSeq;
	/** ラベル */
	private String label;
	/** 登録日 */
	private LocalDateTime createdAt;
	/** 登録者 */
	private int createdBy;
	/** 更新日 */
	private LocalDateTime updatedAt;
	/** 更新者 */
	private int updatedBy;
	
	/**
	 * 検索結果から表示詳細情報をセットする。<br>
	 * ※既に検索結果があるので、セット成否の判定は行わない。
	 * @since 2024/10/28
	 * @param rs 検索結果
	 */
	public void loadByRs(ResultSet rs) {
		try {
			itemSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 項目セット<br>
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	private void itemSet(ResultSet rs) throws SQLException {
		dispdetailId = rs.getInt(COLUMN_NAME_DISPDETAIL_ID);
		dispId = rs.getInt(COLUMN_NAME_DISP_ID);
		dispSeq = rs.getInt(COLUMN_NAME_DISP_SEQ);
		label = rs.getString(COLUMN_NAME_LABEL);
		createdAt = rs.getTimestamp(COLUMN_NAME_CREATED_AT).toLocalDateTime();
		createdBy = rs.getInt(COLUMN_NAME_CREATED_BY);
		updatedAt = rs.getTimestamp(COLUMN_NAME_UPDATED_AT).toLocalDateTime();
		updatedBy = rs.getInt(COLUMN_NAME_UPDATED_BY);
	}

	/**
	 * 初期生成<br>
	 * @since 2024/10/26
	 * @param env 環境情報
	 */
	public void create(Environment env) {
		// 表示情報テーブル構築
		dmlExecute(env, SQL_DELETE_TABLE);
		dmlExecute(env, SQL_CREATE_TABLE);
		System.out.println(LocalDateTime.now().format(fomat) + " : 表示詳細情報("+TABLE_NAME+")の構築を完了しました。");
		// 初期登録
		// login01
		X_Sys_Disp disp = new X_Sys_Disp();
		disp.loadByCd(env, "login01");
		DataCollection dc = new DataCollection();
		dc.setItemInfomation(COLUMN_NAME_DISPDETAIL_ID+":"+R_INTEGER, COLUMN_NAME_DISP_ID+":"+R_INTEGER,
				COLUMN_NAME_DISP_SEQ+":"+R_INTEGER, COLUMN_NAME_LABEL+":"+R_STRING,
				COLUMN_NAME_CREATED_BY+":"+R_INTEGER, COLUMN_NAME_UPDATED_BY+":"+R_INTEGER);
		// ログインID
		dc.addData(100001, disp.getDispId(), 1, "ログインID", env.getLoginUserId(), env.getLoginUserId());
		// パスワード
		dc.addData(100002, disp.getDispId(), 2, "パスワード", env.getLoginUserId(), env.getLoginUserId());
		addExecute(env, SQL_INSERT_DATA, dc);
		System.out.println(LocalDateTime.now().format(fomat) + " : 表示詳細情報("+TABLE_NAME+")の初期登録を完了しました。");
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
	public int getDispSeq() {
		return dispSeq;
	}
	public void setDispSeq(int dispSeq) {
		this.dispSeq = dispSeq;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}
}

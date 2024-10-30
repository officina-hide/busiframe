package busiframe.system.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import busiframe.system.Environment;
import busiframe.system.servlet.I_BaseCreate;

/**
 * 表示情報DAOクラス<br>
 * TODO 本クラスは自動生成では無いが、個別のカスタマイズは行わない事 2024/10/23<br>
 * @since 2024/10/23
 * @version 1.00 新規作成
 */
public class X_Sys_Disp extends BaseDAO implements I_Sys_Disp, I_BaseCreate {

	// テーブル項目
	/** 表示情報ID */
	private int dispId;
	/** 表示識別コード */
	private String dispCd;
	/** 画面タイトル */
	private String dispTitle;
	/** 表示詳細情報リスト */
	private List<X_Sys_DispDetail> dispdetails;
	/** 登録日 */
	private LocalDateTime createdAt;
	/** 登録者 */
	private int createdBy;
	/** 更新日 */
	private LocalDateTime updatedAt;
	/** 更新者 */
	private int updatedBy;
	
	/**
	 * 表示識別コードから情報を取得する。<br>
	 * @since 2024/10/27
	 * @param env 環境情報
	 * @param dispCd 表示識別コード
	 * @return true - 取得成功,false - 取得失敗
	 */
	public boolean loadByCd(Environment env, String dispCd) {
		boolean chk = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD_BY_CD);
			pstmt.setString(1, dispCd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				chk = true;
				itemSet(rs);
			}
			// 表示詳細情報リスト生成
			dispdetails =  getDispDetailList(env, dispId);
			System.out.println(getDispdetails().size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		return chk;
	}

	/**
	 * 表示詳細情報リスト生成<br>
	 * TODO このメソッドについてはどのクラスで管理するかを要検討 2024/10/28
	 * @since 2024/10/27
	 * @param env 環境情報
	 * @param dispId 表示情報ID
	 * @return 表示詳細情報リスト
	 */
	private List<X_Sys_DispDetail> getDispDetailList(Environment env, int dispId) {
		List<X_Sys_DispDetail> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD_DISPDETAIL);
			pstmt.setInt(1, dispId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				X_Sys_DispDetail dd = new X_Sys_DispDetail();
				dd.loadByRs(rs);
				list.add(dd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		return list;
	}

	/**
	 * 項目セット<br>
	 * TODO ORM化要検討 2024/10/28
	 * @since 2024/10/27
	 * @param rs 検索結果
	 * @throws SQLException 
	 */
	private void itemSet(ResultSet rs) throws SQLException {
		dispId = rs.getInt(COLUMN_NAME_DISP_ID);
		dispCd = rs.getString(COLUMN_NAME_DISP_CD);
		dispTitle = rs.getString(COLUMN_NAME_DISP_TITLE);
		createdAt = rs.getTimestamp(COLUMN_NAME_CREATED_AT).toLocalDateTime();
		createdBy = rs.getInt(COLUMN_NAME_CREATED_BY);
		updatedAt = rs.getTimestamp(COLUMN_NAME_UPDATED_AT).toLocalDateTime();
		updatedBy = rs.getInt(COLUMN_NAME_UPDATED_BY);
	}

	/**
	 * 表示情報構築<br>
	 * 表示情報テーブルの構築、必要な表示情報の登録を行う。<br>
	 * @since 2024/10/23
	 * @param env 環境設定
	 */
	public void create(Environment env) {
		// 表示情報テーブル構築
		dmlExecute(env, SQL_DELETE_TABLE);
		dmlExecute(env, SQL_CREATE_TABLE);
		System.out.println(LocalDateTime.now().format(fomat) + " : 表示情報(Sys_Disp)の構築を完了しました。");
		// 初期情報登録
		DataCollection dc = new DataCollection();
		dc.setItemInfomation(COLUMN_NAME_DISP_ID+":"+R_INTEGER, COLUMN_NAME_DISP_CD+":"+R_STRING,
				COLUMN_NAME_DISP_TITLE+":"+R_STRING,
				COLUMN_NAME_CREATED_BY+":"+R_INTEGER, COLUMN_NAME_UPDATED_BY+":"+R_INTEGER);
		dc.addData(1001, "login01", "ログイン Lv.01", env.getLoginUserId(), env.getLoginUserId());
		addExecute(env, SQL_INSERT_DATA, dc);
		System.out.println(LocalDateTime.now().format(fomat) + " : 表示情報(Sys_Disp)の初期登録を完了しました。");
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

	public List<X_Sys_DispDetail> getDispdetails() {
		return dispdetails;
	}
}

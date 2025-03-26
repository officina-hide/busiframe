package busiframe.order.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;
import busiframe.core.dao.I_BaseReference;
import busiframe.core.dao.I_BaseTable;
import busiframe.core.dao.M_Numbering;
import busiframe.system.dao.M_Table;

/**
 * 受注情報 Lv.01クラス<br>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class M_Order01 extends BaseDAO implements I_Order01, I_BaseTable, I_BaseReference {

	/** 受注情報構造体 */
	private X_Order01 order;
	
	/**
	 * 受注テーブル削除<br>
	 * @since 2024/11/20
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		dropTable(env, TABLE_NAME_ORD_ORDER);
	}

	/**
	 * 受注テーブル構築<br>
	 * @since 2024/11/21
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		// 基本構築
		createTable(env, TABLE_NAME_ORD_ORDER, TABLE_COMMENT_ORD_ORDER, COL_NAME_ORDER_ID, COL_COMMENT_ORDER_ID);
		// 項目追加
		addColumn(env, COL_ALTER_ORDER_DATE);
		addColumn(env, COL_ALTER_PARTNER_NAME);
		addColumn(env, COL_ALTER_PRODUCT_NAME);
		addColumn(env, COL_ALTER_ORDER_NUMBER);
		addColumn(env, COL_ALTER_ORDER_AMOUNT);
		
		// 受注情報 Addition 2025/03/24
		M_Table table = new M_Table();
		table.addTableData(env, TABLE_ID_ORD_ORDER, I_Order01.TABLE_NAME_ORD_ORDER,
				I_Order01.TABLE_COMMENT_ORD_ORDER, I_Order01.TABLE_DESCRIPTION_ORD_ORDER);
		table.addColumnData(env, COL_ID_ORDER_ID, COL_NAME_ORDER_ID, TABLE_ID_ORD_ORDER,
				R_INT, COL_COMMENT_ORDER_ID, TABLE_DESCRIPTION_ORD_ORDER);
	}

	/**
	 * 情報取得<br>
	 * @since 2025/03/25
	 * @param env 環境情報
	 * @param orderId 受注情報ID
	 */
	public void load(Environment env, int orderId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD_BY_ID);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				getOrder().setItems(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
	}

	/**
	 * 情報登録<br>
	 * @since 2024/11/21
	 * @param env 環境情報
	 */
	public void save(Environment env) {
		// ID採番 TODO 未実装 2024/11/22
		M_Numbering num = new M_Numbering();
		getOrder().setOrderId(num.newNumber(env, TABLE_ID_ORD_ORDER));
		// 追加登録 TODO 汎用化未実装 2024/11/22
		PreparedStatement pstmt = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_INSERT_ORDER);
			pstmt.setInt(1, order.getOrderId());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			pstmt.setTimestamp(2, new Timestamp(df.parse(order.getOrderDate().toString()).getTime()));
			pstmt.setString(3, order.getPartnerName());
			pstmt.setString(4, order.getProductName());
			pstmt.setBigDecimal(5, order.getOrderNumber());
			pstmt.setBigDecimal(6, order.getOrderAmount());
			pstmt.executeUpdate();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

	/**
	 * 受注一覧生成<br>
	 * 本処理では、登録された要る全ての受注情報を一覧として取得する。<br> 
	 * @param env 環境情報
	 * @return 受注一覧
	 */
	public List<X_Order01> getOrderList(Environment env) {
		List<X_Order01> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				X_Order01 order = new X_Order01();
				order.setItems(rs);
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		return list;
	}

	public X_Order01 getOrder() {
		if(order == null) {
			order = new X_Order01();
		}
		return order;
	}

}

package busiframe.order.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Numbering;

/**
 * 受注情報 Lv.01クラス<br>
 * @since 2024/11/20
 * @version 1.00 新規作成
 */
public class M_Order01 extends BaseDAO implements I_Order01{

	/** 受注情報構造体 */
	private X_Order01 order;
	
	/**
	 * 受注テーブル削除<br>
	 * @since 2024/11/20
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		dropTable(env, TABLE_NAME_ORDER);
	}

	/**
	 * 受注テーブル構築<br>
	 * @since 2024/11/21
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		// 基本構築
		createTable(env, TABLE_NAME_ORDER, TABLE_COMMENT_ORDER, COL_NAME_ORDER_ID, COL_COMMENT_ORDER_ID);
		// 項目追加
		addColumn(env, COL_ALTER_ORDER_DATE);
		addColumn(env, COL_ALTER_PARTNER_NAME);
		addColumn(env, COL_ALTER_PRODUCT_NAME);
		addColumn(env, COL_ALTER_ORDER_NUMBER);
	}

	public X_Order01 getOrder() {
		if(order == null) {
			order = new X_Order01();
		}
		return order;
	}

	/**
	 * 情報登録<br>
	 * @since 2024/11/21
	 * @param env 環境情報
	 */
	public void save(Environment env) {
		// ID採番 TODO 未実装 2024/11/22
		M_Numbering num = new M_Numbering();
		getOrder().setOrderId(num.newNumber(env, I_Order01.TABLE_ID_ORDER));
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
			pstmt.executeUpdate();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

}

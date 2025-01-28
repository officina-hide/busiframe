package busiframe.product.dao;

import java.sql.PreparedStatement;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.BaseTable;
import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Numbering;
import busiframe.core.html.BaseDisplay;

/**
 * 商品情報クラス<br>
 * @since 2024/12/28
 * @version 1.00 新規作成
 */
 public class M_Product extends BaseDAO implements I_Product, BaseTable {

	 /** 商品情報 */
	 X_Priduct product = new X_Priduct();
	 
	/**
	 * テーブル削除<br>
	 * @since 2024/12/31
	 * @param env 環境情報
	 */
	public void dropTable(Environment env) {
		dropTable(env, TABLE_NAME_PRODUCT);
	}

	/**
	 * テーブル構築<br>
	 * @since 2025/01/06
	 * @param env 環境情報
	 */
	public void createTable(Environment env) {
		createTable(env, TABLE_NAME_PRODUCT, TABLE_COMMENT_PRODUCT,
				COL_NAME_PRODUCT_ID, COL_COMMENT_PRODUCT_ID);
		addColumn(env, COL_ALTER_PRODUCT_CD);
		addColumn(env, COL_ALTER_NAME);
		addColumn(env, COL_ALTER_DESCRIPTION);
	}

	/**
	 * 商品情報新規登録<br>
	 * 商品情報IDは自動採番<br>
	 * @since 2025/01/06
	 * @param env 環境情報
	 * @param prodictCd 商品コード
	 * @param name 商品名
	 * @param discription 商品説明
	 */
	public void insertProduct(Environment env, String prodictCd, String name, String discription) {
		M_Numbering num = new M_Numbering();
		product.setProductId(num.newNumber(env, TABLE_ID_PRD_PRODUCT));
		product.setProductCd(prodictCd);
        product.setName(name);
        product.setDescription(discription);
        save(env, product);
    }

	/**
	 * 商品情報更新<br>
	 * @since 2025/01/06
	 * @param env 環境情報
	 * @param product 商品情報
	 */
	private void save(Environment env, X_Priduct product) {
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO " + TABLE_NAME_PRODUCT + " VALUES(?, ?, ?, ?, ?)";
			pstmt = env.getConn().prepareStatement(sql);
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getProductCd());
			pstmt.setString(3, product.getName());
			pstmt.setString(4, product.getDescription());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}
}

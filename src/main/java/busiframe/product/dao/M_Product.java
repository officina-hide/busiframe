package busiframe.product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busiframe.core.dao.BaseDAO;
import busiframe.core.dao.I_BaseTable;
import busiframe.core.dao.Environment;
import busiframe.core.dao.M_Numbering;

/**
 * 商品情報クラス<br>
 * @since 2024/12/28
 * @version 1.00 新規作成
 */
 public class M_Product extends BaseDAO implements I_Product, I_BaseTable {

	 /** 商品情報 */
	 X_Product product = new X_Product();
	 
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
		addColumn(env, COL_ALTER_NAMER);
		addColumn(env, COL_ALTER_DESCRIPTIONR);
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
	private void save(Environment env, X_Product product) {
		PreparedStatement pstmt = null;
		try {
			pstmt = env.getConn().prepareStatement(I_Product.SQL_INSERT);
			connection(env);
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

	/**
	 * 商品情報一覧生成<br>
	 * @since 2025/01/29
	 * @param env 環境情報
	 * @return 商品情報一覧
	 */
	public List<X_Product> getList(Environment env) {
		List<X_Product> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_GET_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				X_Product pr = new X_Product();
				pr.setItems(rs);
				list.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		return list;
	}

	/**
	 * 商品情報取得<br>
	 * @since 2025/02/12
	 * @param env 環境情報
	 * @param productId 商品情報ID
	 */
	public void load(Environment env, int productId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(SQL_LOAD);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				product.setItems(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
	}

	public X_Product getProduct() {
		return product;
	}
}

package jp.hit.coffeebeans.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.hit.coffeebeans.bean.Order;

/*
 * 	Ordersテーブルへアクセスするクラス
 */

public class OrderDao {
	
	// JDBCドライバ名
	private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";

	// 接続文字列
	private static final String URL = "jdbc:mariadb://localhost:3306/WebApp?useSSL=false";

	// ユーザ名
	private static final String USER = "hoge";
	
	// パスワード
	private static final String PASSWORD = "hoge123";
	
	/**
	 * 入力された注文情報をOrdersテーブルへ追加
	 * @param order 入力された注文情報
	 * @return 注文ID
	 * @throws DaoException データベース関連エラー
	 */
	
	public int insert(Order order) throws DaoException {
		
		// 接続に必要な値
		Connection connection = null;
		
		// SQL文を実行する値
		PreparedStatement prepaedStatement = null;
		
		// 検索結果を受け取る値
		ResultSet resultSet = null;
		
		
		try {
			
			// 接続
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// INSERT文（入力された注文情報をordersテーブルに挿入）
			//final String SQL_INSERT = "INSERT INTO orders VALUES (SEQ_ORDERS.nextval, ?, ?, ?, ?)";
			final String SQL_INSERT = "INSERT INTO orders VALUES(NULL, ?, ?, ?, ?)";
			
			// 実行するINSERT文の設定
			prepaedStatement = connection.prepareStatement(SQL_INSERT);
			
			
			// プレースホルダをバインディング
			prepaedStatement.setString(1, order.getName());
			prepaedStatement.setString(2, order.getAddress());
			prepaedStatement.setString(3, order.getTelNumber());
			prepaedStatement.setInt(4, order.getItemId());
			
			// INSERT文の設定
			prepaedStatement.executeUpdate();
			
			final String SQL_SELECT_LAST_ID =
					"SELECT id FROM" +
			        "(SELECT id FROM orders ORDER BY id DESC)" +
							"WHERE ROWNUM >= 1";
			
			
		    // 実行するSELECT文の設定
			prepaedStatement = connection.prepareStatement(SQL_SELECT_LAST_ID);
			
			// SELECT文の実行と検索結果の取得
			resultSet = prepaedStatement.executeQuery();
			
			// 取得した検索結果から注文IDを取得
			if (resultSet.next()) {
				
				// 検索結果があった場合は、取得した情報から注文IDを返す
				return resultSet.getInt("id");
				
			} else {
				
				// 検索結果がなかった場合は、IDではありえない数値を返す
				return -1;
				
			}
			
		} catch (ClassNotFoundException e) {
			throw new DaoException("データベース関連エラー", e);
		} catch (SQLException e) {
			throw new DaoException("データベース関連エラー", e);
		} catch (Exception e) {
			throw new DaoException("データベース関連エラー", e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (prepaedStatement != null) {
						try {
							prepaedStatement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							if (connection != null) {
								try {
									connection.close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		
	}
	
}

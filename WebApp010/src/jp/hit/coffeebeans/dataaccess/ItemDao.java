package jp.hit.coffeebeans.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.hit.coffeebeans.bean.Item;

/*
 * itemsテーブルへアクセスするクラス
 */

public class ItemDao {
	
	// JDBCドライバ名
	private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
	
	// 接続文字列
	private static final String URL = "jdbc:mariadb://localhost:3306/WebApp?useSSL=false";
	
	// ユーザ名
	private static final String USER = "hoge";
	
	// パスワード
	private static final String PASSWORD = "hoge123";
	
	// 例外処理を確認する際に使用するパスワード
    //private static final String PASSWORD = "hit456";
	
	/**
	 * itemsテーブルから原産地域で検索し情報を取得
	 * @param area 入力された原産地域
	 * @return itemsテーブルから取得した情報のリスト
	 * @throws DaoException データベース関連エラー
	 */
	
	public List<Item> selectByArea(String area) throws DaoException {
		
		// 接続に必要な値
		Connection connection = null;
		
		// SQLを実行する値
		PreparedStatement preparedStatement = null;
		
		// 検索結果を受け取る値
		ResultSet resultSet = null;
		
		// Item型の値を格納するリスト
		List<Item> items = new ArrayList<Item>();
		
		
		
		try {
		
		// 接続
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		
		// SELECT文（入力された原産地域の検索）
		final String sQL_SELECT_BY_AREA = "SELECT * FROM items WHERE area = ?";
		
		// 実行するSQL文の設定
		preparedStatement = connection.prepareStatement(sQL_SELECT_BY_AREA);
		
		// プレースホルダをバインディング
		preparedStatement.setNString(1, area);
		
		// SQL文の実行と検索結果の取得
		resultSet = preparedStatement.executeQuery();
		
		// 取得した検索結果でItem型のインスタンスを生成しリストに格納
		while (resultSet.next()) {
			
			// Item型のインスタンス生成
			Item item = new Item();
			
			// NUMBER型の商品IDを取得し、idにセット
			item.setId(resultSet.getInt("id"));
			
			// VARCHAR型の商品名を取得し、nameにセット
			item.setName(resultSet.getString("name"));
			
			// VARCHAR型の原産地域を取得し、areaにセット
			item.setArea(resultSet.getString("area"));
			
			// VARCHAR型の原産国を取得し、originalHomeにセット
			item.setOriginalHome(resultSet.getNString("original_home"));
			
			// NUMBER型の価格を取得し、idにセット
			item.setPrice(resultSet.getInt("price"));
			
			// リストに追加
			items.add(item);
			
		}
		return items;
		
		
		} catch (ClassNotFoundException e) {
			throw new DaoException("データベース関連エラー", e);
		} catch (SQLException e) {
			throw new DaoException("データベース関連エラー", e);
		} catch (Exception e) {
			throw new DaoException("データベース関連エラー", e);
		} finally {
			
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					
					if(preparedStatement != null) {
						
						try {
							preparedStatement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							
							if(connection != null) {
								
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

package jp.hit.coffeebeans.service;

import jp.hit.coffeebeans.bean.Order;
import jp.hit.coffeebeans.dataaccess.DaoException;
import jp.hit.coffeebeans.dataaccess.OrderDao;

/*
 * 注文管理クラス	
 */

public class OrderManager {

	/**
	 * Ordersテーブルに入力された注文情報を追加
	 * @param order 入力された注文情報
	 * @return 注文ID
	 * @throws ServiceException サービス関連エラー
	 */
	
	public int regist(Order order) throws ServiceException {
		
		try {
			return new OrderDao().insert(order);
		} catch (DaoException e) {
			throw new ServiceException("サービス関連エラー", e);
		} catch (Exception e) {
			throw new ServiceException("サービス関連エラー", e);
		}
	}
}

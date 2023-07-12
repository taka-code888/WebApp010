package jp.hit.coffeebeans.service;

import java.util.List;

import jp.hit.coffeebeans.bean.Item;
import jp.hit.coffeebeans.dataaccess.DaoException;
import jp.hit.coffeebeans.dataaccess.ItemDao;

/**
* 商品管理クラス
*/


public class ItemManager {
	
	/**
	 * Itemsテーブルから原産地域で検索し情報を取得
	 * @param area 入力された原産地域
	 * @return Itemsテーブルから取得した情報のリスト
	 * @throws ServiceException サービス関連エラー
	 */	
	
	public List<Item> findByArea(String area) throws ServiceException {
		
		try {
			return new ItemDao().selectByArea(area);
		} catch (DaoException e) {
			throw new ServiceException("サービス関連エラー", e);
		} catch (Exception e) {
			throw new ServiceException("サービス関連エラー", e);
		}
		
	}
	

}

package com.vastika.bankproject.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.bankproject.dao.TransactionDao;
import com.vastika.bankproject.dbutil.DBUtil;
import com.vastika.bankproject.model.Transaction;
//import com.vastika.bankproject.model.Transaction;
import com.vastika.bankproject.sqlquery.SqlQuery;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public int insert(Transaction trc) {
		int insert = 0;
		try (PreparedStatement ps = DBUtil.getConnection().prepareStatement(SqlQuery.INSERT_SQL)) {
			ps.setInt(1, trc.getAccount_info_id());
			ps.setDouble(2, trc.getDeposite_amount());
			ps.setDouble(3, trc.getWithdraw_amount());
			ps.setDouble(4, trc.getBalance());
//			ps.setInt(1, 2);
//			ps.setDouble(2, 222);
//			ps.setDouble(3, 111);
//			ps.setDouble(4, 333);
			insert = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insert;
	}
	
	private int update(Transaction trc) {
		int updated = 0;
		try (PreparedStatement ps = DBUtil.getConnection().prepareStatement(SqlQuery.UPDATE_SQL)) {
			ps.setDouble(1, trc.getDeposite_amount());
			ps.setDouble(2, trc.getWithdraw_amount());

			ps.setDouble(3, trc.getBalance());
			ps.setInt(4, trc.getAccount_info_id());

			updated = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return updated;
	}

	public int insertOrUpdateDepositFund(Transaction trc) {
		int updated = 0;
		try (PreparedStatement ps = DBUtil.getConnection().prepareStatement(SqlQuery.SELECT_BY_ID)) {
			System.out.println(".......");
			ps.setInt(1, trc.getAccount_info_id());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				double lastBalnace = rs.getDouble("balance");
				double finalBalance = lastBalnace + trc.getDeposite_amount();
				System.out.println("final balance: " + finalBalance);
				trc.setBalance(finalBalance);
				update(trc);
			} else {
				insert(trc);
				return updated;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return updated;
	}

	@Override
	public List<Transaction> getAllTransactionInfo() {
		List<Transaction> t_Lists = new ArrayList<>();
		try (PreparedStatement ps = DBUtil.getConnection().prepareStatement(SqlQuery.SELECT_SQL)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction tr = new Transaction();
				tr.setAccount_info_id(rs.getInt("account_info_id"));
				tr.setDeposite_amount(rs.getDouble("deposit_amount"));
				tr.setDeposite_amount(rs.getDouble("withdraw_amount"));
				tr.setBalance(rs.getDouble("balance"));

				t_Lists.add(tr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_Lists;
	}

	@Override
	public int delete(int id) {
		int deleted = 0;
		try (PreparedStatement ps = DBUtil.getConnection().prepareStatement(SqlQuery.DELETE_SQL)) {
			ps.setInt(1, id);
			deleted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleted;

	}

	@Override
	public int updateBalance(Transaction trc) {
		int updated = 0;
		try (PreparedStatement ps = DBUtil.getConnection().prepareStatement(SqlQuery.SELECT_BY_ID)) {
			ps.setInt(1, trc.getAccount_info_id());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				double lastBalnace = rs.getDouble("balance");
				trc.setBalance(lastBalnace - trc.getWithdraw_amount());
				update(trc);
			} else {
				insert(trc);
				return updated;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return updated;
	}
}

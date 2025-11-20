
package dao;

import entity.GameResult;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class GameResultDAO {

    public void save(GameResult result) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(result);
        tx.commit();
        s.close();
    }

    public List<GameResult> getAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<GameResult> list = s.createQuery("from GameResult").list();
        s.close();
        return list;
    }
}

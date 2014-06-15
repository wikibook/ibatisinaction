package org.apache.ibatis.jgamestore.persistence.sqlmapdao;

import org.apache.ibatis.jgamestore.domain.Sequence;
import org.apache.ibatis.jgamestore.persistence.iface.SequenceDao;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

public class SequenceSqlMapDao extends BaseSqlMapDao implements SequenceDao {

  public SequenceSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }

  /**
   * This is a generic sequence ID generator that is based on a database
   * table called 'SEQUENCE', which contains two columns (NAME, NEXTID).
   * <p/>
   * This approach should work with any database.
   *
   * @param name The name of the sequence.
   * @return The Next ID
   * @
   */
  public synchronized int getNextId(String name) {
    Sequence sequence = new Sequence(name, -1);

    sequence = (Sequence) queryForObject("Sequence.getSequence", sequence);
    if (sequence == null) {
      throw new DaoException("Error: A null sequence was returned from the database (could not get next " + name + " sequence).");
    }
    Object parameterObject = new Sequence(name, sequence.getNextId() + 1);
    update("Sequence.updateSequence", parameterObject);

    return sequence.getNextId();
  }

}

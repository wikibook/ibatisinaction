package org.apache.ibatis.jgamestore.persistence.sqlmapdao;

import java.util.List;

import org.apache.ibatis.jgamestore.domain.Category;
import org.apache.ibatis.jgamestore.persistence.iface.CategoryDao;

import com.ibatis.dao.client.DaoManager;

public class CategorySqlMapDao extends BaseSqlMapDao implements CategoryDao {

  public CategorySqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }

  public List getCategoryList() {
    return queryForList("Category.getCategoryList", null);
  }

  public Category getCategory(String categoryId) {
    return (Category) queryForObject("Category.getCategory", categoryId);
  }

}

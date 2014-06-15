package org.apache.ibatis.jgamestore.persistence.iface;


import java.util.List;

import org.apache.ibatis.jgamestore.domain.Category;

public interface CategoryDao {

  List getCategoryList();

  Category getCategory(String categoryId);

}

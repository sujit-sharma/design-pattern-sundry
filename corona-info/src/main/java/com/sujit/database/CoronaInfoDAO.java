package com.sujit.database;

import com.sujit.service.CoronaPOJO;

import java.util.List;

public interface CoronaInfoDAO {
    public void createTable();
    public void insert(CoronaPOJO coronaPOJO);
    public List<CoronaPOJO> getAllPaginatedCovidInfo(int limit);
    public int remove(int limit);
    public void updateAll(List<CoronaPOJO> updateList);
}

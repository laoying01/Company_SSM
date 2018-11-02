package com.laoying.dao;

import com.laoying.model.Reconsider;

import java.util.List;

public interface ReconsiderDao {
    boolean addReconsider(Reconsider reconsider);
    List<Reconsider> getReconsider();
    boolean updateReconsider(Reconsider reconsider);
    Reconsider findReconsider(int r_id);
}

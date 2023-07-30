package com.mt.app.model.dao;

import java.util.List;

import com.mt.app.model.entity.Config;
import com.mt.core.model.dao.BaseJpaRepository;

public interface ConfigRepository extends BaseJpaRepository<Config, String> {

    public List<Config> findByCategory(String category);

    // public List<Config> saveAll(List<Config> entities);
}

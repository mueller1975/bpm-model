package com.mt.app.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mt.app.model.entity.Config;

public interface ConfigRepository extends CrudRepository<Config, String> {

    public List<Config> findByCategory(String category);

    // public List<Config> saveAll(List<Config> entities);
}

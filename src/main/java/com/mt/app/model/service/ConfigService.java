package com.mt.app.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mt.app.model.dao.ConfigRepository;
import com.mt.app.model.dto.ConfigDTO;
import com.mt.app.model.entity.Config;
import com.mt.core.model.exception.ServiceException;
import com.mt.core.model.service.AbstractService;
import com.mt.core.model.vo.OptionVO;

@Service
public class ConfigService extends AbstractService<Config, String, ConfigDTO, ConfigRepository> {

	/**
	 * 查詢 code 設定值
	 * 
	 * @param code
	 * @return
	 */
	public Config getConfigByCode(String code) {
		Config entity = dao.findById(code).orElse(null);
		return entity;
	}

	public Collection<Object> getConfigsByCategory(String category) throws ServiceException {
		List<Config> entities = dao.findByCategory(category);

		ObjectMapper mapper = new ObjectMapper();
		List<Object> list = new ArrayList<>();

		for (Config entity : entities) {
			Object value = null;
			TypeReference<?> type = null;

			switch (category) {
				case "DROPDOWN":
				case "ICON_DROPDOWN":
					type = new TypeReference<List<OptionVO>>() {
					};
					break;
				case "HIERARCHICAL_DROPDOWN":
					type = (TypeReference<?>) new TypeReference<Map<String, List<OptionVO>>>() {
					};
					break;
				case "MPB_FORM":
				case "MPB_FORM_LAB":
					type = (TypeReference<?>) new TypeReference<Map<String, Object>>() {
					};
					break;
				default:
					throw new ServiceException("不支援的系統設定分類 [" + category + "]");
			}

			try {
				value = mapper.readValue(entity.getValue(), type);
			} catch (JsonProcessingException e) {
				throw new ServiceException("字串轉 JSON 失敗", e);
			}

			list.add((Object) (new ConfigDTO(entity.getCode(), entity.getDescription(), value)));
		}

		return list;
	}

	// @Transactional(readOnly = false)
	// public Iterable<Config> saveAll(List<Config> entities) {
	// return configDAO.saveAll(entities);
	// }
}

package com.web.teacher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.teacher.dao.SuggestionDao;
import com.web.teacher.pojo.Suggestion;
import com.web.teacher.service.SuggestionService;
@Service("suggestionService")
public class SuggestionServiceImpl implements SuggestionService{

	@Autowired
	private SuggestionDao suggestionDao;
	public void add(Suggestion suggestion) {
		suggestionDao.add(suggestion);
	}

	public List<Suggestion> queryAll() {
		return suggestionDao.queryAll();
	}

	public Suggestion getById(Integer id) {
		return suggestionDao.getById(id);
	}

}

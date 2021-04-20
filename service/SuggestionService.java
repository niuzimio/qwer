package com.web.teacher.service;

import java.util.List;

import com.web.teacher.pojo.Suggestion;

public interface SuggestionService {
public void add(Suggestion  suggestion);
	
	public List<Suggestion> queryAll();
	public Suggestion getById(Integer id);
}

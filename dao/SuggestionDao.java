package com.web.teacher.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.teacher.pojo.Suggestion;

@Repository("suggestionDao")
public interface SuggestionDao {
	public void add(Suggestion  suggestion);
	public List<Suggestion> queryAll();
	public Suggestion getById(Integer id);
}

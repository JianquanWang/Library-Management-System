package tech.oldwang.service;

import java.util.List;

import tech.oldwang.domain.Category;

public interface CategoryService {
	public int addCategory(String categoryId, String categoryName);
	public void deleteCategory(String categoryId);
}

package tech.oldwang.service.impl;

import java.util.ArrayList;
import java.util.List;

import tech.oldwang.domain.Category;
import tech.oldwang.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	public static final List<Category> categoryDb = new ArrayList<Category>();

	@Override
	public int addCategory(String categoryId, String categoryName) {
		Category category = new Category(categoryId, categoryName);
		for(Category c : categoryDb) {
			if(c.getId().equals(categoryId) || c.getName().equals(categoryName)) {
				return -1;
			}
		}
		categoryDb.add(category);
		return 0;
	}

	@Override
	public void deleteCategory(String categoryId) {
		for(Category c : categoryDb) {
			if(c.getId().equals(categoryId)) {
				categoryDb.remove(c);
				return;
			}
		}
		
	}

}

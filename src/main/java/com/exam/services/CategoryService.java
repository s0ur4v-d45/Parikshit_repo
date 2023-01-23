package com.exam.services;


import java.util.Set;

import com.exam.model.Category;


public interface CategoryService {
	public Category addCategory(Category category);

	public Category updateCategory(Category category);

	public Set<Category> getCategory();

	public Category getCategory(Long categoryId);

	public void deleteCategory(Long categoryId);

}

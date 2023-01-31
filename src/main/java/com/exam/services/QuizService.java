package com.exam.services;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.exam.model.Category;
import com.exam.model.Quiz;


public interface QuizService {

	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuiz(Quiz quiz);

	public Set<Quiz> getQuizzes();

	public Quiz getQuiz(Long quizId);

	public void deleteQuiz(Long quizId);

	public List<Quiz> getQuizzesOfCategory(Category category);

	public List<Quiz> getActiveQuizess();

	public List<Quiz> getActiveQuizzesOfCategory(Category c);

}

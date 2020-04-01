/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Pagination {

    private List<Quiz> quizs;
    private String next;
    private String prev;
    private int totalOfQuiz;
    private int pageNo;

    public Pagination() {
    }

    public Pagination(List<Quiz> quizs, String next, String prev, int totalOfQuiz, int pageNo) {
        this.quizs = quizs;
        this.next = next;
        this.prev = prev;
        this.totalOfQuiz = totalOfQuiz;
        this.pageNo = pageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(List<Quiz> quizs) {
        this.quizs = quizs;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public int getTotalOfQuiz() {
        return totalOfQuiz;
    }

    public void setTotalOfQuiz(int totalOfQuiz) {
        this.totalOfQuiz = totalOfQuiz;
    }

}

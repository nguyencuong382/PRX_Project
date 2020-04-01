/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.dto;

/**
 *
 * @author nc
 */
public class PageInfo {
    private boolean last;
    private int totalPages;
    private long totalElements;
    private long offset;
    private int pageSize;
    private int pageNumber;
    private boolean paged;
    private boolean unpaged;

    public PageInfo() {
    }

    public PageInfo(boolean last, int totalPages, long totalElements, long offset, int pageSize, int pageNumber, boolean paged, boolean unpaged) {
        this.last = last;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.offset = offset;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.paged = paged;
        this.unpaged = unpaged;
    }
    
    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean isPaged() {
        return paged;
    }

    public void setPaged(boolean paged) {
        this.paged = paged;
    }

    public boolean isUnpaged() {
        return unpaged;
    }

    public void setUnpaged(boolean unpaged) {
        this.unpaged = unpaged;
    }
}

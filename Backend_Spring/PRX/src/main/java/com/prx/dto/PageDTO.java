/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.data.domain.Page;

/**
 *
 * @author nc
 */
@JacksonXmlRootElement(localName = "prx")
public class PageDTO<T> {

    private PageInfo page;

    public PageDTO(Page<T> pageData) {
        boolean last = pageData.isLast();
        int totalPages = pageData.getTotalPages();
        long totalElements = pageData.getTotalElements();
        long offset = pageData.getPageable().getOffset();
        int pageSize = pageData.getPageable().getPageSize();
        int pageNumber = pageData.getPageable().getPageNumber();
        boolean paged = pageData.getPageable().isPaged();
        boolean unpaged = pageData.getPageable().isUnpaged();
        page = new PageInfo(last, totalPages, totalElements, offset, pageSize, pageNumber, paged, unpaged);
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }
}

package com.todo.manager.dtos;

import com.todo.manager.enums.Order;

public class PagDTO {

    private int pageNumber;
    private int pageLength;
    private String sortBy;
    private Order order;

    //constructor
    public PagDTO(int pageNumber, int pageLength, String sortBy, Order order) {
        this.pageNumber = pageNumber;
        this.pageLength = pageLength;
        this.sortBy = sortBy;
        this.order = order;
    }

    //getters
    public int getPageNumber() {
        return pageNumber;
    }
    public int getPageLength() {
        return pageLength;
    }
    public String getSortBy() {
        return sortBy;
    }
    public Order getOrder() {
        return order;
    }

    //setters

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}

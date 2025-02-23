package com.sfood.dto;

import java.util.List;

public class PageDTO {
    private int page;
    private int totalPage;
    private int limit;
    private List<FoodDTO> lstFood;
    private List<CategoryDTO> lstCategory;

    public List<CategoryDTO> getLstCategory() {
        return lstCategory;
    }

    public void setLstCategory(List<CategoryDTO> lstCategory) {
        this.lstCategory = lstCategory;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<FoodDTO> getLstFood() {
        return lstFood;
    }

    public void setLstFood(List<FoodDTO> lstFood) {
        this.lstFood = lstFood;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}

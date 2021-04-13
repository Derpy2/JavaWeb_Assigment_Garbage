
package com.javaweb.garbage1.dto;

import com.javaweb.garbage1.entity.Exam;

import java.util.List;

public class TableRsqDTO {
    private Integer total;
    private List listTable;

    public TableRsqDTO() {
    }

    public TableRsqDTO(Integer total, List listTable) {
        this.total = total;
        this.listTable = listTable;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getListTable() {
        return listTable;
    }

    public void setListTable(List listTable) {
        this.listTable = listTable;
    }
}

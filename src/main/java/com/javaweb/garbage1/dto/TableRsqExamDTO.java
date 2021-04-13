package com.javaweb.garbage1.dto;
import java.util.List;
public class TableRsqExamDTO {
    private Integer total;
    private List<ExamDTO> listTable;

    public TableRsqExamDTO() {
    }

    public TableRsqExamDTO(Integer total, List<ExamDTO> listTable) {
        this.total = total;
        this.listTable = listTable;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ExamDTO> getListTable() {
        return listTable;
    }

    public void setListTable(List<ExamDTO> listTable) {
        this.listTable = listTable;
    }
}

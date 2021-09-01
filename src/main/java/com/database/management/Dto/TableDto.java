package com.database.management.Dto;

import com.database.management.Model.ColumnManage;

import java.util.List;

public class TableDto {
    private String tableName;

    private List<ColumnDto> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnDto> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnDto> columns) {
        this.columns = columns;
    }
}

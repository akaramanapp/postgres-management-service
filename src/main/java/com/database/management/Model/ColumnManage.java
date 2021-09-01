package com.database.management.Model;

import javax.persistence.*;

@Entity
@Table(name = "columnmanage")
public class ColumnManage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tableid")
    private long tableid;

    @Column(name = "columnname")
    private String columnname;

    @Column(name = "columntype")
    private String columntype;

    public ColumnManage() {
    }

    public ColumnManage(long id, long tableid, String columnname, String columntype) {
        this.id = id;
        this.tableid = tableid;
        this.columnname = columnname;
        this.columntype = columntype;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTableid() {
        return tableid;
    }

    public void setTableid(long tableid) {
        this.tableid = tableid;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public String getColumntype() {
        return columntype;
    }

    public void setColumntype(String columntype) {
        this.columntype = columntype;
    }
}

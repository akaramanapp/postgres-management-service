package com.database.management.Model;
import javax.persistence.*;

@Entity
@Table(name = "tablemanage")
public class TableManage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tablename")
    private String tablename;

    public TableManage() {

    }

    public TableManage(long id, String tablename) {
        this.id = id;
        this.tablename = tablename;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }
}

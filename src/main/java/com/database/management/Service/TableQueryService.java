package com.database.management.Service;

import com.database.management.Dto.ColumnDto;
import com.database.management.Dto.TableDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class TableQueryService {

    @Value("${spring.datasource.url}")
    private String datasouce;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public Boolean createTableQuery(TableDto tableDto) {
        int index = 0;
        String result = "";
        result = result.concat("CREATE TABLE ")
                .concat(tableDto.getTableName())
                .concat(" (");
        for (ColumnDto item: tableDto.getColumns()) {
            result = result.concat(item.getColumnName())
                    .concat(" ")
                    .concat(item.getColumnType());

            // if iterator end
            if(index++ == tableDto.getColumns().size() - 1){
                result = result.concat(!item.getNullable() ? " NOT NULL" : "");
            } else {
                result = result.concat(!item.getNullable() ? " NOT NULL, " : ", ");
            }
        }

        result = result.concat(");");
        return runQuery(result);
    }

    public void deleteTableQuery(String tableName) {
        String query = "DROP TABLE IF EXISTS ";
        query = query.concat(tableName);
        runQuery(query);
    }

    private Boolean runQuery(String query) {
        Connection c = null;
        Statement statement = null;
        try {
            c = DriverManager.getConnection(datasouce, username, password);
            statement = c.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

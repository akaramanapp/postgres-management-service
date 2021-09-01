package com.database.management.Service;

import com.database.management.Dto.ColumnDto;
import com.database.management.Dto.CreateTableResponseDto;
import com.database.management.Dto.TableDto;
import com.database.management.Model.ColumnManage;
import com.database.management.Repository.ColumnManageRepository;
import com.database.management.Repository.TableManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.database.management.Model.TableManage;;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableManageService {

    @Autowired
    TableManageRepository _tableRepository;

    @Autowired
    ColumnManageRepository _columnManageRepository;

    @Autowired
    TableQueryService _tableQueryService;

    public List<TableManage> getAllTable() {
        return _tableRepository.findAll();
    }

    @Transactional
    public CreateTableResponseDto createTable(TableDto tableDto) {
        CreateTableResponseDto responseDto = new CreateTableResponseDto();
        if(!_tableQueryService.createTableQuery(tableDto)) {
            responseDto.setSuccess(false);
            responseDto.setErrorMessage("Error");
            return responseDto;
        }

        TableManage tableManage = new TableManage();
        List<ColumnManage> columnManages = new ArrayList<>();


        // add table
        tableManage.setTablename(tableDto.getTableName());
        TableManage table = _tableRepository.save(tableManage);

        // add columns
        for (ColumnDto item: tableDto.getColumns()) {
            ColumnManage columnManage = new ColumnManage();
            columnManage.setTableid(table.getId());
            columnManage.setColumnname(item.getColumnName());
            columnManage.setColumntype(item.getColumnType());
            columnManages.add(columnManage);
        }

        // save all columns
        _columnManageRepository.saveAll(columnManages);
        responseDto.setSuccess(true);
        return responseDto;
    }

    @Transactional
    public void deleteTable(Long id){
        TableManage tm = _tableRepository.findById(id).orElse(new TableManage());;

        // delete in manage tables.
        _tableRepository.deleteById(id);
        _columnManageRepository.deleteBytableid(id);

        // drop table
        _tableQueryService.deleteTableQuery(tm.getTablename());
    }
}

package com.database.management.Controller;

import com.database.management.Dto.CreateTableResponseDto;
import com.database.management.Dto.TableDto;
import com.database.management.Model.TableManage;
import com.database.management.Service.TableManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TableManageController {

    @Autowired
    TableManageService _tableManageService;

    @GetMapping("/table")
    public List<TableManage> getAllTable() {
        return _tableManageService.getAllTable();
    }

    @PostMapping("/table")
    public CreateTableResponseDto createTable(@RequestBody TableDto tableDto) {
        CreateTableResponseDto response = _tableManageService.createTable(tableDto);
        return response;
    }

    @DeleteMapping("/table/{id}")
    public void deleteTable(@PathVariable Long id) {
        _tableManageService.deleteTable(id);
    }
}

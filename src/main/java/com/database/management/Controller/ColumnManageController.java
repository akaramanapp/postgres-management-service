package com.database.management.Controller;

import com.database.management.Model.ColumnManage;
import com.database.management.Service.ColumnManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ColumnManageController {

    @Autowired
    ColumnManageService _columnManageService;

    @GetMapping("/column/{id}")
    public List<ColumnManage> findByTableId(@PathVariable Long id) {
        return _columnManageService.findByTableId(id);
    }
}

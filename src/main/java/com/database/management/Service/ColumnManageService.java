package com.database.management.Service;

import com.database.management.Model.ColumnManage;
import com.database.management.Repository.ColumnManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnManageService {

    @Autowired
    ColumnManageRepository _columnRepository;

    public List<ColumnManage> findByTableId(Long id) {
        return _columnRepository.findBytableid(id);
    }

    public void deleteColumn(Long id) {
        _columnRepository.deleteBytableid(id);
    }
}

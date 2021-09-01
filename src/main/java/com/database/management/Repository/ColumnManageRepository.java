package com.database.management.Repository;

import com.database.management.Model.ColumnManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColumnManageRepository extends JpaRepository<ColumnManage, Long> {
    List<ColumnManage> findBytableid(Long tableid);

    @Modifying
    @Query(value = "delete from columnmanage c where c.tableid=:tableid", nativeQuery = true)
    void deleteBytableid(@Param("tableid") Long tableid);
}

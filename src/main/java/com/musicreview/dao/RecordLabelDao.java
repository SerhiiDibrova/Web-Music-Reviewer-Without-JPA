package com.musicreview.dao;

import com.musicreview.model.RecordLabel;

import java.util.List;

public interface RecordLabelDao {
    RecordLabel findByRecordLabelName(String label_name);
    RecordLabel findById(long id);
    boolean existsRecordLabelByName(String label_name);
    void save(RecordLabel recordLabel);
    void delete (Long id);
    List<RecordLabel> findAll();
}

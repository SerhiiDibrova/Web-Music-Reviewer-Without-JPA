package com.musicreview.service;

import com.musicreview.model.RecordLabel;

import java.util.List;


public interface RecordLabelService {
        RecordLabel getRecordLabelByName(String label_name);
        boolean existsRecordLabelByName(String label_name);
        void addRecordLabel(RecordLabel recordLabel);
        void updateRecordLabel(RecordLabel recordLabel);
        void deleteRecordLabel (Long id);
        List<RecordLabel> recordLabelList();
}

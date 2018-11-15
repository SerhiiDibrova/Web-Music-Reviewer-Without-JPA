package com.musicreview.dao.impl;

import com.musicreview.dao.RecordLabelDao;
import com.musicreview.model.RecordLabel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RecordLabelDaoImpl implements RecordLabelDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public RecordLabel findByRecordLabelName(String label_name) {
      RecordLabel recordLabel = (RecordLabel)sessionFactory.getCurrentSession().get(RecordLabel.class,label_name);
      return recordLabel;
    }
//TO-DO <-----------
    @Override
    public boolean existsRecordLabelByName(String label_name) {
        return false;
    }

    @Override
    public void save(RecordLabel recordLabel) {
        sessionFactory.getCurrentSession().save(recordLabel);
    }


    @Override
    public void delete(Long id) {
        RecordLabel recordLabel = (RecordLabel) sessionFactory.getCurrentSession().load(
                RecordLabel.class, id);
        if (null != recordLabel) {
            sessionFactory.getCurrentSession().delete(recordLabel);
        }
    }

    @Override
    public List<RecordLabel> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from record_label")
                .list();
    }
}

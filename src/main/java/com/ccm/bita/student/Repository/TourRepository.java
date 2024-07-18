package com.ccm.bita.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccm.bita.student.model.TourModel;
@Repository
public interface TourRepository  extends JpaRepository<TourModel,Long> {

}

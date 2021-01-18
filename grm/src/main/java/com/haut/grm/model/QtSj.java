package com.haut.grm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;


@Entity
@Table(name="qt_qt_data")
public class QtSj  extends AbstractEntity<Long>{
	
	private String code;
	
	private Integer codeId;
	
}

package fms.api.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import fms.api.audit.Auditable;


@Entity
@Table(name = "Enrollment")
@EntityListeners(AuditingEntityListener.class)
public class Enrollment extends Auditable<String>{

	@Id
	private EnrollmentKey enrollmentKey;

	public EnrollmentKey getEnrollmentKey() {
		return enrollmentKey;
	}

	public void setEnrollmentKey(EnrollmentKey enrollmentKey) {
		this.enrollmentKey = enrollmentKey;
	}
}

package fms.api.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import fms.api.audit.Auditable;

@Entity
@Table(name="Feedback_Question")
@EntityListeners(AuditingEntityListener.class)
public class Feedback_Question extends Auditable<String>{
	@Id
	private Feedback_QuestionKey feedback_QuestionKey;

	public Feedback_QuestionKey getFeedback_QuestionKey() {
		return feedback_QuestionKey;
	}

	public void setFeedback_QuestionKey(Feedback_QuestionKey feedback_QuestionKey) {
		this.feedback_QuestionKey = feedback_QuestionKey;
	}

	public Feedback_Question(Feedback_QuestionKey feedback_QuestionKey) {
		super();
		this.feedback_QuestionKey = feedback_QuestionKey;
	}

	public Feedback_Question() {
		super();
	}
}
package fms.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EnrollmentKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ClassID")
	private Class classID;
	
	@ManyToOne
	@JoinColumn(name = "TraineeID")
	private Trainee traineeID;

	public Class getClassID() {
		return classID;
	}

	public void setClassID(Class classID) {
		this.classID = classID;
	}

	public Trainee getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Trainee traineeID) {
		this.traineeID = traineeID;
	}

	public EnrollmentKey(Class classID, Trainee traineeID) {
		this.classID = classID;
		this.traineeID = traineeID;
	}
}

package com.blandygbc.adopet.domain.tutor;

import com.blandygbc.adopet.domain.model.tutor.TutorNewModel;
import com.blandygbc.adopet.domain.model.tutor.TutorUpdateModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tutors")
@Entity(name = "Tutor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public Tutor(TutorNewModel newTutor) {
        this.name = newTutor.name();
        this.email = newTutor.email();
        this.password = newTutor.password();
    }

    public void updateInfo(@Valid TutorUpdateModel updateTutor) {
        if (updateTutor.name() != null) {
            this.name = updateTutor.name();
        }
        if (updateTutor.email() != null) {
            this.email = updateTutor.email();
        }
        if (updateTutor.password() != null) {
            this.password = updateTutor.password();
        }
    }

}

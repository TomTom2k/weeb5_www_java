package com.example.lab5.backend.pks;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;


public class CandidateSkillPk implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "candidate_id")
    private Long candidate;

    @Column(name = "skill_id")
    private Long skill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkillPk that = (CandidateSkillPk) o;
        return Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill);
    }

    public CandidateSkillPk(Long candidate, Long skill) {
        this.candidate = candidate;
        this.skill = skill;
    }

    public CandidateSkillPk() {
    }

    public Long getCandidate() {
        return candidate;
    }

    public void setCandidate(Long candidate) {
        this.candidate = candidate;
    }

    public Long getSkill() {
        return skill;
    }

    public void setSkill(Long skill) {
        this.skill = skill;
    }
}

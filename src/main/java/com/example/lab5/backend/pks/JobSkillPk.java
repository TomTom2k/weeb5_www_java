package com.example.lab5.backend.pks;

import java.io.Serializable;
import java.util.Objects;

public class JobSkillPk implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long job;
    private Long skill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkillPk that = (JobSkillPk) o;
        return Objects.equals(job, that.job) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, skill);
    }

    public JobSkillPk(Long job, Long skill) {
        this.job = job;
        this.skill = skill;
    }

    public JobSkillPk() {
    }

    public Long getJob() {
        return job;
    }

    public void setJob(Long job) {
        this.job = job;
    }

    public Long getSkill() {
        return skill;
    }

    public void setSkill(Long skill) {
        this.skill = skill;
    }
}

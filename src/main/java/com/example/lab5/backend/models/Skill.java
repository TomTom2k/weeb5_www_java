package com.example.lab5.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.example.lab5.backend.enums.SkillType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
    private Long id;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_type")
    @Enumerated(EnumType.ORDINAL)
    private SkillType skillType;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;

    public Skill(String skillName, String skillDescription, SkillType skillType) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.skillType = skillType;
        this.jobSkills = new ArrayList<>();
    }

    public Skill(Long id, String skillName, String skillDescription, SkillType skillType) {
        this.id = id;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.skillType = skillType;
        this.jobSkills = new ArrayList<>();
    }

    public Skill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public List<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }
}

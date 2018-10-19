package com.mycom.dao;

import java.util.List;
import com.mycom.entity.Skill;

public interface SkillDao {
	public List<Skill> findAll();
	public void insert(Skill skill);
	public void update(Skill skill);
	public void delete(String name);
}

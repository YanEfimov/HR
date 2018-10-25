package com.mycom.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.dao.VacancyDao;
import com.mycom.entity.User;
import com.mycom.entity.Vacancy;
import com.mycom.entity.VacancyRequirence;

@Repository("VacancyDao")
public class JdbcVacancyDao implements VacancyDao{
	private static long id;
	
	private DataSource dataSource;
	
	@Autowired
	private jdbcVacancyRequirenceDao jdbcvacancyrequirementdao;
	
	@Autowired
	private JdbcUserDao users;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private Vacancy creater (ResultSet rs) throws SQLException {
		Vacancy vacancy=new Vacancy();
		vacancy.setId(rs.getLong(Vacancy.ID_COLUMN));
		vacancy.setExperienceYearRequire(rs.getDouble(Vacancy.EXPERIENCEYEARREQUIRE_COLUMN));
		vacancy.setPosition(rs.getString(Vacancy.POSITION_COLUMN));
		vacancy.setSalaryto(rs.getDouble(Vacancy.SALARYTO_COLUMN));
		vacancy.setSalaryfrom(rs.getDouble(Vacancy.SALARYFROM_COLUMN));
		vacancy.setIdDeveloper(rs.getLong(Vacancy.IDDEVELOPER));
		vacancy.setSkills(jdbcvacancyrequirementdao.findById(vacancy.getId()));
		User user = users.FindById(vacancy.getIdDeveloper());
		vacancy.setDevelopername(user.getName()+" "+user.getSurname());
		return vacancy;
	}
	
	@Override
	public List<Vacancy> findAll() {
		List<Vacancy> list=new ArrayList<Vacancy>();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_FINDALL);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				list.add(creater(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Vacancy> sortForSalaryTo() {
		List<Vacancy> list=new ArrayList<Vacancy>();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_SORTFORSALARYTO);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				list.add(creater(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Vacancy> sortForSalaryFrom() {
		List<Vacancy> list=new ArrayList<Vacancy>();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_SORTFORSALARYFROM);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				list.add(creater(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Vacancy> findByCreate(long idDeveloper) {
		List<Vacancy> list=new ArrayList<Vacancy>();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_FINDFORCREATE);
			statement.setLong(1, idDeveloper);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				list.add(creater(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void insert(Vacancy vacancy) {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, vacancy.getPosition());
			statement.setDouble(2, vacancy.getSalaryto());
			statement.setDouble(3, vacancy.getSalaryfrom());
			statement.setDouble(4, vacancy.getExperienceYearRequire());
			statement.setLong(5, vacancy.getIdDeveloper());
			statement.execute();
			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next())
				id=rs.getLong(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (String s:vacancy.getSkills()) {
			VacancyRequirence vacancyrequirence = new VacancyRequirence();
			vacancyrequirence.setIdVacancy(id);
			vacancyrequirence.setSkill(s);
			jdbcvacancyrequirementdao.insert(vacancyrequirence);
			
		}
	}

	@Override
	public void update(Vacancy vacancy) {
		jdbcvacancyrequirementdao.delete(vacancy.getId());
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, vacancy.getPosition());
			statement.setDouble(2, vacancy.getSalaryto());
			statement.setDouble(3, vacancy.getSalaryfrom());
			statement.setDouble(4, vacancy.getExperienceYearRequire());
			statement.setLong(5, vacancy.getIdDeveloper());
			statement.setLong(6, vacancy.getId());
			statement.execute();
			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next())
				id=rs.getLong(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (String s:vacancy.getSkills()) {
			VacancyRequirence vacancyrequirence = new VacancyRequirence();
			vacancyrequirence.setIdVacancy(id);
			vacancyrequirence.setSkill(s);
			jdbcvacancyrequirementdao.insert(vacancyrequirence);
			
		}
	}

	@Override
	public void delete(long vacancy_id){
		jdbcvacancyrequirementdao.delete(vacancy_id);
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
			statement.setLong(1, vacancy_id);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Vacancy findById(long id) {
		Vacancy vacancy = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FINDBYID);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				vacancy = creater(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vacancy;
	}
}

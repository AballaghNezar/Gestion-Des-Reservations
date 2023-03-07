package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import dao.IDAO;
import entities.Categorie;

public class CategorieService implements IDAO<Categorie> {

	@Override
	public boolean create(Categorie o) {
		String req="insert into categorie values(null,?,?)";
		try {
			PreparedStatement ps=Connexion.getCon().prepareStatement(req);
			ps.setString(1, o.getCode());
			ps.setString(2, o.getLibelle());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Categorie o) {
		String req="update categorie set code=?,libelle=? where id=?";
		try {
			PreparedStatement ps=Connexion.getCon().prepareStatement(req);
			ps.setString(1,o.getCode());
			ps.setString(2, o.getLibelle());
			ps.setInt(3, o.getId());
			if(ps.executeUpdate()==1) 
				return true;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Categorie o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categorie findById(int id) {
		String req="select * from categorie where id=?";
		try {
			PreparedStatement ps=Connexion.getCon().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> liste=new ArrayList<Categorie>();
		String req="select * from categorie";
		try {
			PreparedStatement ps=Connexion.getCon().prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				liste.add(new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			return liste;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}

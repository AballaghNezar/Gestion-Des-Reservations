package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Connexion.Connexion;
import dao.IDAO;
import entities.Chambre;

public class ChambreService implements IDAO<Chambre> {

    @Override
    public boolean create(Chambre o) {
        String req = "insert into chambre values(null,?,?)";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setString(1, o.getTelephone());
            ps.setInt(2, o.getCategorie().getId());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Chambre o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Chambre o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Chambre findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Chambre> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}

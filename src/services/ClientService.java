package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import dao.IDAO;
import entities.Client;

public class ClientService implements IDAO<Client> {

    @Override
    public boolean create(Client o) {
        String req = "insert into client values(null,?,?,?,?)";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getTelephone());
            ps.setString(4, o.getEmail());
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Client o) {
        String req = "update client set nom=?,prenom=?,email=?,telephone=? where id=?";
        try {
            PreparedStatement ps;
            ps = Connexion.getCon().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setString(4, o.getTelephone());
            ps.setInt(5, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Client o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Client findById(int id) {
        String req = "select * from client where id=?";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(req);
            if (rs.next()) {
                return new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Client> findAll() {
        String req = "select * from client";
        List<Client> clients = new ArrayList<Client>();
        PreparedStatement stmt;
        try {
            stmt = Connexion.getCon().prepareStatement(req);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("telephone"), rs.getString("email")));
            }
            return clients;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}

package com.emergentes.dao;

import com.emergentes.modelo.Blog;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOimpl extends ConexionDB implements BlogDAO {

    @Override
    public void insert(Blog blog) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into posts (fecha,titulo,contenido) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setDate(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Blog blog) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE posts set fecha=?, titulo=?, contenido=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setDate(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.setInt(4, blog.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE from posts where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Blog getById(int id) throws Exception {
        Blog log = new Blog();
        try {
            this.conectar();
            String sql = "select * from posts where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                log.setId(rs.getInt("Id"));
                log.setFecha(rs.getDate("fecha"));
                log.setTitulo(rs.getString("titulo"));
                log.setContenido(rs.getString("contenido"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return log;
    }

    @Override
    public List<Blog> getAll() throws Exception {
        List<Blog> lista = null;
        try {
            this.conectar();
            String sql = "select * from posts";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Blog>();
            while (rs.next()) {
                Blog log = new Blog();
                log.setId(rs.getInt("Id"));
                log.setFecha(rs.getDate("fecha"));
                log.setTitulo(rs.getString("titulo"));
                log.setContenido(rs.getString("contenido"));
                lista.add(log);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}

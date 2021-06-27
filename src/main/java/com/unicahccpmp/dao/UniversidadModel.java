/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author obetancourth
 */
public class UniversidadModel {
    
    
    public static void verificarTablaUniversidades(){
        try{
             Connection conn = Conn.obtenerConexion();
        
             String SQLCrearTabla = "CREATE TABLE IF NOT EXISTS universidades"
                        + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " SIGLAS TEXT NOT NULL,"
                        + " RECTORES TEXT NOT NULL"
                        + ")";
                Statement comandoSql = conn.createStatement();
                comandoSql.executeUpdate(SQLCrearTabla);
                comandoSql.close();
        }catch(Exception ex){
            //
            System.err.println(ex.getMessage());
        }
    }
    
    public static ArrayList<Universidad> getUniversidades(){
        ArrayList<Universidad> universidades = new ArrayList<Universidad>();
        
        // Todo obtener de la base de datos
        /* Alumno _miAlumno = new Alumno();
        _miAlumno.setID(1);
        _miAlumno.setNOMBRES("Orlando");
        _miAlumno.setAPELLIDOS("Betancourth");
        _miAlumno.setIDENTIDAD("0801198412349");
        _miAlumno.setCORREO("obetancourthunicah@gmail.com");
        alumnos.add(_miAlumno);
        */
        try {
            Connection conn = Conn.obtenerConexion();

            String SQLGetUniversidades = "Select * FROM universidades;";
            Statement comandoSql = conn.createStatement();
            ResultSet cursorUniversidades = comandoSql.executeQuery(SQLGetUniversidades);
            while( cursorUniversidades.next() ){
                Universidad _miUniversidad = new Universidad();
                _miUniversidad.setID(cursorUniversidades.getInt("ID"));
                _miUniversidad.setSIGLAS(cursorUniversidades.getString("SIGLAS"));
                _miUniversidad.setRECTOR(cursorUniversidades.getString("RECTOR"));
                universidades.add(_miUniversidad);
            }
            comandoSql.close();

            return universidades;
        
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            return universidades;
        }
    }
    
    public static Universidad getUniversidadesById(double Id){
        Universidad _miUniversidad = new Universidad();
        
        // Todo obtener de la base de datos
        /* Alumno _miAlumno = new Alumno();
        _miAlumno.setID(1);
        _miAlumno.setNOMBRES("Orlando");
        _miAlumno.setAPELLIDOS("Betancourth");
        _miAlumno.setIDENTIDAD("0801198412349");
        _miAlumno.setCORREO("obetancourthunicah@gmail.com");
        alumnos.add(_miAlumno);
        */
        try {
            Connection conn = Conn.obtenerConexion();

            String SQLGetUniversidades = String.format("Select * FROM universidades where ID=%s;", String.valueOf(Id));
            System.out.println(SQLGetUniversidades);
            Statement comandoSql = conn.createStatement();
            ResultSet cursorUniversidades = comandoSql.executeQuery(SQLGetUniversidades);
            while( cursorUniversidades.next() ){
                _miUniversidad.setID(cursorUniversidades.getInt("ID"));
                _miUniversidad.setSIGLAS(cursorUniversidades.getString("SIGLAS"));
                _miUniversidad.setRECTOR(cursorUniversidades.getString("RECTOR"));
                
            }
            comandoSql.close();

            return _miUniversidad;
        
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            return _miUniversidad;
        }
    }
    
    public static boolean agregarUniversidad(Universidad universidadAAgregar){
        try{
            String sqlStr = "INSERT INTO universidades (SIGLAS, RECTOR) VALUES ('%s', '%s')";
            
            Connection conn = Conn.obtenerConexion();
            Statement comandoSQL = conn.createStatement();
            int registroAfectados = comandoSQL.executeUpdate(
                    String.format(sqlStr,
                       universidadAAgregar.getSIGLAS(),
                       universidadAAgregar.getRECTOR() 
                       
                    )
            );
            return registroAfectados > 0;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public static boolean editarUniversidad(Universidad universidadAEditar){
        try{
            String sqlStr = "UPDATE  universidades set SIGLAS = '%s', RECTOR = '%s' where ID=%f;";
            
            Connection conn = Conn.obtenerConexion();
            Statement comandoSQL = conn.createStatement();
            int registroAfectados = comandoSQL.executeUpdate(
                    String.format(sqlStr,
                       universidadAEditar.getSIGLAS(), 
                       universidadAEditar.getRECTOR()
                    )
                       
            );
            return registroAfectados > 0;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public static boolean eliminarUniversidad(Universidad universidadAEliminar){
        try{
            String sqlStr = "DELETE FROM  universidades where ID=%f;";
            
            Connection conn = Conn.obtenerConexion();
            Statement comandoSQL = conn.createStatement();
            int registroAfectados = comandoSQL.executeUpdate(
                    String.format(sqlStr,
                       universidadAEliminar.getID()
                    )
            );
            return registroAfectados > 0;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
}

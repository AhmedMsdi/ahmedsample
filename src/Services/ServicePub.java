/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DBAccess.DataSource;
import entity.publicite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafxapplication2.FXMLDocumentController;

/**
 *
 * @author a7med
 */
public class ServicePub {
    
     DataSource db;
     Connection cnx;
     Statement st ;
  //   List<equipe> equipes = new ArrayList<equipe>();
 List<publicite> publicites = new ArrayList<>();
    public ServicePub() {
        
       cnx = db.getInstance().getCon();
         try {
             st= (Statement) cnx.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(ServicePub.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void ajouterPub(int id,String titre,String desc)
    {
         
         try {
             String req ="INSERT INTO publicite (id_pub, titre_pub, description) "
                     + "VALUES ('" + id+"', '" + titre + "', '" + desc + "')";
             st.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(ServicePub.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
   
    public List<publicite> selectPub() {
       
          
        try {
           
            ResultSet rest= 
                    st.executeQuery("select * from publicite");
            while(rest.next()){
                publicite e = new publicite();
                e.setId_pub(rest.getInt(1));
                e.setTitre_pub(rest.getString(2));
                e.setDescription(rest.getString(3));
               
                publicites.add(e);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePub.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(publicite e : publicites){
            String ch ="id: "+e.getId_pub()+" titre: "+e.getTitre_pub()+" description: "+e.getDescription();
            
          System.out.println(ch);

       //  return equipes;
    }
   return publicites;

   
    
}
       
    public void supprimerPub(int id)
    {
         
         try {
            String req ="delete from publicite where id_pub ='"+id+"'"; 
                    
             st.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(ServicePub.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    String titre;
    String desc;
     public String modifierPub(int id,int check)
    {
         
           try {
           
            ResultSet rest= 
                    st.executeQuery("select * from publicite where id_pub='"+id+"'");
            while(rest.next()){
                publicite e = new publicite();
                e.setId_pub(rest.getInt(1));
                e.setTitre_pub(rest.getString(2));
                e.setDescription(rest.getString(3));
               
                publicites.add(e);
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServicePub.class.getName()).log(Level.SEVERE, null, ex);
        }
            

          for(publicite e : publicites){
        titre= e.getTitre_pub();
              desc=   e.getDescription();
       

        
    }
      if (check ==1){
           return titre;}
      else { return desc;}
           
    }

      public void modifier2Pub(int id,String titre,String desc)
    {
         
         try {
            String req ="update publicite set titre_pub='"+titre+"',description='"+desc+"' where id_pub='"+id+"'"; 
                    
             st.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(ServicePub.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}

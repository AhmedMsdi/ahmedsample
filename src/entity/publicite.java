/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author a7med
 */
public class publicite {
    int id_pub;
  String titre_pub;
   String description;
    
     public publicite(int id_pub,String titre_pub,String description) {
        this.id_pub=id_pub;
        this.titre_pub=titre_pub;
        this.description=description;
     }
     public publicite(){
         
     }

    public String getDescription() {
        return description;
    }

    public int getId_pub() {
        return id_pub;
    }

    public String getTitre_pub() {
        return titre_pub;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public void setTitre_pub(String titre_pub) {
        this.titre_pub = titre_pub;
    }
     
}

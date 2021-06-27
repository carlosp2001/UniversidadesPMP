/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.universidades;
import com.unicahccpmp.dao.Universidad;
import java.util.Arrays;
/**
 *
 * @author carlospineda
 */
public class UniversidadesTableModel extends GenericDomainTableModel<Universidad> {
    public UniversidadesTableModel(){
        super(Arrays.asList(new Object[]{"Código", "Siglas", "Rector"}));
    }
    
    @Override
    public Class<?> getColumnClass(int colIndex){
        switch(colIndex){
            case 0:
                return Double.class;
                
            case 1:
                return String.class;
            
            case 2:
                return String.class;
            
           
                
        }
        throw new ArrayIndexOutOfBoundsException(colIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int colIndex){
    
        Universidad item=getDomainObject(rowIndex);
        switch(colIndex){
            case 0:
                return item.getID();
            case 1:
                return item.getSIGLAS();
            case 2:
                return item.getRECTOR();
                        
        }
        throw new ArrayIndexOutOfBoundsException(colIndex);
        
        
    }
    
    @Override 
    public boolean isCellEditable(int rowIndex, int ColIndex){
        
        return false;
        
    }
    
    @Override 
    public void setValueAt(Object valor, int rowIndex, int colIndex){
        
       notifyTableCellUpdated(rowIndex, colIndex);
        
    }
   
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.dao;

import finalproject.pbo.model.UserModel;
import java.util.List;

/**
 *
 * @author Dizzay
 */
public interface UserDataDao {
    
    List<UserModel> getUser();
    
}

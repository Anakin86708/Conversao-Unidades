/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author silva
 */
public class Language {
    
    public static ResourceBundle getResourceBundle() {
        if (Locale.getDefault().getCountry().equals("BR"))
            return ResourceBundle.getBundle("Languages.language_pt_BR");
        else
            return ResourceBundle.getBundle("Languages.language_en_US");
    }

}

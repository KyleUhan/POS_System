/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos_system;

/**
 *
 * @author Kyle
 */
public class StartUp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Register register = new Register();
        register.startNewSale(new CustomerSelfScanner());
    }

}

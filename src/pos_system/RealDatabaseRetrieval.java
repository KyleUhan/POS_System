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
public class RealDatabaseRetrieval implements RecordStorageStrategy{

    
    @Override
    public void getStoreProduct(MerchandiseScannerStrategy mss, int scannerArrayPosition){
        System.out.println("Unable to Access DB at this time");

    }
    
    @Override
    public final double getProductPrice(int merchandiseNumber){
        return 0;
    };
    
    public Product getProduct(){return new Product();};
    
    @Override
     public int getDBSize(){
         return 0;
     };
}

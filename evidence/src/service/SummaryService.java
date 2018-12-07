/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Purchase;
import domain.Sales;
import domain.Summary;
import java.util.Date;

/**
 *
 * @author User
 */
public class SummaryService {
    
    
    public static void insertPurchase(Purchase purchase) {
    
    }
    
     public static void insertSummary(Summary summary) {
     
     }
     
      public static void insertSales(Sales sales) {
      
      }
     
    public static Purchase getPurchaseByProductCode(String productCode) {
     Purchase purchase = new Purchase();
     
       return purchase;
    }
    
    
     public static Summary getSummaryByProductCode(String productCode) {
        Summary summary = new Summary();
     
        return summary;
     }
    
     public static void update(Summary summary) {
     
     }
     
     public static void insertMain(Purchase purchase) {
        if (purchase != null) {
            insertPurchase(purchase);
            Purchase p = getPurchaseByProductCode(purchase.getProductCode());

            try {
                Summary summary =getSummaryByProductCode(purchase.getProductCode());
                if (purchase.getProductCode().equalsIgnoreCase(summary.getProductCode())) {
                    int totalQty = summary.getTotalQty() + purchase.getQty();
                    int avilQty = summary.getAvailableQty() + purchase.getQty();
                    summary.setTotalQty(totalQty);
                    summary.setAvailableQty(avilQty);
                    
                }
                SummaryService.update(summary);

            } catch (NullPointerException e) {

                Summary summary2=new Summary(purchase.getProductName(), purchase.getProductCode(), purchase.getQty(), 0, purchase.getQty(), p);
                insertSummary(summary2);

            }

        }
    }
     
     
     
     
     public static void insertForSales(Sales sales) {
        if (sales.getProductCode() != null) {
            Summary summary = SummaryService.getSummaryByProductCode(sales.getProductCode());
            if (summary.getAvailableQty() >= sales.getQty()) {
                insertSales(sales);
                int soldQrt = summary.getSoldQty() + sales.getQty();
                int avilQty = summary.getAvailableQty() - sales.getQty();

                summary.setSoldQty(soldQrt);
                summary.setAvailableQty(avilQty);
              

                SummaryService.update(summary);
            } else {
                System.out.println("You do not have sufficient Product");
            }
        }
    }
    
}

package org.shop;


import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.impl.ProposalServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args){
        //TODO: implement using Spring Framework ApplicationContext


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SellerInitializer sellerInitializer = (SellerInitializer)context.getBean("sellerInitializer");
        DataInitializer dataInitializer = context.getBean(DataInitializer.class);
        ProposalService proposalService = context.getBean("proposalService", ProposalServiceImpl.class);

        //alias
        SellerService sellerService = (SellerService)context.getBean("sellerService");

        System.out.print("Success");
    }
}

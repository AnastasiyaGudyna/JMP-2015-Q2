package org.shop;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * The main Data Initializer util class.
 */
@Service
public class DataInitializer {

    /** The seller initializer. */
    @Resource
    private SellerInitializer sellerInitializer;
    
    /** The product initializer. */
    @Resource
    private ProductInitializer productInitializer;
    
    /** The proposal initializer. */
    @Resource
    private ProposalInitializer proposalInitializer;
    
    /** The user initializer. */
    @Resource
    private UserInitializer userInitializer;

    
    public void setSellerInitializer(SellerInitializer sellerInitializer) {
        this.sellerInitializer = sellerInitializer;
    }


    public void setProductInitializer(ProductInitializer productInitializer) {
        this.productInitializer = productInitializer;
    }


    public void setProposalInitializer(ProposalInitializer proposalInitializer) {
        this.proposalInitializer = proposalInitializer;
    }


    public void setUserInitializer(UserInitializer userInitializer) {
        this.userInitializer = userInitializer;
    }

    /**
     * Inits the data.
     */
    @PostConstruct
    public void initData() {
        sellerInitializer.initSellers();
        userInitializer.initUsers();
        productInitializer.initProducts();
        proposalInitializer.initProposals();
    }
}

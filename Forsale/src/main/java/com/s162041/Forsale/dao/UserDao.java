package com.s162041.Forsale.dao;


import com.s162041.Forsale.entity.Buyer;
import com.s162041.Forsale.entity.Seller;

import java.util.List;

public interface UserDao {
    List<Buyer> getBuyerList();
    List<Seller> getSellerList();
    int deleteBuyerById(String id);
    int deleteSellerById(String id);
}

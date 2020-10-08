package com.project.repository;

import com.project.exception.WishlistException;

public interface WishlistDao {
	



	public boolean addToWishlist(int uId, int pId);
	public boolean deleteWishlist(int wId) throws WishlistException;

}


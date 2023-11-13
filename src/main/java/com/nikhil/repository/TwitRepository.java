package com.nikhil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nikhil.model.Twit;
import com.nikhil.model.User;

public interface TwitRepository extends JpaRepository<Twit,Long> {
	
	List<Twit>findAllByIsTwitTrueOrderByCreatedAtDesc();
	
	
	List<Twit>findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(User user,Long userId);
     
	
	List<Twit>findByLikesContainingOrderByCreatedAtDesc(User user);
	
	
//	@Query("Select t From Twit t Join t.likes l where l.userId=:userId")
//	List<Twit>findByLikesUser_id(Long userId);
	
	@Query("SELECT t FROM Twit t JOIN t.likes l WHERE l.user.id = :userId")
	List<Twit> findByLikesUser_id(Long userId);

}
